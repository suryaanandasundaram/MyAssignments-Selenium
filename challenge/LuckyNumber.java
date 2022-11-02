package challenge;
import java.util.Scanner;
public class LuckyNumber {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Size of the Array");
	int size=sc.nextInt();
	int[] array =new int[size];
	System.out.println("Enter Array Elements");
	for(int i=0;i<size;i++)
	{
		array[i]=sc.nextInt();
	}
	int count=0;
	int temp=-1;

	for(int j=0;j<size;j++)
	{
		for(int m=0;m<size;m++)
		{
			if(array[j]==array[m])
			{
				count=count+1;
			}
		}
		
		if(array[j]==count)
		{
			if(temp<array[j])
			temp=array[j];
		}
		
		count=0;
	}
	
	
	System.out.println("Lucky Number " +temp);
}
}
