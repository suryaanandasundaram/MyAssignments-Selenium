package challenge;

import java.util.Scanner;

public class MajorityElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int half = size / 2;
		if (size % 2 == 0) {
			System.out.println("Please enter odd Number");

		} 
		else 
		{
			int[] array = new int[size];
			System.out.println("Enter the elements of array");
			for (int i = 0; i < size; i++) {
				array[i] = sc.nextInt();
			}

			for (int m = 0; m < size; m++) {
				int temp = array[m];
				int count = 0;
				for (int j = 0; j < size; j++) {
					if (temp != array[j]) {
						count = count + 0;
					} else {
						count = count + 1;
					}

				}

				if (count >= half) {
					System.out.println("Majority element " + array[m]);
					break;
				}
			}

		}
	}

}
