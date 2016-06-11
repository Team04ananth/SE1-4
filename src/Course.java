/**
 * A course is a unit of teaching that typically lasts one academic term, is led by one or more instructors.
 */
public class Course {

	/**
	 * course number
	 */
	private string number;
	/**
	 * course name
	 */
	private string name;
	/**
	 * description of course
	 */
	private string description;
	/**
	 * credit hours of the course
	 */
	private int creditHours;
	/**
	 * class cap of the course
	 */
	private int classCap;

	public string getNumber() {
		return this.number;
	}

	public void setNumber(string number) {
		this.number = number;
	}

	public string getName() {
		return this.name;
	}

	public void setName(string name) {
		this.name = name;
	}

	public string getDescription() {
		return this.description;
	}

	public void setDescription(string description) {
		this.description = description;
	}

	public int getCreditHours() {
		return this.creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public int getClassCap() {
		return this.classCap;
	}

	public void setClassCap(int classCap) {
		this.classCap = classCap;
	}

	public void course() {
		// TODO - implement Course.course
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param number
	 * @param name
	 * @param description
	 * @param credithours
	 * @param classcap
	 */
	public void course(string number, string name, string description, int credithours, int classcap) {
		// TODO - implement Course.course
		throw new UnsupportedOperationException();
	}

}