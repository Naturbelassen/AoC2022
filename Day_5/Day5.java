package aoc2022.Day_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/*
*	Link to the Challenge https://adventofcode.com/2022/day/5
*/

public class Day5 {

	public static void main(String[] args) {
		try {
			List<String> myList = Files.readAllLines(Paths.get("C:\\Users\\Naturbelassen\\eclipse-workspace\\AdventOfCode2022\\src\\aoc2022\\Day_5\\sample_data.txt"));
			
			StringBuilder builderOne = new StringBuilder();
			StringBuilder builderTwo = new StringBuilder();
			StringBuilder builderThree = new StringBuilder();
			StringBuilder builderFour = new StringBuilder();
			StringBuilder builderFive = new StringBuilder();
			StringBuilder builderSix = new StringBuilder();
			StringBuilder builderSeven = new StringBuilder();
			StringBuilder builderEight = new StringBuilder();
			StringBuilder builderNine = new StringBuilder();
			
			// Append in every iteration the corresponding string to the right buffer
			// So we get each column in a separated string
			for(int i = 0; i < 8; i++) {
								
				String iop = myList.get(i);
				System.out.println(iop);
				builderOne.append(iop.charAt(1)); // To Do: change to not use hardcoded indices
				builderTwo.append(iop.charAt(5));
				builderThree.append(iop.charAt(9));
				builderFour.append(iop.charAt(13));
				builderFive.append(iop.charAt(17));
				builderSix.append(iop.charAt(21));
				builderSeven.append(iop.charAt(25));
				builderEight.append(iop.charAt(29));
				builderNine.append(iop.charAt(33));				
			}
			
			// trim whitespace to the left and right
			String columnOne = builderOne.toString().trim();
			String columnTwo = builderTwo.toString().trim();
			String columnThree = builderThree.toString().trim();
			String columnFour = builderFour.toString().trim();
			String columnFive = builderFive.toString().trim();
			String columnSix = builderSix.toString().trim();
			String columnSeven = builderSeven.toString().trim();
			String columnEight = builderEight.toString().trim();
			String columnNine = builderNine.toString().trim();
			
			// array to use in for loop to map each column to an int (index)
			String[] toArray = {columnOne, columnTwo, columnThree, columnFour, columnFive, columnSix, columnSeven, columnEight, columnNine};
			
			// Map index to Stack for Part1
			Map<Integer, Stack<String>> indexToColumn = new HashMap<>();
			for(int i = 1; i <= 9; i++) {
				// Commands start at 1, so map from 1, but array index start at 0 so to address 1st element in toArray[] we use i-1
				indexToColumn.put(i, fillStacks(toArray[i-1]));
			}
			
			// Map index to Stack for Part2
			Map<Integer, Stack<String>> copyOfIndexToColumn = new HashMap<>();
			for(int i = 1; i <= 9; i++) {
				// Commands start at 1, so map from 1, but array index start at 0 so to address 1st element in toArray[] we use i-1
				copyOfIndexToColumn.put(i, fillStacks(toArray[i-1]));
			}
			
			int numberToMove = 0;
			int from = 0;
			int to = 0;
			for(int i = 10; i < 511; i++) {    // To Do: change to not use hardcoded indices
				// Parse each number in command's text file
				numberToMove = Integer.parseInt(myList.get(i).substring(4,7).trim());
				from = Integer.parseInt(myList.get(i).substring(12,14).trim());
				to = Integer.parseInt(myList.get(i).substring(17).trim());
				
				
				
				calculatePart1(indexToColumn, numberToMove, from, to);
				calculatePart2(copyOfIndexToColumn, numberToMove, from, to);
			}
			System.out.println("----- Stacks After rearrangement Part1 -----");
			StringBuilder finFin1 = new StringBuilder();

			// peek() at the top of each stack and append these elements for Part1
			for(int i = 1; i <= 9; i++) { 
				finFin1.append(indexToColumn.get(i).peek());	
				System.out.println(indexToColumn.get(i));
			}
			System.out.println("Solution Part1 -> Elements on top of each Stack are: " + finFin1.toString());
			
			System.out.println("--------------------------------------------------");
			
			System.out.println("----- Stacks After rearrangement Part2 -----");
			StringBuilder finFin2 = new StringBuilder();
			
			// peek() at the top of each stack and append these elements for Part1
			for(int i = 1; i <= 9; i++) { 
				finFin2.append(copyOfIndexToColumn.get(i).peek());
				System.out.println(copyOfIndexToColumn.get(i));
			}
			System.out.println("Solution Part2 -> Elements on top of each Stack are: " + finFin2.toString());
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	// Extracted column will be initialized
	// Last in First out: so we build our stack from the last char up to the first
	public static Stack<String> fillStacks(String toFill) {
		int upTo = toFill.length();
		Stack<String> myStack = new Stack<>();
		for(int i = upTo-1; i >= 0; i--) {
			myStack.push(Character.toString(toFill.charAt(i)));
		}		
		System.out.println(myStack + "  ");
		return myStack;
		
	}
	// get two stacks, pop one element from "from" stack and add the popped element to the "to" stack
	// do so numberToMove times
	public static Map<Integer,Stack<String>> calculatePart1(Map<Integer,Stack<String>> indexToColumn, int numberToMove, int from, int to) {
		for(int j = 0; j < numberToMove; j++) {
			
			 indexToColumn.get(to).push(indexToColumn.get(from).pop());	 // Enhancement: check if peek() is not null, then use pop
		}
		return indexToColumn;
	}
	// pop numberToMove many times elements from "from" stack and add it to a string then
	// start from the last char in the string and push it to "to" stack
	public static void calculatePart2(Map<Integer, Stack<String>> copyOfIndexToColumn, int numberToMove, int from, int to) {
		StringBuilder myHelper = new StringBuilder();
		for(int j = 0; j < numberToMove; j++) {
			myHelper.append(copyOfIndexToColumn.get(from).pop());		
		}
		String testo = myHelper.toString();
		for(int k = testo.length()-1; k >= 0; k-- ) {
			copyOfIndexToColumn.get(to).push(Character.toString(myHelper.charAt(k)));
		}
	}
}
