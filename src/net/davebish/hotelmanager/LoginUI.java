package net.davebish.hotelmanager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 10);
		contentPane.add(panel);

		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setBounds(102, 88, 91, 15);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(102, 133, 91, 15);
		contentPane.add(lblPassword);

		txtUserName = new JTextField();
		txtUserName.setBounds(211, 86, 168, 19);
		txtUserName.setColumns(20);
		contentPane.add(txtUserName);

		pwdPassword = new JPasswordField();
		pwdPassword.setColumns(20);
		pwdPassword.setBounds(211, 131, 168, 19);
		contentPane.add(pwdPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new btnLoginListener());
		btnLogin.setBounds(262, 221, 117, 25);
		contentPane.add(btnLogin);
		// Make the Login button the default if the enter key is pressed
		getRootPane().setDefaultButton(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new btnCancelListener());
		btnCancel.setBounds(120, 221, 117, 25);
		// Make the escape key close the window
		KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
		Action escapeAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				LoginUI.this.dispose();
			}
		};
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				escKey, "ESCAPE");
		getRootPane().getActionMap().put("ESCAPE", escapeAction);
		// Put focus on txtUserName
		txtUserName.requestFocus();
		setLocationRelativeTo(null);
	}

	private class btnCancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// do something in response to cancel clicked
			LoginUI.this.dispose();
		}

	}

	private class btnLoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// do something in response to login clicked
			try {
				Login l = new Login();
				if (l.IsvalidUser(txtUserName.getText(),
						new String(pwdPassword.getPassword())))
					JOptionPane.showMessageDialog(LoginUI.this,
							"Welcome to the Hotel Manager");
				else {
					JOptionPane.showMessageDialog(LoginUI.this,
							"Incorrect UserName/Password combination");
					pwdPassword.setText("");
				}
			} catch (Exception ex) {
				// handle the exception
			}
		}
	}
}
