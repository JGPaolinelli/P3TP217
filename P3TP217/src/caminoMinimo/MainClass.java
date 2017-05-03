package caminoMinimo;

public class MainClass {

	public static void main(String[] args) {
		Instancia ins = new Instancia();
		ins.agregarCiudad("asd", 0.1, 0.2);
		System.out.println(ins.get_ciudades().get("asd"));
		ins.agregarCiudad("qwe", 0.5, 0.15);
		System.out.println(ins.get_ciudades().get("qwe"));
		ins.agregarRuta("asd", "qwe", 500.0, false);
		System.out.println(ins.get_ciudades().get("asd"));
		System.out.println(ins.get_ciudades().get("qwe"));
		
//		Solver solver = new Solver(2);
//		solver.resuelve(0);
		
		
		  final WeightedGraph t = new WeightedGraph (3);
		         t.setLabel (0, "v0");
		         t.setLabel (1, "v1");
		         t.setLabel (2, "v2");
		         t.addEdge(0, 1, 1);
		         t.addEdge(0, 2, 5);
		         t.addEdge(1, 2, 3);
		         t.addEdge(1, 0, 1);
		         t.addEdge(2, 0, 5);
		         t.print();
		   
		         final int [] pred = dijkstra.dijkstra (t, 0);
		         for (int n=0; n<3; n++) {
		            dijkstra.printPath (t, pred, 0, n);
		         }
		
	}

}
