package challenge;

import java.util.Scanner;

public class HappyNumber {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Number");
	int n=sc.nextInt();
	int reminder =0;
	int sum = 0;
	int temp=n;

	do {
		sum=0;
	while(temp>0)
			{
	
		reminder =temp%10;
		sum =sum+(reminder*reminder);
		temp=temp/10;
			}
	temp=sum;
	}while(temp>10);
	
	if(temp==1)
	 System.out.println("Happy Number");
	else
		System.out.println("Un-happy Number");
	 
	 
	 
}
}
