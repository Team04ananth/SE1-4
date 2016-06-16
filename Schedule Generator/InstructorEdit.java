import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InstructorEdit extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Instructor Edit");
	
	JPanel panel = new JPanel();
	
	JButton btnSave = new JButton("Save");
	
	JLabel lblName = new JLabel("Name: ");
	JLabel lblCoursesPerSem = new JLabel("Number of Courses per Sem: ");
	JLabel lblSemAvail = new JLabel("Semester Available: ");
	JLabel lblCourses = new JLabel("Courses: ");
	
	JTextField txtName = new JTextField();
	JTextField txtCoursesPerSem = new JTextField();
	JTextField txtSemAvail = new JTextField();
	JTextField txtCourse1 = new JTextField();
	JTextField txtCourse2 = new JTextField();
	JTextField txtCourse3 = new JTextField();
	JTextField txtCourse4 = new JTextField();
	
	String[] choices = { "Spring","Fall", "Summer","All"};
    JComboBox<String> courseNumber = new JComboBox<String>(choices);
	
	public InstructorEdit(){
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);
		
		menubar.add(menu);
		setJMenuBar(menubar);
		
		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();
		
		lblName.setBounds(x/15, y/10, 60, 25);
		txtName.setBounds(x/15+65, y/10, 300, 25);

		lblCourses.setBounds(x/2+200, y/10+70, 100, 25);
		txtCourse1.setBounds(x/2+300, y/10+50, 200, 25);
		txtCourse2.setBounds(x/2+300, y/10+75, 200, 25);
		txtCourse3.setBounds(x/2+300, y/10+100, 200, 25);
		txtCourse4.setBounds(x/2+300, y/10+125, 200, 25);
		
		lblCoursesPerSem.setBounds(x/15, y/10+40, 200, 25);
		txtCoursesPerSem.setBounds(x/15+220, y/10+40, 50, 25);
		
		lblSemAvail.setBounds(x/15, y/10+80, 150, 25);
		courseNumber.setBounds(x/15+160, y/10+80, 100, 25);
		
		btnSave.setBounds(x/2-50, y-300, 100, 25);
		
		panel.add(lblName);
		panel.add(lblCourses);
		panel.add(lblCoursesPerSem);
		panel.add(lblCoursesPerSem);
		panel.add(lblSemAvail);
		
		panel.add(txtName);
		panel.add(txtCoursesPerSem);
		panel.add(txtCourse1);
		panel.add(txtCourse2);
		panel.add(txtCourse3);
		panel.add(txtCourse4);
		panel.add(courseNumber);
		
		panel.add(btnSave);
		
		add(panel);
	}
}