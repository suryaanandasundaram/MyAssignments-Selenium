package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LearnList {
public static void main(String[] args) {
	
	List<Integer> intlist =new ArrayList<Integer>();
	//Array converted to List
	//List<Integer> intlist1 =Arrays.asList(23,54,67,55,66,42,27,89);
	intlist.add(23);
	intlist.add(54);
	intlist.add(67);
	intlist.add(55);
	intlist.add(66);
	intlist.add(42);
	intlist.add(27);
	intlist.add(89);
	System.out.println(intlist);
	Collections.sort(intlist);
	System.out.println("Sorting Order");
	System.out.println(intlist);
	System.out.println("The odd Numbers from the Integer list");
	for(int eachValue:intlist)
	{
		if(eachValue%2!=0)
			System.out.println(eachValue);
			
	}
	
	System.out.println("********************");
	
	List<String> strlist =new ArrayList<String>();
	//List<String> strlist1 =Arrays.asList("Arun","Deepa","Maria","Deepa","Sharmila","Muthu","Chinrasu");
	

	strlist.add("Arun");
	strlist.add("Deepa");
	strlist.add("Maria");
	strlist.add("Deepa");
	strlist.add("Sharmila");
	strlist.add("Muthu");
	strlist.add("Chinrasu");
	System.out.println(strlist);
	System.out.println("Names starting with M");
	for(String value:strlist)
	{
		if(value.startsWith("M"))
			System.out.println(value);
	}
	
	
}
}
