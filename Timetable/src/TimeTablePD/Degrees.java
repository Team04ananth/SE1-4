package TimeTablePD;
public class Degrees {
	private String DegreeCode;
	private String GradSchool;
	private String DegreeName;
	private int Forecast;
    public Degrees()
    {}
	public Degrees(String degreeCode, String gradSchool, String degreeName,
			int forecast) {
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
