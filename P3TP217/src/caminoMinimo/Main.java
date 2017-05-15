package caminoMinimo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
//		List<Vertice> v = new ArrayList<Vertice>();
//		v.add(new Vertice("0", "Buenos Aires", 0.0, 3.0));
//		v.add(new Vertice("1", "La Pampa", 1.0, 4.0));
//		v.add(new Vertice("2", "2", 5.0, 17.0));
//		v.add(new Vertice("3", "Tu vieja", 15.0, 18.0));
//		v.add(new Vertice("4", "Cordoba", 15.0, 18.0));
//		v.add(new Vertice("5", "Mendoza", 15.0, 18.0));
//		v.add(new Vertice("6", "Salta", 15.0, 18.0));
//		List<Arista> a = new ArrayList<Arista>();
//		a.add(new Arista("0", v.get(0), v.get(1), 1, true));
//		a.add(new Arista("1", v.get(0), v.get(2), 1, true));
//		a.add(new Arista("2", v.get(1), v.get(3), 3, false));
//		a.add(new Arista("4", v.get(1), v.get(4), 2, false));
//		a.add(new Arista("5", v.get(2), v.get(4), 4, true));
//		a.add(new Arista("6", v.get(3), v.get(5), 2, true));
//		a.add(new Arista("7", v.get(4), v.get(6), 15, true));
//		a.add(new Arista("8", v.get(5), v.get(6), 10, false));
//		System.out.println(v.get(0).getNombre().equals(s));
		
		List<Vertice> v = new ArrayList<Vertice>();
		List<Arista> a = new ArrayList<Arista>();
		v.add(new Vertice("0", "Buenos Aires", 0.0, 3.0));
		v.add(new Vertice("1", "La Pampa", 1.0, 4.0));
		v.add(new Vertice("2", "asd", 5.0, 17.0));
		a.add(new Arista("bsas pmp", v.get(0), v.get(1), 1, true));
		a.add(new Arista("bsas asd", v.get(0), v.get(2), 5, true));
		a.add(new Arista("pmp asd", v.get(1), v.get(2), 3, false));
		
		
		Grafo g = new Grafo(v, a);
		Dijkstra d = new Dijkstra(g,1);
		d.ejecutar(g.getVertices().get(0));
		LinkedList<Vertice> camino  = d.getCamino(v.get(2));

		for (Vertice vertex : camino) {
            System.out.println(vertex);
    }	
	}
}
