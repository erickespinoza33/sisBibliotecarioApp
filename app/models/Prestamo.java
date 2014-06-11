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
 * The persistent class for the PRESTAMO database table.
 * 
 */
@Entity
@Table(name="PRESTAMO")
public class Prestamo extends GenericModel {

	@Id
	@Column(name="IDPRESTAMO")
	private long idprestamo;

	@Column(name="ESTADO")
	private BigDecimal estado;

	@Column(name="FECHADEVOLUCION")
	private Date fechadevolucion;

	@Column(name="FECHAFIN")
	private Date fechafin;

	@Column(name="FECHAINICIO")
	private Date fechainicio;

	//bi-directional many-to-one association to Mora
	@OneToMany(mappedBy="prestamo")
	private List<Mora> moras;

	//bi-directional many-to-one association to Bibliotecologo
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="BIB_ID_USUARIO", referencedColumnName="ID_USUARIO"),
		@JoinColumn(name="IDBIBLIO", referencedColumnName="IDBIBLIO")
		})
	private Bibliotecologo bibliotecologo;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IDMATERIAL")
	private Material material;

	//bi-directional many-to-one association to Prestamista
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CARNET", referencedColumnName="CARNET"),
		@JoinColumn(name="ID_USUARIO", referencedColumnName="ID_USUARIO")
		})
	private Prestamista prestamista;

	//bi-directional many-to-one association to Tipoprestamo
	@ManyToOne
	@JoinColumn(name="IDTIPOPRESTAMO")
	private Tipoprestamo tipoprestamo;

	public Prestamo() {
	}

	public long getIdprestamo() {
		return this.idprestamo;
	}

	public void setIdprestamo(long idprestamo) {
		this.idprestamo = idprestamo;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFechadevolucion() {
		return this.fechadevolucion;
	}

	public void setFechadevolucion(Date fechadevolucion) {
		this.fechadevolucion = fechadevolucion;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public List<Mora> getMoras() {
		return this.moras;
	}

	public void setMoras(List<Mora> moras) {
		this.moras = moras;
	}

	public Mora addMora(Mora mora) {
		getMoras().add(mora);
		mora.setPrestamo(this);

		return mora;
	}

	public Mora removeMora(Mora mora) {
		getMoras().remove(mora);
		mora.setPrestamo(null);

		return mora;
	}

	public Bibliotecologo getBibliotecologo() {
		return this.bibliotecologo;
	}

	public void setBibliotecologo(Bibliotecologo bibliotecologo) {
		this.bibliotecologo = bibliotecologo;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Prestamista getPrestamista() {
		return this.prestamista;
	}

	public void setPrestamista(Prestamista prestamista) {
		this.prestamista = prestamista;
	}

	public Tipoprestamo getTipoprestamo() {
		return this.tipoprestamo;
	}

	public void setTipoprestamo(Tipoprestamo tipoprestamo) {
		this.tipoprestamo = tipoprestamo;
	}

	@Override
	public String toString() {
		return "Prestamo [idprestamo=" + idprestamo + ", estado=" + estado
				+ ", fechadevolucion=" + fechadevolucion + ", fechafin="
				+ fechafin + ", fechainicio=" + fechainicio + ", moras="
				+ moras + ", bibliotecologo=" + bibliotecologo + ", material="
				+ material + ", prestamista=" + prestamista + ", tipoprestamo="
				+ tipoprestamo + "]";
	}

}