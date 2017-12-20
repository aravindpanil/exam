package Student;
import java.util.Scanner;
public class StudentDetails {

	String USN, dept;
	int sub1,sub2,sub3;
	float sgpa;
	char grade;
	public static void main(String[] args) {
		StudentDetails obj = new StudentDetails();
		obj.setDetails();
		obj.calc();
		obj.display();
	}
	
	void setDetails(){
		System.out.println("Enter USN and department name\n");
		Scanner sc = new Scanner(System.in);
		USN=sc.nextLine();
		dept=sc.nextLine();
		System.out.println("Enter marks in three subjects\n");
		sub1 = sc.nextInt();
		sub2 = sc.nextInt();
		sub3 = sc.nextInt();
		sc.close();
	}
	
	void calc(){
		sgpa = (sub1+sub2+sub3)/30;
		
		switch(Math.round(sgpa)){
			case 10: grade = 'S';
					 break;
			case 9: grade = 'A';
					break;
			case 8: grade = 'B';
			 		 break;
			case 7: grade = 'C';
			 		 break;
			case 6: grade = 'D';
			 		 break;
			case 5: grade = 'E';
			 		 break;
			default: grade = 'F';
		}
		
	}
	
	void display(){
		System.out.println("USN:"+USN+"\n"+"Department:"+dept+"\n"+"Subject 1:"+sub1+"\n"+"Subject 2:"+sub2+"\n"+"Subject 3:"+sub3);
		System.out.println("SGPA is "+sgpa+" and grade is "+grade);
	}
	
}
