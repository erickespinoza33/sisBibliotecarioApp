package controllers;

import play.*;
import play.mvc.*;
import play.mvc.results.RenderHtml;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;


import models.*;

public class Admin extends Controller {

	public static void index() {
		render();
	}
}