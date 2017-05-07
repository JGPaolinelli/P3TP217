package planificarViaje;

public class MainClass {

public static void main(String[] args) {
		
		Solver solver = new Solver(grafo(), 1, 4, 0);
		System.out.println(solver.resolver().toString());
	}

	private static Grafo grafo() {

		Grafo grafo = new Grafo();
		
		grafo.agregarVertice(new Vertice("1", 1.0 , 1.0));
		grafo.agregarVertice(new Vertice("2", 2.0 , 2.0));
		grafo.agregarVertice(new Vertice("3", 3.0 , 3.0));
		grafo.agregarVertice(new Vertice("4", 4.0 , 4.0));
		grafo.agregarVertice(new Vertice("5", 5.0 , 5.0));
		grafo.agregarVertice(new Vertice("6", 6.0 , 6.0));
		
		grafo.agregarArista(new Arista(1, 2, 4, false));
		grafo.agregarArista(new Arista(1, 6, 3, false));
		grafo.agregarArista(new Arista(2, 6, -2, false));
		grafo.agregarArista(new Arista(2, 5, 2, false));
		grafo.agregarArista(new Arista(2, 3, 3, false));
		grafo.agregarArista(new Arista(3, 4, 1, false));
		grafo.agregarArista(new Arista(3, 5, 1, false));
		grafo.agregarArista(new Arista(5, 4, 4, false));
		grafo.agregarArista(new Arista(6, 5, 3, false));

		return grafo;
	}

}
