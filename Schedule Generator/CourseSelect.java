import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CourseSelect extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Course Select");
	
	JPanel panel = new JPanel();
	
	JButton btnAdd = new JButton("Add");
	JButton btnEdit = new JButton("Edit");
	JButton btnDelete = new JButton("Delete");
	
	JLabel lblCourseNumber = new JLabel("Course Number: ");
	String[] choices = { "CMSC 5233","CMSC 5523", "ENGR 5003","CMSC 5343"};
    JComboBox<String> courseNumber = new JComboBox<String>(choices);
	
	public CourseSelect(){
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
		
		lblCourseNumber.setBounds(x/4, y/5, 100, 25);
		courseNumber.setBounds(x/4+100, y/5, 300, 25);
		btnAdd.setBounds(x/4+80, y/5+100, 100, 25);
		btnEdit.setBounds(x/4+200, y/5+100, 100, 25);
		btnDelete.setBounds(x/4+320, y/5+100, 100, 25);
		
		btnAdd.addActionListener(new CourseSelectAction());
		btnEdit.addActionListener(new CourseSelectAction());
		btnDelete.addActionListener(new CourseSelectAction());
		add(panel);
	}
}

class CourseSelectAction implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Add":
			new CourseAdd();
			break;
		case "Edit":
			new CourseEdit();
		case "Delete":
			new CourseDelete();
		}
	}
}