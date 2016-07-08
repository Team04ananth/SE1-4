package TimeTableDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import TimeTablePD.*;

public class UniversityDM {

	public static boolean loadUniversity(University university) {
		boolean success = true;
		try {
			loadUniversityName(university, "TestDataUniversityName.csv");
			SemesterDM.loadSemesters(university, "TestDataSemesters.csv");
			GradSchoolDM.loadGradSchool(university);
			DegreePlanDM.loadDegreePlan("TestDataDegreePlanReq.csv");

		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			success = false;

		}

		return success;
	}

	public static void loadUniversityName(University university, String fileName)
			throws IOException {
		String line = null;
		String[] token;
		String abbrev;
		String name;
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("src/" + fileName);
			bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			line = bufferedReader.readLine();
			token = line.split(",");
			if (token.length < 2) {
				throw new IOException("Bad path : " + fileName);
			} else {
				name = token[0];
				abbrev = token[1];
				System.out.println(name+" "+abbrev+" ");
				university.setName(name);
				university.setAbbreviation(abbrev);
			}

		} catch (FileNotFoundException ex) {
			System.out.println(" Unable to open file " + fileName);
			throw ex;
		} catch (IOException e) {
			System.out.println("Error reading file " + fileName);
			throw e;
		} finally {
			if (bufferedReader != null)
				bufferedReader.close();
		}
	}

}
