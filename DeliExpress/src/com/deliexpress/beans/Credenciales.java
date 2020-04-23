package com.deliexpress.beans;

public class Credenciales {
	String contr; 
	String email;
	int tipoUsuario; 
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getContr() {
		return contr;
	}
	public void setContr(String contr) {
		this.contr = contr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Credenciales(String contr, String email) {
		super();
		this.contr = contr;
		this.email = email;
	}
	public Credenciales() {
		// TODO Auto-generated constructor stub
	} 
	
}
