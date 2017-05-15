package caminoMinimo;

public class Arista {
	
	private String id;
	private Vertice s, t;
	private int peso;
	private boolean peaje;

	public Arista(String id, Vertice s, Vertice t, int peso, boolean peaje) {
		this.id = id;
		this.s = s;
		this.t = t;
		this.peso = peso;
		this.peaje = peaje;
	}

	public String getId() {
		return id;
	}

	public Vertice getDestino() {
		return t;
	}

	public Vertice getSalida() {
		return s;
	}

	public int getPeso() {
		return peso;
	}
	
	public boolean getPeaje(){
		return peaje;
	}

	@Override
	public String toString() {
		return s + " " + t;
	}
}
