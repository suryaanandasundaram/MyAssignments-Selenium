package week1.day2;

public class FindIntersection {
	
	public static void main(String[] args) {
		
		int[] arr1 =  {3,2,11,4,6,7};
		int[] arr2 = {1,2,8,4,9,7};
		
		int length1=arr1.length;
		int length2=arr2.length;
		
		System.out.println("Common Values in Array");
		
		for(int i=0;i<length1-1;i++)
		{
		 for(int j=0;j<length2-1;j++)
		 {
			if(arr1[i]==arr2[j])
				System.out.println(arr1[i]);
				
		 }
		 
		}
		
	}

}
