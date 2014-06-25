package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ReportLibroCategoria;
import models.ReportLibroExistencia;
import models.ReportPeriodicoFecha;
import models.ReportRevistaFecha;
import models.ReportTgNombre;
import models.ReportUsuarioMoraSolvente;
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
	
	public static void getReportTgNombre(){
		
		Connection conn = play.db.DB.getConnection();
		List<ReportTgNombre> list =  new ArrayList<ReportTgNombre>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM TG_POR_NOMBRE");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportTgNombre rlc = new ReportTgNombre(
						resultSet.getString("TEMA"),
						resultSet.getDate("FECHAARCHIVADO"),
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

	public static void getReportTgAsesor(){
		
		Connection conn = play.db.DB.getConnection();
		List<ReportTgNombre> list =  new ArrayList<ReportTgNombre>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM TG_POR_ASESOR");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportTgNombre rlc = new ReportTgNombre(
						resultSet.getString("TEMA"),
						resultSet.getDate("FECHAARCHIVADO"),
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
	
	public static void getReportRevistaFecha(){
		
		Connection conn = play.db.DB.getConnection();
		List<ReportRevistaFecha> list =  new ArrayList<ReportRevistaFecha>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM REVISTA_POR_FECHA");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportRevistaFecha rrf = new ReportRevistaFecha(
						resultSet.getString("CATEGORIAMATERIAL"),
						resultSet.getString("TITULOREVISTA"),
						resultSet.getString("EDICION"),
						resultSet.getString("NOMBREEDITORIAL"),
						resultSet.getDate("FECHAPUBLICACION"),
						resultSet.getString("UBICACION"),
						resultSet.getString("EXISTENCIAS"));
				if (rrf != null)
					list.add(rrf);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		render(list);
		
	}
	
	public static void getReportPeriodicoFecha(){
		
		Connection conn = play.db.DB.getConnection();
		List<ReportPeriodicoFecha> list =  new ArrayList<ReportPeriodicoFecha>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM PERIODICO_POR_FECHA");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportPeriodicoFecha rrf = new ReportPeriodicoFecha(
						resultSet.getString("CATEGORIAMATERIAL"),
						resultSet.getString("TITULAR"),
						resultSet.getString("EMPRESA"),
						resultSet.getString("NOMBREEDITORIAL"),
						resultSet.getDate("FECHAPUBLICACION"),
						resultSet.getString("UBICACION"),
						resultSet.getString("EXISTENCIAS"));
				if (rrf != null)
					list.add(rrf);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		render(list);
		
	}
	
	public static void getReportRevistaTitulo(){
		
		Connection conn = play.db.DB.getConnection();
		List<ReportRevistaFecha> list =  new ArrayList<ReportRevistaFecha>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM REVISTA_POR_TITULO");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportRevistaFecha rrf = new ReportRevistaFecha(
						resultSet.getString("CATEGORIAMATERIAL"),
						resultSet.getString("TITULOREVISTA"),
						resultSet.getString("EDICION"),
						resultSet.getString("NOMBREEDITORIAL"),
						resultSet.getDate("FECHAPUBLICACION"),
						resultSet.getString("UBICACION"),
						resultSet.getString("EXISTENCIAS"));
				if (rrf != null)
					list.add(rrf);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		render(list);
		
	}
	
	public static void getReportPeriodicoTitulo() {

		Connection conn = play.db.DB.getConnection();
		List<ReportPeriodicoFecha> list = new ArrayList<ReportPeriodicoFecha>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn
					.prepareStatement("SELECT * FROM PERIODICO_POR_TITULO");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportPeriodicoFecha rrf = new ReportPeriodicoFecha(
						resultSet.getString("CATEGORIAMATERIAL"),
						resultSet.getString("TITULAR"),
						resultSet.getString("EMPRESA"),
						resultSet.getString("NOMBREEDITORIAL"),
						resultSet.getDate("FECHAPUBLICACION"),
						resultSet.getString("UBICACION"),
						resultSet.getString("EXISTENCIAS"));
				if (rrf != null)
					list.add(rrf);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		render(list);

	}

	public static void getReportLibroExistencia() {

		Connection conn = play.db.DB.getConnection();
		List<ReportLibroExistencia> list = new ArrayList<ReportLibroExistencia>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn
					.prepareStatement("SELECT * FROM LIBROS_EXISTENCIA");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportLibroExistencia rrf = new ReportLibroExistencia(
						resultSet.getString("ID"),
						resultSet.getString("TITULOLIBRO"),
						resultSet.getString("EDICION"),
						resultSet.getString("NOMBREEDITORIAL"),
						resultSet.getString("TOTALLIBROS"),
						resultSet.getString("EJEMPLARES"),
						resultSet.getString("UBICACION"));
				if (rrf != null)
					list.add(rrf);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		render(list);

	}
	
	public static void getReportUsuarioMora() {

		Connection conn = play.db.DB.getConnection();
		List<ReportUsuarioMoraSolvente> list = new ArrayList<ReportUsuarioMoraSolvente>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn
					.prepareStatement("SELECT * FROM USUARIO_MORA");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportUsuarioMoraSolvente rrf = new ReportUsuarioMoraSolvente(
						resultSet.getString("NOMBRE"),
						resultSet.getString("CARNET"),
						resultSet.getString("TELEFONO"),
						resultSet.getString("CORREO"),
						resultSet.getString("MONTO"),
						resultSet.getDate("FECHAINICIO"),
						resultSet.getDate("FECHAFIN"));
				if (rrf != null)
					list.add(rrf);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		render(list);

	}
	
	public static void getReportUsuarioSolvente() {

		Connection conn = play.db.DB.getConnection();
		List<ReportUsuarioMoraSolvente> list = new ArrayList<ReportUsuarioMoraSolvente>();
		try {
			ResultSet resultSet = null;
			PreparedStatement statement = conn
					.prepareStatement("SELECT * FROM USUARIO_SOLVENTE");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ReportUsuarioMoraSolvente rrf = new ReportUsuarioMoraSolvente(
						resultSet.getString("NOMBRE"),
						resultSet.getString("CARNET"),
						resultSet.getString("TELEFONO"),
						resultSet.getString("CORREO"));
				if (rrf != null)
					list.add(rrf);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		render(list);

	}
}
