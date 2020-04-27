package com.deliexpress.model;

public abstract class Cuenta {
	public String nombre;
	public String ap_pat;
	public String ap_mat;
	public String email;
	public String contr;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp_pat() {
		return ap_pat;
	}
	public void setAp_pat(String ap_pat) {
		this.ap_pat = ap_pat;
	}
	public String getAp_mat() {
		return ap_mat;
	}
	public void setAp_mat(String ap_mat) {
		this.ap_mat = ap_mat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContr() {
		return contr;
	}
	public void setContr(String contr) {
		this.contr = contr;
	}
	
	public String toString() {
		return "nombre " + nombre +" Email: " + email;
	}
	
}
