package TimeTableDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import TimeTablePD.Semesters;
import TimeTablePD.University;

public class SemesterDM {
	public static void loadSemesters(University university, String path)
			throws IOException {
		String line = null;
		String[] token;
		String semName;
		String startDate;
		String endDate;
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("src/" + path);
			bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				token = line.split(",");
				if (token.length < 3) {
					throw new IOException("Bad path : " + path);
				} else {
					semName = token[0];
					startDate = token[1];
					endDate = token[2];
					System.out.println(semName+" "+startDate+" "+endDate+" ");
					Semesters sem = new Semesters();
					sem.setSemesterName(semName);
					sem.setStartDate(startDate);
					sem.setEndDate(endDate);
					university.addSemester(sem);
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
