package challenge;

import java.util.Scanner;

public class LastWordLength {
public static void main(String[] args) {
	
	System.out.println("Please enter the Sentence");
	Scanner sc=new Scanner(System.in);
	String stmt = sc.nextLine();
	String[] words = stmt.split(" ");
	
	int length = words.length;
	
	String lastWord = words[length-1];
	
	char[] charArray = lastWord.toCharArray();
	int lengthOfLastWord = charArray.length;
	System.out.println("Length of last word "+lengthOfLastWord);
	
}
}
