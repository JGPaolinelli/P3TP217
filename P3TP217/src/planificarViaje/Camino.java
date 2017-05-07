package planificarViaje;

import java.util.ArrayList;

public class Camino {

	private ArrayList<Integer> _camino;
	private int _peajes;
	private double _longitud;
	
	public Camino(){
		_camino = new ArrayList<Integer>();
		_peajes = 0;
		_longitud = 0.0;
	}
	
	public void agregar(Arista arista){
		_camino.add(arista.getIdentificadorA());
		_longitud += arista.getLongitud();
		if(arista.isPeaje()){
			_peajes += 1;
		}
	}

	public void eliminar(Arista arista){
		_camino.remove(arista.getIdentificadorA());
		_longitud -= arista.getLongitud();
		if(arista.isPeaje()){
			_peajes -= 1;
		}
	}
	
	public int cantidadPeajes(){
		return _peajes;
	}
	
	public double longitud(){
		return _longitud;
	}
	
	public ArrayList<Integer> getCamino()
	{
		return _camino;
	}
	
	public void add(Integer i){
		_camino.add(i);
	}
	
	public Camino clonar()
	{
		Camino cam = new Camino();
		for(Integer integer: getCamino())
			cam.add(integer);

		return cam;
	}

}
