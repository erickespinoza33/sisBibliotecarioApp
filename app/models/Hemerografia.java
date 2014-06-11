package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HEMEROGRAFIA database table.
 * 
 */
@Entity
@NamedQuery(name="Hemerografia.findAll", query="SELECT h FROM Hemerografia h")
public class Hemerografia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HemerografiaPK id;

	private String descripcionhem;

	@Temporal(TemporalType.DATE)
	private Date fechapublicacion;

	private String lugaredicion;

	private BigDecimal precio;

	//bi-directional many-to-one association to Editorial
	@ManyToOne
	@JoinColumn(name="IDEDITORIAL")
	private Editorial editorial;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="IDMATERIAL")
	private Material material;

	//bi-directional many-to-one association to Periodico
	@OneToMany(mappedBy="hemerografia")
	private List<Periodico> periodicos;

	//bi-directional many-to-one association to Revista
	@OneToMany(mappedBy="hemerografia")
	private List<Revista> revistas;

	public Hemerografia() {
	}

	public HemerografiaPK getId() {
		return this.id;
	}

	public void setId(HemerografiaPK id) {
		this.id = id;
	}

	public String getDescripcionhem() {
		return this.descripcionhem;
	}

	public void setDescripcionhem(String descripcionhem) {
		this.descripcionhem = descripcionhem;
	}

	public Date getFechapublicacion() {
		return this.fechapublicacion;
	}

	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public String getLugaredicion() {
		return this.lugaredicion;
	}

	public void setLugaredicion(String lugaredicion) {
		this.lugaredicion = lugaredicion;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Editorial getEditorial() {
		return this.editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public List<Periodico> getPeriodicos() {
		return this.periodicos;
	}

	public void setPeriodicos(List<Periodico> periodicos) {
		this.periodicos = periodicos;
	}

	public Periodico addPeriodico(Periodico periodico) {
		getPeriodicos().add(periodico);
		periodico.setHemerografia(this);

		return periodico;
	}

	public Periodico removePeriodico(Periodico periodico) {
		getPeriodicos().remove(periodico);
		periodico.setHemerografia(null);

		return periodico;
	}

	public List<Revista> getRevistas() {
		return this.revistas;
	}

	public void setRevistas(List<Revista> revistas) {
		this.revistas = revistas;
	}

	public Revista addRevista(Revista revista) {
		getRevistas().add(revista);
		revista.setHemerografia(this);

		return revista;
	}

	public Revista removeRevista(Revista revista) {
		getRevistas().remove(revista);
		revista.setHemerografia(null);

		return revista;
	}

}