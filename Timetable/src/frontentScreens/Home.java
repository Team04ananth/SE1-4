package frontentScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
@SuppressWarnings("serial")
public class Home extends Frame {
	JPanel panel = new JPanel();
	
	JMenuBar menubar = new JMenuBar();
	
	JMenu menuImp = new JMenu("Import");
	JMenu menuMai = new JMenu("Maintenance");
	JMenu menuGen = new JMenu("Generate schedule");
	JMenu menuRep = new JMenu("Reports");

	JMenuItem studentData = new JMenuItem("Student data");
	JMenuItem studentCourses = new JMenuItem("Student courses");
	JMenuItem instructordata = new JMenuItem("Instructor data");

	JMenuItem courseData = new JMenuItem("Course Data");
	JMenuItem instructorData = new JMenuItem("Instructor Data");
	JMenuItem degreeData = new JMenuItem("Degree Data");
	JMenuItem scheduleData = new JMenuItem("Schedule Data");
	JMenuItem forecast = new JMenuItem("Forecast");
	JMenuItem admin = new JMenuItem("Admin");
	
	public Home(){
		new LogoutButton().setLogoutButton(panel);
		panel.setLayout(null);
		add(panel);
		
		menubar.add(menuImp);
		menubar.add(menuMai);
		menubar.add(menuGen);
		menubar.add(menuRep);
		
		menuImp.add(studentData);
		menuImp.add(studentCourses);
		menuImp.add(instructordata);

		menuMai.add(courseData);
		menuMai.add(instructorData);
		menuMai.add(degreeData);
		menuMai.add(scheduleData);
		menuMai.add(forecast);
		
		setJMenuBar(menubar);
				
		studentData.addActionListener(new menuListener());
		studentCourses.addActionListener(new menuListener());
		instructordata.addActionListener(new menuListener());
		
		courseData.addActionListener(new menuListener());
		instructorData.addActionListener(new menuListener());
		degreeData.addActionListener(new menuListener());
		scheduleData.addActionListener(new menuListener());
		forecast.addActionListener(new menuListener());
		admin.addActionListener(new menuListener());
		
	}
	
}

class menuListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Student data" :
				new ImportStudentData();
				break;
				
			case "Student courses" :
				new ImportStudentCourses();
				break;
				
			case "Instructor data" :
				new ImportInstructorData();
				break;
			
			case "Course Data" :
				new CourseSelect();
				break;
				
			case "Instructor Data" :
				new InstructorSelect();
				break;

			default :
				System.out.println("other");
		}
	}
}