package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import models.Artista;
import models.Categoriamaterial;
import models.Material;
import models.TrabajoGraduacion;
import models.Autor;
import play.Logger;
import play.db.jpa.JPABase;
import play.mvc.*;

import java.text.*;


public class TrabajosGraduacion extends Controller{
	
	public static void nuevoTG(){	
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		render(categorias);
	}	
	
	public static void guardarTG(String tgIdM, int tgIdTg, String tgCategM, String tgUbicaM, int tgExistM, String tgDescM, String tgTema, String tgFecha, String tgAsesor, int tgCD){
		if(tgIdM == null ){
			Logger.log4j.info("New " + tgIdM);
			Connection conn = play.db.DB.getConnection();
			try {				
				CallableStatement prepareCall = conn.prepareCall("call INSERTAR_TRABAJO_GRADUACION("+tgCategM+", '"+tgUbicaM+"',"+tgExistM+", '"+tgDescM+"', '"+tgTema+"', '"+tgFecha+"', '"+tgAsesor+"',"+tgCD+")");
				Logger.log4j.info(prepareCall.execute());	
				
				}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				}				
		}
		else{
			Logger.log4j.info("Update " + tgIdM);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call MODIFICAR_TRABAJO_GRAD("+Integer.parseInt(tgIdM)+", "+tgCategM+", '"+tgUbicaM+"', "+tgExistM+", '"+tgDescM+"',"+tgIdTg+", '"+tgTema+"', '"+tgFecha+"', '"+tgAsesor+"',"+tgCD+")");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}			
		}
		redirect("/material/tg/listar");	

	}
	
	public static void listarTG(){
		List<TrabajoGraduacion> listTGs = TrabajoGraduacion.findAll();
		render(listTGs);
	}
	
	public static void mostrarTG(String id){
		TrabajoGraduacion tg = TrabajoGraduacion.find("IDTG", Long.parseLong(id)).first();	
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		String fecha2 = fecha.format(tg.getFechaarchivado());	
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		Logger.log4j.info(tg.getTema());
		render(tg, categorias, fecha2);	
	}
	
	public static void eliminarTG(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		TrabajoGraduacion tg = TrabajoGraduacion.find("IDTG", Long.parseLong(id)).first();		
		Logger.log4j.info("Eliminar " + tg.getIdtg());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call ELIMINAR_TRABAJO_GRAD("+tg.getMaterial().getIdmaterial()+", "+tg.getIdtg()+")");
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
				+ "success: Trabajo de graduacion eliminado .\""
				+ ", \"url\":\"/material/tg/listar\" }");
	}
	
	public static void agregarAutorTG(String id)
	{
		TrabajoGraduacion tg = TrabajoGraduacion.find("IDTG", Long.parseLong(id)).first();	
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		Logger.log4j.info(tg.getTema());
		render(tg, categorias);
	}
	
	public static void guardarAutor(String tgIdM, int tgIdTg, String nomAutorTG, String apeAutorTG, String direcAutorTG, String telAutorTG){
		Logger.log4j.info("Update " + tgIdM);
		Connection conn = play.db.DB.getConnection();
		try {				
			CallableStatement prepareCall = conn.prepareCall("call INSERTAR_AUTOR_TG("+Integer.parseInt(tgIdM)+", "+tgIdTg+", '"+nomAutorTG+"', '"+apeAutorTG+"', '"+telAutorTG+"', '"+direcAutorTG+"')");
			Logger.log4j.info(prepareCall.execute());
			System.out.println("Se registra el autor");
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se registra el autor");
			System.out.println("INSERTAR_AUTOR_TG("+Integer.parseInt(tgIdM)+", "+tgIdTg+", '"+nomAutorTG+"', '"+apeAutorTG+"', '"+telAutorTG+"', '"+direcAutorTG+"')");
		}
		
		
		redirect("/material/tg/listar");
				
	}
	
	public static void listarAutor(String id){		
		TrabajoGraduacion listTG= TrabajoGraduacion.findById(Long.parseLong(id));
		List lista = listTG.getAutors();
		render(lista);
	}

}
