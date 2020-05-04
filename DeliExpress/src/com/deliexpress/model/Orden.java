package com.deliexpress.model;

public class Orden {
	
	private int id_orden;
	private float precio;
	private int id_repartidor;
	private int id_cliente;
	
	public void setId(int id ){
		this.id_orden=id;
	}
	
	public void setPrecio(float precio) {
		this.precio=precio;
	}
	
	public void setRepartidor(int id_repartidor) {
		this.id_repartidor=id_repartidor;
	}
	
	public void setCliente(int id_cliente) {
		this.id_cliente=id_cliente;
	}
	
	public int getId() {
		return id_orden;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public int getRepartidor() {
		return id_repartidor;
	}
	
	public int getCliente() {
		return id_cliente;
	}

}

