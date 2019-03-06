package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath="configs//Configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader=new BufferedReader(new FileReader(propertyFilePath));
			properties=new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at"+propertyFilePath);
		}
	}
	
	public String getDriverPath() {
		String driverPath=properties.getProperty("driverPath");
		if(driverPath != null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}
	
	public long getImplicitlyWait() {
		String implicitlyWait=properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file");
	}
	
	public String getApplicationURL() {
		String url=properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configurations.properties file");
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName=properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equalsIgnoreCase("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("environment key not specified in the Configurations.properties file");
	}
	
	public DriverType getBrowser() {
		String browserName=properties.getProperty("browser");
		if(browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equalsIgnoreCase("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("browser key not specified in the Configurations.properties file");
	}
	
	public Boolean getBrowserWindowSize() {
		String maximize=properties.getProperty("windowMaximize");
		if(maximize != null) return Boolean.valueOf(maximize);
		return true;
	}
	
	public String getTestDataResourcePath() {
		String testDataResourcePath=properties.getProperty("testDataResourcePath");
		if(testDataResourcePath != null) return testDataResourcePath;
		else throw new RuntimeException("Test Data Resource Path not specified in the Configurations file");
	}
	
	public String getReportConfigPath() {
		String reportConfigPath=properties.getProperty("reportConfigPath");
		if(reportConfigPath != null) return reportConfigPath;
		else throw new RuntimeException("Configuration Report Path not specified in the Configurations file");
	}
}
