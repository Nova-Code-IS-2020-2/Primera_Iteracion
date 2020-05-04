package com.deliexpress.model;

public class Alimento {
	private int id;
	private String foto;
	private String desc; 
	private String nombre;
	private float precio;
	
	public Alimento(int id, String foto, String desc, String nombre, float precio){
		this.id = id ;
		this.foto = foto;
		this.desc = desc;
		this.nombre = nombre;
		this.precio = precio;
	} 
	
	public Alimento() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
