package week1.day2;

public class SumOfDigits {
	
	public static void main(String[] args) {
		
		int input =123;
		int sum=0;
		while(input>0)
		{
			int reminder = input%10;
			input =input/10;
			System.out.println(reminder);
			
			sum=sum+reminder;
		}
		
		System.out.println("Sum of Digits "+sum);
	}

}
