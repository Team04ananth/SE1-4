package TimeTablePD;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainClass {

	public static void main(String[] args) throws IOException {
		University university=new University();
		System.out.println("load complete");
		
/*		
		int i = 1;
		Scanner sc = new Scanner(System.in);
		while (i != 0) {
			System.out
					.println("Press 1 for instructors names\nPress 2 for courses list\npress 3 for degree plans\npress 4 for Grad Schoos\npress 5 for semesters\npress 6 for Uniersity names\npress 7 for data degree plan request\npress 0 to exit");
			i = sc.nextInt();
			MainClass obj=new MainClass();
			if (i == 1) {
				obj.fetchIntructorList();
			} else if (i == 2) {
				obj.fetchCoursesList();
			} else if (i == 3) {
				obj.fetchDegreePlan();
			} else if (i == 4) {
				obj.fetchDataGradSchools();
			} else if (i == 5)
				obj.fetchDataSemesters();

			else if(i==6)
				obj.fetchDataUniversityName();
			else if (i == 7) {
				obj.fetchDataDegreePlanReq();
			}
		}
*/
	}
/*
	 void fetchDetail(int n,String filename)throws IOException
	{
		String s[]=new String[n];
		File file = new File(
				"D:\\prbwork\\Timetable\\src\\"+filename);
		List<String> lines = Files.readAllLines(file.toPath(),StandardCharsets.UTF_8);
		int i = 0;
		for (String line : lines) {
			String[] array = line.split(",");
			if (i == 0) {
				i = 1;
				for(int j=0;j<n;j++)
				{
					s[j]=array[j];
				}
				continue;
			}
		  for(int j=0;j<n;j++)
		  {
			  System.out.print(s[j]+" : "+array[j]+" , ");
		  }
	
		  System.out.println();
		}
		
		
	}
	 void fetchDataGradSchools() throws IOException {
		fetchDetail(2,"TestDataGradSchools.csv");
	}

	 void fetchIntructorList() throws IOException {
		fetchDetail(9,"TestDataFaculty.csv");
	}

	 void fetchDataUniversityName() throws IOException {
		fetchDetail(2,"TestDataUniversityName.csv");
		
	}

	 void fetchDataSemesters() throws IOException {
		fetchDetail(3,"TestDataSemesters.csv");
			}

	 void fetchCoursesList() throws IOException {
		fetchDetail(10,"TestDataCourses.csv");
		
	}

	 void fetchDataDegreePlanReq() throws IOException {
		fetchDetail(5,"TestDataDegreePlanReq.csv");
			}

	 void fetchDegreePlan() throws IOException {
		
		fetchDetail(4,"TestDataDegrees.csv");
		
	}
*/
}
