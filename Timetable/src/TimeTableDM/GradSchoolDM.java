package TimeTableDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.Semesters;
import TimeTablePD.University;

public class GradSchoolDM {

	public static void loadGradSchool(University university) throws IOException {

		loadGradSchoolName(university, "TestDataGradSchools.csv");
		FacultyDM.loadFaculty();
		DegreesDM.loadDegrees("TestDataDegrees.csv");
	}

	public static void loadGradSchoolName(University university, String path)
			throws IOException {
		String line = null;
		String[] token;
		String abbrev;
		String name;
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("src/"+path);
			bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				token = line.split(",");
				if (token.length < 2) {
					throw new IOException("Bad path : " + path);
				} else {
					abbrev = token[0];
					name = token[1];

					GradSchool grad = new GradSchool();
					grad.setGradSchoolAbbrev(abbrev);
					grad.setGradSchoolName(name);
					university.addGradSchool(grad);
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println(" Unable to open file " + path);
			throw ex;
		} catch (IOException e) {
			System.out.println("Error reading file " + path);
			throw e;
		} finally {
			if (bufferedReader != null)
				bufferedReader.close();
		}

	}

}
