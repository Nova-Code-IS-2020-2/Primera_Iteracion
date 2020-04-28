package com.deliexpress.model;

public class Orden {
	
	private int idOrden;
	private int idRepartidor;
	private int idCliente;
	private float precio;
	
	public Orden(int idOrden, int idRepartidor, int idCliente, float precio) {
		this.idCliente = idCliente;
		this.idOrden = idOrden;
		this.idRepartidor = idRepartidor;
		this.precio = precio;
		
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public int getIdRepartidor() {
		return idRepartidor;
	}

	public void setIdRepartidor(int idRepartidor) {
		this.idRepartidor = idRepartidor;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
