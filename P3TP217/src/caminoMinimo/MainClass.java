package caminoMinimo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		String s = "Buenos Aires";
		List<Vertice> v = new ArrayList<Vertice>();
		v.add(new Vertice("0", "Buenos Aires", 0.0, 3.0));
		v.add(new Vertice("0", "La Pampa", 1.0, 4.0));
		v.add(new Vertice("2", "2", 5.0, 17.0));
		v.add(new Vertice("3", "Tu vieja", 15.0, 18.0));
		v.add(new Vertice("4", "Cordoba", 15.0, 18.0));
		v.add(new Vertice("5", "Mendoza", 15.0, 18.0));
		v.add(new Vertice("6", "Salta", 15.0, 18.0));
		List<Arista> a = new ArrayList<Arista>();
		a.add(new Arista("0", v.get(0), v.get(1), 1, true));
		a.add(new Arista("1", v.get(0), v.get(2), 1, true));
		a.add(new Arista("2", v.get(1), v.get(3), 3, false));
		a.add(new Arista("3", v.get(1), v.get(4), 2, false));
		a.add(new Arista("3", v.get(2), v.get(4), 4, true));
		a.add(new Arista("3", v.get(3), v.get(5), 2, true));
		a.add(new Arista("3", v.get(4), v.get(6), 15, true));
		a.add(new Arista("3", v.get(5), v.get(6), 10, false));
		System.out.println(v.get(0).getNombre().equals(s));
		
		Grafo g = new Grafo(v, a);
		Dijkstra d = new Dijkstra(g,2);
		d.ejecutar(g.getVertices().get(0));
		LinkedList<Vertice> camino  = d.getCamino(v.get(6));

		for (Vertice vertex : camino) {
            System.out.println(vertex);
    }
		
	}
}
