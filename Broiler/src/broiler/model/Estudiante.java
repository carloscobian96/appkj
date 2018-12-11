package broiler.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the estudiantes database table.
 * 
 */
@Entity
@Table(name="estudiantes")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante extends TableItem  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte active;

	private byte active;

	private double ahorros;

	private double ahorros;

	private int ano_Estudiante;

	private int ano_Estudiante;

	private int beca;

	private int beca;

	private BigDecimal desc_Matricula;

	private BigDecimal desc_Matricula;

	private int edad;

	private int edad;

	private String fecha;

	private String fecha;

	private String fecha_Nacimiento;

	private String fecha_Nacimiento;

	private String grado;

	private String grado;

	private String mes_Pago;

	private String mes_Pago;

	private String nombre;

	private String nombre;

	private int numero_Estudiante;

	private int numero_Estudiante;

	private String paguese;

	private String paguese;

	private String procede;

	private String procede;

	private String saludo;

	private String saludo;

	private String semestre;

	private String semestre;

	private String sexo;

	private String sexo;

	private String ssn;

	private String ssn;

	private String status;

	private String status;

	private BigDecimal total_Pagado;

	private BigDecimal total_Pagado;

	private BigDecimal total_Pendiente;

	private BigDecimal total_Pendiente;

	private String ultima_Carta;

	private String ultima_Carta;

	private String ultima_Carta_Descripcion;

	private String ultima_Carta_Descripcion;

	private String ultimo_Estado;

	private String ultimo_Estado;

	private BigDecimal vencido;

	private BigDecimal vencido;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="estudiante")
	private List<Pago> pagos;

	public Estudiante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public double getAhorros() {
		return this.ahorros;
	}

	public void setAhorros(double ahorros) {
		this.ahorros = ahorros;
	}

	public double getAhorros() {
		return this.ahorros;
	}

	public void setAhorros(double ahorros) {
		this.ahorros = ahorros;
	}

	public int getAno_Estudiante() {
		return this.ano_Estudiante;
	}

	public void setAno_Estudiante(int ano_Estudiante) {
		this.ano_Estudiante = ano_Estudiante;
	}

	public int getAno_Estudiante() {
		return this.ano_Estudiante;
	}

	public void setAno_Estudiante(int ano_Estudiante) {
		this.ano_Estudiante = ano_Estudiante;
	}

	public int getBeca() {
		return this.beca;
	}

	public void setBeca(int beca) {
		this.beca = beca;
	}

	public int getBeca() {
		return this.beca;
	}

	public void setBeca(int beca) {
		this.beca = beca;
	}

	public BigDecimal getDesc_Matricula() {
		return this.desc_Matricula;
	}

	public void setDesc_Matricula(BigDecimal desc_Matricula) {
		this.desc_Matricula = desc_Matricula;
	}

	public BigDecimal getDesc_Matricula() {
		return this.desc_Matricula;
	}

	public void setDesc_Matricula(BigDecimal desc_Matricula) {
		this.desc_Matricula = desc_Matricula;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public String getFecha_Nacimiento() {
		return this.fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getFecha_Nacimiento() {
		return this.fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getGrado() {
		return this.grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getGrado() {
		return this.grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getMes_Pago() {
		return this.mes_Pago;
	}

	public void setMes_Pago(String mes_Pago) {
		this.mes_Pago = mes_Pago;
	}

	public String getMes_Pago() {
		return this.mes_Pago;
	}

	public void setMes_Pago(String mes_Pago) {
		this.mes_Pago = mes_Pago;
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

	public int getNumero_Estudiante() {
		return this.numero_Estudiante;
	}

	public void setNumero_Estudiante(int numero_Estudiante) {
		this.numero_Estudiante = numero_Estudiante;
	}

	public int getNumero_Estudiante() {
		return this.numero_Estudiante;
	}

	public void setNumero_Estudiante(int numero_Estudiante) {
		this.numero_Estudiante = numero_Estudiante;
	}

	public String getPaguese() {
		return this.paguese;
	}

	public void setPaguese(String paguese) {
		this.paguese = paguese;
	}

	public String getPaguese() {
		return this.paguese;
	}

	public void setPaguese(String paguese) {
		this.paguese = paguese;
	}

	public String getProcede() {
		return this.procede;
	}

	public void setProcede(String procede) {
		this.procede = procede;
	}

	public String getProcede() {
		return this.procede;
	}

	public void setProcede(String procede) {
		this.procede = procede;
	}

	public String getSaludo() {
		return this.saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public String getSaludo() {
		return this.saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
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

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotal_Pagado() {
		return this.total_Pagado;
	}

	public void setTotal_Pagado(BigDecimal total_Pagado) {
		this.total_Pagado = total_Pagado;
	}

	public BigDecimal getTotal_Pagado() {
		return this.total_Pagado;
	}

	public void setTotal_Pagado(BigDecimal total_Pagado) {
		this.total_Pagado = total_Pagado;
	}

	public BigDecimal getTotal_Pendiente() {
		return this.total_Pendiente;
	}

	public void setTotal_Pendiente(BigDecimal total_Pendiente) {
		this.total_Pendiente = total_Pendiente;
	}

	public BigDecimal getTotal_Pendiente() {
		return this.total_Pendiente;
	}

	public void setTotal_Pendiente(BigDecimal total_Pendiente) {
		this.total_Pendiente = total_Pendiente;
	}

	public String getUltima_Carta() {
		return this.ultima_Carta;
	}

	public void setUltima_Carta(String ultima_Carta) {
		this.ultima_Carta = ultima_Carta;
	}

	public String getUltima_Carta() {
		return this.ultima_Carta;
	}

	public void setUltima_Carta(String ultima_Carta) {
		this.ultima_Carta = ultima_Carta;
	}

	public String getUltima_Carta_Descripcion() {
		return this.ultima_Carta_Descripcion;
	}

	public void setUltima_Carta_Descripcion(String ultima_Carta_Descripcion) {
		this.ultima_Carta_Descripcion = ultima_Carta_Descripcion;
	}

	public String getUltima_Carta_Descripcion() {
		return this.ultima_Carta_Descripcion;
	}

	public void setUltima_Carta_Descripcion(String ultima_Carta_Descripcion) {
		this.ultima_Carta_Descripcion = ultima_Carta_Descripcion;
	}

	public String getUltimo_Estado() {
		return this.ultimo_Estado;
	}

	public void setUltimo_Estado(String ultimo_Estado) {
		this.ultimo_Estado = ultimo_Estado;
	}

	public String getUltimo_Estado() {
		return this.ultimo_Estado;
	}

	public void setUltimo_Estado(String ultimo_Estado) {
		this.ultimo_Estado = ultimo_Estado;
	}

	public BigDecimal getVencido() {
		return this.vencido;
	}

	public void setVencido(BigDecimal vencido) {
		this.vencido = vencido;
	}

	public BigDecimal getVencido() {
		return this.vencido;
	}

	public void setVencido(BigDecimal vencido) {
		this.vencido = vencido;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setEstudiante(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setEstudiante(null);

		return pago;
	}

}