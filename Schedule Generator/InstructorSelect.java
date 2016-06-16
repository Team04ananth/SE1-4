import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InstructorSelect extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Instructor Select");
	
	JPanel panel = new JPanel();
	
	JButton btnAdd = new JButton("Add");
	JButton btnEdit = new JButton("Edit");
	JButton btnDelete = new JButton("Delete");
	
	JLabel lblInstructorName = new JLabel("Instructor Name: ");
	String[] choices = { "Michael Miller","Sheena Singh", "Aakriti Thakur"};
    JComboBox<String> instructorName = new JComboBox<String>(choices);
	
	public InstructorSelect(){
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);
		
		menubar.add(menu);
		setJMenuBar(menubar);
		
		panel.add(lblInstructorName);
		panel.add(instructorName);
		panel.add(btnAdd);
		panel.add(btnEdit);
		panel.add(btnDelete);
		
		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();
		
		lblInstructorName.setBounds(x/4, y/5, 100, 25);
		instructorName.setBounds(x/4+100, y/5, 300, 25);
		btnAdd.setBounds(x/4+80, y/5+100, 100, 25);
		btnEdit.setBounds(x/4+200, y/5+100, 100, 25);
		btnDelete.setBounds(x/4+320, y/5+100, 100, 25);
		
		btnAdd.addActionListener(new InstructorSelectAction());
		btnEdit.addActionListener(new InstructorSelectAction());
		btnDelete.addActionListener(new InstructorSelectAction());
		add(panel);
	}
}

class InstructorSelectAction implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Add":
			new InstructorAdd();
			break;
		case "Edit":
			new InstructorEdit();
		case "Delete":
			new InstructorDelete();
		}
	}
}