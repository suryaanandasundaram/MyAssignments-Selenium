package org.studentInformation;


public class Students {

		public void getStudentInfo(int id) {
			System.out.println("Student id-" + id);
		}

		public void getStudentInfo(int id, String name) {
			System.out.println("Student id-" + id);
			System.out.println("Student name-" + name);
		}

		public void getStudentInfo(String email, String phoneNumber) {
			
			System.out.println("Student email-" + email);
			System.out.println("Student phoneNumber-" + phoneNumber);
		}
		
		public static void main(String[] args) {
			Students s1 =new Students();
			System.out.println("The method called with id");
			s1.getStudentInfo(987563);
			System.out.println("The method called with id & Name");
			s1.getStudentInfo(987563, "Suryaprabha");
			System.out.println("The method called with emailid & PhoneNumber");
			s1.getStudentInfo("abc@gmail.com","9785623322");
			
		}
	}


