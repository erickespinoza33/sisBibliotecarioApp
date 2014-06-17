package controllers;

import play.mvc.With;
import models.Autor;

@With(Secure.class)
@CRUD.For(Autor.class)
public class Autores extends CRUD{

}
