package aoc2022.Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


/*
*	Link to the Challenge https://adventofcode.com/2022/day/3
*/


public class Day3 {

	public static void main(String[] args) {
		int myResult = 0;
		boolean charFound = false;
		Map<String, Integer> mappedPoints = 
				Map.ofEntries(Map.entry("a", 1), // Can add more than 10 entries with this approach
						Map.entry("b", 2),
						Map.entry("c", 3),
						Map.entry("d", 4),
						Map.entry("e", 5),
						Map.entry("f", 6),
						Map.entry("g", 7),
						Map.entry("h", 8),
						Map.entry("i", 9),
						Map.entry("j", 10),
						Map.entry("k", 11),
						Map.entry("l", 12),
						Map.entry("m", 13),
						Map.entry("n", 14),
						Map.entry("o", 15),
						Map.entry("p", 16),
						Map.entry("q", 17),
						Map.entry("r", 18),
						Map.entry("s", 19),
						Map.entry("t", 20),
						Map.entry("u", 21),
						Map.entry("v", 22),
						Map.entry("w", 23),
						Map.entry("x", 24),
						Map.entry("y", 25),
						Map.entry("z", 26),
						Map.entry("A", 27),
						Map.entry("B", 28),
						Map.entry("C", 29),
						Map.entry("D", 30),
						Map.entry("E", 31),
						Map.entry("F", 32),
						Map.entry("G", 33),
						Map.entry("H", 34),
						Map.entry("I", 35),
						Map.entry("J", 36),
						Map.entry("K", 37),
						Map.entry("L", 38),
						Map.entry("M", 39),
						Map.entry("N", 40),
						Map.entry("O", 41),
						Map.entry("P", 42),
						Map.entry("Q", 43),
						Map.entry("R", 44),
						Map.entry("S", 45),
						Map.entry("T", 46),
						Map.entry("U", 47),
						Map.entry("V", 48),
						Map.entry("W", 49),
						Map.entry("X", 50),
						Map.entry("Y", 51),
						Map.entry("Z", 52)
						);
		
		
		try {
			List<String> myList = Files.readAllLines(Paths.get("C:\\Users\\Naturbelassen\\eclipse-workspace\\AdventOfCode2022\\src\\aoc2022\\Day_3\\sample_data.txt"));
			System.out.println("_________Start FIRST Exercise_________");
			for(String myString : myList) {
				System.out.println(myString);
				int myLength = myString.length();
				int toHalfLength = myLength / 2;
				// double as = (double) myString.length() * (double) (1/2); // why as = 0 ?
				
				// iterate from i to toHalfLength-1 (because index starts at 0), and j starts at toHalfLength 
				// it is guaranteed that the 1st and 2nd half contains one equal char
				for(int i = 0; i < toHalfLength; i++) {
					// Check if we found a match for this string if yes break out of for loop	
					if(charFound) {
						
						charFound = false;
						break;
					}
					// System.out.println(myString.charAt(i));
					for(int j = toHalfLength; j < myString.length(); j++) {
						// get the correspond numb value from map and check for equality
						// add the value to myResult and set flag to true which indicates we are done for this string
						if(mappedPoints.get(String.valueOf(myString.charAt(i))) == mappedPoints.get(String.valueOf(myString.charAt(j)))) {
						    System.out.println(String.valueOf(myString.charAt(i)) + " == " + String.valueOf(myString.charAt(j)));
							//System.out.println(mappedPoints.get(String.valueOf(myString.charAt(i))) + "  " + mappedPoints.get(String.valueOf(myString.charAt(j))));
							myResult += mappedPoints.get(String.valueOf(myString.charAt(i)));
							
							// When char matches the last char in the 1st pack, then the flag needs to be false,
							// because the outer for loop will not be executed -> the line.94 if(charFound) will not be executed
							// the flag will remain at true and the next line will be skipped because of that
							if(!(i == toHalfLength -1)) {
								charFound = true;
							}
							break;							
						}							
					}
				}
			}
			   System.out.println("_____________________________");
			   System.out.println("RESULT FOR FIRST EXCERCISE: " + myResult);
			   System.out.println("_____________________________");
			// Call to calculate second exercise
			secondPart(myList, mappedPoints);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

	}
	public static void secondPart(List<String> myList, Map<String, Integer> mappedPoints) {
		System.out.println("");
		System.out.println("_________Start Second Exercise_________");
		int zahl = 0;
		int sum = 0;
		boolean stopIter = false;
		boolean stopOuter = false;
		int index = 0;
		// there are 300 lines where we examine 3 each at a time so iterate until i < 100 (not i=100 because we start at i=0)
		for(int i = 0; i < 100; i++) {		
			String myFirst = myList.get(index);
			String mySecond = myList.get(index+1);
			String myThird = myList.get(index+2);

			System.out.println("Strings: " + myFirst + " " + mySecond + " " + myThird);
			// Loop through first and second string if we got a match check if third string is equal also
			for(int j = 0; j < myFirst.length(); j++) {
				// Controlling when to stop this outer loop
				// Will stop the iteration for the 3 pack of strings
				if(stopOuter) {
					stopOuter = false;
					break;
				}
				for(int k = 0; k < mySecond.length(); k++) {
					// Controlling when to stop this inner loop
					// If inner loop stopped, then we will stop here aswell and push the signal to stop 1 level above this loop
					if(stopIter) {
						stopIter = false;
						stopOuter = true;
						break;
					}
					if(mappedPoints.get(String.valueOf(myFirst.charAt(j))) == mappedPoints.get(String.valueOf(mySecond.charAt(k)))) {
						for(int p = 0; p < myThird.length(); p++) {
							if(mappedPoints.get(String.valueOf(myFirst.charAt(j))) == mappedPoints.get(String.valueOf(myThird.charAt(p)))) {
								System.out.println(myThird.charAt(p) + " value is: " + mappedPoints.get(String.valueOf(myFirst.charAt(j))));
								sum += mappedPoints.get(String.valueOf(myFirst.charAt(j)));
								zahl++;
								System.out.println(zahl);
								// Flag that should be turned to true meaning we can stop this whole iteration
								// However if this is the last iteration for j than we wont set it to true, because:
								// we have no choice to set the flag to false within the iteration of the same 3 pack of lines
								// Push the signal to end the whole loop to the inner loop above 1 level
								if(!(j == myFirst.length()-1)) {
									stopIter = true;
								}
								break;
							}
						}
					}
				}
			}
			// Push index +3 because we look lines in pack of 3
			index = index + 3;
		}
		System.out.println("_____________________________");
		System.out.println("RESULT SECOND EXERCISE: " + sum);
		System.out.println("_____________________________");
		
	}

}
