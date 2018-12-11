package broiler.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LoginDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 115306250805950546L;
	private final JTextField tfUsername;
	private final JPasswordField pfPassword;
	private final JLabel lbUsername;
	private final JLabel lbPassword;
	private final JButton btnLogin;
	private final JButton btnCancel;
	private boolean succeeded;

	public LoginDialog(final Frame parent) {
		super(parent, true);
//        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//        setUndecorated(true);
		
		
		
		
		
		
//		super(parent, null, DEFAULT_MODALITY_TYPE );
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints cs = new GridBagConstraints();
		this.setAutoRequestFocus(true);
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		lbUsername = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		tfUsername = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfUsername, cs);

		lbPassword = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		btnLogin = new JButton("Login");

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				int loginresult =Login.authenticate(getUsername(), getPassword());
				if (loginresult!=0) {
					JOptionPane.showMessageDialog(LoginDialog.this,
							"Hi " + getUsername() + "! You have successfully logged in.", "Login",
							JOptionPane.INFORMATION_MESSAGE);
					succeeded = true;
					dispose();
				} else {
					JOptionPane.showMessageDialog(LoginDialog.this, "Invalid username or password", "Login",
							JOptionPane.ERROR_MESSAGE);
					// reset username and password
					tfUsername.setText("");
					pfPassword.setText("");
					succeeded = false;

				}
			}
		});
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				succeeded = false;
				dispose();
			}
		});
		final JPanel bp = new JPanel();
		bp.add(btnLogin);
		bp.add(btnCancel);

		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(bp, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setLocationRelativeTo(parent);
	}

	public String getUsername() {
		return tfUsername.getText().trim();
	}

	public String getPassword() {
		return new String(pfPassword.getPassword());
	}

	public boolean isSucceeded() {
		return succeeded;
	}
}