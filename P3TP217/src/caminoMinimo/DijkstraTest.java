package caminoMinimo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class DijkstraTest {

	List<Vertice> vertices = new ArrayList<Vertice>();
	List<Arista> aristas = new ArrayList<Arista>();
	Grafo grafo = new Grafo(vertices, aristas);
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void instanciaVaciaTest() {
		Dijkstra d = new Dijkstra(grafo, 1);
		d.ejecutar(grafo.getVertices().get(0));
		d.getCamino(vertices.get(3));
	}
	
	@Test
	public void instanciaTest() {
		vertices.add(new Vertice("0", "Buenos Aires", 0.0, 3.0));
		vertices.add(new Vertice("1", "La Pampa", 1.0, 4.0));
		vertices.add(new Vertice("2", "Cordoba", 5.0, 17.0));
		vertices.add(new Vertice("3", "Santa Cruz", 4.0, 15.0));
		aristas.add(new Arista("Buenos Aires La Pampa", vertices.get(0), vertices.get(1), 1, true));
		aristas.add(new Arista("Buenos Aires Cordoba", vertices.get(0), vertices.get(2), 5, true));
		aristas.add(new Arista("La Pampa Cordoba", vertices.get(1), vertices.get(2), 3, false));
		aristas.add(new Arista("Buenos Aires Santa Cruz", vertices.get(0), vertices.get(3),1,false));
		
		Dijkstra d = new Dijkstra(grafo, 1);
		d.ejecutar(grafo.getVertices().get(0));
		LinkedList<Vertice> camino = d.getCamino(vertices.get(3));

		assertEquals(2, camino.size());
	}

}
