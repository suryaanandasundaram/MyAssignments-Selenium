package week7.day2;

public class ReverseEvenWords {
public static void main(String[] args) {
	String test = "I am a software tester"; 
	String[] testArray = test.split(" ");
	
	for(int i=0;i<testArray.length;i++)
	{
		if(i%2!=0)
		{
			String reverse="";
			char[] charArray = testArray[i].toCharArray();
			for(int j=charArray.length-1;j>=0;j--)
			{
				reverse =reverse+charArray[j];
			}
			
			testArray[i]=reverse;
			
		}
	}
	
	for (String string : testArray) {
		System.out.print(string+" ");
		
	}
	
}
}
