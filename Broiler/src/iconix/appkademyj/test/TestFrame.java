package iconix.appkademyj.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import iconix.appkademyj.util.DateLabelFormatter;

public class TestFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Properties p = new Properties();
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(220, 350, 120, 30);
		this.add(datePicker);
		// JLabel l22 = new JLabel("DATE :");
		// l22.setBounds(100, 350, 100, 20);
		// this.add(l22);

	}

	// public class DateLabelFormatter extends AbstractFormatter {
	//
	// private String datePattern = "yyyy-MM-dd";
	// private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	//
	// @Override
	// public Object stringToValue(String text) throws java.text.ParseException {
	// return dateFormatter.parseObject(text);
	// }
	//
	// @Override
	// public String valueToString(Object value) {
	// if (value != null) {
	// Calendar cal = (Calendar) value;
	// return dateFormatter.format(cal.getTime());
	// }
	//
	// return "";
	// }
	//
	// }
}
