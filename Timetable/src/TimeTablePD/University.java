package TimeTablePD;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class University
 {
	private String name;
	private String abbreviation;
	public static TreeMap<String,GradSchool> gradSchools;
	public static TreeMap<String,Semesters> semesters;
	public static TreeMap<String,Courses> courses;
	
	//ArrayList<Courses> courses;
	//ArrayList<Degrees> degrees;
	//ArrayList<Faculty> faculty;


	
	
	public University(String name, String abbrevation) {
		this();
		this.name = name;
		this.abbreviation = abbrevation;
	}
	
	public ArrayList<Faculty> getAllFaculty()
	{
		
		ArrayList<Faculty> c=new ArrayList<Faculty>();
		for(Map.Entry<String,GradSchool> entry :gradSchools.entrySet()) {
			  GradSchool value = entry.getValue();
			  for(Map.Entry<String,Faculty> m:value.faculties.entrySet() )
			  {
				  Faculty f=m.getValue();
				  c.add(f);
			  }
 //             c.add(value.getCourseCode());
			 // System.out.println(key + " => " + value);
			}
		return c;
	}

	public ArrayList<String> getAllCourseCodes()
	{
		ArrayList<String> c=new ArrayList<String>();
		for(Map.Entry<String,Courses> entry : courses.entrySet()) {
			  String key = entry.getKey();
			  Courses value = entry.getValue();
              c.add(value.getCourseCode());
			 // System.out.println(key + " => " + value);
			}
		return c;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public University() {
		gradSchools=new TreeMap<String,GradSchool>();
		semesters=new TreeMap<String, Semesters>();
		courses=new TreeMap<String, Courses>();
				
	}
	public static void addSemester(Semesters sem)
	{
		semesters.put(sem.getSemesterName(), sem);
	}

	public static void addGradSchool(GradSchool grad)
	{
		gradSchools.put(grad.getGradSchoolAbbrev(), grad);
	}

	public static void addCourses(Courses c)
	{
		courses.put(c.getCourseCode(),c);
	}
	public static GradSchool findGradSchoolByName(String name)
	{
		if(name.equals(""))
			return null;
		GradSchool gradSchool=gradSchools.get(name);
		return gradSchool;
	}
	/*
	
	///////////////////////////////////////////////////////////////////
	public void loadUniversityDetails() {
		loadUniversityName();
		loadCourses();
		loadDegrees();
		loadFaculty();
	}

     
	
	
	
	public void loadUniversityName() {
		try

		{
			File file = new File(Property.filePath
					+ "TestDataUniversityName");
			List<String> lines = Files.readAllLines(file.toPath(),
					StandardCharsets.UTF_8);
			int i = 0;
			for (String line : lines) {
				String[] array = line.split(",");
				if (i == 0) {
					i = 1;
					continue;
				}

				this.Name = array[0];
				this.Abbreviation = array[1];
			}
		} catch (IOException e) {

		}
	}

	public void loadCourses() {
		try

		{
			File file = new File(Property.filePath + "TestDataCourses.csv");
			List<String> lines = Files.readAllLines(file.toPath(),
					StandardCharsets.UTF_8);
			int i = 0;			for (String line : lines) {
				String[] array = line.split(",");
				
				  if (i == 0) { i = 1; continue; }
				 
				Courses c = new Courses();
				c.setCourseCode(array[0]);
				c.setCourseName(array[1]);
				c.setCourseDescription(array[2]);
				c.setCourseHours(array[3]);
				c.setCourseCap(array[4]);
				c.setOfferedFall(array[5]);
				c.setOfferedSpring(array[6]);
				c.setOfferedSummer(array[7]);
				ArrayList<String> coursePrep = new ArrayList<String>();
				coursePrep.add(array[8]);
				c.setCoursePrereqs(coursePrep);
				ArrayList<String> teacher = new ArrayList<String>();
				teacher.add(array[9]);
				c.setTeachers(teacher);
				courses.add(c);
			}
		} catch (IOException e) {

		}
	}

	public void loadDegrees() {
		try

		{
			File file = new File(Property.filePath + "TestDataDegrees.csv");
			List<String> lines = Files.readAllLines(file.toPath(),
					StandardCharsets.UTF_8);
			int i = 0;
			for (String line : lines) {
				String[] array = line.split(",");

				if (i == 0) {
					i = 1;
					continue;
				}

				Degrees d = new Degrees();
				d.setDegreeCode(array[0]);
				d.setGradSchool(array[1]);
				d.setDegreeName(array[2]);
				d.setForecast(array[3]);

				degrees.add(d);
			}
		} catch (IOException e) {

		}
	}

	public void loadFaculty() {
		try

		{
			File file = new File(Property.filePath + "TestDataFaculty.csv");
			List<String> lines = Files.readAllLines(file.toPath(),
					StandardCharsets.UTF_8);
			int i = 0;
			for (String line : lines) {
				String[] array = line.split(",");

				if (i == 0) {
					i = 1;
					continue;
				}
				Faculty f = new Faculty();
				f.setLastName(array[0]);
				f.setFirstName(array[1]);
				f.setGradSchool(array[2]);
				f.setDegree(array[3]);
				f.setTitle(array[4]);
				f.setDaysToTeach(array[5]);
				f.setMaxLoadFall(array[6]);
				f.setMaxLoadSpring(array[7]);
				f.setMaxLoadSummer(array[8]);
				f.setMaxLoadFall(array[9]);
				faculty.add(f);
			}
		} catch (IOException e) {

		}
	}
	
	*/
}
