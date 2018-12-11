package iconix.appkademyj.test;

import iconix.appkademyj.estudiante.Estudiante;
import iconix.database.DatabaseConnect;

public class Tester {

	public static void main(String[] args) {

		try {
			Integer r0 = 0x95999999;
			Integer r1 = 0x94ffff58;
			Integer result = r0+r1;

			System.out.println(Integer.toHexString(result));
			
			
			r0 = 0xFFFFFFFF;
			r1 = 1;
			result = r0+r1;

			System.out.println(Integer.toHexString(result));
			
			
			r0 = 0xF000;
			r1 = 0xFFFFFFFF;
			Integer r2 = 0x00000001;
			r0 = r1+r2;

			System.out.println(Integer.toHexString(r0));
			
			
			r0 = 0xFFFFFFFE;
			r1 = 0x3456;
			r2 = 0x00000001;
//			r1 = r0+;

			System.out.println(Integer.toHexString(r0));
			
			
			
			
			
//			Estudiante c = new Estudiante();
//			DatabaseConnect d = new DatabaseConnect();
			//
			//
			// d.getStudentTableByName("", "2017 - 2018");
			// c.update(d);

			// String sql1 = "Insert into estudiantes(";
			// String sql2 = "values (";
			//
			// java.lang.reflect.Field[] fields = Estudiante.class.getDeclaredFields(); //
			// get all declared fields
			//
			// for (java.lang.reflect.Field field : fields) {
			//
			// sql1 += field.getName() + ",";
			// System.out.println(field.get(0));
			// sql2 += "?,";
			//
			// }
			//
			// String sql = sql1.substring(0, sql1.length() - 1) + ") " + sql2.substring(0,
			// sql2.length() - 1) + ") ";
			// PreparedStatement ps = d.openConnection().prepareStatement(sql);
			// int i = 1;
			// for (java.lang.reflect.Field field : fields) {
			//
			// switch (field.getType().toString()) {
			//
			// case "String":
			// ps.setString(i, field.get(field));
			// break;
			// case "Integer":
			// ps.setString(i, getGrado());
			// break;
			// case "Double":
			// ps.setString(i, getGrado());
			// break;
			// }
			//
			// sql2 += "?,";
			// i++;
			// }

			// System.out.println(sql1 + sql2);

			//
			// ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
			// ResultSetMetaData rsmd = rs.getMetaData();
			// String name = rsmd.getColumnName(1);
			//
			//
			//
			// System.out.println(Estudiante.getClass().getEnclosingClass());
			// java.lang.reflect.Field[] n = c.getReflecion();
			// System.out.println(n[0]);
			// System.out.println(n.toString());
		} catch (Throwable e) {
			System.err.println(e);
		}

		// try {
		// int x = (Integer) null;
		// int y = 12;
		// System.out.println(x + y);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		//
		// ErrorFrame frame = new ErrorFrame(e,"MAMAGUEBO");
		// frame.setVisible(true);
		//
		// }

		// JTextArea textArea = new JTextArea();
		//
		// textArea.setAlignmentY(TextArea.CENTER_ALIGNMENT);
		// textArea.setAlignmentX(TextArea.CENTER_ALIGNMENT);
		// textArea.append("ACADEMIA COOPERATIVA DE INTEGRACION SOCIAL\n");
		// textArea.append("ID DE EMLEADO, NOMBRE DE EMPLEADO\n");
		// textArea.append("----------HORAS PAGADAS---------- PERIODO TERMINADO EN:
		// FECHAAAAA\n");
		// textArea.append("TABLA DE DATA\n");
		// textArea.append("TABLA DE DATA\n");
		// textArea.append("TABLA DE DATA\n");
		// textArea.append("TABLA DE DATA TOTAL A PAGAR\n");
		//
		// textArea.append("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		//
		// Font h = new Font("Helvetica", Font.PLAIN, 10);
		// textArea.setFont(h);
		//
		//
		//
		// textArea.append(" 7/14/2017 955.00\n");
		// textArea.append("NINE HUNDRED AND FIFTY FIVE DOLLARD and FOUR CENTS\n");
		// textArea.append("HERNANDEZ CRUZ, NELIDA\n\n");
		// textArea.append("ACCOUNT NUMBER\n");
		//
		//
		// textArea.append("\n\n\n\n\n\n\n");
		//
		// textArea.append("ACADEMIA COOPERATIVA DE INTEGRACION SOCIAL\n");
		// textArea.append("ID DE EMLEADO, NOMBRE DE EMPLEADO\n");
		// textArea.append("----------HORAS PAGADAS---------- PERIODO TERMINADO EN:
		// FECHAAAAA\n");
		// textArea.append("TABLA DE DATA\n");
		// textArea.append("TABLA DE DATA\n");
		// textArea.append("TABLA DE DATA\n");
		// textArea.append("TABLA DE DATA TOTAL A PAGAR\n");

		// try {
		// textArea.print();
		// } catch (PrinterException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// System.out.println(textArea.getText().toString());
		//
		//
		// String str1 = Arrays.toString(DatabaseConnect.nomina);
		// String str2 = str1.substring(1, str1.length()-1);
		//
		//
		//
		// System.out.println(str2);
		//

		// new Thread(new PrintActionListener()).start();
		//
		//
		//
		//
		//
		//
		//
		//
		// try {
		//
		// File temp = File.createTempFile("temp-file-name", ".txt");
		// //File f = new File(null);
		// BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
		// writer.write("asdasd");
		// writer.close();
		//
		//
		//
		// JEditorPane text = new JEditorPane("file:///D:/abc.txt");
		// text.print(null, null, true, null, null, false);
		//
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (PrinterException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		//
		//
		//
		//
		// try {
		// File temp = File.createTempFile("temp-file-name", ".txt");
		// //File f = new File(null);
		// BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
		// writer.write("");
		// writer.close();
		//
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		//
		//
		//
		//
		//
		//
		// File temp = File.createTempFile("temp-file-name", ".txt");
		// //File f = new File(null);
		// BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
		// writer.write("asdasd");
		// writer.close();
		//
		//
		//
		// FileInputStream textStream;
		// textStream = new FileInputStream("trying.txt");
		//
		// DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		// Doc mydoc = new SimpleDoc(textStream, flavor, null);
		//
		// PrintService[] services = PrintServiceLookup.lookupPrintServices(
		// flavor, aset);
		// PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
		//
		// if(services.length == 0) {
		// if(defaultService == null) {
		// //no printer found
		//
		// } else {
		// //print using default
		// DocPrintJob job = defaultService.createPrintJob();
		// job.print(mydoc, aset);
		//
		// }
		//
		// } else {
		//
		// //built in UI for printing you may not use this
		// PrintService service = ServiceUI.printDialog(null, 200, 200, services,
		// defaultService, flavor, aset);
		//
		//
		// if (service != null)
		// {
		// DocPrintJob job = service.createPrintJob();
		// job.print(mydoc, aset);
		// }
		//
		// }
		//

		// TODO Auto-generated method stub
		// String[] estudiantesTitle =
		// {"ID","Numero_Estudiante","Ano_Etudiante","Grado","Semestre","Nombre",
		// "Sexo","SSN","Status","Fecha","Ultimo_Estado","Ultima_Carta","Paguese","Ultima_Carta_Descripcion",
		// "Desc_Matricula","Procede","Beca","Ahorros","Fecha_Nacimiento","Edad","Saludo","Vencido",
		// "Total_Pagado","Total_Pendiente","Mes_Pago"};
		//
		// System.out.println(estudiantesTitle.length);
		//
		// String x = "1234-56-78";
		// String year = x.substring(0, 4);
		// String month = x.substring(5, 7);
		// String day = x.substring(8, 10);
		// System.out.println("year:"+year+" month:"+month+" day"+day);
		//
		//// Integer.parseInt(s[9].substring(0,4))
		//
		// DatabaseConnect d = new DatabaseConnect();
		// System.out.println(d.countRows("estudiantes"));
		// d.fillData();
		// d.descuentosDeMatricula("2016 - 2017");
		// d.emptyPaymentData();
		// Estudiante e = new Estudiante(d.getStudentById(4));

		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		// String dateInString = "7-Jun-2013";

	}

}
