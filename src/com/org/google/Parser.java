package com.org.google;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

	private int numberOfEmpty = 0;
	private String lastField = "format_error";

	public static void main(String[] args) {

		Parser parser = new Parser();
		Scanner scan = new Scanner(System.in);
		String inputString = scan.next();
		String[] input = inputString.split("~n");
		int numberOfFields = 0, numberOfRecords = 0;
		ArrayList<String> fields = new ArrayList<String>();
		ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		if (inputString.contains("~~~")) {
			if (inputString.charAt(inputString.indexOf("~~~") + 3) != '|')
				printError(parser.lastField);
		}
		numberOfFields = parser.processFields(input[0], fields);
		numberOfRecords = parser.processRecords(input, records);
		parser.lastField = (numberOfFields != numberOfRecords)
				? fields.get(numberOfFields - 1) + "_" + (numberOfRecords - numberOfFields)
				: fields.get(numberOfFields - 1);
		System.out
				.println(numberOfFields + ":" + numberOfRecords + ":" + parser.numberOfEmpty + ":" + parser.lastField);
	}

	private static void printError(String lastField) {
		System.out.println("0:0:0:" + lastField);
		System.exit(1);
	}

	private int processFields(String input, ArrayList<String> fields) {
		if (input.charAt(0) != '|')
			printError(lastField);
		StringBuilder value = new StringBuilder();
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) != '|' || (input.charAt(i) == '|' && input.charAt(i - 1) == '~')) {
				value.append(input.charAt(i));
				continue;
			}
			fields.add(value.toString());
			value.setLength(0);
		}
		return fields.size();
	}

	private int processRecords(String[] input, ArrayList<ArrayList<String>> records) {
		int noOfRecords = 0;
		for (int i = 1; i < input.length; i++) {
			String record = input[i];
			ArrayList<String> individualRecord = new ArrayList<String>();
			StringBuilder value = new StringBuilder();
			for (int j = 1; j < record.length(); j++) {
				if (record.charAt(j) != '|' || (record.charAt(j) == '|' && record.charAt(j - 1) == '~')) {
					value.append(record.charAt(j));
					continue;
				} else if (record.charAt(j) == '|' && record.charAt(j - 1) == '|') {
					numberOfEmpty++;
					value.append(" ");
				}
				individualRecord.add(value.toString());
				value.setLength(0);
			}
			records.add(individualRecord);
			noOfRecords = individualRecord.size();
		}
		return noOfRecords;
	}

}
