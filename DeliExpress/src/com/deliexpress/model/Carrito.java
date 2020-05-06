package com.deliexpress.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Carrito {
	public float precio;
	public String nombre;	
	public int cantidad;
	public HashMap<Alimento,Integer> alimentos; 
	public Carrito() {alimentos = new HashMap<Alimento,Integer>();};
	public Carrito(float precio, String nombre, int cantidad) {
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public HashMap<Alimento,Integer> getAlimentos() {
		return alimentos;
	}
	public void agregarAlimento(Alimento a) {
<<<<<<< HEAD
		if(alimentos.containsKey(a)){
			int cant = alimentos.get(a);
			alimentos.replace(a,cant,cant++);
		}else {
			alimentos.put(a, 1);
		}
=======
		precio+= a.getPrecio(); 
		alimentos.put(a,1); 
>>>>>>> 1f2586cd3d9874569949231670b0bf0a5cd74823
	}
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String toString() {
		return "El carrito tiene: \n cantidad = " + this.getCantidad() + "\nNombre = " +this.getNombre() + "\nPrecio"+ this.getPrecio();
	} 
	
	
}
