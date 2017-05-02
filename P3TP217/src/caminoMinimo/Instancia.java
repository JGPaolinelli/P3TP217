package caminoMinimo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Instancia {
	
	private HashMap<String,HashSet<Double>> _adj;
	private Double latitud, logitud;
	
	public Instancia() {
		_adj = new HashMap<>();
	}
	
	public void agregarCiudad (String nombre, Double latitud, Double longitud){
		HashSet<Double> a= new HashSet<Double>();
		a.add(latitud);
		a.add(longitud);
		_adj.put(nombre, a);
	}
	
	public static void main(String[] args) {
		Instancia ins = new Instancia();
		ins.agregarCiudad("asd", 0.1, 0.2);
		System.out.println(ins._adj.get("asd"));
		ins.agregarCiudad("qwe", 0.2, 0.5);
		System.out.println(ins._adj.get("qwe").add(0.4165));
		System.out.println(ins._adj.get("qwe"));
	}

}
