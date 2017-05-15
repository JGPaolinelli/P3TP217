package caminoMinimo;

public class Vertice {
	
	private String _id, _nombre;
	private double _long, _lat;

	public Vertice(String id, String nombre, double longitud, double latitud) {
		this._id = id;
		this._nombre = nombre;
		this._long = longitud;
		this._lat = latitud;
	}

	public String getId() {
		return _id;
	}

	public String getNombre() {
		return _nombre;
	}
		
	public double getLatitud(){
		return _lat;
	}
	public double getLongitud(){
		return _long;
	}
	
	@Override
    public String toString() {
            return _nombre;
    }
}
