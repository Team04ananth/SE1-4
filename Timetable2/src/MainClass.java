import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {
		int i = 1;
		Scanner sc = new Scanner(System.in);
		while (i != 0) {
			System.out
					.println("Press 1 for instructors names\nPress 2 for courses list\npress 3 for degree plans\npress 4 for Grad Schoos\npress 5 for semesters\npress 6 for Uniersity names\npress 7 for data degree plan request\npress 0 to exit");
			i = sc.nextInt();
			if (i == 1) {
				fetchIntructorList();
			} else if (i == 2) {
				fetchCoursesList();
			} else if (i == 3) {
				fetchDegreePlan();
			} else if (i == 4) {
				fetchDataGradSchools();
			} else if (i == 5)
				fetchDataSemesters();

			else if(i==6)
				fetchDataUniversityName();
			else if (i == 7) {
				fetchDataDegreePlanReq();
			}
		}

	}

	static void fetchDataGradSchools() throws IOException {
		File file = new File(
				"D:\\prbwork\\Timetable\\src\\TestDataGradSchools.csv");
		List<String> lines = Files.readAllLines(file.toPath(),
				StandardCharsets.UTF_8);
		int i = 0;
		for (String line : lines) {
			if (i == 0) {
				i = 1;
				continue;
			}
			String[] array = line.split(",");
			System.out.println("GradSchoolAbbrev : " + array[0]
					+ "    GradSchoolName : " + array[1]);
		}
	}

	static void fetchIntructorList() throws IOException {
		File file = new File("D:\\prbwork\\Timetable\\src\\TestDataFaculty.csv");
		List<String> lines = Files.readAllLines(file.toPath(),
				StandardCharsets.UTF_8);
		int i = 0;
		for (String line : lines) {
			if (i == 0) {
				i = 1;
				continue;
			}
			String[] array = line.split(",");
			System.out.println("Last Name : " + array[0] + "    FirstName : "
					+ array[1] + "    Grad School : " + array[2]
					+ "  Degree : " + array[3] + "  Title : " + array[4]
					+ "  DaysToTeach : " + array[5] + "  MaxLoadFall : "
					+ array[6] + "  MaxLoadSpring : " + array[7]
					+ "  MaxLoadSummer : " + array[8]);
		}
	}

	static void fetchDataUniversityName() throws IOException {
		File file = new File(
				"D:\\prbwork\\Timetable\\src\\TestDataUniversityName.csv");
		List<String> lines = Files.readAllLines(file.toPath(),
				StandardCharsets.UTF_8);
		int i = 0;
		for (String line : lines) {
			if (i == 0) {
				i = 1;
				continue;
			}
			String[] array = line.split(",");
			System.out.println("Name : " + array[0] + "    Abbreviation : "
					+ array[1]);
		}
	}

	static void fetchDataSemesters() throws IOException {
		File file = new File(
				"D:\\prbwork\\Timetable\\src\\TestDataSemesters.csv");
		List<String> lines = Files.readAllLines(file.toPath(),
				StandardCharsets.UTF_8);
		int i = 0;
		for (String line : lines) {
			if (i == 0) {
				i = 1;
				continue;
			}
			String[] array = line.split(",");
			System.out.println("SemesterName : " + array[0]
					+ "    Start Date : " + array[1] + "    End Date : "
					+ array[2]);
		}
	}

	static void fetchCoursesList() throws IOException {

		File file = new File(
				"D:\\prbwork\\Timetable\\src\\Files\\TestDataCourses.csv");
		List<String> lines = Files.readAllLines(file.toPath(),
				StandardCharsets.UTF_8);
		int i = 0;
		for (String line : lines) {
			if (i == 0) {
				i = 1;
				continue;
			}
			String[] array = line.split(",");
			System.out.println("CourseCode : " + array[0]
					+ "    Course Name : " + array[1] + "   Description : "
					+ array[2] + "  CourseHours : " + array[3]
					+ "  CourseCap : " + array[4] + "  OfferedFall? : "
					+ array[5] + "  OfferedSpring? : " + array[6]
					+ "  OfferedSummer? : " + array[7]
					+ "  CoursePrereqs (could be list) : " + array[8]
					+ "  Teachers : " + array[9]);
		}

	}

	static void fetchDataDegreePlanReq() throws IOException {

		File file = new File(
				"D:\\prbwork\\Timetable\\src\\Files\\TestDataDegreePlanReq.csv");
		List<String> lines = Files.readAllLines(file.toPath(),
				StandardCharsets.UTF_8);
		int i = 0;
		for (String line : lines) {
			if (i == 0) {
				i = 1;
				continue;
			}
			String[] array = line.split(",");
			System.out.println("DegreeCode : " + array[0] + "   Description : "
					+ array[1] + "   Hours : " + array[2] + "  Type : "
					+ array[3] + "  Courses : " + array[4]);
		}

	}

	static void fetchDegreePlan() throws IOException {
		File file = new File("D:\\prbwork\\Timetable\\src\\TestDataDegrees.csv");
		List<String> lines = Files.readAllLines(file.toPath(),
				StandardCharsets.UTF_8);
		int i = 0;
		for (String line : lines) {
			if (i == 0) {
				i = 1;
				continue;
			}
			String[] array = line.split(",");
			System.out.println("DegreeCode : " + array[0]
					+ "    Grad School : " + array[1] + "   DegreeName : "
					+ array[2] + "  Forecast : " + array[3]);
		}

	}

}
