package com.techelevator.machine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditLog {
	
	File auditLog = new File("Log.txt");
	
	public void writeToFile (String transaction, double tender, double balance) throws IOException {
		
			try(PrintWriter printWriter = new PrintWriter(auditLog)){
				
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
				String dateString = dateFormat.format(date);
				printWriter.write(dateString);
				printWriter.append("       %-20s $%-4.2f $%-4.2f \n", transaction, tender, balance, true);
				printWriter.append("\n");
			}
	}
}
