package Staff;

public class StaffDetails {

		String id, name,desig;
		String sub1,sub2,sub3;
		
		public void setDetails(){
			System.out.println("Enter id, name and designation\n");
			
			id="1MSe0229";
			name="John";
			desig="CS";
			System.out.println("Enter three subjects\n");
			sub1 = "DMS";
			sub2 = "DAA";
			sub3 = "MATH";
			
		}
		
		public void display(){
			System.out.println("Name:"+name+"\n"+"Designation:"+desig+"\n"+"Subject 1:"+sub1+"\n"+"Subject 2:"+sub2+"\n"+"Subject 3:"+sub3);
		}
}

