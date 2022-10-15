package week3.day1;

public class LearnOverloading {

	public int add(int a, int b) {
		int sum = a + b;
		System.out.println(sum);
		return sum;
	}

	public int add(int a, int b, int c) {
		int sum = a + b + c;
		System.out.println(sum);
		return sum;
	}

	public float add(float a, float b) {
		float sum = a + b;
		System.out.println(sum);
		return sum;
	}

	public float add(int a, float b) {
		float sum = a + b;
		System.out.println(sum);
		return sum;
	}

	public static void main(String[] args) {

		LearnOverloading obj1 = new LearnOverloading();
		obj1.add(2, 7);
		obj1.add(15, 20, 60);
		obj1.add(12.5F, 14.7F);
		obj1.add(12, 14.7F);
	}

}
