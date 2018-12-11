package broiler.abstraction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//import iconix.database.DatabaseConnect;

public class Empleados extends TableItem{

	/*
	 * la nomina se corre quincenal no se sabe como
	 * 
	 * SE LE TUVO QUE QUITAR EL PRIVATE A LAS CLASSES YA QUE EL SUPERCLASS EMTHOD NO PUEDE ACCESARLAS
	 * 
	 *para el std poner validar que los nombres de los fields sean igual que el nombre de el DB
	 * 
	 * 
	 * 
	 */
	 Integer id;
	 String nombre;
	 Integer SSN;
	 Integer numDependientes;// poner en formulario
	 String fechaNacimiento;
	 String fechaEmpleo;
	 String telefono;
	 String direccionFisica;
	 String direccionPostal;
	 String posicionTrabajo;
	 String estadoCivil;
	 String chartOfAcct; // cuenta a donde se va en contabilidad
	 boolean salarioFijo;
	 Double salario;// mensual o quincenal?
	 Double hourRate;
	 Double tax;
	 Boolean reg;
	 Double fica = 0.0765;// %
	 Double planMedico;
	 Double cancer;
	 boolean activo;
	 Double totalPagado;
	 Double ded;
	 Double cred;
	// INFORMACION DE NOMINA

	// private Double regNon; //activa el 7% de tax despues de haberle pagado 1500
	// al empleado

	// NOMINAS ACUMULADAS(tabla nueva?)

	public Empleados(final Integer id, final String nombre, final Integer sSN, final Integer numDependientes,
			final String fechaNacimiento, final String fechaEmpleo, final String telefono, final String direccionFisica,
			final String direccionPostal, final String posicionTrabajo, final String estadoCivil,
			final String chartOfAcct, final boolean salarioFijo, final Double salario, final Double hourRate,
			final Double tax, final boolean reg, final Double fica, final Double planMedico, final Double cancer,
			final boolean activo, final Double totalPagado, final Double ded, final Double cred) {
		super();
		this.id = id;
		this.nombre = nombre;
		SSN = sSN;
		this.numDependientes = numDependientes;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaEmpleo = fechaEmpleo;
		this.telefono = telefono;
		this.direccionFisica = direccionFisica;
		this.direccionPostal = direccionPostal;
		this.posicionTrabajo = posicionTrabajo;
		this.estadoCivil = estadoCivil;
		this.chartOfAcct = chartOfAcct;
		this.salarioFijo = salarioFijo;
		this.salario = salario;
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

	public Empleados(final String nombre, final Integer sSN, final Integer numDependientes, final String fechaNacimiento,
			final String fechaEmpleo, final String telefono, final String direccionFisica, final String direccionPostal,
			final String posicionTrabajo, final String estadoCivil, final String chartOfAcct, final boolean salarioFijo,
			final Double salario, final Double hourRate, final Double tax, final boolean reg, final Double fica,
			final Double planMedico, final Double cancer, final boolean activo, final Double totalPagado,
			final Double ded, final Double cred) {
		super();
		this.nombre = nombre;
		SSN = sSN;
		this.numDependientes = numDependientes;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaEmpleo = fechaEmpleo;
		this.telefono = telefono;
		this.direccionFisica = direccionFisica;
		this.direccionPostal = direccionPostal;
		this.posicionTrabajo = posicionTrabajo;
		this.estadoCivil = estadoCivil;
		this.chartOfAcct = chartOfAcct;
		this.salarioFijo = salarioFijo;
		this.salario = salario;
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

	public Empleados(final String[] s) {
		super();
		this.id = Integer.parseInt(s[0]);
		this.nombre = s[1];
		this.SSN = Integer.parseInt(s[2]);
		this.numDependientes = Integer.parseInt(s[3]);// poner en formulario
		this.fechaNacimiento = s[4];
		this.fechaEmpleo = s[5];
		this.telefono = s[6];
		this.direccionFisica = s[7];
		this.direccionPostal = s[8];
		this.posicionTrabajo = s[9];
		this.estadoCivil = s[10];
		this.chartOfAcct = s[11]; // cuenta a donde se va en contabilidad
		this.salarioFijo = s[12].equals("1");// Double.parseDouble(s[12]);
		this.salario = Double.parseDouble(s[13]);// mensual o quincenal?
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

	public Integer getNumDependientes() {
		return numDependientes;
	}

	public void setNumDependientes(final Integer numDependentes) {
		this.numDependientes = numDependentes;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(final Double salarios) {
		this.salario = salarios;
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
