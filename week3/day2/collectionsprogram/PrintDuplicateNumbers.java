package collectionsprogram;
import java.util.HashSet;
import java.util.Set;
public class PrintDuplicateNumbers {
public static void main(String[] args) {
	int data[] = {4,3,6,8,29,1,2,4,7,8};
	

    Set<Integer> setValues =new HashSet<Integer>();
	
	for(int i=0;i<data.length;i++)
	{
	
		int j = data[i];
		boolean add = setValues.add(j);
		if(!add)
		{
			System.out.println("Duplicate element "+j);
		}
		
	}
	System.out.println(setValues);
}
}
