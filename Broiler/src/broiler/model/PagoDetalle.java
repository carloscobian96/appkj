package broiler.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pago_detalles database table.
 * 
 */
@Entity
@Table(name="pago_detalles")
@NamedQuery(name="PagoDetalle.findAll", query="SELECT p FROM PagoDetalle p")
public class PagoDetalle extends TableItem  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double ahorro;

	private double ahorro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_de_Pago;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_de_Pago;

	private int id;

	@Column(name="link_id")
	private int linkId;

	private String mes;

	private String mes;

	private double pago;

	private double pago;

	private double recargo;

	private double recargo;

	private String recibo;

	private String recibo;

	private String semestre;

	private String semestre;

	//bi-directional many-to-one association to Pago
	@ManyToOne
	@JoinColumn(name="pagos_id")
	private Pago pagoBean;

	public PagoDetalle() {
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

	public Date getFecha_de_Pago() {
		return this.fecha_de_Pago;
	}

	public void setFecha_de_Pago(Date fecha_de_Pago) {
		this.fecha_de_Pago = fecha_de_Pago;
	}

	public Date getFecha_de_Pago() {
		return this.fecha_de_Pago;
	}

	public void setFecha_de_Pago(Date fecha_de_Pago) {
		this.fecha_de_Pago = fecha_de_Pago;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLinkId() {
		return this.linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getPago() {
		return this.pago;
	}

	public void setPago(double pago) {
		this.pago = pago;
	}

	public double getPago() {
		return this.pago;
	}

	public void setPago(double pago) {
		this.pago = pago;
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

	public String getRecibo() {
		return this.recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

	public String getRecibo() {
		return this.recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
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

	public Pago getPagoBean() {
		return this.pagoBean;
	}

	public void setPagoBean(Pago pagoBean) {
		this.pagoBean = pagoBean;
	}

}