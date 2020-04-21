package com.deliexpress.beans;

public class Cliente {
	private  int id_cliente;
	private String nombre;
	private String ap_pat;
	private String ap_mat;
	private String email;
	private String contr;
	private String telefono;
	private String direccion;
	
	public void setId(int id) {
		this.id_cliente=id;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setApPat(String apPat) {
		this.ap_pat=apPat;
	}
	
	public void setApMat(String apMat) {
		this.ap_mat=apMat;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setContraseña(String contraseña) {
		this.contr=contraseña;
	}
	
	public void setTelefono(String tel) {
		this.telefono=tel;
	}
	
	public void setDireccion(String dir) {
		this.direccion=dir;
	}
	
	public int getId() {
		return id_cliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApPat() {
		return ap_pat;
	}
	
	public String getApMat() {
		return ap_mat;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getContraseña() {
		return contr;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}

}
