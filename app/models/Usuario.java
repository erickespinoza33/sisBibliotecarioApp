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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
public class Usuario extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private long idUsuario;
	
	@Column(name="ACTIVADO")
	private BigDecimal activado;

	@Column(name="APELLIDOS")
	private String apellidos;
	
	@Column(name="CONTRASENA")
	private String contrasena;

	@Column(name="FECHACREACION")
	private Date fechacreacion;
	
	@Column(name="GENERO")
	private String genero;
	
	@Column(name="NOMBRES")
	private String nombres;

	@Column(name="NOMBREUSUARIO")
	private String nombreusuario;
	
	@ManyToOne
	@JoinColumn(name="IDROL")
	private Rol rol;

	//bi-directional many-to-one association to Administrador
	@OneToMany(mappedBy="usuario")
	private List<Administrador> administradors;
	//bi-directional many-to-one association to Bibliotecologo
	@OneToMany(mappedBy="usuario")
	private List<Bibliotecologo> bibliotecologos;
	//bi-directional many-to-one association to Bitacora
	@OneToMany(mappedBy="usuario")
	private List<Bitacora> bitacoras;
	//bi-directional many-to-one association to Prestamista
	@OneToMany(mappedBy="usuario")
	private List<Prestamista> prestamistas;
	//bi-directional many-to-one association to Rol

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getActivado() {
		return this.activado;
	}

	public void setActivado(BigDecimal activado) {
		this.activado = activado;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombreusuario() {
		return this.nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public List<Administrador> getAdministradors() {
		return this.administradors;
	}

	public void setAdministradors(List<Administrador> administradors) {
		this.administradors = administradors;
	}

	public Administrador addAdministrador(Administrador administrador) {
		getAdministradors().add(administrador);
		administrador.setUsuario(this);

		return administrador;
	}

	public Administrador removeAdministrador(Administrador administrador) {
		getAdministradors().remove(administrador);
		administrador.setUsuario(null);

		return administrador;
	}

	public List<Bibliotecologo> getBibliotecologos() {
		return this.bibliotecologos;
	}

	public void setBibliotecologos(List<Bibliotecologo> bibliotecologos) {
		this.bibliotecologos = bibliotecologos;
	}

	public Bibliotecologo addBibliotecologo(Bibliotecologo bibliotecologo) {
		getBibliotecologos().add(bibliotecologo);
		bibliotecologo.setUsuario(this);

		return bibliotecologo;
	}

	public Bibliotecologo removeBibliotecologo(Bibliotecologo bibliotecologo) {
		getBibliotecologos().remove(bibliotecologo);
		bibliotecologo.setUsuario(null);

		return bibliotecologo;
	}

	public List<Bitacora> getBitacoras() {
		return this.bitacoras;
	}

	public void setBitacoras(List<Bitacora> bitacoras) {
		this.bitacoras = bitacoras;
	}

	public Bitacora addBitacora(Bitacora bitacora) {
		getBitacoras().add(bitacora);
		bitacora.setUsuario(this);

		return bitacora;
	}

	public Bitacora removeBitacora(Bitacora bitacora) {
		getBitacoras().remove(bitacora);
		bitacora.setUsuario(null);

		return bitacora;
	}

	public List<Prestamista> getPrestamistas() {
		return this.prestamistas;
	}

	public void setPrestamistas(List<Prestamista> prestamistas) {
		this.prestamistas = prestamistas;
	}


	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/*
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", activado=" + activado
				+ ", apellidos=" + apellidos + ", contrasena=" + contrasena
				+ ", fechacreacion=" + fechacreacion.toGMTString() + ", genero=" + genero
				+ ", nombres=" + nombres + ", nombreusuario=" + nombreusuario
				+ ", rol=" + rol + ", administradors=" + administradors
				+ ", bibliotecologos=" + bibliotecologos + ", bitacoras="
				+ bitacoras + ", prestamistas=" + prestamistas + "]";
	}
	*/
}