package week7.day2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LearnMap {
	
	public static void main(String[] args) {
		
		Map <Character,Integer> map = new TreeMap<Character,Integer>();
		String s= "suryaprabha";
		char[] charArray = s.toCharArray();
		
			
		for(int i=0;i<charArray.length;i++)
		{
		    if(map.containsKey(charArray[i]))
		    {
		    	Integer integer = map.get(charArray[i]);
		    	integer=integer+1;
		    	map.put(charArray[i], integer);
		    	
		    }
		    else
		    	
		    {
		    	map.put(charArray[i], 1);
		    }
			
		}
		
		Set<Character> keySet = map.keySet();
		
	for (Character character : keySet) {
		
		System.out.println(character+"->"+map.get(character));
	}
		
		
		
		
		
		
		
		
		
	}

}
