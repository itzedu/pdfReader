package com.eduardobaik.statementsreader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWriter {
	private String filePath;
	
	public FileWriter(String filePath) {
		this.filePath = filePath;
	}
	
	public void createText(ArrayList<String> allPurchases) throws FileNotFoundException {
		PrintWriter outputStream = new PrintWriter(filePath);
		for(String p : allPurchases) {
			outputStream.println(p);
		}
		outputStream.close();
		System.out.println("done");
	}
}
