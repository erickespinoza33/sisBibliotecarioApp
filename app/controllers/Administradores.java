package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.mvc.Controller;
import play.mvc.With;
import models.Administrador;

@With(Secure.class)
@CRUD.For(Administrador.class)
public class Administradores extends Controller {
	
	public static void save(Administrador admin){

	}
	

}
