package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import models.Bibliotecologo;
import models.Prestamista;
import models.ResultadoBusqueda;
import models.Categoriamaterial;
import models.Editorial;
import models.Material;
import models.MedioDigital;
import models.Prestamo;
import models.Revista;
import models.Tipoprestamo;
import models.Usuario;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

public class Prestamos extends Controller {
	final static Gson gson = new Gson();
	public static void nuevoPrestamo(){
		List<Categoriamaterial> listaTipoMateial = Categoriamaterial.findAll();
		List<Tipoprestamo> listaTipoPrestamo = Tipoprestamo.findAll();
		render(listaTipoMateial, listaTipoPrestamo);
	}

	public static void guardarPrestamo(int revEdicion,String revTitulo,String revDescH, String revLugarEd, double revPrecio, String revFechaPub, String revEditorial, String revDescM, int revExistM, String revUbicaM, String revCategM, int revId, int revIdCodigo, String revIdM){
		if(revIdM == null ){
			Logger.log4j.info("New " + revIdM);
			Connection conn = play.db.DB.getConnection();
			try { 	
				CallableStatement prepareCall = conn.prepareCall("call INSERTARREVISTA("+revCategM+", '"+revUbicaM+"', "+revExistM+", '"+revDescM+"', "+revEditorial+",'"+revFechaPub+"', "+revPrecio+", '"+revLugarEd+"','"+revDescH+"','"+revTitulo+"','"+revEdicion+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Logger.log4j.info("Update " + revIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				
				CallableStatement prepareCall = conn.prepareCall("call modificarRevista("+Integer.parseInt(revIdM)+","+revCategM+",'"+revUbicaM+"', "+revExistM+", '"+revDescM+"',"+revIdCodigo+", "+revEditorial+",'"+revFechaPub+"', "+revPrecio+", '"+revLugarEd+"','"+revDescH+"',"+revId+",'"+revTitulo+"','"+revEdicion+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		redirect("/prestamo/listar");

	}
	
	public static void mostrarPrestamo(String id){
		Prestamo prestamo = Prestamo.find("IDPRESTAMO", Long.parseLong(id)).first();
		List<Bibliotecologo> litsBiblio = Bibliotecologo.findAll();
		List<Prestamista> litsPresta = Prestamista.findAll();

		List<Categoriamaterial> listaTipoMateial = Categoriamaterial.findAll();
		List<Tipoprestamo> listaTipoPrestamo = Tipoprestamo.findAll();
		render(prestamo, litsBiblio, litsPresta, listaTipoMateial, listaTipoPrestamo);	
	}
	
	
	public static void eliminarPrestamo(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Prestamo prestamo = Prestamo.find("IDPRESTAMO", Long.parseLong(id)).first();
		
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call ");
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
				+ "success: Prestamo Eliminado .\""
				+ ", \"url\":\"/material/revista/listar\" }");
	}
	
	public static void listarPrestamo(){
		List<Prestamo> listPrestamo = Prestamo.findAll();
		Logger.log4j.info(listPrestamo.size());
		render(listPrestamo);
	}
	
	public static void buscarBibliotecologo(String q){
		Logger.log4j.info(q);
		List<Usuario> listarUser = Usuario.find("byApellidosLike", "%"+q+"%").fetch();
		List<ResultadoBusqueda> result = new ArrayList<ResultadoBusqueda>();;
		for (int i = 0; i < listarUser.size(); i++) {
			Usuario usuario = listarUser.get(i);
			Logger.log4j.info(i);
			if(usuario.getRol().getIdrol() != 2){
				Logger.log4j.info(usuario.getNombres()+" "+usuario.getIdUsuario());
				ResultadoBusqueda itemResult = new ResultadoBusqueda(usuario.getIdUsuario(), usuario.getNombres(), usuario.getApellidos());
				Logger.log4j.info(itemResult);
				result.add(itemResult);
			}
			/*
			if(usuario.getRol().getIdrol() != 2){
				listarUser.remove(i);
				i = 0;
			}*/

			
		}
		renderJSON( gson.toJson(result));
	}
	
	
}
