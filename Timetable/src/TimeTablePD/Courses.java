package TimeTablePD;
import java.util.ArrayList;
import java.util.TreeMap;

public class Courses {
	private String CourseCode;
	private String CourseName;
	private String CourseDescription;
	private int CourseHours;
	private int CourseCap;
	private char OfferedFall;
	private char OfferedSpring;
	private char OfferedSummer;
	private ArrayList<String> CoursePrereqs;
    private ArrayList<String> faculty;
	//CourseCode,Course Name,CourseDescription,CourseHours,CourseCap,OfferedFall?,OfferedSpring?,OfferedSummer?,CoursePrereqs (could be list),Teachers
	public Courses() {
		CoursePrereqs=new ArrayList<String>();
		faculty=new ArrayList<String>();
	}

	public Courses(String courseCode, String courseName,
			String courseDescription, int courseHours, int courseCap,
			char offeredFall, char offeredSpring, char offeredSummer,
			ArrayList<String> coursePrereqs, ArrayList<String> teachers) {
		CourseCode = courseCode;
		CourseName = courseName;
		CourseDescription = courseDescription;
		CourseHours = courseHours;
		CourseCap = courseCap;
		OfferedFall = offeredFall;
		OfferedSpring = offeredSpring;
		OfferedSummer = offeredSummer;
		CoursePrereqs = coursePrereqs;
	}

	public String getCourseCode() {
		return CourseCode;
	}

	public void setCoursesPreqEmpty()
	{
		CoursePrereqs=new ArrayList<String>();
	}
	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getCourseDescription() {
		return CourseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		CourseDescription = courseDescription;
	}

	public int getCourseHours() {
		return CourseHours;
	}

	public void setCourseHours(int courseHours) {
		CourseHours = courseHours;
	}

	public int getCourseCap() {
		return CourseCap;
	}

	public void setCourseCap(int courseCap) {
		CourseCap = courseCap;
	}

	public char getOfferedFall() {
		return OfferedFall;
	}

	public void setOfferedFall(char offeredFall) {
		OfferedFall = offeredFall;
	}

	public char getOfferedSpring() {
		return OfferedSpring;
	}

	public void setOfferedSpring(char offeredSpring) {
		OfferedSpring = offeredSpring;
	}

	public char getOfferedSummer() {
		return OfferedSummer;
	}

	public void setOfferedSummer(char offeredSummer) {
		OfferedSummer = offeredSummer;
	}

	public ArrayList<String> getCoursePrereqs() {
		return CoursePrereqs;
	}

	public void addCoursePrereqs(String coursePrereqs) {
		CoursePrereqs.add(coursePrereqs);
	}



    public void addFaculty(String faculty)
    {
    	this.faculty.add(faculty);   
    	}

}
