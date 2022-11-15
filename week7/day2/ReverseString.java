package week7.day2;

public class ReverseString {
public static void main(String[] args) {
	String test = "feeling good";
	
	char[] charArray = test.toCharArray();
	
	for(int i=charArray.length-1;i>=0;i--)
	{
		System.out.print(charArray[i]);
	}
	
	
	int length = test.length();
	
	System.out.println();
	
	for(int i=length-1;i>=0;i--)
	{
		System.out.print(test.charAt(i));
	}
	
}
}
