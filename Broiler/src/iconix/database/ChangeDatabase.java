package iconix.database;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ChangeDatabase extends JInternalFrame {

	private static final long serialVersionUID = 7966358791876115757L;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					final ChangeDatabase frame = new ChangeDatabase();
					frame.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangeDatabase() {
		setBounds(100, 100, 685, 414);

	}

}
