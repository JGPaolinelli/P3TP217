package caminoMinimo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.xml.soap.Node;

public class Instancia {
	
	private HashMap<String,HashSet<Double>> _ciudades;
	private HashMap<String,HashSet<Integer>> _rutas;
	
	public Instancia() {
		_ciudades = new HashMap<>();
		_rutas = new HashMap<String,HashSet<Integer>>();
	}
	
	public void agregarCiudad (String nombre, Double latitud, Double longitud){
		HashSet<Double> a= new HashSet<Double>();
		a.add(latitud);
		a.add(longitud);
		get_ciudades().put(nombre, a);
	}
	
	public void agregarRuta (String ciudad1, String ciudad2, Double longitud, boolean peaje){
		if (_ciudades.containsKey(ciudad1) && _ciudades.containsKey(ciudad2)){
		_ciudades.get(ciudad1).add(longitud);
		_ciudades.get(ciudad2).add(longitud);}
	}

	public HashMap<String,HashSet<Double>> get_ciudades() {
		return _ciudades;
	}
}
