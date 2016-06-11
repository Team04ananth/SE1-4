/**
 * A degree plan is "major specific" and is established through collaboration between the schedule and the academic advisor for the student's major.
 */
public class DegreePlan {

	SemesterForecast semesterForecasts;
	/**
	 * code of the degree plan
	 */
	private string code;
	/**
	 * name of the degree plan
	 */
	private string name;
	/**
	 * degree plan department
	 */
	private string department;
	/**
	 * degree plan track MSE, MSCS
	 */
	private string track;

	public string getCode() {
		return this.code;
	}

	public void setCode(string code) {
		this.code = code;
	}

	public string getName() {
		return this.name;
	}

	public void setName(string name) {
		this.name = name;
	}

	public string getDepartment() {
		return this.department;
	}

	public void setDepartment(string department) {
		this.department = department;
	}

	public string getTrack() {
		return this.track;
	}

	public void setTrack(string track) {
		this.track = track;
	}

	public void numberCourseNeeded() {
		// TODO - implement DegreePlan.numberCourseNeeded
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param student
	 */
	public void listCourseToTake(studentCourses student) {
		// TODO - implement DegreePlan.listCourseToTake
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param code
	 * @param name
	 * @param dept
	 * @param track
	 */
	public void degree(string code, string name, string dept, string track) {
		// TODO - implement DegreePlan.degree
		throw new UnsupportedOperationException();
	}

}