package week7.day2;

public class Palindrome {

	public static void main(String[] args) {
		
		String value= "madam";
		String reverse="";
		
		char[] charArray = value.toCharArray();
		int length = charArray.length;
	
		for(int i=length-1;i>=0;i--)
		{
			reverse=reverse+charArray[i];
			
		}
	
		
		if(value.equalsIgnoreCase(reverse))
		{
			System.out.println("Given String \""+value+"\" is Palindrome");
		}
		
	}

	
	
	
	
	
	

}
