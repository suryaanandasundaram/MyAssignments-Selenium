package week3.day1;

public class Audi extends Car {
	public void hybridFuel() {
		System.out.println("Hybrid Fuel");
	}
	public void applyBreak() {
		System.out.println("Break Applied-Audi");
	}
	public void parentapplyBreak() {
		System.out.println("The Parent Method Called from Sub Class");
		super.applyBreak();
	}
}
