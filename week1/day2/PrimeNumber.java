package week1.day2;

public class PrimeNumber {

	public static void main(String[] args) {
		
		int input = 13;
		boolean flag =false;
		int reminder;
		int half= input/2;
		for(int i=2;i<=half;i++)
		{
			reminder=input%i;
		if(reminder==0)
		{	flag=true;
		    break;
	    }
		}
		if(flag==true)
		System.out.println("Not a Prime");
		else
		System.out.println("Prime");
}}
