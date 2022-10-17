package collectionsprogram;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {
public static void main(String[] args) {
	String[] array=new String[] {"HCL", "Wipro","Aspire Systems","CTS"};
	
	List<String> strList =Arrays.asList(array);
	System.out.println("Before Sorting");
	System.out.println(strList);
	Collections.sort(strList);
	Collections.reverse(strList);
	System.out.println("After Sorting");
	System.out.println(strList);
	
}
}
