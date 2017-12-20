interface Student{
	String sname = "";
	String sno = "";
	int cls = 0;
	String getValue();
}

interface Department{
	int dno = 0;
	float getAttendance();
}

interface exam extends Student, Department{
	void calAttendance();
	boolean eligible();
}
