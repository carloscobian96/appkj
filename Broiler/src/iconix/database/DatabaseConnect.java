package iconix.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import iconix.appkademyj.estudiante.Estudiante;

/**
 * @author ScrapyardHacker - Carlos Cobian
 */
public class DatabaseConnect {

	/*
	 * Constants and Variables
	 * 
	 */
	// JDBC driver name and URL
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final private static String database = "appkj";
	final private static String host = "localhost";
	// Database credentials//#FIXME
	final private static String USER = "root";
	final private static String PASS = "";
	// #FIXME
	private static final String DB_URL = "jdbc:mysql://" + host + "/" + database
			+ "?verifyServerCertificate=false&useSSL=false" // bypassing the certificate validation
	// + "&useSSL=true"
	// + "&requireSSL=true"
	;

	private static Connection conn = null;
	// #FIXME
	private static String[] estudiantesTitle = { "ID", "Numero_Estudiante", "Ano_Estudiante", "Grado", "Semestre",
			"Nombre", "Sexo", "SSN", "Status", "Fecha", "Ultimo_Estado", "Ultima_Carta", "Paguese",
			"Ultima_Carta_Descripcion", "Desc_Matricula", "Procede", "Beca", "Ahorros", "Fecha_Nacimiento", "Edad",
			"Saludo", "Vencido", "Total_Pagado", "Total_Pendiente", "Mes_Pago", "active" };
	private static String[] estudiantesTitleSelection = { estudiantesTitle[0], estudiantesTitle[1], estudiantesTitle[3],
			estudiantesTitle[5], estudiantesTitle[7] };
	private static String[] pagosSelect = { "Descripcion", "Cantidad", "Balance_Pendiente", "Recargo", "Ahorro" };
	private static String[] historySelect = { "id", "Pago", "Recargo", "ahorro", "Recibo", "Fecha_de_Pago" };
	private static String[] historyPrint = { "Pago", "Recibo", "mes", "Fecha_de_Pago", "recargo", "ahorro" };
	private static String[] empleadosTitle = { "ID", "nombre", "SSN", "numDependientes", "fechaNacimiento",
			"fechaEmpleo", "telefono", "direccionFisica", "direccionPostal", "posicionTrabajo", "estadoCivil",
			"chartOfAcct", "salarioFijo", "salario", "hourRate", "tax", "reg", "fica", "planMedico", "cancer", "activo",
			"totalPagado", "ded", "cred" };
	private static String[] empleadosSelect = { "ID", "nombre", "SSN", "telefono", "posicionTrabajo" };
	// Variables
	private static String[] nomina = { "ID", "SSN", "Nombre", "salarioFijo", "salario", "hourRate", "tax", "planMedico",
			"cancer", "ded", "cred" };
	private static String[] descripcionPagos = { "Matricula", "Agosto", "Septiembre", "Octubre", "Noviembre",
			"Diciembre", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Cafeteria", "Cuota Graduacion",
			"Dolar Familiar", "Balance Anterior" };

	private final Statement statement = null;
	private final ResultSet resultSet = null;

	/**
	 * Database Section
	 */

	public DatabaseConnect() {
	}

