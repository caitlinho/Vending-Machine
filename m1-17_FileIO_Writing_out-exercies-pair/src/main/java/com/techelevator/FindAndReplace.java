package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		
		File inputFile = getFileFromUser();
		String wordToReplace = getWordFromUser();
		String wordToReplaceWith = getReplacementWordFromUser();
		String thisLine;
		File sourceFile = passSourceFilePath();
		
		
		try(Scanner newScanner = new Scanner(inputFile); PrintWriter newWriter = new PrintWriter(sourceFile)){
			BufferedWriter bufferedWriter = new BufferedWriter(newWriter);
			
			while (newScanner.hasNextLine()){
				
				thisLine = newScanner.nextLine();
				
				if (thisLine.contains(wordToReplace)) {
					String changedLine = thisLine.replace(wordToReplace, wordToReplaceWith);
					bufferedWriter.write(changedLine + "\n");
					bufferedWriter.flush();
				}
				
			}
		}
		
		
		

	}
	
	private static File getFileFromUser() {
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path of the file >>>");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		
		if (inputFile.exists() == false) {
			System.out.print("File does not exist");
			System.exit(1);
		} else if (inputFile.isFile() == false) {
			System.out.print("Not a File");
			System.exit(1);
		}
		
		return inputFile;
	}
	
	private static String getWordFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("What is the word to be Replaced:");
		String wordToReplace = userInput.nextLine();
		return wordToReplace; 
	}
	
	private static String getReplacementWordFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("What is the word to Replace with:");
		String wordToReplaceWith = userInput.nextLine();
		return wordToReplaceWith; 
	}
	
	private static File passSourceFilePath() throws IOException {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Provide the source file: ");
		String fileName = userInput.nextLine();
		File newFile = new File(fileName);
		String path = null;
		
		if (newFile.exists()) {
			System.out.print("This " + newFile.getAbsolutePath() + "already exists");
			System.exit(1);
		}
		
			System.out.print("Enter a name for the new file: ");
			fileName = userInput.nextLine();
			File sourceFile = new File(fileName);
			sourceFile.createNewFile();
			path = sourceFile.getAbsolutePath();
			File targetFile = new File(path);
			return targetFile;
		
	}
	
}
