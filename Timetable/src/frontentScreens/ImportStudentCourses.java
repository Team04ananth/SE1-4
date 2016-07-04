package frontentScreens;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TimeTablePD.Student;
import TimeTablePD.StudentCourses;
import controller.Main;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ImportStudentCourses extends Frame {

	String filename;
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Student Courses");

	JPanel panel = new JPanel();

	JButton btnImport = new JButton("Import");
	JButton btnSave = new JButton("Save");

	JLabel addFile = new JLabel("Add file: ");
	JTextField file = new JTextField();
	JFileChooser fileChooser = new JFileChooser();

	public ImportStudentCourses() {
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);

		menubar.add(menu);
		setJMenuBar(menubar);

		panel.add(addFile);
		panel.add(file);
		panel.add(btnImport);
		panel.add(btnSave);

		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();

		addFile.setBounds(x / 4, y / 5, 100, 25);
		file.setBounds(x / 4 + 100, y / 5, 300, 25);
		btnImport.setBounds(x / 4 + 80, y / 5 + 100, 100, 25);
		btnSave.setBounds(x / 4 + 230, y / 5 + 100, 100, 25);
		btnImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int returnVal = fileChooser
						.showOpenDialog(ImportStudentCourses.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File f = fileChooser.getSelectedFile();
					// This is where a real application would open the file.
					filename = f.getAbsolutePath();
					file.setText(filename);
				}
			}
			
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				readStudentCourses();
			}
		});
		
		add(panel);

	}

	public void readStudentCourses() {

		FileInputStream inputStream = null;
		Workbook workbook = null;
		filename=file.getText();
		String excelFilePath = filename;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));

			Main.studentCourses=new ArrayList<StudentCourses>();
			workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();


			int i=1;
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
                if(i==1)
                {
                	i++;
                	continue;
                }
				
				Cell cell = cellIterator.next();
				StudentCourses obj=new StudentCourses();

				obj.setStudentID(cell.getNumericCellValue()+"");
				cell = cellIterator.next();
				obj.setCourseNo(cell.getStringCellValue());
				cell = cellIterator.next();
				obj.setCourseName(cell.getStringCellValue());
				cell = cellIterator.next();
				obj.setSemester(cell.getStringCellValue());
				cell = cellIterator.next();
				obj.setGrade(cell.getStringCellValue());
				Main.studentCourses.add(obj);

/*				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					}
					System.out.print(" - ");
					
				}
				*/
//				System.out.println();
			}
			JOptionPane.showMessageDialog(null, "Student Coures imported successfully");
			this.setVisible(false);
			new Home();

		} catch (Exception e) {
			System.out.println("error");
			JOptionPane.showMessageDialog(null, "Wrong file selected");

		}
		if (workbook != null)
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (inputStream != null)
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public static void main(String[] args) {
		
		ImportStudentCourses mainscr = new ImportStudentCourses();
		mainscr.setTitle("Course Scheduling System");
		mainscr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainscr.setSize(400, 400);
		mainscr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainscr.setVisible(true);
	}

}