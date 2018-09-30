package com.canvass.challenge;
import java.io.*;
import com.google.code.externalsorting.ExternalSort;

public class Challenge2 {
	public static void main(String[] args) {
		String inputfile=args[0];
		String outputfile="random_data_sorted.csv";
		try {
			ExternalSort.mergeSortedFiles(ExternalSort.sortInBatch(new File(inputfile),new rowComparator()), new File(outputfile),new rowComparator());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
