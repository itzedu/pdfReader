package com.eduardobaik.statementsreader;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class Reader {
	
	public static void main(String[] args) throws InvalidPasswordException, IOException {
		ChaseReader sapphire = new ChaseReader("/Users/eduardobaik/Desktop/PDFReader/2017-06-25-statements-3525.pdf");
		ChaseReader hyatt = new ChaseReader("/Users/eduardobaik/Desktop/PDFReader/2017-07-27-statements-4642.pdf");
		FileWriter writer = new FileWriter("/Users/eduardobaik/Desktop/PDFReader/chase.txt");
		FileWriter writer2 = new FileWriter("/Users/eduardobaik/Desktop/PDFReader/hyatt.txt");
		writer.createText(sapphire.allPurchases());
		writer2.createText(hyatt.allPurchases());
	}
}
