package com.deliexpress.beans;

public class Alimento {
	int idAlimento; 
	String direcFoto;
	String desc; 
	String nombreAlim;
	public int getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}
	public String getDirecFoto() {
		return direcFoto;
	}
	public void setDirecFoto(String direcFoto) {
		this.direcFoto = direcFoto;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getNombreAlim() {
		return nombreAlim;
	}
	public void setNombreAlim(String nombreAlim) {
		this.nombreAlim = nombreAlim;
	}
	public Alimento(int idAlimento, String direcFoto, String desc, String nombreAlim) {
		super();
		this.idAlimento = idAlimento;
		this.direcFoto = direcFoto;
		this.desc = desc;
		this.nombreAlim = nombreAlim;
	}
	public Alimento() {
		// TODO Auto-generated constructor stub
	}
	
	
}
