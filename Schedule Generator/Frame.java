import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame{
//	JButton logout = new JButton("Logout");
	public Frame() {
//		int x = GetScreenResolution.getScreenWidth();
//		logout.setBounds(x-120, 5, 100, 25);		
//		logout.addActionListener(new LogoutAction());

		setTitle("Course Scheduling System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 400);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
}

//class LogoutAction implements ActionListener {
//	
//	public void actionPerformed(ActionEvent e) {
//		System.exit(0);
//	}
//}