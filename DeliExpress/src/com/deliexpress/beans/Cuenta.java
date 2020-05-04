package com.deliexpress.beans;

public class Cuenta {
	
	private int id_cliente;
	private String nombre;
	private String ap_pat;
	private String ap_mat;
	private String email;
	//password=contr
	private String contr;
	private String telefono;
	private String direccion;

	public Cuenta(){
		
	}
	public Cuenta(int id_cliente, String nombre, String ap_pat, String ap_mat, String email, String contr, String telefono, String direccion) {
		
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.ap_pat = ap_pat;
		this.ap_mat = ap_mat;
		this.email = email;
		this.contr = contr;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	//getters y setters
	public int getId() {
		return id_cliente;
	}
	public void setId(int id) {
		this.id_cliente = id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getAp_pat() {
		return ap_pat;
	}
	public String getAp_mat() {
		return ap_mat;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAp_pat(String x) {
		this.ap_pat = x;
	}
	public void setAp_mat(String x) {
		this.ap_mat = x;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String x) {
		this.email = x;
	}
	public String getContr() {
		return contr;
	}
	public void setContr(String x) {
		this.contr = x;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String x) {
		this.telefono = x;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String x) {
		this.direccion = x;
	}
}