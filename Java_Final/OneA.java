interface Test{
	void print(int a);
}

public class OneA implements Test{

	public void print(int a){
		System.out.println(a);
	}
	
	public static void main(String[] args){
		OneA obj = new OneA();
		obj.print(34);
	}
	
}
