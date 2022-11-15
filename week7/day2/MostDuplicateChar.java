package week7.day2;

import java.util.HashMap;
import java.util.Map;

public class MostDuplicateChar {
public static void main(String[] args) {
	
	String test ="abbaba";
	char[] charArray = test.toCharArray();
	int max=0;
	char maxkey=0;
	
	Map<Character,Integer> m=new HashMap<Character,Integer>();
	
	for(int i=0;i<charArray.length;i++)
	{
		char c = charArray[i];
		
		if(m.containsKey(c)==true)
		{
			int intValue = m.get(c).intValue();
			intValue=intValue+1;
			m.put(c, intValue);
			if(max<intValue)
			{
				max=intValue;
				maxkey=c;
			}
			
		}
		else
		{
			m.put(c, 1);
		}
			
	}
	
	Integer integer = m.get(maxkey);
	
	System.out.println(maxkey+" -> "+integer);
	
}
}
