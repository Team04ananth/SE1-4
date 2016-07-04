package frontentScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.University;

@SuppressWarnings("serial")
public class InstructorAdd extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Instructor Add");
	JPanel panel = new JPanel();
	JButton btnSave = new JButton("ADD");
	JLabel lblFirstName = new JLabel("First Name: ");
	JLabel lblLastName = new JLabel("Last Name: ");
	JLabel lblGrad=new JLabel("Grad School");
	JComboBox<String> comboGrad;
	JLabel lblDegree=new JLabel("Degree");
	JTextField txtDegree = new JTextField();
	JLabel lbltitle=new JLabel("Title");
	JTextField txtTitle = new JTextField();
	JLabel lblDaysToTeach=new JLabel("Days To Teach");
	JTextField txtDaysToTeach = new JTextField();
	JLabel lblMaxLoadFall=new JLabel("Max Load Fall");
	JTextField txtMaxLoadFall = new JTextField();
	JLabel lblMaxLoadSpring=new JLabel("Max Load Spring");
	JTextField txtMaxLoadSpring = new JTextField();
	JLabel lblMaxLoadSummer=new JLabel("Max Load Summer");
	JTextField txtMaxLoadSummer = new JTextField();
	JTextField txtFirstName = new JTextField();
	JTextField txtLastName = new JTextField();

	public InstructorAdd(){
		String a[]=getAllGradSchoolName();
		comboGrad=new JComboBox<String>(a);
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);		
		menubar.add(menu);
		setJMenuBar(menubar);		
		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();
		lblFirstName.setBounds(x/15, y/10, 140, 25);
		txtFirstName.setBounds(x/15+100, y/10, 300, 25);
		lblLastName.setBounds(x/15, y/10+40, 140, 25);
		txtLastName.setBounds(x/15+100, y/10+40, 300, 25);
		lblGrad.setBounds(x/15, y/10+80, 140, 25);
		comboGrad.setBounds(x/15+100, y/10+80, 300, 25);
		lbltitle.setBounds(x/15, y/10+120, 140, 25);
		txtTitle.setBounds(x/15+100, y/10+120, 300, 25);
		lblMaxLoadFall.setBounds(x/15, y/10+160, 140, 25);
		txtMaxLoadFall.setBounds(x/15+100, y/10+160, 300, 25);
		lblMaxLoadSpring.setBounds(x/15, y/10+200, 140, 25);
		txtMaxLoadSpring.setBounds(x/15+100, y/10+200, 300, 25);
		lblMaxLoadSummer.setBounds(x/15, y/10+240, 140, 25);
		txtMaxLoadSummer.setBounds(x/15+100, y/10+240, 300, 25);
		btnSave.setBounds(x/2-50, y-300, 100, 25);
		panel.add(lblFirstName);
		panel.add(txtFirstName);
		panel.add(lblLastName);
		panel.add(txtLastName);
		panel.add(lblGrad);
		panel.add(comboGrad);
		panel.add(lbltitle);
		panel.add(txtTitle);
		panel.add(lblMaxLoadFall);
		panel.add(txtMaxLoadFall);
		panel.add(lblMaxLoadSpring);
		panel.add(txtMaxLoadSpring);
		panel.add(lblMaxLoadSummer);
		panel.add(txtMaxLoadSummer);
		panel.add(btnSave);
		add(panel);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Faculty faculty=new Faculty();
				faculty.setDaysToTeach(txtDaysToTeach.getText());
				faculty.setDegree(txtDegree.getText());
				faculty.setTitle(txtTitle.getText());
				faculty.setFirstName(txtFirstName.getText());
				faculty.setGradSchool(comboGrad.getSelectedItem().toString());
				faculty.setLastName(txtLastName.getText());
				String a=txtMaxLoadFall.getText();
				faculty.setMaxLoadFall(Integer.parseInt(a));
				a=txtMaxLoadSpring.getText();
				faculty.setMaxLoadSpring(Integer.parseInt(a));
				a=txtMaxLoadSummer.getText();
				faculty.setMaxLoadSummer(Integer.parseInt(a));
				addNewFaculty(faculty);
				JOptionPane.showMessageDialog(null,
						"New Instructor Added Successfully");
				new InstructorSelect();
				InstructorAdd.this.setVisible(false);
			}
		});	
		
	}
	void addNewFaculty(Faculty faculty)
	{
		String gN=faculty.getGradSchool();
		for(Map.Entry<String, GradSchool> gr: University.gradSchools.entrySet())
		{
			String gradSchoolID= gr.getKey();
			
			if(gradSchoolID.trim().equals(gN))
			{
				GradSchool grad=gr.getValue();
				grad.addFaculty(faculty);
				break;
			}
		}
	}
	String[] getAllGradSchoolName()
	{
		
		int l=University.gradSchools.size();
		String ss[]=new String[l];
		int i=0;
		for(Map.Entry<String, GradSchool> g: University.gradSchools.entrySet())
		{
			ss[i]=g.getKey();
		}
		return ss;
	}
}