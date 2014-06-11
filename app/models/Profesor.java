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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the PROFESOR database table.
 * 
 */
@Entity
@Table(name="PROFESOR")
public class Profesor extends GenericModel {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDPROFESOR")
	private long idprofesor;
	
	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;

	@Id
	@Column(name="CARNET")
	private long carnet;

	@Column(name="EXTTELEFONICA")
	private String exttelefonica;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(name="CODINFRAESTRUCTURA")
	private Institucion institucion;

	//bi-directional many-to-one association to Prestamista
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CARNET", referencedColumnName="CARNET"),
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
		})
	private Prestamista prestamista;

	public Profesor() {
	}
/*
	public ProfesorPK getId() {
		return this.id;
	}

	public void setId(ProfesorPK id) {
		this.id = id;
	}
*/
	public String getExttelefonica() {
		return this.exttelefonica;
	}

	public void setExttelefonica(String exttelefonica) {
		this.exttelefonica = exttelefonica;
	}

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Prestamista getPrestamista() {
		return this.prestamista;
	}

	public void setPrestamista(Prestamista prestamista) {
		this.prestamista = prestamista;
	}
	
	@Override
	public String toString() {
		return "Profesor [idprofesor=" + idprofesor + ", idUsuario="
				+ idUsuario + ", carnet=" + carnet + ", exttelefonica="
				+ exttelefonica + ", institucion=" + institucion
				+ ", prestamista=" + prestamista + "]";
	}

	
}