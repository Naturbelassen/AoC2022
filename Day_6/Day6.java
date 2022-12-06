package aoc2022.Day_6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
*	Link to the Challenge https://adventofcode.com/2022/day/6
*/


public class Day6 {

	public static void main(String[] args) {
		try {
			List<String> myList = Files.readAllLines(Paths.get("C:\\Users\\Naturbelassen\\eclipse-workspace\\AdventOfCode2022\\src\\aoc2022\\Day_6\\sample_data.txt"));
			System.out.println("Part1: Index of first 4 Distinct directly-connected Variables: " + calculateIndexOfFirst4DirectlyConnectedDiffVariables(myList));
			System.out.println("Part2: Index of first 14 Distinct directly-connected Variables: " + calculateIndexOfFirst14DirectlyConnectedDiffVariables(myList));		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int calculateIndexOfFirst4DirectlyConnectedDiffVariables(List<String> myList) {
		for(String lineOfList : myList) {
			for(int i = 0; i < lineOfList.length()-4; i++ ) {
				// Loop through each line and compare 4 chars at a time: if all of them are not equal return index + 4 which indicates the index where the flag ended
				if((lineOfList.charAt(i) != lineOfList.charAt(i+1)) && (lineOfList.charAt(i) != lineOfList.charAt(i+2)) && (lineOfList.charAt(i) != lineOfList.charAt(i+3))
					&& (lineOfList.charAt(i+1) != lineOfList.charAt(i+2)) && (lineOfList.charAt(i+1) != lineOfList.charAt(i+3))
					&& (lineOfList.charAt(i+2) != lineOfList.charAt(i+3))) {
					return i + 4;
					
				}
			}
		}
		
		return 0;
		
	}
	
	public static int calculateIndexOfFirst14DirectlyConnectedDiffVariables(List<String> myList) {
		List<Character> myCharList = new ArrayList<>();
		for(String lineOfList : myList) {
			for(int i = 0; i < lineOfList.length(); i++ ) {
				// Add char if it is not in my List
				if(!(myCharList.contains(lineOfList.charAt(i)))) {
					myCharList.add(lineOfList.charAt(i));
				}else {
					// Char is already in myCharList we need to: figure out the index of the element in myCharList
					// Delete the duplicated char and everything before it
					// Add duplicated char into myCharList
					// Return i+1 if myCharList contains 14 characters (+1 because index starts at 0)
					int beforeDeleteEverything = myCharList.indexOf(lineOfList.charAt(i));
					for(int j = beforeDeleteEverything; j >= 0; j--) {
						myCharList.remove(j);
					}
					myCharList.add(lineOfList.charAt(i));
				}
				if(myCharList.size() == 14) {			
					return i+1;
				}
			}
		}
		return 0;
	}

}
