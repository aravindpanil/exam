import java.util.Scanner;
public class ThreeA {

	int age;
	String name;
	public static void main(String[] args) {
		ThreeA obj = new ThreeA();
		obj.read();
	}
	
	void read(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee name and age\n");
		
		try{
			String n = sc.nextLine();
			boolean res = isNumber(n);
			if(res)
				throw new NameException("Integer Entered For Name\n");
			int ag = sc.nextInt();
			if(ag > 50)
				throw new AgeException("Employee over 50\n");
		}
			
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	boolean isNumber(String n){
		try{
			int ch = Integer.parseInt(n);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}

}
