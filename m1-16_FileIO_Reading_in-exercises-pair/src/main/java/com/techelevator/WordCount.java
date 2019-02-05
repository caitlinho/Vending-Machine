package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) throws FileNotFoundException{
		
		File inputFile = getFileFromUser();
		
		int wordCount = 0;
		int lineNumber = 0;
		int sentenceCount = 0;
		 
		try(Scanner fileScanner = new Scanner(inputFile)) {  
						
			while(fileScanner.hasNextLine()) {
				
				String thisLine = fileScanner.nextLine();			
				String[] wordsInThisLine = thisLine.split(" ");
				
					for (int i = 0; i < wordsInThisLine.length; i++) {
						if (!(wordsInThisLine[i].equals(""))) {
						wordCount++;
						}
				}
				
				if (thisLine.trim().length() > 0) {
					for (int i = 0; i < thisLine.length()-1; i++) {
						if (thisLine.charAt(i) == '.' || thisLine.charAt(i) == '?' || thisLine.charAt(i) == '!') {
							sentenceCount++;
						}
					}
				}
				lineNumber++;
			}
			System.out.println("Word Count: " + wordCount);
			System.out.println("Number of Sentences: " + sentenceCount);
			System.out.println("Number of (text) Lines: " + lineNumber);
		}
	}

	private static File getFileFromUser() {
		Scanner userInput = new Scanner(System.in); 
		/*
		 * suppressed warning because "userInput" should be closed but we never close System.in or else JVM is mad
		 */
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}
	
}
