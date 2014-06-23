package models;

public class UserInfo {
	private long id;
	private String nombres;
	private String apellidos;
	private String rol;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", rol=" + rol + "]";
	}
	
	public UserInfo(long id, String nombres, String apellidos, String rol) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rol = rol;
	}
	

}
