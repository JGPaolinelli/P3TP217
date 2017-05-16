package caminoMinimo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		List<Vertice> v = new ArrayList<Vertice>();
		List<Arista> a = new ArrayList<Arista>();
		v.add(new Vertice("0", "Buenos Aires", 0.0, 3.0));
		v.add(new Vertice("1", "La Pampa", 1.0, 4.0));
		v.add(new Vertice("2", "Cordoba", 5.0, 17.0));
		v.add(new Vertice("3", "Santa Cruz", 4.0, 15.0));
		a.add(new Arista("Buenos Aires La Pampa", v.get(0), v.get(1), 1, true));
		a.add(new Arista("Buenos Aires Cordoba", v.get(0), v.get(2), 5, true));
		a.add(new Arista("La Pampa Cordoba", v.get(1), v.get(2), 3, false));
		a.add(new Arista("Buenos Aires Santa Cruz", v.get(0), v.get(3),1,false));

		Grafo g = new Grafo(v, a);
		Dijkstra d = new Dijkstra(g, 1);
		d.ejecutar(g.getVertices().get(0));
		LinkedList<Vertice> camino = d.getCamino(v.get(3));
		
		System.out.println(camino.toString());
	}
}
