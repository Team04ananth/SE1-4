package controller;
import java.util.ArrayList;

import TimeTableDM.UniversityDM;
import TimeTablePD.Student;
import TimeTablePD.StudentCourses;
import TimeTablePD.University;


public class Main {
	

	public static ArrayList<StudentCourses> studentCourses;	
	public static ArrayList<Student> student;
	public static University university=new University();
	
public static void main(String[] args) {
	UniversityDM uniDM=new UniversityDM();
	University uni=new University();
	uniDM.loadUniversity(uni);
	System.out.println("loaded successfully");
}
	
}
