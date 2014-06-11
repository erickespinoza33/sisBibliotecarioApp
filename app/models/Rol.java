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

/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@Table(name="ROL")
public class Rol extends GenericModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDROL")
	private long idrol;

	@Column(name="ROL")
	private String rol;

	//bi-directional many-to-many association to Funcion
	@ManyToMany
	@JoinTable(
		name="ROLES_FUNCIONES"
		, joinColumns={
			@JoinColumn(name="IDROL")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDFUNCION")
			}
		)
	private List<Funcion> funcions;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public long getIdrol() {
		return this.idrol;
	}

	public void setIdrol(long idrol) {
		this.idrol = idrol;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Funcion> getFuncions() {
		return this.funcions;
	}

	public void setFuncions(List<Funcion> funcions) {
		this.funcions = funcions;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

}