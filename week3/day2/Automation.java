package week3.day2;

public class Automation extends MultipleLanguage implements Language, TestTool {

	public void selenium() {
		System.out.println("Selenium Method Called");
	}

	public void java() {
		System.out.println("Java Method Called");

	}

	public void javaScript() {
		System.out.println("JavaScript Method Called");

	}

	public void ruby() {
		System.out.println("Ruby Method Called");

	}

	public static void main(String[] args) {
		Automation a1 = new Automation();
		a1.selenium();
		a1.java();
		a1.javaScript();
		a1.ruby();
		a1.python();

	}

}
