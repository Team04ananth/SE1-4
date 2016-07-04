package frontentScreens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

public class LogoutButton {
	JButton logout = new JButton("Logout");
	
	void setLogoutButton(JPanel p){
		int x = GetScreenResolution.getScreenWidth();
		logout.setBounds(x-120, 5, 100, 25);
		logout.addActionListener(new LogoutAction());
		p.add(logout);
	}

}

class LogoutAction implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}