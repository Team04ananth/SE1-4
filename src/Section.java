import com.sun.corba.se.spi.orbutil.fsm.State;

/**
 * A section is a class assigned for a lecture.
 */
public class Section {

	Schedule schedules;
	/**
	 * section number
	 */
	private int number;

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void numberStudents() {
		// TODO - implement Section.numberStudents
		throw new UnsupportedOperationException();
	}

	public void calPercentCap() {
		// TODO - implement Section.calPercentCap
		throw new UnsupportedOperationException();
	}

	public Section() {
		// TODO - implement Section.Section
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param number
	 * @param schedule
	 */
	public void section(int number, State schedule) {
		// TODO - implement Section.section
		throw new UnsupportedOperationException();
	}

}