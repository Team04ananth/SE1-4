/**
 * Teaching staff of a university.
 */
public class Faculty {

	/**
	 * name of faculty member
	 */
	private string name;
	/**
	 * a degree a faculty member can teach
	 */
	private string degree;
	private string title;
	/**
	 * days a faculty member can teach
	 */
	private string daystoteach;

	public string getName() {
		return this.name;
	}

	public void setName(string name) {
		this.name = name;
	}

	public string getDegree() {
		return this.degree;
	}

	public void setDegree(string degree) {
		this.degree = degree;
	}

	public string getTitle() {
		return this.title;
	}

	public void setTitle(string title) {
		this.title = title;
	}

	public string getDaystoteach() {
		return this.daystoteach;
	}

	public void setDaystoteach(string daystoteach) {
		this.daystoteach = daystoteach;
	}

	public Faculty() {
		// TODO - implement Faculty.Faculty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param degree
	 * @param title
	 * @param daystoteach
	 */
	public Faculty(string name, string degree, string title, string daystoteach) {
		// TODO - implement Faculty.Faculty
		throw new UnsupportedOperationException();
	}

}