package controllers;

import play.mvc.With;
import models.Bibliotecologo;

@With(Secure.class)
@CRUD.For(Bibliotecologo.class)
public class Bibliotecologos extends CRUD{

}
