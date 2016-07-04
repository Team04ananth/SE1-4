package frontentScreens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TimeTablePD.Courses;
import TimeTablePD.Faculty;
import TimeTablePD.GradSchool;
import TimeTablePD.University;
import controller.Main;

@SuppressWarnings("serial")
public class CourseEdit extends Frame {

	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Course Edit");

	JPanel panel = new JPanel();

	JButton btnSave = new JButton("Save");

	JLabel lblDept = new JLabel("Department: ");
	JLabel lblCourseNum = new JLabel("Course Number: ");
	JLabel lblCourseName = new JLabel("Course Name: ");
	JLabel lblSemOffered = new JLabel("Semester Offered: ");
	JLabel lblCreditHours = new JLabel("Credit Hours: ");
	JLabel lblPrereq = new JLabel("Prerequisite: ");
	JLabel lblCourseDes = new JLabel("Course Description: ");

	JTextField txtDept = new JTextField();
	JTextField txtCourseNum = new JTextField();
	JTextField txtCourseName = new JTextField();
	JTextField txtSemOffered = new JTextField();
	JTextField txtCreditHours = new JTextField();
	JTextField txtPrereq = new JTextField();
	JTextField txtCourseDes = new JTextField();
	JCheckBox offeredFall = new JCheckBox("Offered Fall?");
	JCheckBox offeredSpring = new JCheckBox("Offered Spring?");
	JCheckBox offeredSummer = new JCheckBox("Offered Summer?");
	Courses cour;

	public CourseEdit(String cNo) {
		fetchCourseDetail(cNo);
		panel.setLayout(null);
		new LogoutButton().setLogoutButton(panel);

		menubar.add(menu);
		setJMenuBar(menubar);

		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();

		lblDept.setBounds(x / 15, y / 10, 150, 25);
		txtDept.setBounds(x / 15 + 140, y / 10, 200, 25);

		lblPrereq.setBounds(x / 2, y / 10, 150, 25);
		txtPrereq.setBounds(x / 2 + 140, y / 10, 200, 25);

		lblCourseNum.setBounds(x / 15, y / 10 + 40, 150, 25);
		txtCourseNum.setBounds(x / 15 + 140, y / 10 + 40, 200, 25);

		lblCourseName.setBounds(x / 15, y / 10 + 80, 150, 25);
		txtCourseName.setBounds(x / 15 + 140, y / 10 + 80, 200, 25);

		lblSemOffered.setBounds(x / 15, y / 10 + 120, 150, 25);
		// txtSemOffered.setBounds(x/15+140, y/10+120, 200, 25);
		offeredFall.setBounds(x / 15 + 140, y / 10 + 120, 100, 25);
		offeredSpring.setBounds(x / 15 + 240, y / 10 + 120, 100, 25);
		offeredSummer.setBounds(x / 15 + 340, y / 10 + 120, 100, 25);

		lblCreditHours.setBounds(x / 15, y / 10 + 160, 150, 25);
		txtCreditHours.setBounds(x / 15 + 140, y / 10 + 160, 70, 25);

		lblCourseDes.setBounds(x / 15, y / 10 + 270, 150, 25);
		txtCourseDes.setBounds(x / 15 + 140, y / 10 + 250, 3 * x / 4, 80);

		btnSave.setBounds(x / 2, y - 200, 100, 25);

		panel.add(lblDept);
		panel.add(lblCourseNum);
		panel.add(lblCourseName);
		panel.add(lblSemOffered);
		panel.add(lblCreditHours);
		panel.add(lblPrereq);
		panel.add(lblCourseDes);

		panel.add(txtDept);
		panel.add(txtCourseNum);
		panel.add(txtCourseName);
		// panel.add(txtSemOffered);
		panel.add(offeredFall);
		panel.add(offeredSpring);
		panel.add(offeredSummer);

		panel.add(txtCreditHours);
		panel.add(txtPrereq);
		panel.add(txtCourseDes);

		panel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cour.setCourseCode(txtCourseNum.getText());
				//System.out.println("cur "+cour.getCourseName());
				cour.setCourseName(txtCourseName.getText());
				//System.out.println("cur "+cour.getCourseName());

				cour.setCourseHours(Integer.parseInt(txtCreditHours.getText()));

				if (offeredFall.isSelected())
					cour.setOfferedFall('Y');
				else
					cour.setOfferedFall('N');
				if (offeredSpring.isSelected())
					cour.setOfferedSpring('Y');
				else
					cour.setOfferedSpring('N');
				if (offeredSummer.isSelected())
					cour.setOfferedSummer('Y');
				else
					cour.setOfferedSummer('N');
				cour.setCourseDescription(txtCourseDes.getText());
				String ss = txtPrereq.getText();
				
				String token[] = ss.split(",");
				cour.setCoursesPreqEmpty();
				for (String t : token) {
					cour.addCoursePrereqs(t);
				}
				JOptionPane.showMessageDialog(null,
						"Course Info Successfully Edited");
				new Home();
				CourseEdit.this.setVisible(false);
			}
		});

		add(panel);
	}

	void fetchCourseDetail(String cNo) {
		for (Map.Entry<String, Courses> entry : University.courses.entrySet()) {
			Courses value = entry.getValue();
			String key = entry.getKey();
			if (key.equals(cNo)) {
				cour = value;
				
				txtCourseDes.setText(value.getCourseDescription());
				txtCourseName.setText(value.getCourseName());
				txtCourseNum.setText(value.getCourseCode());
				txtCreditHours.setText(value.getCourseHours() + "");
				if (value.getOfferedFall() == 'N'
						|| value.getOfferedFall() == 'n')
					offeredFall.setSelected(false);
				else
					offeredFall.setSelected(true);
				if (value.getOfferedSpring() == 'N'
						|| value.getOfferedSpring() == 'n')
					offeredSpring.setSelected(false);
				else
					offeredSpring.setSelected(true);
				if (value.getOfferedSummer() == 'N'
						|| value.getOfferedSummer() == 'n')
					offeredSummer.setSelected(false);
				else
					offeredSummer.setSelected(true);
				String ss = "";
				for (String e : value.getCoursePrereqs()) {
					if (ss.equals(""))
						ss += e;
					else
						ss += "," + e;
				}
				txtPrereq.setText(ss);
			}

		}
	}
}