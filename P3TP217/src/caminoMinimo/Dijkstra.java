package caminoMinimo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
	private final List<Vertice> vertices;
	private final List<Arista> aristas;
	private Set<Vertice> verticesVisitados;
	private Set<Vertice> vertSinVisitar;
	private Map<Vertice, Vertice> predecesores;
	private Map<Vertice, Integer> distancia;
	private int peajesmax/*,peajesvisitados*/;
	private HashMap<Vertice,Integer >peajesvisitados; //para poder guardar los peajes en cada arista y luego compararlos en tiempo real
	

	// copiamos los arreglos para poder modificarlos
	public Dijkstra(Grafo grafo, int peajes) {
		this.vertices = new ArrayList<Vertice>(grafo.getVertices());
		this.aristas = new ArrayList<Arista>(grafo.getAristas());
		peajesmax = peajes;
	}

	public void ejecutar(Vertice salida) {
		verticesVisitados = new HashSet<Vertice>();
		vertSinVisitar = new HashSet<Vertice>();
		distancia = new HashMap<Vertice, Integer>();
		predecesores = new HashMap<Vertice, Vertice>();
		peajesvisitados=new HashMap<Vertice,Integer>();
//		peajesvisitados=0;
		distancia.put(salida, 0);
		peajesvisitados.put(salida, 0);
		vertSinVisitar.add(salida);
		while (vertSinVisitar.size() > 0/* && peajesmax>peajesvisitados*/) {
			Vertice nodo = getMinimo(vertSinVisitar);
			verticesVisitados.add(nodo);
			vertSinVisitar.remove(nodo);
			buscarDistanciaMinima(nodo);	
		}
	}

	private void buscarDistanciaMinima(Vertice nodo) {
		List<Vertice> nodosAdj = getVecinos(nodo);
		for (Vertice t : nodosAdj) {
//			System.out.println(t.getNombre());
//			System.out.println("getPeajeMinimo(nodo): "+getPeajeMinimo(nodo)+" + "+" getPeaje(nodo, t): "+getPeaje(nodo, t));
//			System.out.println("nodo es:"+nodo.getNombre()+" y t es "+t.getNombre()+" getDistanciaMinima det:"+getDistanciaMinima(t)+"es mayor a la "+
//					 "getDistanciaMinima(nodo) " +getDistanciaMinima(nodo)+" + "+ " getDistancia(nodo, t))"+getDistancia(nodo, t)+ " y si tiene peaje: "+getPeaje(nodo, t)
//					 +"peajes visitados: "+peajesvisitados+ "peajes maximos: "+ peajesmax);	
//			
			//para que funcionara se copio lo que hace la primer parte del if, se utilizo el formato de distancia para comparar de la misma manera
			if (getDistanciaMinima(t) > getDistanciaMinima(nodo) + getDistancia(nodo, t) && peajesmax >= getPeajeMinimo(nodo) + getPeaje(nodo, t) ){	
				distancia.put(t, getDistanciaMinima(nodo) + getDistancia(nodo, t));
				peajesvisitados.put(t, getPeajeMinimo(nodo) + getPeaje(nodo, t));
				predecesores.put(t, nodo);
				vertSinVisitar.add(t);
				}
					
		}
	}

	private List<Vertice> getVecinos(Vertice node) {
		List<Vertice> vecinos = new ArrayList<Vertice>();
		for (Arista arista : aristas) {
			if (arista.getSalida().equals(node) && !estaVisitado(arista.getDestino())) {
				vecinos.add(arista.getDestino());
			}
		}
		return vecinos;
	}

	private boolean estaVisitado(Vertice v) {
		return verticesVisitados.contains(v);
	}

	private int getDistancia(Vertice node, Vertice target) {
		for (Arista arista : aristas) {
			if (arista.getSalida().equals(node) && arista.getDestino().equals(target)) {
				return arista.getPeso();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private int getPeaje(Vertice node, Vertice target) {
		for (Arista arista : aristas) {
			if (arista.getSalida().equals(node) && arista.getDestino().equals(target)) {
				if( arista.getPeaje()){
					return 1;
				}
			}
		}
		return 0;
	}

	private Vertice getMinimo(Set<Vertice> Vertices) {
		Vertice minimo = null;
		for (Vertice Vertice : Vertices) {
			if (minimo == null) {
				minimo = Vertice;
			} else {
				if (getDistanciaMinima(Vertice) < getDistanciaMinima(minimo)) {
					minimo = Vertice;
				}
			}
		}
		return minimo;
	}

	private int getDistanciaMinima(Vertice destino) {
		Integer d = distancia.get(destino);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}
	
	private int getPeajeMinimo (Vertice Destino){
		Integer p = peajesvisitados.get(Destino);
		if (p == null) {
			return 0;
		}
		else{
			return p;
		}
	}

	public LinkedList<Vertice> getCamino(Vertice t) {
		LinkedList<Vertice> camino = new LinkedList<Vertice>();
		Vertice paso = t;
		if (predecesores.get(paso) == null) {
			throw new IllegalArgumentException("No hay camino disponible para esa cantidad de peajes, pag� rata!");
		}
		camino.add(paso);
		while (predecesores.get(paso) != null) {	
			paso = predecesores.get(paso);
			camino.add(paso);
		}
		// con esto se reordena porque queda medio raro xD
		Collections.reverse(camino);
		return camino;
	}
}
