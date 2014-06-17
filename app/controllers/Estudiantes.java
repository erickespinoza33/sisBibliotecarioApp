package controllers;

import play.mvc.With;
import models.Estudiante;

@With(Secure.class)
@CRUD.For(Estudiante.class)
public class Estudiantes extends CRUD {

}
