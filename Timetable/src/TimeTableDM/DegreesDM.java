package TimeTableDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import TimeTablePD.Degrees;
import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.University;

public class DegreesDM {
	public static void loadDegrees(String path) throws IOException {
//		DegreeCode,Grad School,DegreeName,Forecast
		
		String line = null;
		String[] token;
		String degreeCode;
		String gradSchoolName;
		String degreeName;
		int forecast;
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("src/"+path);
			bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				token = line.split(",");
				if (token.length < 4) {
					throw new IOException("Bad path : " + path);
				} else {
					// LastName,FirstName,Grad
					// School,Degree,Title,DaysToTeach,MaxLoadFall,MaxLoadSpring,MaxLoadSummer

					degreeCode = token[0];
					gradSchoolName=token[1];
					degreeName = token[2];
					forecast=Integer.parseInt(token[3]);
					Degrees degree=new Degrees();
					degree.setDegreeCode(degreeCode);
					degree.setDegreeName(degreeName);
					degree.setGradSchool(gradSchoolName);
					degree.setForecast(forecast);

					GradSchool grad = University
							.findGradSchoolByName(gradSchoolName);
					grad.addDegree(degree);
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
