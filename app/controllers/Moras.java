package controllers;

import java.sql.*;
import java.util.List;

import models.Mora;
import play.Logger;
import play.mvc.Controller;

public class Moras extends Controller {
	
	public static void mostrarMoras(String id){
		Mora mora = Mora.find("IDMORA", Long.parseLong(id)).first();
		render(mora);
	}
	
	public static void listarMoras(){
		List<Mora> moras = Mora.findAll();
		render(moras);
	}
	
}
