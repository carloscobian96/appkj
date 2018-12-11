package iconix.appkademyj.test;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class PipedPrint implements Runnable {
	PipedOutputStream pos = new PipedOutputStream();
	PipedInputStream pis = new PipedInputStream();
	byte[] abPrinterBytes = null;

	private void mainProcess() throws IOException, PrintException, InterruptedException {
		abPrinterBytes = getBytesFromFile();
		pis.connect(pos);
		Thread randWriter = new Thread(this);
		randWriter.start();
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
		PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
		if (defaultService != null) {
			DocPrintJob job = defaultService.createPrintJob();
			DocAttributeSet das = new HashDocAttributeSet();
			Doc doc = new SimpleDoc(pis, flavor, das);
			System.out.println("Main::Fired Print");
			job.print(doc, pras);
			System.out.println("Main::Done Print");
		}
		randWriter.join();
		System.out.println("Main::Join Over");
	}

	private byte[] getBytesFromFile() throws IOException {

		File temp = File.createTempFile("temp-file-name", ".txt");
		// File f = new File(null);
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
		writer.write("asdasd");
		writer.close();

		// File fFile = new
		// File("C:\\Users\\Wijdan\\Documents\\NetBeansProjects\\demo_print\\src\\demo_print\\pass.txt");
		// //File to print
		byte[] abFileBytes = new byte[(int) temp.length()];
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(temp));
		for (int i = 0; i < abFileBytes.length; i += in.read(abFileBytes, i, (abFileBytes.length - i)))
			;
		return abFileBytes;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("RandWriter started Writing");
			for (int i = 0; i < abPrinterBytes.length; i += 400) {
				pos.write(abPrinterBytes, i, ((i + 400) < abPrinterBytes.length) ? 400 : (abPrinterBytes.length - i));
				System.out.println("Thread:: Wrote bytes. Sleeping....");
				Thread.sleep(500);
			}
			pos.close();
			System.out.println("Thread::Closed pos. Exitting Thread...");
		} catch (Exception ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		PipedPrint t1 = new PipedPrint();
		try {
			t1.mainProcess();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}