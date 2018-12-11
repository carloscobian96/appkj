package broiler.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado extends TableItem  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte activo;

	private byte activo;

	private byte activo;

	private double cancer;

	private double cancer;

	private double cancer;

	private String chartOfAcct;

	private String chartOfAcct;

	private String chartOfAcct;

	private BigDecimal cred;

	private BigDecimal cred;

	private BigDecimal cred;

	private BigDecimal ded;

	private BigDecimal ded;

	private BigDecimal ded;

	private String direccionFisica;

	private String direccionFisica;

	private String direccionFisica;

	private String direccionPostal;

	private String direccionPostal;

	private String direccionPostal;

	private String estadoCivil;

	private String estadoCivil;

	private String estadoCivil;

	private String fechaEmpleo;

	private String fechaEmpleo;

	private String fechaEmpleo;

	private String fechaNacimiento;

	private String fechaNacimiento;

	private String fechaNacimiento;

	private double fica;

	private double fica;

	private double fica;

	private BigDecimal hourRate;

	private BigDecimal hourRate;

	private BigDecimal hourRate;

	private String nombre;

	private String nombre;

	private String nombre;

	private int numDependientes;

	private int numDependientes;

	private int numDependientes;

	private BigDecimal planMedico;

	private BigDecimal planMedico;

	private BigDecimal planMedico;

	private String posicionTrabajo;

	private String posicionTrabajo;

	private String posicionTrabajo;

	private byte reg;

	private byte reg;

	private byte reg;

	private BigDecimal salario;

	private BigDecimal salario;

	private BigDecimal salario;

	private byte salarioFijo;

	private byte salarioFijo;

	private byte salarioFijo;

	private int ssn;

	private int ssn;

	private int ssn;

	private BigDecimal tax;

	private BigDecimal tax;

	private BigDecimal tax;

	private String telefono;

	private String telefono;

	private String telefono;

	private BigDecimal totalPagado;

	private BigDecimal totalPagado;

	private BigDecimal totalPagado;

	//bi-directional many-to-one association to Historialnomina
	@OneToMany(mappedBy="empleado")
	private List<Historialnomina> historialnominas;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public double getCancer() {
		return this.cancer;
	}

	public void setCancer(double cancer) {
		this.cancer = cancer;
	}

	public double getCancer() {
		return this.cancer;
	}

	public void setCancer(double cancer) {
		this.cancer = cancer;
	}

	public double getCancer() {
		return this.cancer;
	}

	public void setCancer(double cancer) {
		this.cancer = cancer;
	}

	public String getChartOfAcct() {
		return this.chartOfAcct;
	}

	public void setChartOfAcct(String chartOfAcct) {
		this.chartOfAcct = chartOfAcct;
	}

	public String getChartOfAcct() {
		return this.chartOfAcct;
	}

	public void setChartOfAcct(String chartOfAcct) {
		this.chartOfAcct = chartOfAcct;
	}

	public String getChartOfAcct() {
		return this.chartOfAcct;
	}

	public void setChartOfAcct(String chartOfAcct) {
		this.chartOfAcct = chartOfAcct;
	}

	public BigDecimal getCred() {
		return this.cred;
	}

	public void setCred(BigDecimal cred) {
		this.cred = cred;
	}

	public BigDecimal getCred() {
		return this.cred;
	}

	public void setCred(BigDecimal cred) {
		this.cred = cred;
	}

	public BigDecimal getCred() {
		return this.cred;
	}

	public void setCred(BigDecimal cred) {
		this.cred = cred;
	}

	public BigDecimal getDed() {
		return this.ded;
	}

	public void setDed(BigDecimal ded) {
		this.ded = ded;
	}

	public BigDecimal getDed() {
		return this.ded;
	}

	public void setDed(BigDecimal ded) {
		this.ded = ded;
	}

	public BigDecimal getDed() {
		return this.ded;
	}

	public void setDed(BigDecimal ded) {
		this.ded = ded;
	}

	public String getDireccionFisica() {
		return this.direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public String getDireccionFisica() {
		return this.direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public String getDireccionFisica() {
		return this.direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public String getDireccionPostal() {
		return this.direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getDireccionPostal() {
		return this.direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getDireccionPostal() {
		return this.direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFechaEmpleo() {
		return this.fechaEmpleo;
	}

	public void setFechaEmpleo(String fechaEmpleo) {
		this.fechaEmpleo = fechaEmpleo;
	}

	public String getFechaEmpleo() {
		return this.fechaEmpleo;
	}

	public void setFechaEmpleo(String fechaEmpleo) {
		this.fechaEmpleo = fechaEmpleo;
	}

	public String getFechaEmpleo() {
		return this.fechaEmpleo;
	}

	public void setFechaEmpleo(String fechaEmpleo) {
		this.fechaEmpleo = fechaEmpleo;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getFica() {
		return this.fica;
	}

	public void setFica(double fica) {
		this.fica = fica;
	}

	public double getFica() {
		return this.fica;
	}

	public void setFica(double fica) {
		this.fica = fica;
	}

	public double getFica() {
		return this.fica;
	}

	public void setFica(double fica) {
		this.fica = fica;
	}

	public BigDecimal getHourRate() {
		return this.hourRate;
	}

	public void setHourRate(BigDecimal hourRate) {
		this.hourRate = hourRate;
	}

	public BigDecimal getHourRate() {
		return this.hourRate;
	}

	public void setHourRate(BigDecimal hourRate) {
		this.hourRate = hourRate;
	}

	public BigDecimal getHourRate() {
		return this.hourRate;
	}

	public void setHourRate(BigDecimal hourRate) {
		this.hourRate = hourRate;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumDependientes() {
		return this.numDependientes;
	}

	public void setNumDependientes(int numDependientes) {
		this.numDependientes = numDependientes;
	}

	public int getNumDependientes() {
		return this.numDependientes;
	}

	public void setNumDependientes(int numDependientes) {
		this.numDependientes = numDependientes;
	}

	public int getNumDependientes() {
		return this.numDependientes;
	}

	public void setNumDependientes(int numDependientes) {
		this.numDependientes = numDependientes;
	}

	public BigDecimal getPlanMedico() {
		return this.planMedico;
	}

	public void setPlanMedico(BigDecimal planMedico) {
		this.planMedico = planMedico;
	}

	public BigDecimal getPlanMedico() {
		return this.planMedico;
	}

	public void setPlanMedico(BigDecimal planMedico) {
		this.planMedico = planMedico;
	}

	public BigDecimal getPlanMedico() {
		return this.planMedico;
	}

	public void setPlanMedico(BigDecimal planMedico) {
		this.planMedico = planMedico;
	}

	public String getPosicionTrabajo() {
		return this.posicionTrabajo;
	}

	public void setPosicionTrabajo(String posicionTrabajo) {
		this.posicionTrabajo = posicionTrabajo;
	}

	public String getPosicionTrabajo() {
		return this.posicionTrabajo;
	}

	public void setPosicionTrabajo(String posicionTrabajo) {
		this.posicionTrabajo = posicionTrabajo;
	}

	public String getPosicionTrabajo() {
		return this.posicionTrabajo;
	}

	public void setPosicionTrabajo(String posicionTrabajo) {
		this.posicionTrabajo = posicionTrabajo;
	}

	public byte getReg() {
		return this.reg;
	}

	public void setReg(byte reg) {
		this.reg = reg;
	}

	public byte getReg() {
		return this.reg;
	}

	public void setReg(byte reg) {
		this.reg = reg;
	}

	public byte getReg() {
		return this.reg;
	}

	public void setReg(byte reg) {
		this.reg = reg;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public byte getSalarioFijo() {
		return this.salarioFijo;
	}

	public void setSalarioFijo(byte salarioFijo) {
		this.salarioFijo = salarioFijo;
	}

	public byte getSalarioFijo() {
		return this.salarioFijo;
	}

	public void setSalarioFijo(byte salarioFijo) {
		this.salarioFijo = salarioFijo;
	}

	public byte getSalarioFijo() {
		return this.salarioFijo;
	}

	public void setSalarioFijo(byte salarioFijo) {
		this.salarioFijo = salarioFijo;
	}

	public int getSsn() {
		return this.ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getSsn() {
		return this.ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getSsn() {
		return this.ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public BigDecimal getTotalPagado() {
		return this.totalPagado;
	}

	public void setTotalPagado(BigDecimal totalPagado) {
		this.totalPagado = totalPagado;
	}

	public BigDecimal getTotalPagado() {
		return this.totalPagado;
	}

	public void setTotalPagado(BigDecimal totalPagado) {
		this.totalPagado = totalPagado;
	}

	public BigDecimal getTotalPagado() {
		return this.totalPagado;
	}

	public void setTotalPagado(BigDecimal totalPagado) {
		this.totalPagado = totalPagado;
	}

	public List<Historialnomina> getHistorialnominas() {
		return this.historialnominas;
	}

	public void setHistorialnominas(List<Historialnomina> historialnominas) {
		this.historialnominas = historialnominas;
	}

	public Historialnomina addHistorialnomina(Historialnomina historialnomina) {
		getHistorialnominas().add(historialnomina);
		historialnomina.setEmpleado(this);

		return historialnomina;
	}

	public Historialnomina removeHistorialnomina(Historialnomina historialnomina) {
		getHistorialnominas().remove(historialnomina);
		historialnomina.setEmpleado(null);

		return historialnomina;
	}

}