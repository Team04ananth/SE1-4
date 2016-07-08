package frontentScreens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.AdminCredentials;
import controller.Main;
import TimeTableDM.UniversityDM;

@SuppressWarnings("serial")
public class MainScreen extends Frame {
	JPanel panelMain = new JPanel();

	JLabel universityName = new JLabel("Name: Oklahoma Christian University",
			SwingConstants.CENTER);
	JLabel labelUserName = new JLabel("Username: ");
	JLabel labelPassword = new JLabel("Password: ");

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();

	JButton login = new JButton("Login");

	public MainScreen() {

		setTitle("Course Scheduling System");
		panelMain.setLayout(null);

		add(panelMain);

		username.setBackground(Color.CYAN);
		password.setBackground(Color.CYAN);
		// Border roundedBorder = new LineBorder(Color.black, 4, true); // the
		// third parameter - true, says it's round
		// username.setBorder(roundedBorder);
		// password.setBorder(roundedBorder);

		panelMain.add(universityName);
		panelMain.add(labelUserName);
		panelMain.add(username);
		panelMain.add(labelPassword);
		panelMain.add(password);
		panelMain.add(login);

		int x = GetScreenResolution.getScreenWidth();
		int y = GetScreenResolution.getScreenHeight();

		universityName.setBounds(0, y / 8, x, 100);

		Font labelFont = universityName.getFont();
		String labelText = universityName.getText();

		int stringWidth = universityName.getFontMetrics(labelFont).stringWidth(
				labelText);
		int componentWidth = universityName.getWidth();
		// Find out how much the font can grow in width.
		double widthRatio = (double) componentWidth / (double) stringWidth;
		int newFontSize = (int) (labelFont.getSize() * widthRatio);
		int componentHeight = universityName.getHeight();
		// Pick a new font size so it will not be larger than the height of
		// label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);
		// Set the label's font size to the newly determined size.
		universityName.setFont(new Font(labelFont.getName(), Font.PLAIN,
				fontSizeToUse));

		labelUserName.setBounds(x / 3, y / 3, 100, 25);
		username.setBounds(x / 2 - 130, y / 3, 200, 25);
		labelPassword.setBounds(x / 3, y / 3 + 50, 100, 25);
		password.setBounds(x / 2 - 130, y / 3 + 50, 200, 25);
		login.setBounds(x / 3 + 150, y / 3 + 120, 100, 25);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					if ((username.getText().equals(AdminCredentials.name1) && password
							.getText().equals(AdminCredentials.password1))
							|| (username.getText().equals(
									AdminCredentials.name2) && password
									.getText().equals(
											AdminCredentials.password2))
							|| (username.getText().equals(
									AdminCredentials.name3) && password
									.getText().equals(
											AdminCredentials.password3))) {
						MainScreen.this.setVisible(false);
						new Home();
					} else {
						JOptionPane.showMessageDialog(null,
								"Invalid Username or Password");
					}

				} catch (Exception ex) {

				}
			}
		});

	}

	public static void main(String[] args) {
		UniversityDM.loadUniversity(Main.university);
		MainScreen mainscr = new MainScreen();
		mainscr.setTitle("Course Scheduling System");
		mainscr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainscr.setSize(400, 400);
		mainscr.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainscr.setVisible(true);
	}

}
