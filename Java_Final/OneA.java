interface Student{
	String getValue();
}

interface Department{
	float getAttendance();
	int total = 54; //change this value for total classes
}

interface exam extends Student, Department{
	void calAttendance();
	boolean eligible();
}

public class OneA implements exam{
	String sname, sno;
	int cls,attendance;
	float attper;
	
	OneA(String name,String no,int cl,int att){
		sname = name;
		sno = no;
		cls = cl;
		attendance = att;
	}
	
	public static void main(String[] args){
		OneA obj = new OneA("John Jamail","1MSCS012",9,12);
		OneA obj2 = new OneA("Jessica","1MSCS045",4,65);
		OneA obj3 = new OneA("John Jamail","1MSCS142",10,90);
		System.out.println(obj.getValue()+obj2.getValue()+obj3.getValue());
		obj.calAttendance();
		obj.getAttendance();
		System.out.println(obj.eligible());
	}
	
	public String getValue(){
		return("Name:"+sname+"\nNumber:"+sno+"\ncls:"+cls+"\n");
	}
	
	public float getAttendance(){
		return attper;
	}
	
	public void calAttendance(){
		attper = attendance/total*100;
	}

	public boolean eligible(){
		if(attper >= 85)
			return true;
		else
			return false;
	}
	
}