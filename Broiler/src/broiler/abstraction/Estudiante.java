package broiler.abstraction;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//CURRENTLY DISABLED
//import java.text.SimpleDateFormat;
import java.sql.Statement;

//import com.mysql.jdbc.Field;

import broiler.database.DatabaseConnect;

public class Estudiante implements java.io.Serializable {
	// private String tablename="estudiante";

	private Integer ID;
	private Integer Numero_Estudiante;
	private Integer Ano_Estudiante;
	private String Grado;
	private String Semestre;
	private String Nombre;
	private String sexo;
	private String ssn;
	private String Status;

	private String Fecha;
	private String Ultimo_Estado;
	private String Ultima_Carta;
	private String Paguese;

	private String Ultima_Carta_Descripcion;
	private Double Desc_Matricula;
	private String procede;
	private Integer Beca;
	private Double Ahorros;
	private String Fecha_Nacimiento;
	private Integer Edad;
	private String Saludo;
	private Double Vencido;
	private Double Total_Pagado;
	private Double Total_Pendiente;
	private String Mes_Pago;
	private boolean active;

	public Estudiante(final Integer iD, final Integer numero_Estudiante, final Integer ano_Estudiante,
			final String grado, final String semestre, final String nombre, final String sexo, final String ssn,
			final String status, final String fecha, final String ultimo_Estado, final String ultima_Carta,
			final String paguese, final String ultima_Carta_Descripcion, final Double desc_Matricula,
			final String procede, final Integer beca, final Double ahorros, final String fecha_Nacimiento,
			final Integer edad, final String saludo, final Double vencido, final Double total_Pagado,
			final Double total_Pendiente, final String mes_Pago, final boolean active) {
		super();
		ID = iD;
		Numero_Estudiante = numero_Estudiante;
		Ano_Estudiante = ano_Estudiante;
		Grado = grado;
		Semestre = semestre;
		Nombre = nombre;
		this.sexo = sexo;
		this.ssn = ssn;
		Status = status;
		Fecha = fecha;
		Ultimo_Estado = ultimo_Estado;
		Ultima_Carta = ultima_Carta;
		Paguese = paguese;
		Ultima_Carta_Descripcion = ultima_Carta_Descripcion;
		Desc_Matricula = desc_Matricula;
		this.procede = procede;
		Beca = beca;
		Ahorros = ahorros;
		Fecha_Nacimiento = fecha_Nacimiento;
		Edad = edad;
		Saludo = saludo;
		Vencido = vencido;
		Total_Pagado = total_Pagado;
		Total_Pendiente = total_Pendiente;
		Mes_Pago = mes_Pago;
		this.active = active;
	}

