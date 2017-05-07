package planificarViaje;

import java.util.ArrayList;

public class Grafo {
	
	private ArrayList<Vertice> _vertices;
	private ArrayList<Arista> _aristas;
	private int _contadorDeId;
	
	public Grafo(){
		_vertices = new ArrayList<Vertice>();
		_contadorDeId = 0;
	}

	public void agregarVertice(Vertice vertice) {
		_vertices.add(new Vertice(vertice.getNombre(),vertice.getLongitud(),vertice.getLatitud(),_contadorDeId));		
		_contadorDeId += 1;
	}

	public void agregarArista(Arista arista) {
		_aristas.add(arista);
	}
	
	public int cantidadDeVertices(){
		return _vertices.size();
	}
	
	public int cantidadDeAristas(){
		return _aristas.size();
	}
	
	public Vertice getVertice(int posicion){
		return _vertices.get(posicion);
	}
	
	public Arista getArista(int posicion){
		return _aristas.get(posicion);
	}

}
