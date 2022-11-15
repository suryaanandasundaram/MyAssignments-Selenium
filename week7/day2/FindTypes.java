package week7.day2;

public class FindTypes {

	public static void main(String[] args) {
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		
		int  letter = 0, space = 0, num = 0, specialChar = 0;
		
		char[] charArray = test.toCharArray();
		for(int i=0;i<charArray.length;i++)
		{
			char j=charArray[i];
			
			if(Character.isLetter(j))
			{
				letter++;
			}
			else if(Character.isDigit(j))
			{
				num++;
			}
			else if(Character.isSpaceChar(j))
			{
				space++;
			}
			else
			{
				specialChar++;
			}
		
			
		}
		
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("specialCharcter: " + specialChar);

	}

}