	public Estudiante(final String[] s) {
		super();

		try {
			// CURRENTLY UNUSED DATEFORMATTER
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			if (s[0] != null) {
				ID = Integer.parseInt(s[0]);
			} else {
				ID = null;
			}
			if (s[1] != null) {
				Numero_Estudiante = Integer.parseInt(s[1]);
			} else {
				Numero_Estudiante = null;
			}
			if (s[2] != null) {
				Ano_Estudiante = Integer.parseInt(s[2]);
			} else {
				Ano_Estudiante = null;
			}

			Grado = s[3];
			Semestre = s[4];
			Nombre = s[5];
			this.sexo = s[6];
			this.ssn = s[7];
			Status = s[8];
			Fecha = s[9];
			Ultimo_Estado = s[10];
			Ultima_Carta = s[11];
			Paguese = s[12];
			Ultima_Carta_Descripcion = s[13];

			if (s[14] != null) {
				Desc_Matricula = Double.parseDouble(s[14]);
			} else {
				Desc_Matricula = null;
			}

			this.procede = s[15];

			if (s[16] != null) {
				Beca = Integer.parseInt(s[16]);
			} else {
				Beca = null;
			}
			if (s[17] != null) {
				Ahorros = Double.parseDouble(s[17]);
			} else {
				Ahorros = null;
			}

			Fecha_Nacimiento = s[18];

			if (s[19] != null) {
				Edad = Integer.parseInt(s[19]);
			} else {
				Edad = null;
			}

			Saludo = s[20];

			if (s[21] != null) {
				Vencido = Double.parseDouble(s[21]);
			} else {
				Vencido = null;
			}
			if (s[22] != null) {
				Total_Pagado = Double.parseDouble(s[22]);
			} else {
				Total_Pagado = null;
			}
			if (s[23] != null) {
				Total_Pendiente = Double.parseDouble(s[23]);
			} else {
				Total_Pendiente = null;
			}

			Mes_Pago = s[24];
			active = s[25].equals("1");
		} catch (final NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Estudiante() {

		ID = null;
		Numero_Estudiante = 0;
		Ano_Estudiante = 2018;
		Grado = "7B";
		Semestre = "2018 - 2019";
		Nombre = "Default Constructor";
		sexo = "M";
		ssn = "1231231234";
		Status = "Rematricula";

		Fecha = "2018/01/18";
		Ultimo_Estado = null;
		Ultima_Carta = null;
		Paguese = null;

		Ultima_Carta_Descripcion = null;
		Desc_Matricula = 100.0;
		procede = "PR";
		Beca = 1;
		Ahorros = null;
		Fecha_Nacimiento = "2018/01/18";
		Edad = 99;
		Saludo = "Sr.";
		Vencido = 0.0;
		Total_Pagado = 1100.0;
		Total_Pendiente = 11.0;
		Mes_Pago = "05";
		active = true;

		// TODO Auto-generated constructor stub
	}

	public int update(DatabaseConnect databaseConnect) throws SQLException, IllegalArgumentException, IllegalAccessException {
		String tableName = "estudiantes";
		Field[] fields = this.getClass().getDeclaredFields();
		String sql;

		if (ID == null) {
			String sql1 = "Insert into " + tableName + "(";
			String sql2 = "values (";
			for (Field field : fields) {
				sql1 += field.getName() + ",";
				sql2 += "?,";
			}
			sql = sql1.substring(0, sql1.length() - 1) + ") " + sql2.substring(0, sql2.length() - 1) + ") ";
		} else {
			String sql1 = "update " + tableName + " set ";
			for (Field field : fields) {
				sql1 += field.getName() + "=?,";
			}
			sql = sql1.substring(0, sql1.length() - 1) + " where ID = " + ID;
		}

		PreparedStatement ps = databaseConnect.openConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		int i = 1;
		for (Field field : fields) {
			// System.out.println(field.getName() + ": " + field.getType().toString() + ": "
			// + field.get(this));

			if (field.get(this) != null) {
				switch (field.getType().toString()) {

				case "class java.lang.String":
					ps.setString(i, (String) field.get(this));
					break;
				case "class java.lang.Integer":
					ps.setInt(i, (Integer) field.get(this));
					break;
				case "class java.lang.Double":
					ps.setDouble(i, (Double) field.get(this));
					break;
				case "boolean":
					ps.setBoolean(i, (Boolean) field.get(this));
					break;
				default:
					ps.setObject(i, field.get(this));
				}
			} else {
				ps.setNull(i, i);
			}
			i++;
		}

		if (ID != null) {
			ps.executeUpdate();
			databaseConnect.closeConnection();
			return ID;
		} else {
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			ID = rs.getInt(1);
			databaseConnect.closeConnection();
			return ID;
		}
	}

	public Integer getID() {
		return ID;
	}

	public void setID(final Integer iD) {
		ID = iD;
	}

	public Integer getNumero_Estudiante() {
		return Numero_Estudiante;
	}

	public void setNumero_Estudiante(final Integer numero_Estudiante) {
		Numero_Estudiante = numero_Estudiante;
	}

	public Integer getAno_Estudiante() {
		return Ano_Estudiante;
	}

	public void setAno_Estudiante(final Integer ano_Estudiante) {
		Ano_Estudiante = ano_Estudiante;
	}

	public String getGrado() {
		return Grado;
	}

	public void setGrado(final String grado) {
		Grado = grado;
	}

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(final String semestre) {
		Semestre = semestre;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(final String nombre) {
		Nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(final String sexo) {
		this.sexo = sexo;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(final String ssn) {
		this.ssn = ssn;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(final String status) {
		Status = status;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(final String fecha) {
		Fecha = fecha;
	}

	public String getUltimo_Estado() {
		return Ultimo_Estado;
	}

	public void setUltimo_Estado(final String ultimo_Estado) {
		Ultimo_Estado = ultimo_Estado;
	}

	public String getUltima_Carta() {
		return Ultima_Carta;
	}

	public void setUltima_Carta(final String ultima_Carta) {
		Ultima_Carta = ultima_Carta;
	}

	public String getPaguese() {
		return Paguese;
	}

	public void setPaguese(final String paguese) {
		Paguese = paguese;
	}

	public String getUltima_Carta_Descripcion() {
		return Ultima_Carta_Descripcion;
	}

	public void setUltima_Carta_Descripcion(final String ultima_Carta_Descripcion) {
		Ultima_Carta_Descripcion = ultima_Carta_Descripcion;
	}

	public Double getDesc_Matricula() {
		return Desc_Matricula;
	}

	public void setDesc_Matricula(final Double desc_Matricula) {
		Desc_Matricula = desc_Matricula;
	}

	public String getProcede() {
		return procede;
	}

	public void setProcede(final String procede) {
		this.procede = procede;
	}

	public Integer getBeca() {
		return Beca;
	}

	public void setBeca(final Integer beca) {
		Beca = beca;
	}

	public Double getAhorros() {
		return Ahorros;
	}

	public void setAhorros(final Double ahorros) {
		Ahorros = ahorros;
	}

	public String getFecha_Nacimiento() {
		return Fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(final String fecha_Nacimiento) {
		Fecha_Nacimiento = fecha_Nacimiento;
	}

	public Integer getEdad() {
		return Edad;
	}

	public void setEdad(final Integer edad) {
		Edad = edad;
	}

	public String getSaludo() {
		return Saludo;
	}

	public void setSaludo(final String saludo) {
		Saludo = saludo;
	}

	public Double getVencido() {
		return Vencido;
	}

	public void setVencido(final Double vencido) {
		Vencido = vencido;
	}

	public Double getTotal_Pagado() {
		return Total_Pagado;
	}

	public void setTotal_Pagado(final Double total_Pagado) {
		Total_Pagado = total_Pagado;
	}

	public Double getTotal_Pendiente() {
		return Total_Pendiente;
	}

	public void setTotal_Pendiente(final Double total_Pendiente) {
		Total_Pendiente = total_Pendiente;
	}

	public String getMes_Pago() {
		return Mes_Pago;
	}

	public void setMes_Pago(final String mes_Pago) {
		Mes_Pago = mes_Pago;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

}

// public void update(final DatabaseConnect d) throws SQLException {
//
// // DatabaseConnect d = new DatabaseConnect();
//
// if (ID == null) {
//
// final String sql = "insert into estudiantes("
// +
// "Numero_Estudiante,Ano_Estudiante,Grado,Semestre,Nombre,Sexo,SSN,Status,Fecha,Desc_Matricula,Procede,Beca,Fecha_Nacimiento,Edad,Saludo,Vencido,active"//
// 16
// + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
// final PreparedStatement ps = d.openConnection().prepareStatement(sql);
// ps.setInt(1, getNumero_Estudiante());// Numero de Estudiante
// ps.setInt(2, getAno_Estudiante());// ano_estudiante
// ps.setString(3, getGrado());// Grado
// ps.setString(4, getSemestre());// Semestre
// ps.setString(5, getNombre());// Nombre
// ps.setString(6, getSexo());// sexo
// ps.setString(7, getSsn());// ssn
// ps.setString(8, getStatus());// status
// ps.setString(9, getFecha());// FECHA
// ps.setDouble(10, getDesc_Matricula());// descuento matricula
// ps.setString(11, getProcede());// procede
// ps.setInt(12, getBeca());// beca
// ps.setString(13, getFecha_Nacimiento());// fecha nacimiento
// ps.setInt(14, getEdad());// edad
// ps.setString(15, getSaludo());// saludo
// ps.setInt(16, 3200);// vencido
// ps.setBoolean(17, true);
// ps.executeUpdate();
// d.closeConnection();
//
// } else {
// final String sql = "update estudiantes set " + "Numero_Estudiante=?, " +
// "Ano_Estudiante=?, " + "Grado=?, "
// + "Semestre=?, " + "Nombre=?, " + "Sexo=?, " + "SSN=?, " + "Status=?, " +
// "Fecha=?, "
// + "Desc_Matricula=?, " + "Procede=?, " + "Beca=?, " + "Fecha_Nacimiento=?, "
// + "Edad=?, "
// + "Saludo=?, " + "Vencido=?, " + "active=? "// 17
// + "WHERE ID=?";
// final PreparedStatement ps = d.openConnection().prepareStatement(sql);
// ps.setInt(1, getNumero_Estudiante());// Numero de Estudiante
// ps.setInt(2, getAno_Estudiante());// ano_estudiante
// ps.setString(3, getGrado());// Grado
// ps.setString(4, getSemestre());// Semestre
// ps.setString(5, getNombre());// Nombre
// ps.setString(6, getSexo());// sexo
// ps.setString(7, getSsn());// ssn
// ps.setString(8, getStatus());// status
// ps.setString(9, getFecha());// FECHA
// ps.setDouble(10, getDesc_Matricula());// descuento matricula
// ps.setString(11, getProcede());// procede
// ps.setInt(12, getBeca());// beca
// ps.setString(13, getFecha_Nacimiento());// fecha nacimiento
// ps.setInt(14, getEdad());// edad
// ps.setString(15, getSaludo());// saludo
// ps.setInt(16, 3200);// vencido
// ps.setBoolean(17, isActive());// vencido
// ps.setInt(18, getID());// id
// ps.executeUpdate();
// d.closeConnection();
//
// }
//
// }