package com.eduardobaik.statementsreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class ChaseReader {
	private String pdfLocation;
	
	public ChaseReader(String location) {
		pdfLocation = location;
	}
	
	public ArrayList<String> allPurchases() throws InvalidPasswordException, IOException {
		File statement = new File(pdfLocation);
		PDDocument document = PDDocument.load(statement);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String text = pdfStripper.getText(document);
		ArrayList<String> allPurchases = getPurchases(text);
		document.close();
		
		return allPurchases;
	}
	
	private ArrayList<String> getPurchases(String statement) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(statement.split("\n")));
		ArrayList<String> purchases = new ArrayList<String>();
		boolean push = false;
		for(int i = 0; i < list.size(); i++) {
			if(push) {
				if(list.get(i).charAt(2) == '/') {
					purchases.add(addDelimeter(list.get(i)));
				} else {
					push = false;
				}
			}
			
			if(list.get(i).equals("Transaction Merchant Name or Transaction Description $ Amount")) {
				push = true;
			}
		}
		return purchases;
	}
	
	private String addDelimeter(String line) {
		int lastSpace = line.lastIndexOf(" ");
		String newLine = line.substring(0, 5) + "," + line.substring(5, lastSpace) + "," + line.substring(lastSpace, line.length());
		return newLine;
	}

}
