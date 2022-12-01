package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day1_2 {

	public static void main(String[] args) {

		int placeHolder = 0;
		int[] topThree = {0,0,0}; 
		try {
			List<String> myMap = Files.readAllLines(Paths.get("Path_To_Your_File")); //Add the Path to your File
			//Add all Numbers until \n is found
			//Check if placeHolder is greater than any number in topThree
			//Reset placeHolder to 0 and add again until \n is found
			for(String myString : myMap) {
				if(myString.length() != 0) {
					placeHolder += Integer.parseInt(myString);				
				}else {
					for(int i = 0; i < topThree.length; i++) {
						if(topThree[i] < placeHolder) {
							topThree[i] = placeHolder;							
							break;
						}
					}
					placeHolder = 0;
				}
			}
			System.out.println(Arrays.toString(topThree));
			int sum = (int) Arrays.stream(topThree).sum();
			System.out.println("Sum of Array: " + sum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
