package com.canvass.challenge;
import java.io.*;
import com.google.code.externalsorting.ExternalSort;
/*
 * Have used External Sort for sorting large files
 */
public class Challenge2 {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Input file Missing . Usage : java -cp <path to challenge-0.0.1-SNAPSHOT-jar-with-dependencies.jar> com.canvass.challenge.Challenge2 <path to large_data.csv>");
			System.exit(0);
		}
		String inputfile=args[0];
		String outputfile="random_data_sorted.csv";
		try {
			ExternalSort.mergeSortedFiles(ExternalSort.sortInBatch(new File(inputfile),new rowComparator()), new File(outputfile),new rowComparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
