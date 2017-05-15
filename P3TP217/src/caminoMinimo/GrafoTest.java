package caminoMinimo;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GrafoTest {
	
	List<Vertice> vertices = new ArrayList<Vertice>();
	List<Arista> aristas = new ArrayList<Arista>();
	Grafo grafo = new Grafo(vertices, aristas);
	
	@Test
	public void grafoVacioTest() {
		assertEquals(0, grafo.cantVertices());
	}
	
	@Test
	public void grafoVerticesTest() {
		vertices.add(new Vertice("0", "Buenos Aires", 0.0, 3.0));
		vertices.add(new Vertice("1", "La Pampa", 1.0, 4.0));
		vertices.add(new Vertice("2", "asd", 5.0, 17.0));
		
		assertEquals(3, grafo.cantVertices());
	}
	
	@Test
	public void grafoAristasTest() {
		vertices.add(new Vertice("0", "Buenos Aires", 0.0, 3.0));
		vertices.add(new Vertice("1", "La Pampa", 1.0, 4.0));
		vertices.add(new Vertice("2", "asd", 5.0, 17.0));
		aristas.add(new Arista("bsas pmp", vertices.get(0), vertices.get(1), 1, true));
		aristas.add(new Arista("bsas asd", vertices.get(0), vertices.get(2), 5, true));
		aristas.add(new Arista("pmp asd", vertices.get(1), vertices.get(2), 3, false));
		
		assertEquals(3, grafo.cantAristas());
	}
}
