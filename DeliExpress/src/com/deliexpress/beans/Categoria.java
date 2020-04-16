package com.deliexpress.beans;

public class Categoria {
	
	private int id_cat;
	private String nombre_cat;
	
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
		return nombre_cat;
	}
	
	public void setNombre(String nombre){
		nombre_cat=nombre;
	}
}
