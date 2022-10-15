package org.system;

public class Desktop extends Computer{
protected void desktopSize()
{
System.out.println("Desktop Size-1980*1080");	
}
public static void main(String[] args) {
	
	Desktop d1=new Desktop();
	d1.computerModel();
	d1.desktopSize();
}
}
