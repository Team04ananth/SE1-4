import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CourseAdd extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Course Add");
	
	JPanel panel = new JPanel();
	
	JButton btnAddCourse = new JButton("Add Course");
	
	JLabel lblDept = new JLabel("Department: ");
	JLabel lblCourseNum = new JLabel("Course Number: ");
	JLabel lblCourseName = new JLabel("Course Name: ");
	JLabel lblSemOffered = new JLabel("Semester Offered: ");
	JLabel lblCreditHours = new JLabel("Credit Hours: ");
	JLabel lblPrereq = new JLabel("Prerequisite: ");
	JLabel lblCourseDes = new JLabel("Course Description: ");
	
	JTextField txtDept = new JTextField();
	JTextField txtCourseNum = new JTextField();
	JTextField txtCourseName = new JTextField();
	JTextField txtSemOffered = new JTextField();
	JTextField txtCreditHours = new JTextField();
	JTextField txtPrereq = new JTextField();
	JTextField txtCourseDes = new JTextField();
	
	public CourseAdd(){
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);
		
		menubar.add(menu);
		setJMenuBar(menubar);
		
	
		
		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();
		
		lblDept.setBounds(x/15, y/10, 150, 25);
		txtDept.setBounds(x/15+140, y/10, 200, 25);

		lblPrereq.setBounds(x/2, y/10, 150, 25);
		txtPrereq.setBounds(x/2+140, y/10, 200, 25);
		
		lblCourseNum.setBounds(x/15, y/10+40, 150, 25);
		txtCourseNum.setBounds(x/15+140, y/10+40, 200, 25);
		
		lblCourseName.setBounds(x/15, y/10+80, 150, 25);
		txtCourseName.setBounds(x/15+140, y/10+80, 200, 25);
		
		lblSemOffered.setBounds(x/15, y/10+120, 150, 25);
		txtSemOffered.setBounds(x/15+140, y/10+120, 200, 25);
		
		lblCreditHours.setBounds(x/15, y/10+160, 150, 25);
		txtCreditHours.setBounds(x/15+140, y/10+160, 70, 25);
		
		lblCourseDes.setBounds(x/15, y/10+270, 150, 25);
		txtCourseDes.setBounds(x/15+140, y/10+250, 3*x/4, 80);
		
		btnAddCourse.setBounds(x/2, y-200, 100, 25);
		
		panel.add(lblDept);
		panel.add(lblCourseNum);
		panel.add(lblCourseName);
		panel.add(lblSemOffered);
		panel.add(lblCreditHours);
		panel.add(lblPrereq);
		panel.add(lblCourseDes);
		
		panel.add(txtDept);
		panel.add(txtCourseNum);
		panel.add(txtCourseName);
		panel.add(txtSemOffered);
		panel.add(txtCreditHours);
		panel.add(txtPrereq);
		panel.add(txtCourseDes);
		
		panel.add(btnAddCourse);
		
		add(panel);
	}
}