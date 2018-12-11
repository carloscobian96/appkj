package iconix.appkademyj.empleados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class NominaTitle implements Printable {

	@Override
	public int print(final Graphics g, final PageFormat pf, final int pageIndex)

			throws PrinterException {
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		final Date date = new Date();
		final String fecha = dateFormat.format(date);

		final Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		g2d.setFont(new Font("SansSerif", Font.PLAIN, 20));
		g2d.setColor(Color.black);
		g2d.drawString("Reporte de Nomina \n " + fecha, 50, 200);
		return Printable.PAGE_EXISTS;
	}
}