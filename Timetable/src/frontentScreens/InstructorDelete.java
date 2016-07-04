package frontentScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.University;
import controller.Main;

@SuppressWarnings("serial")
public class InstructorDelete extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Instructor Delete");
	ArrayList<Faculty> faculty;
	
	JPanel panel = new JPanel();
	
	JButton btnDelete = new JButton("Delete");
	
	JLabel lblInstructorName = new JLabel("Instructor Name: ");
	
	JComboBox<String> instructorName;
	
	public InstructorDelete(){		
		String[] choices = getIntructorList();
	    instructorName = new JComboBox<String>(choices);
		
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
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Faculty selF=getSelectedFacultyObject();
				deleteFacultyObject(selF);
				JOptionPane.showMessageDialog(null,
						"Instructor Record Deleted!!");
				new InstructorSelect();
				InstructorDelete.this.setVisible(false);
			
			}
		});
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
	void deleteFacultyObject(Faculty f)
	{
		System.out.println("Removing faculties from courses left");
		for(Map.Entry<String, GradSchool> g:University.gradSchools.entrySet())
		{
			GradSchool gs=g.getValue();
			
			if(gs.faculties.containsKey(f.getLastName()))
			{
				gs.removeFaculty(f);
				break;
			}
		}
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
				
				//System.out.println("caught here ");

		        return i;		
			}
		}
		return null;
	}

}