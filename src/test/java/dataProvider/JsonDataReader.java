package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import gherkin.deps.com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.CreditCard;
import testDataTypes.Customer;

public class JsonDataReader {
	
	private final String customerFilePath=FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()+"Customer.json"; 
	private final String creditCardFilePath=FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()+"CreditCard.json";
	private List<Customer> customerList;
	private List<CreditCard> creditCardList;
	
	public JsonDataReader() {
		customerList=getCustomerData();
		creditCardList=getCreditCardData();
	}
	
	private List<CreditCard> getCreditCardData() {
		Gson gson=new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader=new BufferedReader(new FileReader(creditCardFilePath));
			CreditCard[] creditCards=gson.fromJson(bufferReader, CreditCard[].class);
			return Arrays.asList(creditCards);
		} catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path: "+creditCardFilePath);
		} finally {
			try {
				if(bufferReader != null) bufferReader.close();
			} catch (IOException ignore) {
				
			}
		}
	}
	
	public final CreditCard getCreditCardByName(String creditCardName) {
		return creditCardList.stream().filter(x -> x.firstName.equalsIgnoreCase(creditCardName)).findAny().get();
	}
	private List<Customer> getCustomerData() {
		Gson gson=new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader=new BufferedReader(new FileReader(customerFilePath));
			Customer[] customers=gson.fromJson(bufferReader, Customer[].class);
			return Arrays.asList(customers);
		} catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path: "+customerFilePath);
		} finally {
			try {
				if(bufferReader != null) bufferReader.close();
			}
			catch(IOException ignore) {
			}
		}
	}
	
	public final Customer getCustomerByName(String customerName) {
		return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}
}
