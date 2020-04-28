package com.deliexpress.model;

public class Repartidor extends Cuenta {
	public int id_repartidor;
	public Repartidor() {}
	public Repartidor(int id_repartidor, String nombre, String ap_pat, String ap_mat, String email, String contr, int telefono, String direccion) {
		this.id_repartidor = id_repartidor;
		this.nombre = nombre;
		this.ap_pat = ap_pat;
		this.ap_mat = ap_mat;
		this.email = email;
		this.contr = contr;
	}

	public int getId_repartidor() {
		return id_repartidor;
	}

	public void setId_repartidor(int id_repartidor) {
		this.id_repartidor = id_repartidor;
	}
}
