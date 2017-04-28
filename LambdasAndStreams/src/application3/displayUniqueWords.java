package application3;

/* -------------------------------- Problem 3 -------------------------------- */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class displayUniqueWords {

	public static void main(String[] args)
    {   
		// Creates list of type string
        ArrayList<String> wordList = new ArrayList<String>();
        
        //initialize scanner
        Scanner getUserInput = new Scanner(System.in);  // Reading from System.in

        
        //Get user input, then store words line by line
        	System.out.println("Enter sentence with no punctuation then hit enter: ");
        	String word = getUserInput.nextLine();
        	
        	//Split string into tokens using whitespace as pattern
        	StringTokenizer tokenizer = new StringTokenizer(word);

        	while(tokenizer.hasMoreTokens()) { 
        	    String token = tokenizer.nextToken();
            	wordList.add(token);
        	}

        	
        // Sorts arrayList containing words alphabetically
        wordList.sort(String::compareToIgnoreCase);


        // Writes words
        	System.out.println("\nOutput in Alphabetical order:");
        for (String pWord : wordList){
            System.out.println(pWord);
        }
        
        //Close scanner input
        getUserInput.close();
        
    }//end method main

}//end class displayUniqueWords
