package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* The FileIO provides simple file input/output operations
* that serve as hands-on practice on Unit Testing.
*
* @author  gianniskokkosis
* @version 1.0
* @since   2020-04-06 
*/
public class FileIO {
	
	/**
	 * Reads a file that contains numbers line by line 
	 * and returns an array of the integers found in the file.
	 * @param filepath the file that contains the numbers
	 * @return an array of numbers
	 * @exception IllegalArgumentException when the given file does not exist
	 * @exception IllegalArgumentException when the given file is empty
	 * @exception IOException when an IO interruption occurs (not required to be tested)
	 */
	public int[] readFile(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) 
			throw new IllegalArgumentException("Input file does not exist");
		
		List<Integer> numbersList = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				int number = Integer.parseInt(line);
				numbersList.add(number);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (numbersList.size() == 0) 
			throw new IllegalArgumentException("Given file is empty");
		
		// Convert a List to an array using 
		return numbersList.stream().mapToInt(i -> i).toArray();
	}


	/**
	 * isInt takes a String as an argument and returns
	 * false if the given string does not represent an integer
	 * number. Otherwise, it returns true if the given string 
	 * represents an integer number
	 * @param input which is a String variable
	 */
	public static boolean isInt(String input){
		/*
		 * If input is null or an empty string
		 * then return false because the input variable 
		 * does not represent an integer number
		 */
		if (input == null || input.trim().isEmpty()){
			return false;
		}

		/*
		 * Loop through the characters of input variable.
		 * If one of the i'th characters of input is not a digit,
		 * then return false because it does not represent an integer
		 * number.
		 */
		for (int i = 0; i < input.length(); i++){
			if (!Character.isDigit(input.charAt(i))){
				return false;
			}
		}
		/*
		 * Otherwise return true because all the characters of
		 * input variable are digits so input variable represents
		 * an integer number
		 */ 
		return true;
	}

}
