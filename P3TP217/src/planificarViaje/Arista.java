package planificarViaje;

public class Arista {

	private int identificadorA;
	private int identificadorB;
	private double longitud;
	private boolean peaje;
	
	public Arista(int identificadorA, int identificadorB, double longitud, boolean peaje) {
		this.identificadorA = identificadorA;
		this.identificadorB = identificadorB;
		this.longitud = longitud;
		this.peaje = peaje;
	}

	public int getIdentificadorA() {
		return identificadorA;
	}

	public int getIdentificadorB() {
		return identificadorB;
	}

	public double getLongitud() {
		return longitud;
	}

	public boolean isPeaje() {
		return peaje;
	}
	
}
