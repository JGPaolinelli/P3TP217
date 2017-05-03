package caminoMinimo;

public class MainClass {

	public static void main(String[] args) {
		Instancia ins = new Instancia();
		ins.agregarCiudad("asd", 0.1, 0.2);
		System.out.println(ins.get_ciudades().get("asd"));
		ins.agregarCiudad("qwe", 0.5, 0.15);
		System.out.println(ins.get_ciudades().get("qwe"));
		ins.agregarRuta("asd", "qwe", 500.0, false);
		System.out.println(ins.get_ciudades().get("asd"));
		System.out.println(ins.get_ciudades().get("qwe"));
		
		Solver solver = new Solver(2);
		solver.resuelve(0);
		
	}

}
