package broiler.abstraction;

import java.sql.SQLException;

//import iconix.database.DatabaseConnect;

public class Testbroiler {

	public static void main(String[] args) {

		try {
			/*
			 * para el std se utilizara este caso convertido a junit para probar los updates
			 * 
			 * DatabaseConnect d = new DatabaseConnect(); 
			 * String[] s = {"7", "carlos2",
			 * "123121234", "0", "12/12/1212", "12/12/1212", "787-635-1197", "asd", "asd",
			 * "Boss", "Soltero", "20200", "0", "0", "100", "2", "1", "0.0765", "34",
			 * "30.74", "1", "8800", "10", "0"}; 
			 * Empleados e = new Empleados(s);
			 * System.out.println(e.getTableName());
			 * System.out.println(e.update(d,Integer.parseInt(s[0])));
			 * 
			 * 
			 */
			DatabaseConnect d = new DatabaseConnect();
			String[] s = { "7", "carlos4", "123121234", "0", "12/12/1212", "12/12/1212", "787-635-1197", "asd", "asd",
					"Boss", "Soltero", "20200", "0", "0", "100", "2", "1", "0.0765", "34", "30.74", "1", "8800", "10",
			"0" };
			Empleados e = new Empleados(s);
			System.out.println(e.getTableName());
			System.out.println(e.update(d, Integer.parseInt(s[0])));

			String[] s2 = { "334", "0", "2018", "7B", "2018 - 2019", "Student1", "M", "1231231234", "Rematricula", "2018/01/18", null, null, null, null, "100.00", "PR", "1", null, "2018/01/18", "99", "Sr.", "0.00", "1100.00", "11.00", "05", "1"};
			Estudiantes es = new Estudiantes(s2);
			System.out.println(es.getTableName());
			System.out.println(es.update(d, 334));




		} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
