package models;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;
import play.data.validation.Required;
import play.data.validation.MaxSize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the FUNCION database table.
 * 
 */
@Entity
@Table(name="FUNCION")
public class Funcion extends GenericModel {
	@Id
	@Column(name="IDFUNCION")
	private long idfuncion;

	@Column(name="FUNCION")
	private String funcion;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="funcions")
	private List<Rol> rols;

	public Funcion() {
	}

	public long getIdfuncion() {
		return this.idfuncion;
	}

	public void setIdfuncion(long idfuncion) {
		this.idfuncion = idfuncion;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}