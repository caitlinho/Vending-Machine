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
	
	public void writeToFile (String transaction, double tender, double balance) throws IOException {
		try (FileWriter auditLog = new FileWriter("Log.txt", true); PrintWriter printWriter = new PrintWriter(auditLog)) {
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
			String dateString = dateFormat.format(date);
			printWriter.write(dateString);
			printWriter.format("       %-20s $%-8.2f $%-4.2f", transaction, tender, balance);
			printWriter.println();
	}
	catch (Exception e) {
		return;
	}
	}
}
