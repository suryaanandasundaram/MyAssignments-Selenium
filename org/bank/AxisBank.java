package org.bank;

public class AxisBank extends BankInfo {
	public void deposit() {
		System.out.println("Deposit method -Axis Bank");
	}

	public void parentDeposit() {
		super.deposit();
	}

	public static void main(String[] args) {
		AxisBank a1 = new AxisBank();
		a1.deposit();
		a1.fixed();
		a1.saving();
		a1.parentDeposit();

	}
}
