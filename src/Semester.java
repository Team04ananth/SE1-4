/**
 * A term in a college or University, lasting fifteen to eighteen weeks.
 */
public class Semester {

	Schedule schedules;
	/**
	 * name of the semester
	 */
	private string name;
	/**
	 * start date of the semester
	 */
	private date startDate;
	/**
	 * end date of the semester
	 */
	private date endDate;

	public string getName() {
		return this.name;
	}

	public void setName(string name) {
		this.name = name;
	}

	public date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(date startDate) {
		this.startDate = startDate;
	}

	public date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(date endDate) {
		this.endDate = endDate;
	}

	public void semester() {
		// TODO - implement Semester.semester
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param startdate
	 * @param enddate
	 */
	public void semester(string name, date startdate, date enddate) {
		// TODO - implement Semester.semester
		throw new UnsupportedOperationException();
	}

}