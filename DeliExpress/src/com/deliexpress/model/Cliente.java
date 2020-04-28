package com.deliexpress.model;

public class Cliente extends Cuenta{

	private  int id_cliente;
	private String nombre;
	private String ap_pat;
	private String ap_mat;
	private String email;
	private String contr;
	private String telefono;
	private String direccion;
	
	public Cliente() {}
	
	public Cliente(int id_cliente, String nombre, String ap_pat, String ap_mat, String email, String contr, String telefono, String direccion) {
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.ap_pat = ap_pat;
		this.ap_mat = ap_mat;
		this.email = email;
		this.contr = contr;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
}
