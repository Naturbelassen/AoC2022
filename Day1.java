package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 0;
		int placeHolder = 0;
		try {
			List<String> myMap = Files.readAllLines(Paths.get("Path_To_Your_File")); //Add the Path to your File
			//Add all Numbers until \n is found
			//Check if plsceHolder is greater than max
			//Reset placeHolder to 0 and add again until \n is found
			for(String myString : myMap) {
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
