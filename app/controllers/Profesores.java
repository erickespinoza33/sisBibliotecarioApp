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
import models.Profesor;
import models.Institucion;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

public class Profesores extends Controller {
	
	public static void listarProfesor(){
		List<Profesor> listProfesor = Profesor.findAll();
		render(listProfesor);
	}
	
	public static void nuevoProfesor(){
		List<Bibliotecologo> bibliotecologos = Bibliotecologo.findAll();
		List<Institucion> instituciones = Institucion.findAll();
		render(bibliotecologos, instituciones);
	}
	
	public static void guardarProfesor(String nombresP, String apellidosP, String generoP, String username, String password, String bibliotecologo, String telmovilP, String telfijoP, String direccionP, String correoP, String documentoP, String fechasusc, int carnet, int infra, String exTel, String profIdUsuario,  int profCarnet, int profIdProfesor){
		
		if(profIdUsuario == null) {
			Bibliotecologo bibliot = Bibliotecologo.find("IDBIBLIO", Long.parseLong(bibliotecologo)).first();
			Logger.log4j.info("New " + profIdUsuario);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call insertarProfesor('"+nombresP+"', '"+apellidosP+"', '"+generoP+"', '"+username+"', '"+password+"',"+bibliot.getUsuario().getIdUsuario()+","+Integer.parseInt(bibliotecologo)+", '"+telmovilP+"', '"+telfijoP+"', '"+direccionP+"','"+correoP+"', '"+documentoP+"', '"+fechasusc+"',"+carnet+", "+Integer.parseInt(bibliotecologo)+", "+infra+",'"+exTel+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else {
			Logger.log4j.info("New " + profIdUsuario);
			Logger.log4j.info("New " + profCarnet);
			Logger.log4j.info("New " + profIdProfesor);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call modificarProfesor("+Integer.parseInt(profIdUsuario)+", '"+nombresP+"', '"+apellidosP+"', '"+generoP+"', '"+username+"', "+profCarnet+", '"+telmovilP+"', '"+telfijoP+"', '"+direccionP+"','"+correoP+"', '"+documentoP+"', "+carnet+", "+profIdProfesor+", "+infra+",'"+exTel+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
			
			redirect("/profesor/listar");
	}
	
	public static void mostrarProfesor(String id){
		Profesor profesor = Profesor.find("IDPROFESOR", Long.parseLong(id)).first();
		List<Institucion> instituciones = Institucion.findAll();
		render(profesor, instituciones);	
	}
	
	public static void eliminarProfesor(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Profesor profesor = Profesor.find("IDPROFESOR", Long.parseLong(id)).first();
		//Logger.log4j.info("Eliminar " + period.getId());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call eliminarProfesor("+profesor.getPrestamista().getUsuario().getIdUsuario()+", "+profesor.getPrestamista().getCarnet()+",  "+profesor.getIdprofesor()+")");
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
				+ "success: Profesor Eliminado .\""
				+ ", \"url\":\"/profesor/listar\" }");
	}
	

}
