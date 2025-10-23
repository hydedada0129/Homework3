package util;
import java.io.FileInputStream;
//存Customer info to a file "membership.txt"
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.Customer;

public class CustomerFileIO {

	public static void main(String[] args) {

		
	}
	
	//寫入一個檔案
	public static void saveCustomerToFile(Customer customer){
		//Java object to bytes
		try {
			FileOutputStream fos=new FileOutputStream("membership.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(customer);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Customer readCustomerToFile(){
		Customer customer=null;
		try {
			FileInputStream fis = new FileInputStream("membership.txt");		
			ObjectInputStream ois =new ObjectInputStream(fis);
			customer=(Customer)ois.readObject();	//轉成Java object
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
}
