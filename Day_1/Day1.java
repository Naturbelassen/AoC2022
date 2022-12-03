package aoc2022.Day_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
*	Link to the Challenge https://adventofcode.com/2022/day/1
*/

public class Day1 {

	public static void main(String[] args) {
		int max = 0;
		int placeHolder = 0;
		try {
			List<String> myList = Files.readAllLines(Paths.get("Path_To_Your_File")); //Add the Path to your File
			//Add all Numbers until \n is found
			//Check if placeHolder is greater than max
			//Reset placeHolder to 0 and add again until \n is found
			for(String myString : myList) {
				if(myString.length() != 0) {
					placeHolder += Integer.parseInt(myString);				
				}else {
					if(max < placeHolder) {
						max = placeHolder;
						placeHolder = 0;
					}else {
						placeHolder = 0;
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(max);

	}

}
