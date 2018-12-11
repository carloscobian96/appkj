package broiler.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6414721841704137293L;
	private final String datePattern = "yyyy-MM-dd";
	private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	@Override
	public Object stringToValue(final String text) throws java.text.ParseException {
		return dateFormatter.parseObject(text);
	}

	@Override
	public String valueToString(final Object value) {
		if (value != null) {
			final Calendar cal = (Calendar) value;
			return dateFormatter.format(cal.getTime());
		}

		return "";
	}

}
