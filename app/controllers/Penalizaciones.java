package controllers;

import play.Logger;
import play.mvc.Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Estudiante;
import models.Externo;
import models.Prestamista;

public class Penalizaciones extends Controller{
	
	public static void nuevaPenalizacion(String carnet, String mora){
		Logger.log4j.info("New " + carnet);
		int check_carnet = Integer.parseInt(carnet);
		Estudiante estudiante = new Estudiante();
		Externo externo = new Externo();
		if(check_carnet >= 2000 && check_carnet < 3000){
			estudiante = Estudiante.find("CARNET", Long.parseLong(carnet)).first();
			render(estudiante, mora);
		}
		else{
			externo = Externo.find("CARNET", Long.parseLong(carnet)).first();
			render(externo, mora);
		}
		
	}
	
	public static void guardarPenalizacion(String mora, String idUEst, String carnetEst, String idEst, String idUExt, String carnetExt, String idExt, String tiempo, String descripcion){
		Logger.log4j.info("New " + idUEst);
		if(idUEst != null){
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call insertarPenalizacion("+mora+", " +idUEst+", "+carnetEst+", "+idEst+", null, null, null, '"+tiempo+"', '"+descripcion+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(idUExt != null){
			Logger.log4j.info("New " + idUExt);
			Logger.log4j.info("New " + carnetExt);
			Logger.log4j.info("New " + idExt);
			Connection conn = play.db.DB.getConnection();
			try {
				CallableStatement prepareCall = conn.prepareCall("call insertarPenalizacion("+mora+", null, null, null, "+idUExt+", "+carnetExt+", "+idExt+", '"+tiempo+"', '"+descripcion+"')");
				Logger.log4j.info(prepareCall.execute());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		redirect("/mora/listar");
		
	}
	
	
}
