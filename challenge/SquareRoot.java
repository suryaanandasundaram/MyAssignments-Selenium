package challenge;
import java.util.*;
public class SquareRoot {
	
	public int sqaureRoot(int value)
	{	
		Set<Integer> oddNumberSet = new TreeSet<Integer>();
		 for(int i=1;i<value;i=i+2)
		 {
			 oddNumberSet.add(i);
		 }	
		List<Integer> oddNumberList =new ArrayList<Integer>(oddNumberSet);
		System.out.println(oddNumberList);
		int temp=value;
		int count=1;		
		for(int m=1;(m<temp&&temp!=0&&temp>0);m++)
		{
		int local =oddNumberList.get(m);
		temp= temp-local;
		count=count+1;			
		}
		System.out.println("Sqaure Root of Given Value is "+count);	
		return 	count;}
	
	public static void main(String[] args) 
		{
		
		SquareRoot s1 =new SquareRoot();
		s1.sqaureRoot(26);
	
		}

}