	public Connection openConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			// System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// System.out.println("Connected");
		} catch (final Exception e) {
			System.out.println("Unhandled Exception");
			e.printStackTrace();
		}
		return conn;
	}

	public Connection getOpenConnection() {
		if (conn != null) {
			return conn;
		} else {
			openConnection();
		}
		return conn;
	}

	public void closeConnection() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (final Exception e) {

		}
	}

	/**
	 * STUDENTS SECTION
	 */

	public DefaultTableModel getStudentByName(final String s, final String semestre) {

		final String query = "select * from estudiantes where Nombre like '%" + s + "%' and Semestre like '%" + semestre
				+ "%' and active=true";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5161340525257886521L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};
		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			final ResultSet rs = ps.executeQuery(query);

			for (int i = 0; i < estudiantesTitleSelection.length; i++) {
				table.addColumn(estudiantesTitleSelection[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[estudiantesTitleSelection.length];
				for (int i = 0; i < estudiantesTitleSelection.length; i++) {
					tempArray[i] = rs.getString(estudiantesTitleSelection[i]);
				}
				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public DefaultTableModel getStudentByName(final String s) {

		Statement stmt = null;
		final String query = "select * from estudiantes where Nombre like '%" + s + "%' and active=true";
		final DefaultTableModel table = new DefaultTableModel() {

			private static final long serialVersionUID = 4678517766183558013L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);
			for (int i = 0; i < estudiantesTitleSelection.length; i++) {
				table.addColumn(estudiantesTitleSelection[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[estudiantesTitleSelection.length];

				for (int i = 0; i < estudiantesTitleSelection.length; i++) {
					tempArray[i] = rs.getString(estudiantesTitleSelection[i]);
				}
				table.addRow(tempArray);
			}
			stmt.close();
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public DefaultTableModel getStudentBySSN(final String s) {

		Statement stmt = null;
		final String query = "select * from estudiantes where SSN like '%" + s + "%' and active=true";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1735927199563760973L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);
			for (int i = 0; i < estudiantesTitleSelection.length; i++) {
				table.addColumn(estudiantesTitleSelection[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[estudiantesTitleSelection.length];

				for (int i = 0; i < estudiantesTitleSelection.length; i++) {
					tempArray[i] = rs.getString(estudiantesTitleSelection[i]);
				}
				table.addRow(tempArray);
			}
			stmt.close();
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public DefaultTableModel getStudentBySSN(final String s, final String semestre) {
		final String query = "select * from estudiantes where SSN like '%" + s + "%' and Semestre like '%" + semestre
				+ "%' and active=true";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8335226213064002702L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			final ResultSet rs = ps.executeQuery(query);
			for (int i = 0; i < estudiantesTitleSelection.length; i++) {
				table.addColumn(estudiantesTitleSelection[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[estudiantesTitleSelection.length];

				for (int i = 0; i < estudiantesTitleSelection.length; i++) {
					tempArray[i] = rs.getString(estudiantesTitleSelection[i]);
				}
				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public String[] getStudentById(final Integer id) {
		Statement stmt = null;
		final String query = "select * from Estudiantes where ID like '%" + id + "%'";
		final String[] tempArray = new String[estudiantesTitle.length];
		try {
			openConnection();
			stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);

			rs.next();

			for (int i = 0; i < estudiantesTitle.length; i++) {
				tempArray[i] = rs.getString(estudiantesTitle[i]);
			}
			stmt.close();
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return tempArray;

	}

	public DefaultTableModel getStudentByGrade(final String s, final String semestre) {
		final String query = "select * from estudiantes where Grado like '%" + s + "%' and Semestre like '%" + semestre
				+ "%' and active=true";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4257491540976706149L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			final ResultSet rs = ps.executeQuery(query);
			for (int i = 0; i < estudiantesTitleSelection.length; i++) {
				table.addColumn(estudiantesTitleSelection[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[estudiantesTitleSelection.length];

				for (int i = 0; i < estudiantesTitleSelection.length; i++) {
					tempArray[i] = rs.getString(estudiantesTitleSelection[i]);
				}
				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public DefaultTableModel getTable(String query) {
		final DefaultTableModel table = new DefaultTableModel() {
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			final ResultSet rs = ps.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			// populate columns
			for (int i = 1; i <= columnCount; i++) {
				table.addColumn(rsmd.getColumnName(i));
			}
			// populate rows
			while (rs.next()) {
				final String[] tempArray = new String[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					tempArray[i - 1] = rs.getString(rsmd.getColumnName(i));
				}
				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public ResultSet testResultSet(String query) {
		ResultSet rs = null;
		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery(query);
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public DefaultTableModel getStudentPayments(final Estudiante e, final String anoEscolar) {
		final String query2 = "select * from pagos where Link_Id = ? and Semestre = ?  ";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 5890144465699043336L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query2);
			ps.setInt(1, e.getID());
			ps.setString(2, anoEscolar);
			final ResultSet rs = ps.executeQuery();
			for (int i = 0; i < pagosSelect.length; i++) {
				table.addColumn(pagosSelect[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[pagosSelect.length];

				for (int i = 0; i < pagosSelect.length; i++) {
					tempArray[i] = rs.getString(pagosSelect[i]);
				}
				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}
		return table;
	}

	public DefaultTableModel getPaymentHistory(final Estudiante e, final String anoEscolar, final String mes) {
		final String query2 = "select * from pago_detalles where link_id = ? and Semestre = ? and mes = ?";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8193114173404970971L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query2);
			ps.setInt(1, e.getID());
			ps.setString(2, anoEscolar);
			ps.setString(3, mes);
			final ResultSet rs = ps.executeQuery();
			for (int i = 0; i < historySelect.length; i++) {
				table.addColumn(historySelect[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[historySelect.length];

				for (int i = 0; i < historySelect.length; i++) {
					tempArray[i] = rs.getString(historySelect[i]);
				}
				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}
		return table;
	}

	public DefaultTableModel getFullPaymentHistory(final Estudiante e, final String anoEscolar) {
		final String query2 = "select * from appkj.pago_detalles where link_id = ? and Semestre =?";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -3899257521852361037L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query2);
			ps.setInt(1, e.getID());
			ps.setString(2, anoEscolar);
			final ResultSet rs = ps.executeQuery();
			for (int i = 0; i < historyPrint.length; i++) {
				table.addColumn(historyPrint[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[historyPrint.length];

				for (int i = 0; i < historyPrint.length; i++) {
					tempArray[i] = rs.getString(historyPrint[i]);
				}
				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}
		return table;
	}

	public DefaultTableModel getStudentReport(final String semestre, final boolean conBalancePendiente) {

		final String query = "select * from appkj.estudiantes where active = 1 and Semestre =?";
		final String query2 = "select Balance_Pendiente,Ahorro from appkj.pagos where Link_Id = ? and Semestre =?";
		final String[] reportTitles = { "ID", "Grado", "Nombre" };

		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2963774976700382245L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, semestre);
			final ResultSet rs = ps.executeQuery();

			for (int i = 0; i < reportTitles.length; i++) {
				table.addColumn(reportTitles[i]);
			}
			table.addColumn("Total_Debido");
			table.addColumn("Total_Ahorros");

			while (rs.next()) {

				final String[] tempArray = new String[reportTitles.length + 2];

				for (int i = 0; i < reportTitles.length; i++) {
					tempArray[i] = rs.getString(reportTitles[i]);
				}

				final PreparedStatement ps2 = conn.prepareStatement(query2);
				ps2.setInt(1, Integer.parseInt(tempArray[0]));
				ps2.setString(2, semestre);
				final ResultSet rs2 = ps2.executeQuery();

				Double Balance_Pendiente = 0.0;
				Double Ahorros = 0.0;
				while (rs2.next()) {
					Balance_Pendiente += rs2.getDouble(1);
					Ahorros += rs2.getDouble(2);
				}

				tempArray[3] = Balance_Pendiente.toString();
				tempArray[4] = Ahorros.toString();

				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}
		return table;

	}

	public int getIdOfSSN(final int ssn) {
		Statement stmt = null;
		final String query = "select * from Estudiantes where SSN like '%" + ssn + "%'";
		int result = 0;
		try {
			openConnection();
			stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);
			rs.next();
			result = rs.getInt(estudiantesTitleSelection[0]);
			closeConnection();
			return result;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean issuePayment(final int id, final String descripcion, final Double pago, final Double balance,
			final Double recargo, final Double recargo2, final Double ahorro, final String recibo, final String fecha,
			final String Semestre) {

		try {
			final String sql = "UPDATE pagos SET Balance_Pendiente =?,Recargo =?,Ahorro =?  WHERE link_id=? and Descripcion=? ";
			this.openConnection();
			final PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, (balance - pago + (recargo - recargo2)));
			ps.setDouble(2, (recargo));
			ps.setDouble(3, ahorro);
			ps.setInt(4, id);
			ps.setString(5, descripcion);
			ps.executeUpdate();
			this.closeConnection();
			final String sql2 = "insert into pago_detalles(link_id,Pago,Recibo,mes,Fecha_de_Pago,Semestre,recargo,ahorro) values(?,?,?,?,?,?,?,?)";
			this.openConnection();
			final PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, id);
			ps2.setDouble(2, pago);
			ps2.setString(3, recibo);
			ps2.setString(4, descripcion);
			ps2.setString(5, fecha);
			ps2.setString(6, Semestre);
			ps2.setDouble(7, recargo);
			ps2.setDouble(8, ahorro);
			ps2.executeUpdate();
			this.closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void descuentosDeMatricula(final String semestre) {
		try {
			openConnection();
			// this gets the students
			final String query1 = "select * from estudiantes where Desc_Matricula > 0 and Semestre = ?";
			final PreparedStatement ps = conn.prepareStatement(query1);
			ps.setString(1, semestre);
			final ResultSet rs = ps.executeQuery();
			// select each student
			while (rs.next()) {
				// we are working with a single student here
				final String[] tempArray = new String[estudiantesTitle.length];
				// now we're gonna get his matricula and debt values
				final String query2 = "select * from pagos where Link_ID = ? and  Descripcion = ?";
				final PreparedStatement ps2 = conn.prepareStatement(query2);
				ps2.setInt(1, rs.getInt("ID"));
				ps2.setString(2, "Matricula");
				final ResultSet rs2 = ps2.executeQuery();
				rs2.next();
				// first we'll verify that no discount has been applied
				if (rs2.getDouble("Cantidad") == 700 && rs2.getDouble("Cantidad") > rs.getDouble("Desc_Matricula")
						&& rs2.getDouble("Balance_Pendiente") > rs.getDouble("Desc_Matricula")) {
					// here we'll updateboth values
					final String query3 = "update pagos set Cantidad = ? ,Balance_Pendiente = ? where Link_Id = ? and Descripcion = ? ";
					final PreparedStatement ps3 = conn.prepareStatement(query3);
					ps3.setDouble(1, (rs2.getDouble("Cantidad") - rs.getDouble("Desc_Matricula")));
					ps3.setDouble(2, (rs2.getDouble("Balance_Pendiente") - rs.getDouble("Desc_Matricula")));
					ps3.setInt(3, rs.getInt("ID"));
					ps3.setString(4, "Matricula");
					ps3.executeUpdate();
				}
				for (int i = 0; i < estudiantesTitle.length; i++) {
					tempArray[i] = rs.getString(estudiantesTitle[i]);
				}
				// System.out.println(Arrays.toString(tempArray));
			}
			closeConnection();

		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aplicarRecargos(final String semestre, final String mes, final Double recargo, final Double ahorros) {

		final String query = "select * from pagos where Semestre = ? and Descripcion = ?";

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, semestre);
			ps.setString(2, mes);
			final ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getDouble("Balance_Pendiente") > 0) {
					final String query2 = "UPDATE pagos SET Recargo =?,Balance_Pendiente=Balance_Pendiente+? WHERE Link_Id=? and Descripcion=? and Semestre = ?";
					final PreparedStatement ps2 = conn.prepareStatement(query2);
					ps2.setDouble(1, recargo);
					ps2.setDouble(2, recargo);
					ps2.setInt(3, rs.getInt("Link_Id"));
					ps2.setString(4, mes);
					ps2.setString(5, semestre);
					ps2.executeUpdate();
				} else {
					final String query2 = "UPDATE pagos SET Ahorro =? WHERE Link_Id=? and Descripcion=? and Semestre = ?";
					final PreparedStatement ps2 = conn.prepareStatement(query2);
					ps2.setDouble(1, ahorros);
					ps2.setInt(2, rs.getInt("Link_Id"));
					ps2.setString(3, mes);
					ps2.setString(4, semestre);
					ps2.executeUpdate();
				}
			}
			closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}

	}

	public boolean deactivateStudentByID(final int id) {
		try {
			final String sql = "UPDATE estudiantes SET active =0 WHERE ID=?";
			this.openConnection();
			final PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			this.closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public Double getPendingBalance(final int id, final String semestre) {
		Double total = 0.0;
		final String query2 = "select SUM(Balance_Pendiente) as total FROM pagos "
				+ "where Link_Id= ? and Semestre = ?";

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query2);
			ps.setInt(1, id);
			ps.setString(2, semestre);
			final ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getDouble("total");
			closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}

		return total;
	}

	/**
	 * EMPLOYEE SECTION
	 */

	public String[] getEmployeeById(final Integer id) {
		Statement stmt = null;
		final String query = "select * from empleados where ID like '%" + id + "%'";
		final String[] tempArray = new String[empleadosTitle.length];
		try {
			openConnection();
			stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);

			rs.next();

			for (int i = 0; i < empleadosTitle.length; i++) {
				tempArray[i] = rs.getString(empleadosTitle[i]);
			}
			stmt.close();
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return tempArray;

	}

	public DefaultTableModel getEmployeeByName(final String s) {

		Statement stmt = null;
		final String query = "select * from empleados where Nombre like '%" + s + "%' and activo=1";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1626015559732068725L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};
		// TODO create table and fix titles
		try {
			openConnection();
			stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);
			for (int i = 0; i < empleadosSelect.length; i++) {
				table.addColumn(empleadosSelect[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[empleadosSelect.length];

				for (int i = 0; i < empleadosSelect.length; i++) {
					tempArray[i] = rs.getString(empleadosSelect[i]);
				}
				table.addRow(tempArray);
			}
			stmt.close();
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public DefaultTableModel getEmployeeBySSN(final String s) {

		Statement stmt = null;
		final String query = "select * from empleados where SSN like '%" + s + "%' and activo=1";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4196383369602226063L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};
		// TODO create table and fix titles
		try {
			openConnection();
			stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery(query);
			for (int i = 0; i < empleadosSelect.length; i++) {
				table.addColumn(empleadosSelect[i]);
			}
			while (rs.next()) {
				final String[] tempArray = new String[empleadosSelect.length];

				for (int i = 0; i < empleadosSelect.length; i++) {
					tempArray[i] = rs.getString(empleadosSelect[i]);
				}
				table.addRow(tempArray);
			}
			stmt.close();
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public boolean deactivateEmployeeByID(final int id) {
		try {
			final String sql = "UPDATE empleados SET activo =0 WHERE ID=?";
			this.openConnection();
			final PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			this.closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public DefaultTableModel getNomina() {
		final String query2 = "select * from empleados where activo = 1";
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -6953312249736105779L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				if (column == 12 || column == 13) {
					return true;
				}
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query2);
			final ResultSet rs = ps.executeQuery();

			table.addColumn("ID");
			table.addColumn("SSN");
			table.addColumn("Nombre");
			table.addColumn("Salario");
			table.addColumn("Costo P/H");
			table.addColumn("Horas");
			table.addColumn("Tax %");
			table.addColumn("Tax");
			table.addColumn("FICA %");
			table.addColumn("FICA");
			table.addColumn("Medicare");
			table.addColumn("Cancer");
			table.addColumn("Ded");
			table.addColumn("Cred");
			table.addColumn("Total");

			while (rs.next()) {
				final String[] tempArray = new String[15];
				Double total = 0.0;
				Double tax = 0.0;
				Double Fica = 0.0;
				final DecimalFormat df2 = new DecimalFormat("#.##");

				tempArray[0] = rs.getString(nomina[0]);// ID
				tempArray[1] = rs.getString(nomina[1]);// SSN
				tempArray[2] = rs.getString(nomina[2]);// Nombre
				tempArray[3] = rs.getString(nomina[4]);// Salario
				total += Double.parseDouble(tempArray[3]);

				tempArray[4] = rs.getString(nomina[5]);// costo PH
				tempArray[5] = Double.toString(0.0);// horas
				total += (Double.parseDouble(tempArray[4]) * Double.parseDouble(tempArray[5]));

				tax = Double.parseDouble(df2.format(((Double.parseDouble(rs.getString(nomina[6])) / 100) * total)));

				Fica = Double.parseDouble(df2.format(Double.parseDouble(rs.getString("fica")) * total));

				tempArray[6] = df2.format(Double.parseDouble(rs.getString(nomina[6])));// tax
				tempArray[7] = tax.toString();// tax

				tempArray[8] = df2.format(Double.parseDouble(rs.getString("fica")) * 100);

				tempArray[9] = Fica.toString();// FICA
				tempArray[10] = rs.getString(nomina[7]);// medicare
				tempArray[11] = rs.getString(nomina[8]);// cancer
				tempArray[12] = rs.getString(nomina[9]);// ded
				tempArray[13] = rs.getString(nomina[10]);// cred

				Double totalFinal = Double.parseDouble(df2.format(total - tax// -tax
						- Fica // -fica
						- Double.parseDouble(tempArray[12])// -ded
						+ Double.parseDouble(tempArray[13])// +cred
						- Double.parseDouble(tempArray[10])// -medicare
						- Double.parseDouble(tempArray[11])// -cancer
				));

				tempArray[14] = totalFinal.toString();// total

				if (Double.parseDouble(tempArray[6]) == 0.0
						&& Double.parseDouble(rs.getString("totalPagado")) >= 1500) {

					Arreglar1500NoRegular(Integer.parseInt(rs.getString(nomina[0])));

					tax = 0.07 * total;
					tempArray[6] = "7.00";
					tempArray[7] = df2.format(tax);// tax

					totalFinal = Double.parseDouble(df2.format(total - tax// -tax
							- Fica // -fica
							- Double.parseDouble(tempArray[12])// -ded
							+ Double.parseDouble(tempArray[13])// +cred
							- Double.parseDouble(tempArray[10])// -medicare
							- Double.parseDouble(tempArray[11])// -cancer
					));

					tempArray[14] = totalFinal.toString();// total
				}

				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}
		return table;
	}

	public void registrarNomina(final JTable j, Double[][] hr, final String date) {
		try {
			this.openConnection();
			for (int i = 0; i < j.getRowCount(); i++) {
				final String sql = "insert into historialnomina(id_empleado, salario, rate, horas, tax_rate, tax, fica, medicare, cancer, total, fecha,hr_reg,hr_enfermedad,hr_vac,hr_fer,hr_mat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				final PreparedStatement ps = conn.prepareStatement(sql);

				ps.setInt(1, Integer.parseInt(j.getValueAt(i, 0).toString()));// id
				ps.setDouble(2, Double.parseDouble(j.getValueAt(i, 3).toString()));// salario
				ps.setDouble(3, Double.parseDouble(j.getValueAt(i, 4).toString()));// rate
				ps.setDouble(4, Double.parseDouble(j.getValueAt(i, 5).toString()));// horas
				ps.setDouble(5, Double.parseDouble(j.getValueAt(i, 6).toString()));// taxRate
				ps.setDouble(6, Double.parseDouble(j.getValueAt(i, 7).toString()));// tax
				ps.setDouble(7, Double.parseDouble(j.getValueAt(i, 8).toString()));// FICA
				ps.setDouble(8, Double.parseDouble(j.getValueAt(i, 9).toString()));// medcare
				ps.setDouble(9, Double.parseDouble(j.getValueAt(i, 10).toString()));// cancer
				ps.setDouble(10, Double.parseDouble(j.getValueAt(i, 11).toString()));// total
				ps.setString(11, date);
				ps.setDouble(12, hr[i][0]);
				ps.setDouble(13, hr[i][1]);
				ps.setDouble(14, hr[i][2]);
				ps.setDouble(15, hr[i][3]);
				ps.setDouble(16, hr[i][4]);
				ps.execute();
			}

			this.closeConnection();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<String> getNominaDates() {
		final String query = "SELECT DISTINCT fecha FROM historialnomina order by fecha desc";
		final ArrayList<String> arr = new ArrayList<String>();
		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			final ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				arr.add(rs.getString(1));
			}
			closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}
		return arr;

	}

	public void agregarATotalEmpleado(final int id, final Double total) {

		try {
			this.openConnection();
			final String sql = "UPDATE empleados SET totalPagado= totalPagado + ? WHERE  ID = ?";
			final PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, total);
			ps.setInt(2, id);
			ps.executeUpdate();
			this.closeConnection();
		} catch (final SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void Arreglar1500NoRegular(final int id) {

		try {
			this.openConnection();
			final String sql = "UPDATE empleados SET tax=7 WHERE  ID = ?";
			final PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			this.closeConnection();
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * 
	 * other SECTION
	 */

	public int countRows(final String tableName) {
		try {
			openConnection();
			final ResultSet rs = conn.prepareStatement("SELECT COUNT(*) AS rowcount FROM " + tableName).executeQuery();
			rs.next();
			final int count = rs.getInt("rowcount");
			rs.close();
			closeConnection();
			return count;
		} catch (final SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

	public void fillData() throws SQLException {

		// String[] s = { "Matricula", "Agosto", "Septiembre", "Octubre", "Noviembre",
		// "Diciembre", "Enero", "Febrero",
		// "Marzo", "Abril", "Mayo", "Cafeteria", "Cuota Graduacion", "Dolar Familiar",
		// "Balance Anterior" };
		final Double[] x = { 700.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 0.0, 0.0, 0.0,
				0.0 };
		final String sql = "insert into pagos(" + "Sort," + "Link_Id," + "Descripcion," + "Cantidad,"
				+ "Balance_Pendiente," + "Vencido," + "Recargo," + "Balance," + "Fecha," + "Ahorro," + "Semestre)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?)";
		final int rows = countRows("Estudiantes");
		this.openConnection();
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < descripcionPagos.length; i++) {
				// estudiante j
				// sector i
				final PreparedStatement ps = conn.prepareStatement(sql);

				final String sql2 = "select Semestre from estudiantes where ID=?";

				final PreparedStatement ps2 = conn.prepareStatement(sql2);

				ps2.setInt(1, j + 1);

				final ResultSet rs = ps2.executeQuery();

				rs.next();

				final String seme = rs.getString("Semestre");

				ps.setInt(1, i + 1);
				ps.setInt(2, j + 1);
				ps.setString(3, descripcionPagos[i]);
				ps.setDouble(4, x[i]);// cantidad
				ps.setDouble(5, x[i]);// balance
				ps.setDouble(6, 0);// vencido
				ps.setDouble(7, 0);// recargo
				// ps.setDouble(8, 0);// balance recargo
				ps.setDouble(8, 0);// balance
				ps.setString(9, null);// fecha
				ps.setDouble(10, 0);// ahorro
				ps.setString(11, seme);// semestre
				ps.executeUpdate();
				;
			}

			System.out.println("Estudiante: " + (j + 1));
		}

		this.closeConnection();

	}

	public List<Estudiante> nuevoAnoEscolar(final String semestre, final String newSemestre, final Double cuota)
			throws SQLException, IllegalArgumentException, IllegalAccessException {
		final String sql = "select * from estudiantes where active = 1 and Semestre = ?";
		final List<Estudiante> students = new ArrayList<Estudiante>();

		// try {

		openConnection();
		final PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, semestre);

		final ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			// Construct Student
			final String[] tempArray = new String[estudiantesTitle.length];
			for (int i = 0; i < estudiantesTitle.length; i++) {
				tempArray[i] = rs.getString(estudiantesTitle[i]);
			}
			final Estudiante e = new Estudiante(tempArray);

			// deactivate 12 graders
			if (e.getGrado().contains("12")) {
				deactivateStudentByID(e.getID());
				e.setActive(false);
			} else {
				// increment semestre
				e.setSemestre(newSemestre);
				// increment age
				e.setEdad(e.getEdad() + 1);
				// increment grade
				String gradoNum = "";
				String gradoLetra = "";
				final String gradoTemp = e.getGrado();
				for (int i = 0; i < gradoTemp.length(); i++) {
					if (isNumeric("" + gradoTemp.charAt(i))) {
						gradoNum += gradoTemp.charAt(i);
					} else if (gradoTemp.charAt(i) == 'P' || gradoTemp.charAt(i) == 'K') {
						gradoNum = "PK";
					} else {
						gradoLetra += gradoTemp.charAt(i);
					}

				}
				if (gradoNum == "PK") {
					e.setGrado("1");
				} else {
					e.setGrado((Integer.parseInt(gradoNum) + 1) + gradoLetra);
				}

				// update in DB
				e.update(this);
				// Generate payment Data

				Double thisCuota = 0.0;
				if (e.getGrado().contains("6") || e.getGrado().contains("9") || e.getGrado().contains("12")) {
					thisCuota = cuota;
				}

				fillData(e.getID(), e.getDesc_Matricula(), newSemestre, thisCuota,
						getPendingBalance(e.getID(), semestre));
				students.add(e);
			}
		}

		ps.close();
		closeConnection();

		return students;

	}

	public void fillData(final int id, final Double descuento, final String semestre, final Double cuota,
			final Double balanceAnterior) throws SQLException {

		// CAMBIAR PA QUE ITERE EN LISTA DE ID's NO DE AUTO INCREMENTALES I y J
		// try {
		final String[] s = { "Matricula", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre", "Enero",
				"Febrero", "Marzo", "Abril", "Mayo", "Cafeteria", "Cuota Graduacion", "Dolar Familiar",
				"Balance Anterior" };
		final Double[] x = { 700.0 - descuento, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0, 250.0,
				0.0, cuota, 0.0, balanceAnterior };
		final String sql = "insert into pagos(" + "Sort," + "Link_Id," + "Descripcion," + "Cantidad,"
				+ "Balance_Pendiente," + "Vencido," + "Recargo," + "Balance," + "Fecha," + "Ahorro," + "Semestre)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		this.openConnection();
		for (int i = 0; i < s.length; i++) {
			// estudiante j
			// sector i
			final PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i + 1);
			ps.setInt(2, id);
			ps.setString(3, s[i]);
			ps.setDouble(4, x[i]);// cantidad
			ps.setDouble(5, x[i]);// balance
			ps.setDouble(6, 0);// vencido
			ps.setDouble(7, 0);// recargo
			// ps.setDouble(8, 0);// balance recargo
			ps.setDouble(8, 0);// balance
			ps.setString(9, null);// fecha
			ps.setDouble(10, 0);// ahorro
			ps.setString(11, semestre);// semestre
			ps.executeUpdate();
			System.out.println(id);
		}
		this.closeConnection();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
	}

	public void emptyPaymentData() {
		try {
			final String sql = "truncate table pagos";
			this.openConnection();
			final PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			this.closeConnection();

			final String sql2 = "truncate table pago_detalles";
			this.openConnection();
			final PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.executeUpdate();
			this.closeConnection();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isNumeric(final String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	public DefaultTableModel getResult(final String query) {
		final DefaultTableModel table = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 5520473395537124846L;

			@Override
			public boolean isCellEditable(final int row, final int column) {
				return false;
			}
		};

		try {
			openConnection();
			final PreparedStatement ps = conn.prepareStatement(query);
			final ResultSet rs = ps.executeQuery(query);
			final ResultSetMetaData rsmd = rs.getMetaData();
			final int columnCount = rsmd.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				table.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rs.next()) {
				final String[] tempArray = new String[columnCount];

				for (int i = 0; i < columnCount; i++) {
					tempArray[i] = rs.getString(rsmd.getColumnName(i + 1));
				}
				table.addRow(tempArray);
			}
			closeConnection();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return table;

	}

	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
}

// public DefaultTableModel getStudentTableByName(final String s, final String
// semestre) {
// String titles = Arrays.toString(estudiantesTitleSelection);
// titles = titles.substring(1, titles.length() - 1);
// String query = "select " + titles + " from estudiantes where Nombre like '%"
// + s + "%' and Semestre like '%"
// + semestre + "%' and active=true";
// ResultSet rs = null;
// DefaultTableModel t = null;
// System.out.println(query);
//
// try {
// openConnection();
// final PreparedStatement ps = conn.prepareStatement(query);
// rs = ps.executeQuery(query);
//
// t = buildTableModel(rs);
//
// closeConnection();
// } catch (SQLException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
//
// return t;
//
// }
