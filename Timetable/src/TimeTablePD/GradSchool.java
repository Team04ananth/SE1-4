package TimeTablePD;

import java.util.TreeMap;

public class GradSchool {
	private String GradSchoolAbbrev;
	private String GradSchoolName;
	public TreeMap<String,Faculty> faculties;
	public TreeMap<String,Degrees>degrees;
	

	public GradSchool()
	{
		degrees=new TreeMap<String, Degrees>();
		faculties=new TreeMap<String, Faculty>();
	}
	public GradSchool(String gradSchoolAbbrev, String gradSchoolName) {
		super();
		GradSchoolAbbrev = gradSchoolAbbrev;
		GradSchoolName = gradSchoolName;
	}

	public void addFaculty(Faculty faculty)
	{
		faculties.put(faculty.getLastName(), faculty);
	}
	public void addDegree(Degrees d)
	{
		degrees.put(d.getDegreeCode(), d);
	}
	public String getGradSchoolAbbrev() {
		return GradSchoolAbbrev;
	}

	public void setGradSchoolAbbrev(String gradSchoolAbbrev) {
		GradSchoolAbbrev = gradSchoolAbbrev;
	}

	public String getGradSchoolName() {
		return GradSchoolName;
	}

	public void setGradSchoolName(String gradSchoolName) {
		GradSchoolName = gradSchoolName;
	}
  public void removeFaculty(Faculty f)
  {
	  faculties.remove(f.getLastName());
  }

}
