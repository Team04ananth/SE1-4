package frontentScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
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
	//JMenuItem instructordata = new JMenuItem("Instructor data");

	JMenuItem courseData = new JMenuItem("Course Data");
	JMenuItem instructorData = new JMenuItem("Instructor Data");
	//JMenuItem degreeData = new JMenuItem("Degree Data");
	//JMenuItem scheduleData = new JMenuItem("Schedule Data");
	//JMenuItem forecast = new JMenuItem("Forecast");
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
		//menuImp.add(instructordata);

		menuMai.add(courseData);
		menuMai.add(instructorData);
		//menuMai.add(degreeData);
		//menuMai.add(scheduleData);
		//menuMai.add(forecast);
		 menuMai.add(admin);
		
		setJMenuBar(menubar);
				
		studentData.addActionListener(new menuListener());
		studentCourses.addActionListener(new menuListener());
	//	instructordata.addActionListener(new menuListener());
		
		courseData.addActionListener(new menuListener());
		instructorData.addActionListener(new menuListener());
		//degreeData.addActionListener(new menuListener());
		//scheduleData.addActionListener(new menuListener());
		//forecast.addActionListener(new menuListener());
		admin.addActionListener(new menuListener());
		menuGen.addMenuListener(new MenuListener() {

	        @Override
	        public void menuSelected(MenuEvent e) {
	            Home.this.setVisible(false);
	        	new ScheduleSelect();
	        }

	        @Override
	        public void menuDeselected(MenuEvent e) {
	            //System.out.println("menuDeselected");

	        }

	        @Override
	        public void menuCanceled(MenuEvent e) {
	            //System.out.println("menuCanceled");

	        }
	    });
		menuRep.addMenuListener(new MenuListener() {

	        @Override
	        public void menuSelected(MenuEvent e) {
	            Home.this.setVisible(false);
	        	new Report();
	        }

	        @Override
	        public void menuDeselected(MenuEvent e) {
	            //System.out.println("menuDeselected");

	        }

	        @Override
	        public void menuCanceled(MenuEvent e) {
	            //System.out.println("menuCanceled");

	        }
	    });

	}
	
	class menuListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			switch(e.getActionCommand()) {
				case "Student data" :
					Home.this.setVisible(false);
					new ImportStudentData();
					break;
					
				case "Student courses" :
					Home.this.setVisible(false);
					new ImportStudentCourses();
					
					break;
					
				case "Instructor data" :
					Home.this.setVisible(false);

					new ImportInstructorData();

					break;
				
				case "Course Data" :
					Home.this.setVisible(false);
					new CourseSelect();
					break;
					
				case "Instructor Data" :
					Home.this.setVisible(false);
					new InstructorSelect();
					break;
				case "Degree Data":
					Home.this.setVisible(false);
					new DegreeSelect();
					break;
				case "Generate schedule":
					Home.this.setVisible(false);
					new ScheduleSelect();
					break;
				case "Admin":
					Home.this.setVisible(false);
					new Admin();
					break;
				default :
					System.out.println("other");
			}
		}
	}
}

