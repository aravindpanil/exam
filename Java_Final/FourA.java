import java.util.Scanner;
public class FourA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your cgpa and age\n");
		
		try{
		float cgpa = sc.nextFloat();
		
		if(cgpa > 8){
			
			try{
				int age = sc.nextInt();
				
				if(age>25)
					throw new AgeOutOfRangeException();
				
				System.out.println("You are eligible\n");
			}
			
			catch(AgeOutOfRangeException e){
				System.out.println(e);
			}
		}
		
		else
			throw new LowCgpaException();

	  }
		
		catch(LowCgpaException e){
			System.out.println(e);
		}
		
	}
}

class LowCgpaException extends Exception{
	
	public String toString(){
		return("Error - you do not have enough CGPA");
	}
	
}

class AgeOutOfRangeException extends Exception{
	
	public String toString(){
		return("Error - you are too old");
	}
	
}

