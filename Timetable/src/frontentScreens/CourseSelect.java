package frontentScreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import controller.Main;
import TimeTablePD.University;

@SuppressWarnings("serial")
public class CourseSelect extends Frame {

	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Course Select");

	JPanel panel = new JPanel();

	JButton btnAdd = new JButton("Add");
	JButton btnEdit = new JButton("Edit");
	JButton btnDelete = new JButton("Delete");

	JLabel lblCourseNumber = new JLabel("Course Number: ");
	String[] choices = loadCourseChoices();
	//String[] choices = { "CMSC 5233", "CMSC 5523", "ENGR 5003", "CMSC 5343" };
	JComboBox<String> courseNumber = new JComboBox<String>(choices);

	public CourseSelect() {
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);

		menubar.add(menu);
		setJMenuBar(menubar);

		panel.add(lblCourseNumber);
		panel.add(courseNumber);
		panel.add(btnAdd);
		panel.add(btnEdit);
		panel.add(btnDelete);

		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();

		lblCourseNumber.setBounds(x / 4, y / 5, 100, 25);
		courseNumber.setBounds(x / 4 + 100, y / 5, 300, 25);
		btnAdd.setBounds(x / 4 + 80, y / 5 + 100, 100, 25);
		btnEdit.setBounds(x / 4 + 200, y / 5 + 100, 100, 25);
		btnDelete.setBounds(x / 4 + 320, y / 5 + 100, 100, 25);
		JButton back=new JButton("BACK");
	 	back.setBounds(x-200,y-200,100,25);
	 	panel.add(back);
	 	back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CourseSelect.this.setVisible(false);
				new Home();
			}
		});
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CourseAdd();
			}
		});
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String courseNo=courseNumber.getSelectedItem().toString();
				new CourseEdit(courseNo);
			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//String courseNo=courseNumber.getSelectedItem().toString();
				
				new CourseDelete();
			}
		});
		add(panel);
	}

	public String[] loadCourseChoices() {
		String[] ss = null;
		ArrayList<String> courses = new ArrayList<String>();
		University uni = Main.university;
		courses = uni.getAllCourseCodes();
		ss = new String[courses.size()];
		for (int i = 0; i < courses.size(); i++)
			ss[i] = courses.get(i).toString();
		return ss;
	}

	public static void main(String[] args) {

		CourseSelect mainscr = new CourseSelect();
		mainscr.setTitle("Course Scheduling System");
		mainscr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainscr.setSize(400, 400);
		mainscr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainscr.setVisible(true);
	}

}
