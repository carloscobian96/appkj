package broiler.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historialnomina database table.
 * 
 */
@Entity
@NamedQuery(name="Historialnomina.findAll", query="SELECT h FROM Historialnomina h")
public class Historialnomina extends TableItem  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double cancer;

	private double cancer;

	private double cancer;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private double fica;

	private double fica;

	private double fica;

	private double horas;

	private double horas;

	private double horas;

	@Column(name="hr_enfermedad")
	private double hrEnfermedad;

	@Column(name="hr_enfermedad")
	private double hrEnfermedad;

	@Column(name="hr_enfermedad")
	private double hrEnfermedad;

	@Column(name="hr_fer")
	private double hrFer;

	@Column(name="hr_fer")
	private double hrFer;

	@Column(name="hr_fer")
	private double hrFer;

	@Column(name="hr_mat")
	private double hrMat;

	@Column(name="hr_mat")
	private double hrMat;

	@Column(name="hr_mat")
	private double hrMat;

	@Column(name="hr_reg")
	private double hrReg;

	@Column(name="hr_reg")
	private double hrReg;

	@Column(name="hr_reg")
	private double hrReg;

	@Column(name="hr_vac")
	private double hrVac;

	@Column(name="hr_vac")
	private double hrVac;

	@Column(name="hr_vac")
	private double hrVac;

	private int id;

	private int id;

	@Column(name="id_empleado")
	private int idEmpleado;

	@Column(name="id_empleado")
	private int idEmpleado;

	private double medicare;

	private double medicare;

	private double medicare;

	private double rate;

	private double rate;

	private double rate;

	private double salario;

	private double salario;

	private double salario;

	private double tax;

	private double tax;

	private double tax;

	@Column(name="tax_rate")
	private double taxRate;

	@Column(name="tax_rate")
	private double taxRate;

	@Column(name="tax_rate")
	private double taxRate;

	private double total;

	private double total;

	private double total;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="empleados_ID")
	private Empleado empleado;

	public Historialnomina() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public double getHoras() {
		return this.horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getHoras() {
		return this.horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getHoras() {
		return this.horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getHrEnfermedad() {
		return this.hrEnfermedad;
	}

	public void setHrEnfermedad(double hrEnfermedad) {
		this.hrEnfermedad = hrEnfermedad;
	}

	public double getHrEnfermedad() {
		return this.hrEnfermedad;
	}

	public void setHrEnfermedad(double hrEnfermedad) {
		this.hrEnfermedad = hrEnfermedad;
	}

	public double getHrEnfermedad() {
		return this.hrEnfermedad;
	}

	public void setHrEnfermedad(double hrEnfermedad) {
		this.hrEnfermedad = hrEnfermedad;
	}

	public double getHrFer() {
		return this.hrFer;
	}

	public void setHrFer(double hrFer) {
		this.hrFer = hrFer;
	}

	public double getHrFer() {
		return this.hrFer;
	}

	public void setHrFer(double hrFer) {
		this.hrFer = hrFer;
	}

	public double getHrFer() {
		return this.hrFer;
	}

	public void setHrFer(double hrFer) {
		this.hrFer = hrFer;
	}

	public double getHrMat() {
		return this.hrMat;
	}

	public void setHrMat(double hrMat) {
		this.hrMat = hrMat;
	}

	public double getHrMat() {
		return this.hrMat;
	}

	public void setHrMat(double hrMat) {
		this.hrMat = hrMat;
	}

	public double getHrMat() {
		return this.hrMat;
	}

	public void setHrMat(double hrMat) {
		this.hrMat = hrMat;
	}

	public double getHrReg() {
		return this.hrReg;
	}

	public void setHrReg(double hrReg) {
		this.hrReg = hrReg;
	}

	public double getHrReg() {
		return this.hrReg;
	}

	public void setHrReg(double hrReg) {
		this.hrReg = hrReg;
	}

	public double getHrReg() {
		return this.hrReg;
	}

	public void setHrReg(double hrReg) {
		this.hrReg = hrReg;
	}

	public double getHrVac() {
		return this.hrVac;
	}

	public void setHrVac(double hrVac) {
		this.hrVac = hrVac;
	}

	public double getHrVac() {
		return this.hrVac;
	}

	public void setHrVac(double hrVac) {
		this.hrVac = hrVac;
	}

	public double getHrVac() {
		return this.hrVac;
	}

	public void setHrVac(double hrVac) {
		this.hrVac = hrVac;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public double getMedicare() {
		return this.medicare;
	}

	public void setMedicare(double medicare) {
		this.medicare = medicare;
	}

	public double getMedicare() {
		return this.medicare;
	}

	public void setMedicare(double medicare) {
		this.medicare = medicare;
	}

	public double getMedicare() {
		return this.medicare;
	}

	public void setMedicare(double medicare) {
		this.medicare = medicare;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getTax() {
		return this.tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTax() {
		return this.tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTax() {
		return this.tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}