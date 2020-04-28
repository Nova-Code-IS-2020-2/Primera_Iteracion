package com.deliexpress.model;

public class Categoria {
	
	public int id_cat;
	public String nombre_cat;
	
	public Categoria() {
	}
	
	public Categoria(String nombre_cat) {
		this.nombre_cat=nombre_cat;
	}
	
	public int getId() {
		return this.id_cat;
	}
	
	public void setId(int id_cat) {
		this.id_cat=id_cat;
	}
	
	public String getNombre(){
		return this.nombre_cat;
	}
	
	public void setNombre(String nombre){
		this.nombre_cat=nombre;
	}
}