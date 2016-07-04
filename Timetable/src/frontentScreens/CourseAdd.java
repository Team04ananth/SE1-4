package frontentScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



import javax.swing.ListSelectionModel;

import controller.Main;
import TimeTablePD.Courses;
import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.University;

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
	JLabel lblFac = new JLabel("Faculties: ");
	
	JCheckBox offeredFall=new JCheckBox("Offered Fall?");
	JCheckBox offeredSpring=new JCheckBox("Offered Spring?");
	JCheckBox offeredSummer=new JCheckBox("Offered Summer?");
	JList<String> faculty;
	JScrollPane scrollPane = new JScrollPane();
    
    
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

		String f[]=getFaculty();
		faculty=new JList<String>(f);
		faculty.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(faculty);
		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();
		
		lblDept.setBounds(x/15, y/10, 150, 25);
		txtDept.setBounds(x/15+140, y/10, 200, 25);

		lblPrereq.setBounds(x/2, y/10, 150, 25);
		txtPrereq.setBounds(x/2+140, y/10, 200, 25);
		
		lblCourseNum.setBounds(x/15, y/10+40, 150, 25);
		txtCourseNum.setBounds(x/15+140, y/10+40, 200, 25);

		lblFac.setBounds(x/2, y/10+40, 150,25);
		scrollPane.setBounds(x/2+140,y/10+40,200,100);
		lblCourseName.setBounds(x/15, y/10+80, 150, 25);
		txtCourseName.setBounds(x/15+140, y/10+80, 200, 25);
		
		lblSemOffered.setBounds(x/15, y/10+120, 150, 25);
		offeredFall.setBounds(x/15+140, y/10+120, 100, 25);
		offeredSpring.setBounds(x/15+240, y/10+120, 100, 25);
		offeredSummer.setBounds(x/15+340, y/10+120, 100, 25);
		
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
		panel.add(lblFac);
		panel.add(scrollPane);
		panel.add(txtDept);
		panel.add(txtCourseNum);
		panel.add(txtCourseName);
		//panel.add(txtSemOffered);
	    panel.add(offeredFall);
	    panel.add(offeredSpring);
	    panel.add(offeredSummer);
	    
		panel.add(txtCreditHours);
		panel.add(txtPrereq);
		panel.add(txtCourseDes);
		
		
		panel.add(btnAddCourse);
		btnAddCourse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Courses c=new Courses();
				c.setCourseCap(25);
				c.setCourseCode(txtCourseNum.getText());
				c.setCourseName(txtCourseName.getText());
				c.setCourseHours(Integer.parseInt(txtCreditHours.getText()));
				
				
				
				if(offeredFall.isSelected())
				c.setOfferedFall('Y');
				else
					c.setOfferedFall('N');
				if(offeredSpring.isSelected())
					c.setOfferedSpring('Y');
					else
						c.setOfferedSpring('N');
				if(offeredSummer.isSelected())
					c.setOfferedSummer('Y');
					else
						c.setOfferedSummer('N');
				c.setCourseDescription(txtCourseDes.getText());
				String ss=txtPrereq.getText();
				String token[]=ss.split(",");
				for(String t:token)
				{
					c.addCoursePrereqs(t);
				}
				 Object obj[ ] = faculty.getSelectedValues();
				    for(int i = 0; i < obj.length; i++)
				    {
				      c.addFaculty((String) obj[i]);
				    }
	//			c.addFaculty(faculty);
				    University u=Main.university;
				    u.addCourses(c);
				    JOptionPane.showMessageDialog(null, "New Course Successfully Added");
				    //new Home();
				    offeredFall.setSelected(false);
				    offeredSpring.setSelected(false);
				    offeredSummer.setSelected(false);
				    txtCourseDes.setText("");
				    txtCourseName.setText("");
				    txtCourseNum.setText("");
				    txtCreditHours.setText("");
				    txtDept.setText("");
				    txtPrereq.setText("");
				    		
			}
		});
		
		add(panel);
	}
	
	String[] getFaculty()
	{
		ArrayList<String> al=new ArrayList<String>();
		University uni=Main.university;
		for (Map.Entry<String,GradSchool> entry : uni.gradSchools.entrySet()) {
	        GradSchool value = entry.getValue();
	        for (Map.Entry<String,Faculty> fac : value.faculties.entrySet()) {
	                  al.add(fac.getValue().getLastName());
	        }
	        
	   }
		String f[]=new String[al.size()];
		for(int i=0;i<al.size();i++)
			f[i]=al.get(i);
		return f;	
	}
	
}