package TimeTableDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.poi.ss.formula.functions.IfFunc;

import TimeTablePD.Courses;
import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.University;

public class CoursesDM {

	public static void loadCourses(String path) throws IOException {
		System.out.println("Reading Coures");
		// CourseCode,Course
		// Name,CourseDescription,CourseHours,CourseCap,OfferedFall?,
		// OfferedSpring?,OfferedSummer?,CoursePrereqs (could be list),Teachers
		String line = null;
		String[] token;
		String courseCode;
		String courseName;
		String courseDesc;
		int courseHours;
		int courseCap;
		char offerFall;
		char offerSpring;
		char offerSummer;
		ArrayList<String> coursePrereqs;
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("src/"+path);
			bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				Courses c=new Courses();
				
				coursePrereqs = new ArrayList<String>();

				int commaIndex = line.indexOf(',');
				int quoteIndex = line.indexOf('"');
				if (quoteIndex == -1) {
					token = line.split(",");
					courseCode = token[0];
					//System.out.print("   Corse code: "+courseCode);
					c.setCourseCode(courseCode);
					
					courseName = token[1];
					//System.out.print("  Corse name: "+courseName);

					c.setCourseName(courseName);
					courseDesc = token[2];
					//System.out.print("  Corse desc: "+courseDesc);

					c.setCourseDescription(courseDesc);
					courseHours=Integer.parseInt(token[3]);
					//System.out.print("  Corse hours: "+courseHours);

					courseCap=Integer.parseInt(token[4]);
					//System.out.print("  Corse Cap: "+courseCap);

					c.setCourseHours(courseHours);
					
					c.setCourseCap(courseCap);
					offerFall = token[5].charAt(0);
					c.setOfferedFall(offerFall);

					offerSpring = token[6].charAt(0);
					c.setOfferedSpring(offerSpring);
					offerSummer = token[7].charAt(0);
					//System.out.print("  "+offerFall+" "+offerSpring+" "+offerSummer);

					c.setOfferedSummer(offerSummer);
					String preq = token[8];
	//				System.out.println("pres added ->"+preq);

					if (!preq.equals("none")) {
						
						c.addCoursePrereqs(preq);
					}
					String fac=token[9];
					c.addFaculty(fac);
					University.addCourses(c);
				} else {
//					System.out.println("------------------------------------------------------------");
					courseCode = line.substring(0, commaIndex);
	//				System.out.print("Course code --"+courseCode+"---");
					c.setCourseCode(courseCode);
					int save = commaIndex;
					commaIndex = line.indexOf(',', commaIndex + 1);
					courseName = line.substring(save + 1, commaIndex);
		//			System.out.print("Course name --"+courseName+"---");

					c.setCourseName(courseName);
					save = commaIndex;
					commaIndex = line.indexOf(',', commaIndex + 1);
					int nextQuoteIndex;
					if (quoteIndex < commaIndex) {
						nextQuoteIndex = line.indexOf('"', quoteIndex + 1);
						courseDesc = line.substring(quoteIndex + 1,
								nextQuoteIndex);
						c.setCourseDescription(courseDesc);
		//				System.out.print("Course desc --"+courseDesc+"---");

						save = line.indexOf(',', nextQuoteIndex);
					} else {
						save = commaIndex;
						commaIndex = line.indexOf(',', commaIndex + 1);
						courseDesc = line.substring(save + 1, commaIndex);
						c.setCourseDescription(courseDesc);
			//			System.out.print("Course desc --"+courseDesc+"---");

						nextQuoteIndex = commaIndex;
						save = nextQuoteIndex;
					}
					// save=nextQuoteIndex;
					commaIndex = line.indexOf(',', save + 1);
					courseHours = Integer.parseInt(line.substring(save + 1,
							commaIndex));
			//		System.out.print("Course hours --"+courseHours+"---");

					c.setCourseHours(courseHours);
					save = commaIndex;
					commaIndex = line.indexOf(',', save + 1);
					courseCap = Integer.parseInt(line.substring(save + 1,
							commaIndex));
		//			System.out.println("Course cap --"+courseCap+"---");

					c.setCourseCap(courseCap);
					save = commaIndex;
					commaIndex = line.indexOf(',', save + 1);
					offerFall = line.substring(save + 1, commaIndex).charAt(0);
			//		System.out.println("offerfall --"+offerFall+"---");

					c.setOfferedFall(offerFall);
					save = commaIndex;
					commaIndex = line.indexOf(',', save + 1);
					offerSpring = line.substring(save + 1, commaIndex)
							.charAt(0);
				//	System.out.println("offerSpring --"+offerSpring+"---");

					c.setOfferedSpring(offerSpring);
					save = commaIndex;
					commaIndex = line.indexOf(',', save + 1);
					offerSummer = line.substring(save + 1, commaIndex)
							.charAt(0);
			//		System.out.println("offersummer --"+offerSummer+"---");

					c.setOfferedSummer(offerSummer);
					save = commaIndex;
					nextQuoteIndex = line.indexOf('"', commaIndex + 1);
					int nextComma = line.indexOf(',', commaIndex + 1);
					
					if (nextQuoteIndex != -1 && nextQuoteIndex < nextComma) {
						save = nextQuoteIndex;
						nextQuoteIndex = line.indexOf('"', nextQuoteIndex + 1);
						String pre = line.substring(save + 1, nextQuoteIndex);
						String tokenPre[] = pre.split(",");
						for (int k = 0; k < tokenPre.length; k++)
							{//System.out.println("preq==="+tokenPre[k]+"===");
							
							c.addCoursePrereqs(tokenPre[k]);
							}
							save = nextComma;
					} else {
						String ss = line.substring(save + 1, nextComma);
						if (!ss.equals("none")) {
			//				System.out.println("preq==="+ss+"===");
							c.addCoursePrereqs(ss);
						}
						save = nextComma;
					}
					nextQuoteIndex = line.indexOf('"', save + 1);
					if (nextQuoteIndex != -1) {
						save = nextQuoteIndex;
						nextQuoteIndex = line.indexOf('"', nextQuoteIndex + 1);
						String fac = line.substring(save + 1, nextQuoteIndex);
						String tokenfac[] = fac.split(",");
						for (int k = 0; k < tokenfac.length; k++) { // coursePrereqs.add(tokenPre[k]);
						//here i have got faculty names
	//						System.out.println("token==="+tokenfac[k]+"===");
                            c.addFaculty(tokenfac[k]);                                       							
						}
					} else {

		//				System.out.println("fac==="+line.substring(save + 1)+"===");
						c.addFaculty(line.substring(save + 1));
					}
					University.addCourses(c);
					System.out.println(courseCode+" "+courseName+" "+courseDesc+" "+courseHours+" "+courseCap+" "+offerFall+" "+offerSpring+" "+offerSummer);
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

//	public static void main(String[] args) throws IOException {
//
//		loadCourses("D:\\prbwork\\Timetable\\src\\TimeTablePD\\TestDataCourses.csv");
//	}
}
