import java.util.Scanner;
public class ThreeA {

	int age;
	String name;
	
	public static void main(String[] args){
		ThreeA obj = new ThreeA();
		obj.read();
	}
	
	ThreeA(){
		
	}
	
	ThreeA(int a,String na){
		age = a;
		name = na;
		System.out.println("Name "+name+" Age "+age);
	}
	
	void read(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee name and age\n");
		
		try{
			String n = sc.nextLine();
			boolean res = isNumber(n);
			if(res)
				throw new NameException();
			int ag = sc.nextInt();
			if(ag > 50)
				throw new AgeException();
			ThreeA obj = new ThreeA(ag,n);
			
		}
			
		catch(Exception e){
			System.out.println(e);
		}
		sc.close();
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

class NameException extends Exception{
	
	public String toString(){
		return("Error:Number entered for name\n");
	}
	
}

class AgeException extends Exception{
	
	public String toString(){
		return("Error:Employee Age over 50\n");
	}
	
}