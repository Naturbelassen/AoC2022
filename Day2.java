package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*	Link to the Challenge https://adventofcode.com/2022/day/2
*/

public class Day2 {

	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;
		//Map how many Points you get for choosing rock,paper,scissor
		Map<Character, Integer> mappedPoints = new HashMap<>();
		mappedPoints.put('X',1);
		mappedPoints.put('Y', 2);
		mappedPoints.put('Z', 3);
		
		//Map the outcome of the game
		Map<String, Integer> mappedOutcome = new HashMap<>();
		mappedOutcome.put("A Y", 6); // Rock vs. Paper
		mappedOutcome.put("A X", 3); // Rock vs. Rock 
		mappedOutcome.put("A Z", 0); // Rock vs. Scissor
		mappedOutcome.put("B X", 0); // Paper vs. Rock
		mappedOutcome.put("B Y", 3); // Paper vs. Paper
		mappedOutcome.put("B Z", 6); // Paper vs. Scissor
		mappedOutcome.put("C Z", 3); // Scissor vs. Scissor
		mappedOutcome.put("C Y", 0); // Scissor vs. Paper
		mappedOutcome.put("C X", 6); // Scissor vs. Rock
		
		// X -> Lose
		// Y -> Draw
		// Z -> Win
		Map<String,Character> mappedAgain = new HashMap<>();
		mappedAgain.put("A Y", 'X'); // Play against Rock and Y -> Draw. Choose: X. Tuple "A X" determines the outcome 
		mappedAgain.put("A X", 'Z'); // Play against Rock and Y -> Win. Choose: Z. Tuple "A Z" determines the outcome
		mappedAgain.put("A Z", 'Y'); // Play against Rock and Y -> Lose. Choose: Y. Tuple "A Y" determines the outcome
		mappedAgain.put("B X", 'X'); // Play against Paper and X -> Lose. Choose: X. Tuple "B X" determines the outcome
		mappedAgain.put("B Y", 'Y'); // Play against Paper and Y -> Draw. Choose: Y. Tuple "B Y" determines the outcome
		mappedAgain.put("B Z", 'Z'); // Play against Paper and Z -> Win. Choose: Z. Tuple "B Z" determines the outcome
		mappedAgain.put("C Z", 'X'); // Play against Scissor and Z -> Win. Choose: X. Tuple "C X" determines the outcome
		mappedAgain.put("C Y", 'Z'); // Play against Scissor and Y -> Draw. Choose: Z. Tuple "C Z" determines the outcome
		mappedAgain.put("C X", 'Y'); // Play against Scissor and X -> Lose. Choose: Y. Tuple "C Y" determines the outcome
		
		try {
			List<String> myList = Files.readAllLines(Paths.get("C:\\Users\\Naturbelassen\\eclipse-workspace\\AdventOfCode2022\\src\\aoc2022\\xyz.txt"));
			
			//Exercise 1: 
			//Get Outcome of the game + the value of the second argument
			for(String myLine : myList) {
				sum1 += mappedOutcome.get(myLine) + mappedPoints.get(myLine.charAt(2));
			}
			
			//Exercise 2: 
			//a) Determines if win/draw/lose and choose rock/paper/scissor which gives us the value
			//b) Determines outcome by constructing key from given letter A/B/C and our rock/paper/scissor from a)
			for(String miString : myList) {
				sum2 += mappedPoints.get(mappedAgain.get(miString)) +  mappedOutcome.get(miString.substring(0, 1) + " " + mappedAgain.get(miString));
			}
			System.out.println("Excercise 2_1: " + sum1);
			
			System.out.println("Excercise 2_2: " + sum2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
