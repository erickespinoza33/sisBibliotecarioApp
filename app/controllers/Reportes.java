package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ReportLibroCategoria;
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

}
