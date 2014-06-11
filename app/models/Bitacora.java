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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.*;


/**
 * The persistent class for the BITACORA database table.
 * 
 */
@Entity
@Table(name="BITACORA")
public class Bitacora extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDBITACORA")
	private long idbitacora;

	@Column(name="ACCIONREALIZADA")
	private String accionrealizada;

	@Column(name="REGISTROAFECTADO")
	private String registroafectado;

	@Column(name="TABLAAFECTADA")
	private String tablaafectada;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Bitacora() {
	}

	public long getIdbitacora() {
		return this.idbitacora;
	}

	public void setIdbitacora(long idbitacora) {
		this.idbitacora = idbitacora;
	}

	public String getAccionrealizada() {
		return this.accionrealizada;
	}

	public void setAccionrealizada(String accionrealizada) {
		this.accionrealizada = accionrealizada;
	}

	public String getRegistroafectado() {
		return this.registroafectado;
	}

	public void setRegistroafectado(String registroafectado) {
		this.registroafectado = registroafectado;
	}

	public String getTablaafectada() {
		return this.tablaafectada;
	}

	public void setTablaafectada(String tablaafectada) {
		this.tablaafectada = tablaafectada;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}