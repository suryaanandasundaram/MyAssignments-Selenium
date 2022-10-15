package week3.day1;

public class Properties {
	public static void main(String[] args) {

		Vehicle v1 = new Vehicle();
		v1.applyBreak();
		v1.soundHorn();

		Car c1 = new Car();
		c1.applyBreak();
		c1.soundHorn();
		c1.openSunroof();
		c1.turnOnAC();

		BMW b1 = new BMW();
		b1.applyBreak();
		b1.soundHorn();
		b1.openSunroof();
		b1.turnOnAC();
		b1.autoPark();

		Audi a1 = new Audi();
		a1.applyBreak();
		a1.soundHorn();
		a1.openSunroof();
		a1.turnOnAC();
		a1.hybridFuel();

		Auto au1 = new Auto();
		au1.applyBreak();
		au1.soundHorn();
		au1.handStarter();

		Bajaj ba1 = new Bajaj();
		ba1.applyBreak();
		ba1.soundHorn();
		ba1.electronicMeter();
		
		System.out.println("*************");
		a1.applyBreak();
		a1.parentapplyBreak();
		

	}
}
