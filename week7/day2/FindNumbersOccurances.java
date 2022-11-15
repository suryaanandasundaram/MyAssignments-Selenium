package week7.day2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FindNumbersOccurances {

	

	public static void main(String[] args) {
		
		int array[] = {2,3,5,6,3,2,1,4,2,1,6,-1};
		
		Map<Integer,Integer> m =new TreeMap<Integer,Integer>();
		
		for(int i=0; i<array.length;i++)
		{
			int temp=array[i];
			
			if(m.containsKey(temp)==true)
			{
				int intValue = m.get(temp).intValue();
				intValue=intValue+1;
				
				m.put(temp, intValue);
			}
			else
			{
				m.put(temp, 1);
			}
		}
		
	   
		    Set<Integer> keySet2 = m.keySet();
	   
		    for (Integer integer : keySet2) {
		    	
		    	Integer integer2 = m.get(integer);
		    	
		    	System.out.println(integer +"->"+integer2);
				
			}
		

	}

}
