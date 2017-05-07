package planificarViaje;

public class Solver {

	private Grafo _grafo;
	private Camino _camino;
	private Camino _incumbent;
	private int _s;
	private int _t;
	private int _peajes;
	
	public Solver(Grafo grafo, int s, int t, int peajes){
		_grafo = grafo;
		_s = s;
		_t = t;
		_peajes = peajes;
	}

	public Camino resolver() {
		_camino = new Camino();
		_incumbent = new Camino();		
		considerar(_s);
		
		return _incumbent;
	}

	private void considerar(int id) {

		if( id == _grafo.cantidadDeVertices()){
			if( _camino.cantidadPeajes() <= _peajes &&
				_camino.longitud() > _incumbent.longitud() ){
				_incumbent = _camino.clonar();
			}
			return;
		}
		
		_camino.agregar(_grafo.getArista(id));
		considerar(id+1);

		_camino.eliminar(_grafo.getArista(id));
		considerar(id+1);
	}
	
}
