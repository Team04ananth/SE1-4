import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InstructorDelete extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Instructor Delete");
	
	JPanel panel = new JPanel();
	
	JButton btnDelete = new JButton("Delete");
	
	JLabel lblInstructorName = new JLabel("Instructor Name: ");
	
	String[] choices = { "Robert Nix","Jamie Anderson", "Anderfield", "Mary Jane"};
    JComboBox<String> instructorName = new JComboBox<String>(choices);
    
	public InstructorDelete(){		
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);
		
		menubar.add(menu);
		setJMenuBar(menubar);
		
		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();
		
		lblInstructorName.setBounds(x/4+100, y/5, 100, 25);
		instructorName.setBounds(x/4+200, y/5, 300, 25);
		
		btnDelete.setBounds(x/4+250, y/5+120, 100, 25);
		
		panel.add(lblInstructorName);
		panel.add(instructorName);
		panel.add(btnDelete);
		
		add(panel);
	}
}