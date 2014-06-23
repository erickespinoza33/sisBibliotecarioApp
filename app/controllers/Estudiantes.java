package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Bibliotecologo;
import models.Categoriamaterial;
import models.Editorial;
import models.Periodico;
import models.Rol;
import models.Usuario;
import models.Prestamista;
import models.Estudiante;
import models.Institucion;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;


public class Estudiantes extends Controller {
	
	public static void nuevoEstudiante(){
		List<Bibliotecologo> bibliotecologos = Bibliotecologo.findAll();
		List<Institucion> instituciones = Institucion.findAll();
		render(bibliotecologos, instituciones);
	}
	
	public static void listarEstudiante(){
		List<Estudiante> listEstudiantes = Estudiante.findAll();
		render(listEstudiantes);
	}
	
	public static void mostrarEstudiante(String id){
		Estudiante estudiante = Estudiante.find("IDESTUDIANTE", Long.parseLong(id)).first();
		List<Institucion> instituciones = Institucion.findAll();
		render(estudiante, instituciones);	
	}
	
	public static void eliminarEstudiante(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Estudiante estudiante = Estudiante.find("IDESTUDIANTE", Long.parseLong(id)).first();
		//Logger.log4j.info("Eliminar " + period.getId());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call eliminarEstudiante("+estudiante.getPrestamista().getUsuario().getIdUsuario()+", "+estudiante.getPrestamista().getCarnet()+",  "+estudiante.getIdestudiante()+")");
			Logger.log4j.info(prepareCall.execute());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		renderJSON("{\"success\":"
				+ true
				+ ", \"code\":"
				+ 500
				+ " ,\"message\":\" "
				+ "success: Periodico Eliminado .\""
				+ ", \"url\":\"/estudiante/listar\" }");
	}
	
	public static void guardarEstudiante(String nombres, String apellidos, String genero, String username, String password, int activado, String bibliotecologo, String movil, String fijo, String direccion, String correo, String documento, String fechasusc, int carnet, int infra, String carrera, String estIdUsuario,  int estCarnet, int estIdEstudiante){
			
		if(estIdUsuario == null) {
			Bibliotecologo bibliot = Bibliotecologo.find("IDBIBLIO", Long.parseLong(bibliotecologo)).first();
			Logger.log4j.info("New " + estIdUsuario);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call insertarEstudiante('"+nombres+"', '"+apellidos+"', '"+genero+"', '"+username+"', '"+password+"', "+activado+","+bibliot.getUsuario().getIdUsuario()+","+Integer.parseInt(bibliotecologo)+", '"+movil+"', '"+fijo+"', '"+direccion+"','"+correo+"', '"+documento+"', '"+fechasusc+"',"+carnet+", "+Integer.parseInt(bibliotecologo)+", "+infra+",'"+carrera+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else {
			Logger.log4j.info("New " + estIdUsuario);
			Logger.log4j.info("New " + estCarnet);
			Logger.log4j.info("New " + estIdEstudiante);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call modificarEstudiante("+Integer.parseInt(estIdUsuario)+", '"+nombres+"', '"+apellidos+"', '"+genero+"', '"+username+"', "+activado+", "+estCarnet+", '"+movil+"', '"+fijo+"', '"+direccion+"','"+correo+"', '"+documento+"',"+carnet+", "+estIdEstudiante+", "+infra+",'"+carrera+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
			
			redirect("/estudiante/listar");
		

	}
	
}
