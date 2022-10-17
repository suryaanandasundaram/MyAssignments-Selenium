package collectionsprogram;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {
	public static void main(String[] args) {
		int[] array = { 5, 6, 9, 8, 1, 2, 3, 5, 9, 10, 7, 8, 7, 2, 1, 10, 5, 3, 3 };
		Set<Integer> set = new TreeSet<Integer>();
		for (int i : array) {
			set.add(i);
		}
		System.out.println(set);
		List<Integer> list = new ArrayList<Integer>(set);
		for (int j = 0; j <= (list.size() - 1); j++) {

			try {
				if (list.get(j) + 1 == list.get(j + 1)) {
					continue;
				}

				else {

					int missingNumber = list.get(j) + 1;
					System.out.println("Missing Number is " + missingNumber);
				}
			} catch (Exception e) {

			}
		}
	}
}
