package week7.day2;



public class CharOccurance {
	public static void main(String[] args) {
		
		String str = "welcome to chennai";
		char value ='e';
		int count=0;
		
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++)
		{
			if(value==charArray[i])
				count++;
		}
		
		System.out.println("No of CharOccurance : " +value+" "+count);
	}
}
