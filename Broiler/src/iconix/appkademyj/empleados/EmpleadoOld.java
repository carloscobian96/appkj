package iconix.appkademyj.empleados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import iconix.database.DatabaseConnect;

public class EmpleadoOld implements java.io.Serializable {

	/*
	 * la nomina se corre quincenal no se sabe como
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 5440884002877104564L;
	private Integer id;
	private String nombre;
	private Integer SSN;
	private Integer numDependentes;// poner en formulario
	private String fechaNacimiento;
	private String fechaEmpleo;
	private String telefono;
	private String direccionFisica;
	private String direccionPostal;
	private String posicionTrabajo;
	private String estadoCivil;
	private String chartOfAcct; // cuenta a donde se va en contabilidad
	private boolean salarioFijo;
	private Double salarios;// mensual o quincenal?
	private Double hourRate;
	private Double tax;
	private Boolean reg;
	private Double fica = 0.0765;// %
	private Double planMedico;
	private Double cancer;
	private boolean activo;
	private Double totalPagado;
	private Double ded;
	private Double cred;
	// INFORMACION DE NOMINA

	// private Double regNon; //activa el 7% de tax despues de haberle pagado 1500
	// al empleado

	// NOMINAS ACUMULADAS(tabla nueva?)

	public EmpleadoOld(final Integer id, final String nombre, final Integer sSN, final Integer numDependentes,
			final String fechaNacimiento, final String fechaEmpleo, final String telefono, final String direccionFisica,
			final String direccionPostal, final String posicionTrabajo, final String estadoCivil,
			final String chartOfAcct, final boolean salarioFijo, final Double salarios, final Double hourRate,
			final Double tax, final boolean reg, final Double fica, final Double planMedico, final Double cancer,
			final boolean activo, final Double totalPagado, final Double ded, final Double cred) {
		super();
		this.id = id;
		this.nombre = nombre;
		SSN = sSN;
		this.numDependentes = numDependentes;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaEmpleo = fechaEmpleo;
		this.telefono = telefono;
		this.direccionFisica = direccionFisica;
		this.direccionPostal = direccionPostal;
		this.posicionTrabajo = posicionTrabajo;
		this.estadoCivil = estadoCivil;
		this.chartOfAcct = chartOfAcct;
		this.salarioFijo = salarioFijo;
		this.salarios = salarios;
		this.hourRate = hourRate;
		this.tax = tax;
		this.planMedico = planMedico;
		this.reg = reg;
		this.fica = fica;
		this.cancer = cancer;
		this.activo = activo;
		this.totalPagado = totalPagado;
		this.ded = ded;
		this.cred = cred;
	}

	public EmpleadoOld(final String nombre, final Integer sSN, final Integer numDependentes, final String fechaNacimiento,
			final String fechaEmpleo, final String telefono, final String direccionFisica, final String direccionPostal,
			final String posicionTrabajo, final String estadoCivil, final String chartOfAcct, final boolean salarioFijo,
			final Double salarios, final Double hourRate, final Double tax, final boolean reg, final Double fica,
			final Double planMedico, final Double cancer, final boolean activo, final Double totalPagado,
			final Double ded, final Double cred) {
		super();
		this.nombre = nombre;
		SSN = sSN;
		this.numDependentes = numDependentes;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaEmpleo = fechaEmpleo;
		this.telefono = telefono;
		this.direccionFisica = direccionFisica;
		this.direccionPostal = direccionPostal;
		this.posicionTrabajo = posicionTrabajo;
		this.estadoCivil = estadoCivil;
		this.chartOfAcct = chartOfAcct;
		this.salarioFijo = salarioFijo;
		this.salarios = salarios;
		this.hourRate = hourRate;
		this.tax = tax;
		this.reg = reg;
		this.fica = fica;
		this.planMedico = planMedico;
		this.cancer = cancer;
		this.activo = true;
		this.totalPagado = totalPagado;
		this.ded = ded;
		this.cred = cred;
	}

	public EmpleadoOld(final String[] s) {
		super();
		this.id = Integer.parseInt(s[0]);
		this.nombre = s[1];
		this.SSN = Integer.parseInt(s[2]);
		this.numDependentes = Integer.parseInt(s[3]);// poner en formulario
		this.fechaNacimiento = s[4];
		this.fechaEmpleo = s[5];
		this.telefono = s[6];
		this.direccionFisica = s[7];
		this.direccionPostal = s[8];
		this.posicionTrabajo = s[9];
		this.estadoCivil = s[10];
		this.chartOfAcct = s[11]; // cuenta a donde se va en contabilidad
		this.salarioFijo = s[12].equals("1");// Double.parseDouble(s[12]);
		this.salarios = Double.parseDouble(s[13]);// mensual o quincenal?
		this.hourRate = Double.parseDouble(s[14]);
		this.tax = Double.parseDouble(s[15]);
		this.reg = s[16].equals("1");
		this.fica = Double.parseDouble(s[17]);
		this.planMedico = Double.parseDouble(s[18]);
		this.cancer = Double.parseDouble(s[19]);
		this.activo = s[20].equals("1");
		this.totalPagado = Double.parseDouble(s[21]);
		this.ded = Double.parseDouble(s[22]);
		this.cred = Double.parseDouble(s[23]);
	}

	public void update(final DatabaseConnect d) throws SQLException {

		if (id == null) {

			final String sql = "insert into empleados(" + "nombre," + " SSN," + " numDependientes,"
					+ " fechaNacimiento," + " fechaEmpleo," + " telefono," + " direccionFisica," + " direccionPostal,"
					+ " posicionTrabajo," + " estadoCivil," + " chartOfAcct," + " salarioFijo," + " salario,"
					+ " hourRate," + " tax," + " reg," + " fica," + " planMedico," + " cancer," + " activo,"
					+ " totalPagado," + " ded," + " cred" + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			final PreparedStatement ps = d.openConnection().prepareStatement(sql);
			ps.setString(1, getNombre());
			ps.setInt(2, getSSN());
			ps.setInt(3, getNumDependentes());
			ps.setString(4, getFechaNacimiento());
			ps.setString(5, getFechaEmpleo());
			ps.setString(6, getTelefono());
			ps.setString(7, getDireccionFisica());
			ps.setString(8, getDireccionPostal());
			ps.setString(9, getPosicionTrabajo());
			ps.setString(10, getEstadoCivil());
			ps.setString(11, getChartOfAcct());
			ps.setBoolean(12, isSalarioFijo());
			ps.setDouble(13, getSalarios());
			ps.setDouble(14, getHourRate());
			ps.setDouble(15, getTax());
			ps.setBoolean(16, getReg());
			ps.setDouble(17, getFica());
			ps.setDouble(18, getPlanMedico());
			ps.setDouble(19, getCancer());
			ps.setBoolean(20, isActivo());
			ps.setDouble(21, getTotalPagado());
			ps.setDouble(22, getDed());
			ps.setDouble(23, getCred());
			ps.executeUpdate();
			d.closeConnection();

		} else {
			final String sql = "update empleados set " + "nombre=?, " + "SSN=?, " + "numDependientes=?, "
					+ "fechaNacimiento=?, " + "fechaEmpleo=?, " + "telefono=?, " + "direccionFisica=?, "
					+ "direccionPostal=?, " + "posicionTrabajo=?, " + "estadoCivil=?, " + "chartOfAcct=?, "
					+ "salarioFijo=?, " + "salario=?, " + "hourRate=?, " + "tax=?, " + "reg=?, " + "fica=?, "
					+ "planMedico=?, " + "cancer=?, " + "activo=?, " + "totalPagado=?, " + "ded=?, " + "cred=? "
					+ "WHERE ID=?";
			final PreparedStatement ps = d.openConnection().prepareStatement(sql);
			ps.setString(1, getNombre());
			ps.setInt(2, getSSN());
			ps.setInt(3, getNumDependentes());
			ps.setString(4, getFechaNacimiento());
			ps.setString(5, getFechaEmpleo());
			ps.setString(6, getTelefono());
			ps.setString(7, getDireccionFisica());
			ps.setString(8, getDireccionPostal());
			ps.setString(9, getPosicionTrabajo());
			ps.setString(10, getEstadoCivil());
			ps.setString(11, getChartOfAcct());
			ps.setBoolean(12, isSalarioFijo());
			ps.setDouble(13, getSalarios());
			ps.setDouble(14, getHourRate());
			ps.setDouble(15, getTax());
			ps.setBoolean(16, getReg());
			ps.setDouble(17, getFica());
			ps.setDouble(18, getPlanMedico());
			ps.setDouble(19, getCancer());
			ps.setBoolean(20, isActivo());
			ps.setDouble(21, getTotalPagado());
			ps.setDouble(22, getDed());
			ps.setDouble(23, getCred());
			ps.setInt(24, getId());
			ps.executeUpdate();
			d.closeConnection();

		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public Integer getSSN() {
		return SSN;
	}

	public void setSSN(final Integer sSN) {
		SSN = sSN;
	}

	public Integer getNumDependentes() {
		return numDependentes;
	}

	public void setNumDependentes(final Integer numDependentes) {
		this.numDependentes = numDependentes;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Boolean getReg() {
		return reg;
	}

	public void setReg(final Boolean reg) {
		this.reg = reg;
	}

	public void setFechaNacimiento(final String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaEmpleo() {
		return fechaEmpleo;
	}

	public void setFechaEmpleo(final String fechaEmpleo) {
		this.fechaEmpleo = fechaEmpleo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public String getDireccionFisica() {
		return direccionFisica;
	}

	public void setDireccionFisica(final String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(final String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getPosicionTrabajo() {
		return posicionTrabajo;
	}

	public void setPosicionTrabajo(final String posicionTrabajo) {
		this.posicionTrabajo = posicionTrabajo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(final String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getChartOfAcct() {
		return chartOfAcct;
	}

	public void setChartOfAcct(final String chartOfAcct) {
		this.chartOfAcct = chartOfAcct;
	}

	public boolean isSalarioFijo() {
		return salarioFijo;
	}

	public void setSalarioFijo(final boolean salarioFijo) {
		this.salarioFijo = salarioFijo;
	}

	public Double getSalarios() {
		return salarios;
	}

	public void setSalarios(final Double salarios) {
		this.salarios = salarios;
	}

	public Double getHourRate() {
		return hourRate;
	}

	public void setHourRate(final Double hourRate) {
		this.hourRate = hourRate;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(final Double tax) {
		this.tax = tax;
	}

	public Double getFica() {
		return fica;
	}

	public void setFica(final Double fica) {
		this.fica = fica;
	}

	public Double getPlanMedico() {
		return planMedico;
	}

	public void setPlanMedico(final Double planMedico) {
		this.planMedico = planMedico;
	}

	public Double getCancer() {
		return cancer;
	}

	public void setCancer(final Double cancer) {
		this.cancer = cancer;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(final boolean activo) {
		this.activo = activo;
	}

	public Double getTotalPagado() {
		return totalPagado;
	}

	public void setTotalPagado(final Double totalPagado) {
		this.totalPagado = totalPagado;
	}

	public Double getDed() {
		return ded;
	}

	public void setDed(final Double ded) {
		this.ded = ded;
	}

	public Double getCred() {
		return cred;
	}

	public void setCred(final Double cred) {
		this.cred = cred;
	}

	/*
	 * extensiones contributivas - completa(no paga nada) - mitad - ninguna
	 */

	// private boolean salarioFijo;
	// DATA PARA LA TABLA DE HISTORIAL

	// fecha de quincena
	// total de horas pagadas
	// calario(alternante con el total de horas)

}
