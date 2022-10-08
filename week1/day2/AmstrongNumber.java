package week1.day2;

public class AmstrongNumber {

	public static void main(String[] args) {
		
		int input =153;
		int calculated=0;
		int reminder;
		int original;
		
		original=input;
		
		while(input>0)
		{
			reminder=input % 10;
			input =input/10;
			calculated=calculated+(reminder*reminder*reminder);
			
		}
		
		if(calculated==original)
			System.out.println("This is Amstrong Number");
		else
			System.out.println("This is not Amstrong Number");
	}
}
