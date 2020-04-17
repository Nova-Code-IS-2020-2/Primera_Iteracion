package com.deliexpress.model;

public class Carrito {
	private int cantidad;
	private int idAlimento;
	private int idOrden;
	
	public Carrito(int cantidad, int idAlimento, int idOrden) {
		this.cantidad = cantidad;
		this.idAlimento = idAlimento;
		this.idOrden = idOrden;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}
	
	
}
