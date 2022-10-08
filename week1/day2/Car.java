package week1.day2;

public class Car 

{	
	public void printCarName()
    {
    	System.out.println("Carname is BMW");
    }
    
    public int getRegNumber()
    
    {
    	int regNumber = 7865;
        return regNumber; 		
	}
    
    public String getColor()
    {
    	String color = "Black";
    	return color;
    }
    
    public boolean isCarPuncture()
    
    {
    	boolean isPuncture = true;
    	return isPuncture;
    }
    
    public int addNumbers(int num1,int num2,int num3)
    
    {
    	int sum = num1+num2+num3;
    	return sum;
    }
    
    private int subNumbers(int num4, int num5)
    {
    	int sub = num4-num5;
    	return sub;
    }
    
    float mulNumbers(float num6,float num7)
    
    {
    	float mul = num6*num7;
    	return mul;
    }
    public int divNumbers(int num8, int num9)
    
    {
    	int  div=num8/num9;
    	return div;
    }

    public static void main(String[] args) 
    {		
      
    	Car car1 = new Car();
    	int addNumbers = car1.addNumbers(3,4,5);
    	System.out.println("AddNumbers :" +addNumbers);
    	
    	int subNumbers = car1.subNumbers(700, 90);
    	System.out.println("SubNumbers :" +subNumbers);
    	
    	float mulNumbers = car1.mulNumbers(700, 50);
    	System.out.println("MulNumbers :" +mulNumbers);
    }    
    
}

