import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ImportInstructorData extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Instructor Data");
	
	JPanel panel = new JPanel();
	
	JButton btnImport = new JButton("Import");
	JButton btnSave = new JButton("Save");
	
	JLabel addFile = new JLabel("Add file: ");
	JTextField file = new JTextField();
	
	public ImportInstructorData(){
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
		
		addFile.setBounds(x/4, y/5, 100, 25);
		file.setBounds(x/4+100, y/5, 300, 25);
		btnImport.setBounds(x/4+80, y/5+100, 100, 25);
		btnSave.setBounds(x/4+230, y/5+100, 100, 25);
		
		add(panel);
				
	}
}