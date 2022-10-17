package collectionsprogram;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesWords {
public static void main(String[] args) {
	String text = "We learn java basics as part of java sessions in java week1";
	System.out.println(text);
	String[] strArray =text.split(" ");
	Set<String> set =new LinkedHashSet<String>();
	for(String s:strArray)
	{
		set.add(s);
	}
	
	System.out.println(set);
}
}
