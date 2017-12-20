interface Test{
	void print(int a);
}

public class OneA implements Test{

	public void print(int a){
		System.out.println(a);
	}
	
	public static void main(String[] args){
		Test var = new OneA();
		var.print(34);
	}
	
}
