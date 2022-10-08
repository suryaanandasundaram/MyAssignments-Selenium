package week1.day2;

public class MyCar {

	public static void main(String[] args) {
		
		Car car1 = new Car();
    	int addNumbers = car1.addNumbers(3,4,5);
    	System.out.println("AddNumbers :" +addNumbers);
    	
    	//int subNumbers = car1.subNumbers(700, 90);
    	//System.out.println("SubNumbers :" +subNumbers);
    	
    	float mulNumbers = car1.mulNumbers(700, 50);
    	System.out.println("MulNumbers :" +mulNumbers);
	}
	
}
