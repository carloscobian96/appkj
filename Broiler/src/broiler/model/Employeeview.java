package broiler.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employeeview database table.
 * 
 */
@Entity
@NamedQuery(name="Employeeview.findAll", query="SELECT e FROM Employeeview e")
public class Employeeview extends TableItem  {
	private static final long serialVersionUID = 1L;

	private int id;

	private String nombre;

	private String posicionTrabajo;

	private int ssn;

	private String telefono;

	public Employeeview() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicionTrabajo() {
		return this.posicionTrabajo;
	}

	public void setPosicionTrabajo(String posicionTrabajo) {
		this.posicionTrabajo = posicionTrabajo;
	}

	public int getSsn() {
		return this.ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}