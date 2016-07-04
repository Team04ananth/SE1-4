package TimeTablePD;

public class Semesters {
private String SemesterName;
private String StartDate;
private String EndDate;
public Semesters(String semesterName, String startDate, String endDate) {
	SemesterName = semesterName;
	StartDate = startDate;
	EndDate = endDate;
}
public Semesters()
{
	SemesterName="";
	StartDate="";
	EndDate="";
	
			
}

public String getSemesterName() {
	return SemesterName;
}
public void setSemesterName(String semesterName) {
	SemesterName = semesterName;
}
public String getStartDate() {
	return StartDate;
}
public void setStartDate(String startDate) {
	StartDate = startDate;
}
public String getEndDate() {
	return EndDate;
}
public void setEndDate(String endDate) {
	EndDate = endDate;
}


}
