package com.deliexpress.beans;

public class Categoria {
	
	private int id_cat;
	private String nombre_cat;
	
	public int getId() {
		return id_cat;
	}
	
	public void setId(int id) {
		id_cat=id;
	}
	
	public String getName(){
		return nombre_cat;
	}
	
	public void setName(String nombre){
		nombre_cat=nombre;
	}
}
