package TimeTableDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.University;

public class FacultyDM {

	public static void loadFaculty() throws IOException {
		loadFacultyName("TestDataFaculty.csv");
		CoursesDM.loadCourses("TestDataCourses.csv");
	}

	public static void loadFacultyName(String path) throws IOException {
		// LastName,FirstName,Grad
		// School,Degree,Title,DaysToTeach,MaxLoadFall,MaxLoadSpring,MaxLoadSummer
		String line = null;
		String[] token;
		String lastName;
		String firstName;
		String gradSchool;
		String degree;
		String title;
		String daysToTeach;
		int loadFall;
		int loadSpring;
		int loadSummer;
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("src/"+path);
			bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				token = line.split(",");
				if (token.length < 9) {
					throw new IOException("Bad path : " + path);
				} else {
					// LastName,FirstName,Grad
					// School,Degree,Title,DaysToTeach,MaxLoadFall,MaxLoadSpring,MaxLoadSummer

					firstName = token[0];
					lastName = token[1];
					gradSchool = token[2];
					degree = token[3];
					title = token[4];
					daysToTeach = token[5];
					loadFall = Integer.parseInt(token[6]);
					loadSpring = Integer.parseInt(token[7]);
					loadSummer = Integer.parseInt(token[8]);
					Faculty fac = new Faculty();
					fac.setLastName(lastName);
					fac.setFirstName(firstName);
					fac.setGradSchool(gradSchool);
					fac.setDegree(degree);
					fac.setTitle(title);
					fac.setMaxLoadFall(loadFall);
					fac.setMaxLoadSpring(loadSpring);
					fac.setMaxLoadSummer(loadSummer);
					GradSchool grad = University
							.findGradSchoolByName(gradSchool);
					grad.addFaculty(fac);
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
	public Faculty getFacultyByName(String name)
	{
	    	
		return null;
	}

}
