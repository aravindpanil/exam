package Staff;
import java.util.Scanner;

public class StaffDetails {

		String id, name,desig;
		String sub1,sub2,sub3;
		
		public void setDetails(){
			System.out.println("Enter id, name and designation\n");
			Scanner sc = new Scanner(System.in);
			id=sc.nextLine();
			name=sc.nextLine();
			desig=sc.nextLine();
			System.out.println("Enter three subjects\n");
			sub1 = sc.nextLine();
			sub2 = sc.nextLine();
			sub3 = sc.nextLine();
			sc.close();
		}
		
		public void display(){
			System.out.println("Name:"+name+"\n"+"Designation:"+desig+"\n"+"Subject 1:"+sub1+"\n"+"Subject 2:"+sub2+"\n"+"Subject 3:"+sub3);
		}
}

