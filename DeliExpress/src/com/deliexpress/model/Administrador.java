package com.deliexpress.model;

public class Administrador extends Cuenta {
public int id_admin;
	
	public Administrador() {}
	public Administrador(int id_repartidor, String nombre, String ap_pat, String ap_mat, String email, String contr, int telefono, String direccion) {
		this.id_admin = id_repartidor;
		this.nombre = nombre;
		this.ap_pat = ap_pat;
		this.ap_mat = ap_mat;
		this.email = email;
		this.contr = contr;
	}

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
}
