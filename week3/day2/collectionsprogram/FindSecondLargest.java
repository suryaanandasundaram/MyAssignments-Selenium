package collectionsprogram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {
public static void main(String[] args) {
	int[] data = {3,2,11,4,6,7,2,3,3,6,7};
	 Set<Integer> setValues =new TreeSet<Integer>();
	 for(int i=0;i<data.length;i++)
		{
		 int j = data[i];
		 setValues.add(j);
		}
	 List<Integer> listValues =new ArrayList<Integer>(setValues);
	 System.out.println(listValues);
	 int size = listValues.size();
	 System.out.println("List size " +size);
	 Integer integer = listValues.get(size-2);
	 System.out.println("Second Largest Number " +integer);
	 
}
}
