package broiler.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name="pagos")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago extends TableItem  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double ahorro;

	private double ahorro;

	private double balance;

	private double balance;

	private double balance_Pendiente;

	private double balance_Pendiente;

	private double cantidad;

	private double cantidad;

	private String descripcion;

	private String descripcion;

	private String fecha;

	private String fecha;

	private int link_Id;

	private double recargo;

	private double recargo;

	private String semestre;

	private String semestre;

	private int sort;

	private int sort;

	private double vencido;

	private double vencido;

	//bi-directional many-to-one association to PagoDetalle
	@OneToMany(mappedBy="pagoBean")
	private List<PagoDetalle> pagoDetalles;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="estudiantes_ID")
	private Estudiante estudiante;

	public Pago() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAhorro() {
		return this.ahorro;
	}

	public void setAhorro(double ahorro) {
		this.ahorro = ahorro;
	}

	public double getAhorro() {
		return this.ahorro;
	}

	public void setAhorro(double ahorro) {
		this.ahorro = ahorro;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance_Pendiente() {
		return this.balance_Pendiente;
	}

	public void setBalance_Pendiente(double balance_Pendiente) {
		this.balance_Pendiente = balance_Pendiente;
	}

	public double getBalance_Pendiente() {
		return this.balance_Pendiente;
	}

	public void setBalance_Pendiente(double balance_Pendiente) {
		this.balance_Pendiente = balance_Pendiente;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getLink_Id() {
		return this.link_Id;
	}

	public void setLink_Id(int link_Id) {
		this.link_Id = link_Id;
	}

	public double getRecargo() {
		return this.recargo;
	}

	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}

	public double getRecargo() {
		return this.recargo;
	}

	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public double getVencido() {
		return this.vencido;
	}

	public void setVencido(double vencido) {
		this.vencido = vencido;
	}

	public double getVencido() {
		return this.vencido;
	}

	public void setVencido(double vencido) {
		this.vencido = vencido;
	}

	public List<PagoDetalle> getPagoDetalles() {
		return this.pagoDetalles;
	}

	public void setPagoDetalles(List<PagoDetalle> pagoDetalles) {
		this.pagoDetalles = pagoDetalles;
	}

	public PagoDetalle addPagoDetalle(PagoDetalle pagoDetalle) {
		getPagoDetalles().add(pagoDetalle);
		pagoDetalle.setPagoBean(this);

		return pagoDetalle;
	}

	public PagoDetalle removePagoDetalle(PagoDetalle pagoDetalle) {
		getPagoDetalles().remove(pagoDetalle);
		pagoDetalle.setPagoBean(null);

		return pagoDetalle;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}