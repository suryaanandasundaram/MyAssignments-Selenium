package collectionsprogram;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class RemoveDuplicates {
	public static void main(String[] args) {
		String str1 = "PayPal India";
		char[] ch = str1.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		for (char c : ch) {
			if (Character.isWhitespace(c))
				continue;

			boolean add = charSet.add(c);
			if (!add) {
				dupCharSet.add(c);
			}

		}

		System.out.println("Character Set " + charSet);
		System.out.println("Duplicate Character Set " + dupCharSet);

		List<Character> list = new ArrayList<Character>(dupCharSet);
		for (int i = 0; i < list.size(); i++) {
			char ch1 = list.get(i);
			if (Character.isWhitespace(ch1))
				continue;
			charSet.remove(list.get(i));

		}
		System.out.println("After Removing Duplicates");
		System.out.println("Character Set " + charSet);
		System.out.println("Duplicate Character Set " + dupCharSet);

	}
}
