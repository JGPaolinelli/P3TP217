package caminoMinimo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List<Vertice> v = new ArrayList<Vertice>();
		v.add(new Vertice("0", "0", 0.0, 3.0));
		v.add(new Vertice("1", "1", 1.0, 4.0));
		v.add(new Vertice("2", "2", 5.0, 17.0));
		List<Arista> a = new ArrayList<Arista>();
		a.add(new Arista("0", v.get(0), v.get(1), 3, false));
		a.add(new Arista("1", v.get(0), v.get(2), 5, true));
		a.add(new Arista("2", v.get(1), v.get(2), 1, false));
		Grafo g = new Grafo(v, a);
		Dijkstra d = new Dijkstra(g,1);
		d.ejecutar(g.getVertices().get(0));
		LinkedList<Vertice> camino  = d.getCamino(v.get(2));

		for (Vertice vertex : camino) {
            System.out.println(vertex);
    }
		
	}
}
