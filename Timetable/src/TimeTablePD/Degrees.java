package TimeTablePD;

import java.util.ArrayList;
import java.util.TreeMap;

public class Degrees {
	private String DegreeCode;
	private String GradSchool;
	private String DegreeName;
	private int Forecast;
	public int count;
	public ArrayList<DegreePlan> degreePlan;
    public Degrees()
    {
    	count=1;
    	degreePlan=new ArrayList<DegreePlan>();
    }
	public Degrees(String degreeCode, String gradSchool, String degreeName,
			int forecast) {
		count=1;
		DegreeCode = degreeCode;
		GradSchool = gradSchool;
		DegreeName = degreeName;
		Forecast = forecast;
	}

	public String getDegreeCode() {
		return DegreeCode;
	}

	public void setDegreeCode(String degreeCode) {
		DegreeCode = degreeCode;
	}

	public String getGradSchool() {
		return GradSchool;
	}

	public void setGradSchool(String gradSchool) {
		GradSchool = gradSchool;
	}

	public String getDegreeName() {
		return DegreeName;
	}

	public void setDegreeName(String degreeName) {
		DegreeName = degreeName;
	}

	public int getForecast() {
		return Forecast;
	}

	public void setForecast(int forecast) {
		Forecast = forecast;
	}

}
