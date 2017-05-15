package caminoMinimo;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{
	
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenu mnAgregar;
	private JMenuItem mntmVertice;
	private JMenuItem mntmArista;
	private JMenuItem mntmCalcularCaminoMinimo;
	
	public Menu(){
		this.menuBar = new JMenuBar();
		this.mnMenu = new JMenu("Menu");
		this.mnAgregar = new JMenu("Agregar");
		this.mnAgregar.setIcon(new ImageIcon(MainViejo.class.getResource("/org/openstreetmap/gui/jmapviewer/images/plus.png")));
		this.mntmVertice = new JMenuItem("Ciudad");
		this.mntmArista = new JMenuItem("Ruta");
		this.mntmCalcularCaminoMinimo = new JMenuItem("Calcular Camino Minimo");
		this.menuBar.add(this.mnMenu);
		this.mnMenu.add(this.mnAgregar);
		this.mnAgregar.add(this.mntmVertice);
		this.mnAgregar.add(this.mntmArista);
		this.mnMenu.add(this.mntmCalcularCaminoMinimo);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenuItem getMntmVertice() {
		return mntmVertice;
	}

	public JMenuItem getMntmArista() {
		return mntmArista;
	}

	public JMenuItem getMntmCalcularCaminoMinimo() {
		return mntmCalcularCaminoMinimo;
	}
	
}
