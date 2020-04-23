package com.deliexpress.beans;

import java.util.List;

public class Orden {
	int idOrden; 
	double precio;
	int idRepartidor; 
	int idCliente;
	List<Integer[]> alimentos; 
	public Orden() {
		
	}
	
	public List<Integer[]> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Integer[]> alimentos) {
		this.alimentos = alimentos;
	}

	public Orden(int idOrden, double precio, int idRepartidor, int idCliente) {
		this.idOrden = idOrden;
		this.precio = precio;
		this.idRepartidor = idRepartidor;
		this.idCliente = idCliente;
	}

	public int getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
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
	
}
