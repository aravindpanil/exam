import Student.*;
import Staff.*;
public class TwoA {

	public static void main(String[] args) {
		StudentDetails obj1 = new StudentDetails();
		StaffDetails obj2 = new StaffDetails();
		obj1.setDetails();
		obj1.calc();
		obj1.display();
		obj2.setDetails();
		obj2.display();
	}
 
}
