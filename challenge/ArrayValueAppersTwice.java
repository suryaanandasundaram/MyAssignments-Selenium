package challenge;

import java.util.Scanner;

public class ArrayValueAppersTwice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements of array");
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		int count = 0;
		for (int m = 0; m < size; m++) {
			int temp = array[m];
			for (int j = m + 1; j < size; j++) {
				if (temp == array[j]) {
					count = count + 1;
				} else {
					count = count + 0;
				}}}

		if (count > 0) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}
}
