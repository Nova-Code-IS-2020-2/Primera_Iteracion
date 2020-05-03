package com.deliexpress.beans;

public class Repartidor{
	
	private int id_repartidor;
	private String nombre, aPat, aMat, email, contr;
	
	public Repartidor() {}
	
	public Repartidor(String n, String aP, String aM, String email, String contr) {
		this.nombre = n;
		this.aPat = aP;
		this.aMat = aM;
		this.email = email;
		this.contr = contr;
	}

	public int getId_repartidor() {
		return id_repartidor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getaPat() {
		return aPat;
	}

	public void setaPat(String aPat) {
		this.aPat = aPat;
	}

	public String getaMat() {
		return aMat;
	}

	public void setaMat(String aMat) {
		this.aMat = aMat;
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
	
	
}