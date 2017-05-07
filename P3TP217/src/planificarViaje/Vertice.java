package planificarViaje;

public class Vertice {

	private String nombre;
	private double longitud;
	private double latitud;
	private int identificador;
	
	public Vertice(String nombre, double longitud, double latitud) {
		this.nombre = nombre;
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public Vertice(String nombre, double longitud, double latitud, int identificador){
		this.nombre = nombre;
		this.longitud = longitud;
		this.latitud = latitud;
		this.identificador = identificador;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public double getLatitud(){
		return this.latitud;
	}
	
	public double getLongitud(){
		return this.longitud;
	}
	
	public int getIdentificador(){
		return this.identificador;
	}

	@Override
	public String toString() {
		return "Vertice [" + nombre + ", " + longitud + ", " + latitud + "]";
	}
	
	
	
}
