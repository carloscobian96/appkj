package iconix.appkademyj.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class ConnectToAzure {
	private static final String server = "appkademyj";
	private static final String database = "AppKademyJ";
	private static final String user = "iicxgroup@appkademyj";
	private static final String password = "!C0N!XDB";
	// private static final String
	// url="jdbc:sqlserver://iconix1db.database.windows.net:1433;database=autopart;user=iconix1@iconix1db;password=BTSQL420!?;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	private static final String url = String.format(
			"jdbc:sqlserver://%s.database.windows.net:1433;" + "database=%s;" + "user=%s;" + "password=%s;"
					+ "encrypt=true;" + "trustServerCertificate=false;"
					+ "hostNameInCertificate=*.database.windows.net;" + "loginTimeout=30;",
			server, database, user, password);
	private static Connection connection = null;
	private static CloudStorageAccount storageAccount;
	private static CloudFileClient fileClient;
	private static CloudFileShare share;
	private static CloudFileDirectory rootDir;
	// AZURE CONSTRUCT
	private static String ShareName = "sampleshare";
	private static String AccountName = "fignastorage1";
	private static String AccountKey = "/80+v5AIvSaWJlXENHk8bEYoSEGIfcL0YZnzdYih8k6C64hUC1mbfGJ1uiB8zd6R3iCoVFVu8f1rWXW4/9fiFQ==";

	private static String[] tableTitle = { "ID", "ANOMBREFIELD", "ASSNFIELD", "ATELEFONOFIELD", "ADIRECCIONPOSTALFIELD",
			"AEMAILFIELD", "ABUTTONGROUP", "BMARCAFIELD", "BMODELOFIELD", "BTABLILLAFIELD", "BMARBETEFIELD",
			"BCOMPRAFIELD", "CBANCOFIELD", "CROUTINGFIELD", "CNUMERODECUENTAFELD", "CBUTTONGROUP", "DFECHAFIELD",
			"GREPRESENTANTEFIELD", "GCONTROLFIELD", "GINICIALESTECNICOFIELD", "GINICIALESFINFIELD", "GVOUCHERFIELD",
			"GCODIGOFIELD", "SIGNAMEIMG", "FILENAMEACAA", "FILENAMEMILID", "FILENAMEMARBETE", "FILENAMELES",
			"FILENAMEIDB", "APROBADO" };
	private static String[] reportTitle = { "centro", "mes", "ano", "date", "log", "idNew", "idRenovado", "idReemplazo",
			"idDuplicado", "solEduMil", "solEduDep", "solACAA", "solAnualidad", "solSeguro", "formBeneficiario",
			"dd2558", "les", "tallerFigna", "unidad", "orentacionBeneficios", "orientacinUsuarios" };
	// Define the connection-string with your values
	public static final String storageConnectionString = "DefaultEndpointsProtocol=http;" + "AccountName=" + AccountName
			+ ";" + "AccountKey=" + AccountKey;

	public static void main(String[] args) {
		try {
			System.out.println(url);
			connection = DriverManager.getConnection(url);
			System.out.println("Successful connection");

			String schema = connection.getSchema();
			System.out.println("Successful connection - Schema: " + schema);

			System.out.println("Query data example:");
			System.out.println("=========================================");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ConnectToAzure() {
		super();
		try {
			storageAccount = CloudStorageAccount.parse(storageConnectionString);
			fileClient = storageAccount.createCloudFileClient();
			share = fileClient.getShareReference(ShareName);
			rootDir = share.getRootDirectoryReference();
		} catch (InvalidKeyException | URISyntaxException | StorageException invalidKey) {
			invalidKey.printStackTrace();
		}
	}

	public void uploadFile(String filePath, String fileName, String fileDir)
			throws URISyntaxException, StorageException, IOException, FileNotFoundException {

		CloudFileDirectory containerDir = rootDir.getDirectoryReference(fileDir);
		CloudFile cloudFile = containerDir.getFileReference(fileName);
		cloudFile.uploadFromFile(filePath);

	}

	public File downloadFile(String fileName, String filePath, String fileDir) {

		CloudFile file;
		File f = null;

		try {
			CloudFileDirectory containerDir = rootDir.getDirectoryReference(fileDir);
			file = containerDir.getFileReference(fileName);
			File tempFile = File.createTempFile("tempFile", ".pdf");
			tempFile.deleteOnExit();
			OutputStream outputStream = new FileOutputStream(tempFile);
			file.download(outputStream);
			outputStream.close();
			f = new File(tempFile.getAbsolutePath());

		} catch (URISyntaxException | StorageException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;

	}

	public File downloadFile(String fileName, String fileDir) {
		CloudFile file;
		File f = null;
		try {
			CloudFileDirectory containerDir = rootDir.getDirectoryReference(fileDir);
			file = containerDir.getFileReference(fileName);

			f = File.createTempFile("tempFile", ".pdf");
			f.deleteOnExit();

			OutputStream outputStream = new FileOutputStream(f);
			file.download(outputStream);
			outputStream.close();

		} catch (URISyntaxException | StorageException | IOException e) {
			e.printStackTrace();
		}
		return f;

	}

	public File downloadSignature(String fileName, String fileDir) {
		CloudFile file;
		File f = null;
		try {
			CloudFileDirectory containerDir = rootDir.getDirectoryReference(fileDir);
			file = containerDir.getFileReference(fileName);

			f = File.createTempFile("tempFile", ".png");
			f.deleteOnExit();

			OutputStream outputStream = new FileOutputStream(f);
			file.download(outputStream);
			outputStream.close();

		} catch (URISyntaxException | StorageException | IOException e) {
			e.printStackTrace();
		}
		return f;

	}

	public void makeDirectory(String dirName) {
		try {
			CloudFileDirectory sampleDir = rootDir.getDirectoryReference(dirName);
			if (sampleDir.createIfNotExists()) {
				System.out.println("sampledir created");
			} else {
				System.out.println("sampledir already exists");
			}
		} catch (StorageException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public static void listFiles() {
		for (ListFileItem fileItem : rootDir.listFilesAndDirectories()) {
			System.out.println(fileItem.getUri());
		}
	}

	// ACAA METHODS
	public void addACAA(String[] s) {

		try {
			String acaaTitles = "aNombreField,aSSNField,aTelefonoField,aDireccionPostalField,aEmailField,aButtonGroup,bMarcaField,bModeloField,bTablillaField,bMarbeteField,bCompraField,cBancoField,cRoutingField"
					+ ",cNumeroDeCuentaFeld,cButtonGroup,dFechaField,gRepresentanteField,gControlField,gInicialesTecnicoField,gInicialesFinField,gVoucherField,gCodigoField,sigNameIMG,fileNameACAA,fileNameMilID"
					+ ",fileNameMarbete,fileNameLES,fileNameIDB,aprobado";
			String insertTableSQL = "INSERT INTO acaa1(" + acaaTitles + ") VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);

			for (int i = 1; i < 30; i++) {
				preparedStatement.setString(i, s[i - 1]);
				// System.out.println(i);
			}
			preparedStatement.executeUpdate();
			String schema = connection.getSchema();
			System.out.println("Successful connection - Schema: " + schema);
			System.out.println("=========================================");
			System.out.println("Added");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DefaultTableModel getACAAbyName(String searchName) throws SQLException {
		Statement stmt = null;
		String query = "select * from acaa1 where ANOMBREFIELD like '%" + searchName + "%' ";
		DefaultTableModel table = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		connection = DriverManager.getConnection(url);
		try {
			for (String name : ConnectToAzure.getTableTitle()) {
				table.addColumn(name);
			}
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String[] tempArray = new String[30];
				for (int i = 0; i < 30; i++) {
					tempArray[i] = rs.getString(getTableTitle()[i]);
				}
				// System.out.println(Arrays.toString(tempArray));
				table.addRow(tempArray);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		stmt.close();
		return table;
	}

	public DefaultTableModel getACAAbyName3(String searchName) throws SQLException {
		Statement stmt = null;
		String query = "select ID,ANOMBREFIELD,ASSNFIELD,ATELEFONOFIELD, APROBADO from acaa1 where ANOMBREFIELD like '%"
				+ searchName + "%' ";
		DefaultTableModel table = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		connection = DriverManager.getConnection(url);

		try {
			table.addColumn(getTableTitle()[0]);
			table.addColumn(getTableTitle()[1]);
			table.addColumn(getTableTitle()[2]);
			table.addColumn(getTableTitle()[3]);
			table.addColumn(getTableTitle()[29]);
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String[] tempArray = new String[5];
				tempArray[0] = rs.getString(getTableTitle()[0]);
				tempArray[1] = rs.getString(getTableTitle()[1]);
				tempArray[2] = rs.getString(getTableTitle()[2]);
				tempArray[3] = rs.getString(getTableTitle()[3]);
				tempArray[4] = rs.getString(getTableTitle()[29]);
				// System.out.println(Arrays.toString(tempArray));
				table.addRow(tempArray);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		stmt.close();
		return table;
	}

	public DefaultTableModel getUnapprovedACAA() throws SQLException {
		Statement stmt = null;
		String query = "select ID,ANOMBREFIELD,ASSNFIELD,ATELEFONOFIELD, APROBADO from acaa1 where APROBADO like '%false%' ";
		DefaultTableModel table = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		connection = DriverManager.getConnection(url);
		try {
			table.addColumn(getTableTitle()[0]);
			table.addColumn(getTableTitle()[1]);
			table.addColumn(getTableTitle()[2]);
			table.addColumn(getTableTitle()[3]);
			table.addColumn(getTableTitle()[29]);
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String[] tempArray = new String[5];
				tempArray[0] = rs.getString(getTableTitle()[0]);
				tempArray[1] = rs.getString(getTableTitle()[1]);
				tempArray[2] = rs.getString(getTableTitle()[2]);
				tempArray[3] = rs.getString(getTableTitle()[3]);
				tempArray[4] = rs.getString(getTableTitle()[29]);
				// System.out.println(Arrays.toString(tempArray));
				table.addRow(tempArray);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		stmt.close();
		return table;
	}

	public void aproveACAA(String id) throws SQLException {

		PreparedStatement stmt = null;
		String query = "UPDATE acaa1 SET APROBADO = ? where ID =?";

		connection = DriverManager.getConnection(url);
		try {
			stmt = connection.prepareStatement(query);
			stmt.setString(1, "true");
			stmt.setInt(2, Integer.parseInt(id));
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		stmt.close();
	}

	public String[] getACAAStrings(String id) throws SQLException {

		String[] result = new String[30];
		Statement stmt = null;
		String query = "select * from acaa1 where ID =" + id;
		DefaultTableModel table = new DefaultTableModel();
		connection = DriverManager.getConnection(url);
		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			for (int i = 0; i < 30; i++) {
				result[i] = rs.getString(getTableTitle()[i]);
			}
			// System.out.println(Arrays.toString(result));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		stmt.close();
		return result;
	}

	// Report
	public void uploadReport(String[] s) {
		try {
			String reportTitles = "centro,mes,ano,date,log,idNew,idRenovado,"
					+ "idReemplazo,idDuplicado,solEduMil,solEduDep,solACAA,"
					+ "solAnualidad,solSeguro,formBeneficiario,dd2558,les,"
					+ "tallerFigna,unidad,orentacionBeneficios,orientacinUsuarios";
			String insertTableSQL = "INSERT INTO informe_mensual(" + reportTitles + ") VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);

			for (int i = 1; i < 22; i++) {
				preparedStatement.setString(i, s[i - 1]);
				// System.out.println(i);
			}
			preparedStatement.executeUpdate();

			String schema = connection.getSchema();
			System.out.println("Successful connection - Schema: " + schema);

			System.out.println("=========================================");

			System.out.println("Added");
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DefaultTableModel getReport(String mes, String ano) throws SQLException {
		String[] thisList = { reportTitle[0], reportTitle[5], reportTitle[6], reportTitle[7], reportTitle[8],
				reportTitle[9], reportTitle[10], reportTitle[11], reportTitle[12], reportTitle[13], reportTitle[14],
				reportTitle[15], reportTitle[16], reportTitle[17], reportTitle[18], reportTitle[19], reportTitle[20] };

		String[] pueblos = { "", "Aguadilla", "Arecibo", "Carolina", "Cayey", "Ceiba", "Juana Diaz",
				"Total " + mes + " , " + ano };
		Statement stmt = null;
		String query = "select centro,idNew,idRenovado,idReemplazo,idDuplicado,solEduMil,solEduDep,"
				+ "solACAA,solAnualidad,solSeguro,formBeneficiario,dd2558,les,tallerFigna,unidad,"
				+ "orentacionBeneficios,orientacinUsuarios from informe_mensual where mes like '%" + mes
				+ "%' AND ano like '%" + ano + "%' ";
		DefaultTableModel table = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		try {

			for (int i = 0; i < pueblos.length; i++) {
				table.addColumn(pueblos[i]);
			}
			table.addRow(pueblos);
			for (int i = 2; i < thisList.length; i++) {
				table.addRow(new String[] { thisList[i], "0", "0", "0", "0", "0", "0", "0" });
			}

			// table.addRow(pueblos);

			// Connect
			connection = DriverManager.getConnection(url);
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				switch (rs.getString(thisList[0])) {
				case "Aguadilla":
					for (int i = 1; i < thisList.length - 1; i++) {
						table.setValueAt(rs.getString(thisList[i]), i, 1);
					}
					System.out.println("");
					break;
				case "Arecibo":
					for (int i = 1; i < thisList.length - 1; i++) {
						table.setValueAt(rs.getString(thisList[i]), i, 2);
					}
					System.out.println("");
					break;
				case "Carolina":
					for (int i = 1; i < thisList.length - 1; i++) {
						table.setValueAt(rs.getString(thisList[i]), i, 3);
					}
					System.out.println("");
					break;
				case "Cayey":
					for (int i = 1; i < thisList.length - 1; i++) {
						table.setValueAt(rs.getString(thisList[i]), i, 4);
					}
					System.out.println("");
					break;
				case "Ceiba":
					for (int i = 1; i < thisList.length - 1; i++) {
						table.setValueAt(rs.getString(thisList[i]), i, 5);
					}
					System.out.println("");
					break;
				case "Juana Diaz":
					for (int i = 1; i < thisList.length - 1; i++) {
						table.setValueAt(rs.getString(thisList[i]), i, 6);
					}
					System.out.println("");
					break;
				}

				for (int i = 1; i < thisList.length - 1; i++) {
					int total = 0;
					for (int j = 1; j < pueblos.length - 1; j++) {
						String val = table.getValueAt(i, j).toString();
						total += Integer.parseInt(val);
						System.out.println(total + "::" + val);
					}
					table.setValueAt(total, i, 7);
				}

				// String[] tempArray= new String[thisList.length];
				// for(int i = 0;i<thisList.length;i++) {
				// tempArray[i]=rs.getString(thisList[i]);
				// }
				// System.out.println(Arrays.toString(tempArray));
				// table.addRow(tempArray);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		stmt.close();
		return table;
	}

	public static DefaultTableModel verify(String[] s) throws SQLException {
		Statement stmt = null;
		String query = "SELECT * FROM informe_mensual WHERE centro like '%" + s[0] + "%' AND mes like '%" + s[1]
				+ "%' AND ano like '%" + s[2] + "%'";
		DefaultTableModel table = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		connection = DriverManager.getConnection(url);
		try {
			for (String name : reportTitle) {
				table.addColumn(name);
			}
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String[] tempArray = new String[30];
				for (int i = 0; i < 21; i++) {
					tempArray[i] = rs.getString(reportTitle[i]);
				}
				// System.out.println(Arrays.toString(tempArray));
				table.addRow(tempArray);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		stmt.close();
		return table;
	}

	// GETTERS AND SETTERS
	public static String[] getTableTitle() {
		return tableTitle;
	}

	public static void setTableTitle(String[] tableTitle) {
		ConnectToAzure.tableTitle = tableTitle;
	}

}
