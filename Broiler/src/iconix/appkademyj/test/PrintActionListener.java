package iconix.appkademyj.test;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintActionListener implements Runnable {

	private BufferedImage image;

	public PrintActionListener() {
		this.image = image;
	}

	@Override
	public void run() {

		try {
			File temp = File.createTempFile("temp-file-name", ".txt");
			// File f = new File(null);
			BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
			writer.write("asdasd");
			writer.close();

			PrinterJob printJob = PrinterJob.getPrinterJob();
			printJob.setPrintable((Printable) temp);

			if (printJob.printDialog()) {
				try {
					printJob.print();
				} catch (PrinterException prt) {
					prt.printStackTrace();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public class ImagePrintable implements Printable {

		private double x, y, width;

		private int orientation;

		private BufferedImage image;

		public ImagePrintable(PrinterJob printJob, BufferedImage image) {
			PageFormat pageFormat = printJob.defaultPage();
			this.x = pageFormat.getImageableX();
			this.y = pageFormat.getImageableY();
			this.width = pageFormat.getImageableWidth();
			this.orientation = 0;// pageFormat.getOrientation();
			System.out.println(this.x);
			System.out.println(this.y);
			System.out.println(this.width);
			System.out.println(this.orientation);
			this.image = image;
		}

		@Override
		public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
			if (pageIndex == 0) {
				int pWidth = 0;
				int pHeight = 0;
				if (orientation == PageFormat.PORTRAIT) {
					pWidth = (int) Math.min(width, image.getWidth());
					pHeight = pWidth * image.getHeight() / image.getWidth();
				} else {
					pHeight = (int) Math.min(width, image.getHeight());
					pWidth = pHeight * image.getWidth() / image.getHeight();
				}
				System.out.println(x + " : " + y + " : " + pWidth + " : " + pHeight + " : ");
				g.drawImage(image, -20, 410, 240, 160, null);
				// g.drawImage(image, (int) x, (int) y, pWidth, pHeight, null);
				return PAGE_EXISTS;
			} else {
				return NO_SUCH_PAGE;
			}
		}

	}

}
