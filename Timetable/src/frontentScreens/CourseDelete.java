package frontentScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TimeTablePD.Courses;
import TimeTablePD.University;

@SuppressWarnings("serial")
public class CourseDelete extends Frame{
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Course Delete");
	
	JPanel panel = new JPanel();
	
	JButton btnDelete = new JButton("Delete Course");
	
	JLabel lblCourseNumber = new JLabel("Course Number: ");
	JLabel lblCourseName = new JLabel("Course Name: ");
	
	//String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
    JComboBox<String> courseNumber;// = new JComboBox<String>(choices);
    
    JTextField txtCourseName = new JTextField();
//	String courseCode;
 //   Courses cc;
    Map<String,Courses> cour=new TreeMap<String,Courses>();
	public CourseDelete(){
		String choices[]=loadCourseCodes();
//		String choices[]=getCourseCode();
//		courseCode=cNo;
//		fetchCourseDetail(courseCode);
		courseNumber= new JComboBox<String>(choices);
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
		JButton back=new JButton("BACK");
	 	back.setBounds(x-200,y-200,100,25);
	 	panel.add(back);
	 	back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CourseDelete.this.setVisible(false);
				new CourseSelect();
			}
		});
		courseNumber.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cno=courseNumber.getSelectedItem().toString();
				String cname=cour.get(cno).getCourseName();
				txtCourseName.setText(cname);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cno=courseNumber.getSelectedItem().toString();
				Courses toDelCourse=cour.get(cno);
				removeCourse(toDelCourse);
				JOptionPane.showMessageDialog(null, "Course Deleted Succesfully");
				//choices=loadCourseCodes();
				courseNumber.removeItemAt(courseNumber.getSelectedIndex());
			}
		});
		
		
		add(panel);
		
	}
	
	
	String[] loadCourseCodes()
	{
		for (Map.Entry<String, Courses> entry : University.courses.entrySet()) {
			String key = entry.getKey();
			Courses val=entry.getValue();
			cour.put(key,val );
		}
		String[] ss=new String[cour.size()];
		
		int i=0;
		for (Map.Entry<String, Courses> entry : University.courses.entrySet()) {
		   ss[i++]=entry.getKey();
		}
		return ss;
	}
	void removeCourse(Courses toDelCourse)
	{
		
		for (Map.Entry<String, Courses> entry : University.courses.entrySet()) {
			String key = entry.getKey();
			Courses val=entry.getValue();
			ArrayList<String> c= val.getCoursePrereqs();
			if(c.contains(toDelCourse.getCourseCode()))
			{
				removePreqCourceFromCourse(val,toDelCourse.getCourseCode());
			}
			
		}
		
			University.courses.remove(toDelCourse.getCourseCode());
		
	}
	void removePreqCourceFromCourse(Courses val,String cN)
	{
		ArrayList<String> c= val.getCoursePrereqs();
		val.setCoursesPreqEmpty();
		for (String t : c) {
			if(!t.equals(cN))
			val.addCoursePrereqs(t);
		} 
	}
}