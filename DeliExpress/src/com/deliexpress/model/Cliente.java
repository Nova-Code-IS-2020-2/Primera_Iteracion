package com.deliexpress.model;

public class Cliente extends Cuenta{

	public int id_cliente;
	public String direccion;
	public int telefono;
	
	public Cliente() {}
	
	public Cliente(int id_cliente, String nombre, String ap_pat, String ap_mat, String email, String contr, int telefono, String direccion) {
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
