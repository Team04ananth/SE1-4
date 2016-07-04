package frontentScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import TimeTablePD.Faculty;
import TimeTablePD.University;
import controller.Main;

@SuppressWarnings("serial")
public class InstructorSelect extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Instructor Select");
	ArrayList<Faculty> faculty;
	JPanel panel = new JPanel();
	
	JButton btnAdd = new JButton("Add");
	JButton btnEdit = new JButton("Edit");
	JButton btnDelete = new JButton("Delete");
	
	JLabel lblInstructorName = new JLabel("Instructor Name: ");
	JComboBox<String> instructorName;
	
	public InstructorSelect(){
		String[] choices = getIntructorList();
	    instructorName = new JComboBox<String>(choices);
		
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
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InstructorAdd();
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Faculty selF=getSelectedFacultyObject();
				new InstructorEdit(selF);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InstructorDelete();
			}
		});
		add(panel);
		
	}
	String[] getIntructorList()
	{
		String[] ss = null;
		faculty = new ArrayList<Faculty>();
		University uni = Main.university;
		faculty = uni.getAllFaculty();
	     
		ss = new String[faculty.size()];
		for (int i = 0; i < faculty.size(); i++)
			ss[i] = faculty.get(i).getFirstName()+" "+faculty.get(i).getLastName();
		return ss;
		
	}
	Faculty getSelectedFacultyObject()
	{
		System.out.println("here 1");
		String s=instructorName.getSelectedItem().toString();
		int spaceIndex=s.indexOf(' ');
		String lastName=s.substring(spaceIndex+1);
		String firstName=s.substring(0, spaceIndex);
		System.out.println(firstName);
		System.out.println(lastName);
		
		System.out.println("here 2");

		for(Faculty i:faculty)
		{
			System.out.println("checking "+i.getFirstName()+" "+i.getLastName());
			if(i.getLastName().trim().equals(lastName.trim())&&i.getFirstName().trim().equals(firstName.trim()))
			{
				System.out.println("caught here ");

		        return i;		
			}
		}
		return null;
	}
}
