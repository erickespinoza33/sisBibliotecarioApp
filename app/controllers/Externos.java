package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import models.Bibliotecologo;
import models.Categoriamaterial;
import models.Editorial;
import models.Externo;
import models.Periodico;
import models.Rol;
import models.UserInfo;
import models.Usuario;
import models.Prestamista;
import models.Institucion;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;


public class Externos extends Controller {
	
	public static void nuevoExterno(){
		List<Bibliotecologo> bibliotecologos = Bibliotecologo.findAll();
		List<Institucion> instituciones = Institucion.findAll();
		render(bibliotecologos, instituciones);
	}
	
	public static void listarExterno(){
		List<Externo> Externos = Externo.findAll();
		render(Externos);
	}
	
	public static void mostrarExterno(String id){
		Externo externo = Externo.find("IDEXTERNO", Long.parseLong(id)).first();
		List<Institucion> instituciones = Institucion.findAll();
		render(externo, instituciones);	
	}
	
	public static void mostrarExternoPorId(){
		Gson gson = new Gson();
		String userJSON = session.get("userInfo");
		UserInfo user = gson.fromJson(userJSON, UserInfo.class);
		Logger.log4j.info("---------------" + user);
		Externo externo = Externo.find("ID_USUARIO", user.getId()).first();
		List<Institucion> instituciones = Institucion.findAll();
		renderTemplate("Externos/mostrarExterno.html",externo, instituciones);	
	}
	
	public static void eliminarExterno(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Externo externo = Externo.find("IDEXTERNO", Long.parseLong(id)).first();
		//Logger.log4j.info("Eliminar " + period.getId());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call eliminarExterno("+externo.getPrestamista().getUsuario().getIdUsuario()+", "+externo.getPrestamista().getCarnet()+",  "+externo.getIdexterno()+")");
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
				+ ", \"url\":\"/externo/listar\" }");
	}
	
	public static void guardarExterno(String nombres, String apellidos, String genero, String username, String password, int activado, String bibliotecologo, String movil, String fijo, String direccion, String correo, String documento, String fechasusc, int carnet, String profesion, String trabajo, String extIdUsuario,  int extCarnet, int extIdExterno){
			
		if(extIdUsuario == null) {
			Bibliotecologo bibliot = Bibliotecologo.find("IDBIBLIO", Long.parseLong(bibliotecologo)).first();
			Logger.log4j.info("New " + extIdUsuario);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call insertarExterno('"+nombres+"', '"+apellidos+"', '"+genero+"', '"+username+"', '"+password+"', "+activado+","+bibliot.getUsuario().getIdUsuario()+","+Integer.parseInt(bibliotecologo)+", '"+movil+"', '"+fijo+"', '"+direccion+"','"+correo+"', '"+documento+"', '"+fechasusc+"',"+carnet+", "+Integer.parseInt(bibliotecologo)+", '"+profesion+"','"+trabajo+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else {
			Logger.log4j.info("New " + extIdUsuario);
			Logger.log4j.info("New " + extCarnet);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call modificarexterno("+Integer.parseInt(extIdUsuario)+", '"+nombres+"', '"+apellidos+"', '"+genero+"', '"+username+"', "+activado+", "+extCarnet+", '"+movil+"', '"+fijo+"', '"+direccion+"','"+correo+"', '"+documento+"',"+carnet+", "+extIdExterno+", '"+profesion+"' ,'"+trabajo+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		Gson gson = new Gson();
		String userJSON = session.get("userInfo");
		UserInfo user = gson.fromJson(userJSON, UserInfo.class);
		if(user.getRol().equals("Prestamista")){
			redirect("/index");			
		}
			
		redirect("/externo/listar");
		

	}
	
}
