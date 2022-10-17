package week3.day2;

public class MyBankAccount {
	public static void main(String[] args) {

		HDFC h1 = new HDFC();
		System.out.println("Called using Implementation class object");
		h1.minimumBalance();
		h1.provideCreditCard();
		h1.provideDebitCard();

		System.out.println("********************");
		
		RBI r1 = new HDFC();
		System.out.println("Scope restriction of object");
		r1.minimumBalance();
		r1.provideDebitCard();
		//r1.provideCreditCard();
	}
}
