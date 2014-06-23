package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Categoriamaterial;
import models.Editorial;
import models.Periodico;
import play.mvc.*;
import play.Logger;
import play.db.jpa.JPABase;


public class Periodicos extends Controller {
	
	public static void nuevoPeriodico(){
		List<Editorial> editorial = Editorial.findAll();
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		render(editorial, categorias);
	}
	
	public static void listarPeriodico(){
		List<Periodico> listPeriodicos = Periodico.findAll();
		render(listPeriodicos);
	}
	
	public static void mostrarPeriodico(String id){
		Periodico period = Periodico.find("IDPERIODICO", Long.parseLong(id)).first();
		List<Editorial> editorial = Editorial.findAll();
		List<Categoriamaterial> categorias = Categoriamaterial.findAll();
		Logger.log4j.info(period.getEmpresa());
		render(period, editorial, categorias);	
	}
	
	public static void eliminarPeriodico(String id){
		Logger.log4j.info("ID a Eliminar "+id);
		Periodico period = Periodico.find("IDPERIODICO", Long.parseLong(id)).first();
		//Logger.log4j.info("Eliminar " + period.getId());
		Connection conn = play.db.DB.getConnection();
		try {
			CallableStatement prepareCall = conn.prepareCall("call eliminarPeriodico("+period.getHemerografia().getMaterial().getIdmaterial()+", "+period.getHemerografia().getCodigohem()+",  "+period.getIdperiodico()+")");
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
				+ ", \"url\":\"/material/periodico/listar\" }");
	}
	
	public static void guardarPeriodico(String perCatMat, String perUbic, int perExist, String perDescM, String perEdit, String perFechaP, float perPrec, String perLugar, String perDescH, String perEmpr, String perTitu, String perIdMat, int perCodHem, int perIdPer){
		
		if(perIdMat == null ){
			Logger.log4j.info("New " + perIdMat);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call insertarPeriodico("+perCatMat+", '"+perUbic+"', "+perExist+", '"+perDescM+"', "+perEdit+",'"+perFechaP+"', "+perPrec+", '"+perLugar+"', '"+perDescH+"', '"+perEmpr+"', '"+perTitu+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Logger.log4j.info("Update " + perIdMat);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call modificarPeriodico("+Integer.parseInt(perIdMat)+", "+perCatMat+", '"+perUbic+"', "+perExist+", '"+perDescM+"', "+perCodHem+","+perEdit+",'"+perFechaP+"', "+perPrec+", '"+perLugar+"', '"+perDescH+"',"+perIdPer+", '"+perEmpr+"', '"+perTitu+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		redirect("/material/periodico/listar");

	}
	

}
