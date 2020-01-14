package com.project.Methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class represents a  transaction database
 * optimized for the TNR and TopKRules algorithms for top-k
 * association rule mining. 
 * <br/><br/>
 * 
 * It contains a list of transaction implemented as linked-lists
 * and keep track of the largest item ids and the total number
 * of transactions in the database. 
 * <br/><br/>
 * 
 * The main method is loadFile() for reading a file. But transactions
 * can also be added manually by calling the method addTransaction.
 * 
 * @see AloTKO
 * @see AloTKU
 * @see Transaction
 * @author Philippe Fournier-Viger
 * */

public class Database {

	/** the largest item in the database */
	public int maxItem = 0;
	/** the number of transactions in the database */
	public int tidsCount =0;
	
	/** The list of transactions in this database */
	private final List<Transaction> transactions = new ArrayList<Transaction>();

	/**
	 * Load a file from a file path.
	 * @param path the input file path
	 * @throws IOException exception if an error while writing the file
	 */
	public void loadFile(String path) throws IOException {
		BufferedReader  myInput = null;
		try {
			// open the file
			FileInputStream fin = new FileInputStream(new File(path));
			myInput = new BufferedReader(new InputStreamReader(fin));

			// for each line (transaction into the file until the end of the file
			String thisLine;
			while ((thisLine = myInput.readLine()) != null) {
				// if the line is  a comment, is  empty or is a
				// kind of metadata
				if (thisLine.isEmpty() == true ||
						thisLine.charAt(0) == '#' || thisLine.charAt(0) == '%'
								|| thisLine.charAt(0) == '@') {
					continue;
				}
				
				// split the line according to spaces and process it
				addTransaction(thisLine.split(" "));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(myInput != null){
				myInput.close();
			}
	    }
	}
	
	/**
	 * Read a transaction from the file and store it into memory
	 * @param itemsString an array of items, where an item is an integer represented as a String.
	 */
	public void addTransaction(String itemsString[]){
		// we create an object Transaction to store the items
		Transaction transaction = new Transaction(itemsString.length);
		
		// for each item (String)
		for(String itemString : itemsString){
			// if it is empty, skip it
			if("".equals(itemString)){
				continue;
			}
			// convert from string to integer
			int item = Integer.parseInt(itemString);
			// if the item is larger than the largest item, remember that
			if(item >= maxItem){
				maxItem = item;
			}
			// add the item to the transaction
			transaction.addItem(item);
		}
		// increase the number of transactions
		tidsCount++;
		
		// add the transaction to the transaction database
		transactions.add(transaction);
		
		// Sort transactions by descending order of items because
		// TopKRules and TNR assume that items are sorted by lexical order
		// for optimization.
		Collections.sort(transaction.getItems(), new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}});
	}
	
	/**
	 * Get the number of transactions.
	 * @return the number of transactions
	 */
	public int size(){
		return transactions.size();
	}

	/**
	 * Get the list of transactions in this database.
	 * @return a List of Transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

//	public int checkDatabaseSize(String path) throws IOException {
//		int databaseSize =0;
//		String thisLine;
//		BufferedReader myInput = null;
//		try {
//			FileInputStream fin = new FileInputStream(new File(path));
//			myInput = new BufferedReader(new InputStreamReader(fin));
//			while ((thisLine = myInput.readLine()) != null) {
//				databaseSize++;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(myInput != null){
//				myInput.close();
//			}
//	    }
//		return databaseSize;
//	}
	
}
