package aoc2022.Day_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
*	Link to the Challenge https://adventofcode.com/2022/day/4
*/


public class Day4 {
	public static void main(String[] args) {
		String myFirst = "";
		String mySecond ="";
		int firstFirstInt = 0;
		int firstSecondInt = 0;
		int secondFirstInt = 0;
		int secondSecondInt = 0;
		int sum1 = 0;
		int sum2 = 0;
		try {
			List<String> myList = Files.readAllLines(Paths.get("C:\\Users\\Naturbelassen\\eclipse-workspace\\AdventOfCode2022\\src\\aoc2022\\Day_4\\sample_data.txt"));
			for(String myString : myList) {
				// Split Line by ","
				String[] myStringArray = myString.split(",");
				myFirst = myStringArray[0];
				mySecond = myStringArray[1];
				
				// Get each number
				firstFirstInt = Integer.parseInt(myFirst.split("-")[0]);
				firstSecondInt = Integer.parseInt(myFirst.split("-")[1]);
				secondFirstInt = Integer.parseInt(mySecond.split("-")[0]);
				secondSecondInt = Integer.parseInt(mySecond.split("-")[1]);
				
				// Compare each start and end of interval
				if(firstFirstInt <= secondFirstInt && firstSecondInt >= secondSecondInt || secondFirstInt <= firstFirstInt && secondSecondInt >= firstSecondInt) {
					sum1++;
				}
				
				// Check if the end of first interval is lager than the beginning of the second AND check if the first interval starts before the second interval ends
				// 59-92,91-93 -> works
				// 58-98,23-57 -> does not work although the second interval begins earlier than the first, but the second interval ends before the first starts
				if(firstSecondInt >= secondFirstInt && firstFirstInt <= secondSecondInt) {
					sum2++;
					System.out.println(firstFirstInt + " " + firstSecondInt + " " + secondFirstInt + " " + secondSecondInt);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("First Exercise sum is: " + sum1 +"\n" + "Second Exercise sum is: " + sum2 );
		
		
		
	}
}
