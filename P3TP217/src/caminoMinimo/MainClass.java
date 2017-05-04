package caminoMinimo;

import java.util.ArrayList;
import java.util.HashSet;

public class MainClass {

	public static void main(String[] args) {
//		Instancia ins = new Instancia(5);
//		ins.agregarCiudad("asd", 0.1, 0.2);
//		System.out.println(ins.get_ciudades().get("asd"));
//		ins.agregarCiudad("qwe", 0.5, 0.15);
//		System.out.println(ins.get_ciudades().get("qwe"));
//		ins.agregarRuta("asd", "qwe", 500.0, false);
//		System.out.println(ins.get_ciudades().get("asd"));
//		System.out.println(ins.get_ciudades().get("qwe"));
		
//		Solver solver = new Solver(2);
//		solver.resuelve(0);
		
		
		  final WeightedGraph GRAFO = new WeightedGraph (4);
		         GRAFO.setLabel (0, "v0",true);
		         GRAFO.setLabel (1, "v1",true);
		         GRAFO.setLabel (2, "v2",false);
		         GRAFO.setLabel (3, "v3", true);
		         GRAFO.addEdge(0, 1, 1);
		         GRAFO.addEdge(0, 2, 5);
		         GRAFO.addEdge(0, 3, 8);
		         GRAFO.addEdge(1, 2, 3);
		         GRAFO.addEdge(2, 3, 1);
//		         t.addEdge(1, 0, 1);
//		         t.addEdge(2, 0, 5);
//		         GRAFO.print();
//		   
		         final int [] pred = dijkstra.dijkstra (GRAFO, 0,2);
		         for (int n=0; n<4; n++) {
		            dijkstra.printPath (GRAFO, pred, 0, n);
		         }
		         for (int i = 0; i < pred.length; i++) {
					System.out.println(pred[i]);
				}
		
//		ArrayList<HashSet<String>> a = new ArrayList<HashSet<String>>();
//		a.add(new HashSet<String>());
//		a.get(0).add("asd");
//		System.out.println(a.get(0));
		
		
	}

}
