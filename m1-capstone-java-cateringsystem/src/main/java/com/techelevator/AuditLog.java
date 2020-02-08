package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
public class AuditLog  {

	private LocalDate currentDate;
	private LocalTime currentTime;
	private String fileName;
//date timestamp action
	//actions = adding money: amount added & total account balance
//				giving change:
//				number ordered _ product Name _ product code
	
	public File initiateAuditLog(String fileName) throws IOException{
		
		this.fileName = fileName;
		
		File logFile = new File(fileName);
		
		if(logFile.exists()) {
			
		}else {
			logFile.createNewFile();
		}
		return logFile;
	}
	
	public void logAddMoney(int inputMoney, float currentAccountBalance ) {
		try {
			FileWriter auditWriter = new FileWriter("CLI-Audit",true);
			PrintWriter auditPrinter = new PrintWriter(auditWriter) ;
			auditPrinter.println(currentDate.now() + " " + currentTime.now() + " ADD MONEY: " + inputMoney + ".00" + " " + currentAccountBalance);
			auditPrinter.close();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void logGivingChange(float changeReturned, float currentAccountBalance) {
		try {
			FileWriter auditWriter = new FileWriter("CLI-Audit",true);
			PrintWriter auditPrinter = new PrintWriter(auditWriter) ;
			auditPrinter.println(currentDate.now() + " " + currentTime.now() + " GIVE CHANGE: " + changeReturned +  " " + currentAccountBalance);
			auditPrinter.close();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	public void logItemPurchased(int quantityOrdered, String productName, String productId, float itemTotalCost, float tempAccountBalance) {
		try {
			FileWriter auditWriter = new FileWriter("CLI-Audit",true);
			PrintWriter auditPrinter = new PrintWriter(auditWriter) ;
			auditPrinter.println(String.format("%-10s %-10s %-5s %-20s %-5s %-5s %-5s", currentDate.now(), currentTime.now(), quantityOrdered, productName, productId, itemTotalCost, tempAccountBalance));
			auditPrinter.close();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
}
