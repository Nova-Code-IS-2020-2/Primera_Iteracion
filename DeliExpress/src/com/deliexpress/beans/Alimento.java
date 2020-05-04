package com.deliexpress.beans;

public class Alimento {
	
	private int id;
	private String nombre, descripcion, foto;
	private Float precio; 
	private int categoria;
	
	public Alimento() {
	}
	
	public Alimento(String nombre, String desc, String foto, Float precio, int categoria) {
		this.nombre = nombre;
		this.descripcion = desc;
		this.foto = foto;
		this.precio = precio; 
		this.categoria=categoria;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public String getDireccionFoto() {
		return this.foto;
	}
	public int getCategoria() {
		return this.categoria;
	}
	public Float getPrecio(){
		return this.precio;
	}
	
	public void  setId(int id) {
		this.id=id;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setDescripcion(String desc){
		this.descripcion=desc;
	}
	
	public void setDireccionFoto(String foto){
		this.foto=foto;
	}
	
	public void setPrecio(Float precio){
		this.precio=precio;
	}
	public void setCategoria(int categoria) {
		this.categoria=categoria;
	}
	
	public String guardarBD() {
	
		return ("Fracaso");
	}
}
