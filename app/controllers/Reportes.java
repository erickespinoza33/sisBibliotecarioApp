package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ReportLibroCategoria;
import models.Reporttg_por_nombre;
import play.Logger;
import play.mvc.Controller;

public class Reportes extends Controller {
	
	public static void getReportLibroCategoria(){
		
		Connection conn = play.db.DB.getConnection();
		List<ReportLibroCategoria> list =  new ArrayList<ReportLibroCategoria>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM LIBRO_CATEGORIA");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportLibroCategoria rlc = new ReportLibroCategoria(
						resultSet.getString("DESCRIPCIONCATEGORIA"),
						resultSet.getString("UBICACION"),
						resultSet.getString("EXISTENCIAS"),
						resultSet.getString("TITULO"),
						resultSet.getString("EDICION"),
						resultSet.getString("VOLUMEN"));
				if (rlc != null)
					list.add(rlc);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		render(list);
		
	}
	
	public static void getReporttg_por_nombre(){
		
		Connection conn = play.db.DB.getConnection();
		List<Reporttg_por_nombre> list =  new ArrayList<Reporttg_por_nombre>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM TG_POR_NOMBRE");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Reporttg_por_nombre rlc = new Reporttg_por_nombre(
						resultSet.getString("TEMA"),
						resultSet.getString("FECHAARCHIVADO"),
						resultSet.getString("ASESOR"),
						resultSet.getString("NOMBRESAUTOR"),
						resultSet.getString("APELLIDOSAUTOR"));
				if (rlc != null)
					list.add(rlc);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		render(list);
		
	}

}
