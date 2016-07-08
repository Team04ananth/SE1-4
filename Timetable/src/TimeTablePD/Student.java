package TimeTablePD;

import java.util.ArrayList;

public class Student {
private String studentID;
private String degreeCode;
private String semCode;
public ArrayList<String> coursesLeft;
public Student()
{
	coursesLeft=new ArrayList<String>();
}

public String getStudentID() {
	return studentID;
}

public void setStudentID(String studentID) {
	this.studentID = studentID;
}

public String getDegreeCode() {
	return degreeCode;
}

public void setDegreeCode(String degreeCode) {
	this.degreeCode = degreeCode;
}

public String getSemCode() {
	return semCode;
}

public void setSemCode(String semCode) {
	this.semCode = semCode;
}


}
