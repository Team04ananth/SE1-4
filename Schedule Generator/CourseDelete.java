import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CourseDelete extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Course Delete");
	
	JPanel panel = new JPanel();
	
	JButton btnDelete = new JButton("Delete Course");
	
	JLabel lblCourseNumber = new JLabel("Course Number: ");
	JLabel lblCourseName = new JLabel("Course Name: ");
	
	String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
    JComboBox<String> courseNumber = new JComboBox<String>(choices);
    
    JTextField txtCourseName = new JTextField();
	
	public CourseDelete(){		
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);
		
		menubar.add(menu);
		setJMenuBar(menubar);
		
		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();
		
		lblCourseNumber.setBounds(x/4+100, y/5, 100, 25);
		courseNumber.setBounds(x/4+200, y/5, 300, 25);
		
		lblCourseName.setBounds(x/4+100, y/5+60, 100, 25);
		txtCourseName.setBounds(x/4+200, y/5+60, 300, 25);
		txtCourseName.setEnabled(false);
		
		btnDelete.setBounds(x/4+250, y/5+120, 200, 25);
		
		panel.add(lblCourseNumber);
		panel.add(courseNumber);
		panel.add(lblCourseName);
		panel.add(txtCourseName);
		panel.add(btnDelete);
		
		add(panel);
	}
}