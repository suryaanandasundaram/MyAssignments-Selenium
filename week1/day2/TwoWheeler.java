package week1.day2;

public class TwoWheeler {
	
	int noOfWheels = 2;
	short noOfMirrors = 2;
	long chassisNumber = 51049921;
	boolean isPunctured =false;
	String bikeName = "Unicorn";
	double runningKM = 2341441.14212412;
	
	public static void main(String[] args) {
		
		TwoWheeler obj = new TwoWheeler();
		
		System.out.println("No of Wheels "+obj.noOfWheels);
		System.out.println("No of Mirrors "+obj.noOfMirrors);
		System.out.println("Chassis Number "+obj.chassisNumber);
		System.out.println("Is Punctured "+obj.isPunctured);
		System.out.println("Bike Name "+obj.bikeName);
		System.out.println("Running KM "+obj.runningKM);
		
	}

}
