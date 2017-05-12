package caminoMinimo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menu extends JMenuBar{
	
	JMenuBar menuBar;
	JMenu mnMenu;
	JMenu mnAgregar;
	JMenuItem mntmVertice;
	JMenuItem mntmArista;
	JMenuItem mntmCalcularCaminoMinimo;
	
	public Menu(){
		this.menuBar = new JMenuBar();
		this.mnMenu = new JMenu("Menu");
		this.mnAgregar = new JMenu("Agregar");
		this.mnAgregar.setIcon(new ImageIcon(Main.class.getResource("/org/openstreetmap/gui/jmapviewer/images/plus.png")));
		this.mntmVertice = new JMenuItem("Vertice");
		this.mntmVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		this.mntmArista = new JMenuItem("Arista");
		this.mntmArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.mntmCalcularCaminoMinimo = new JMenuItem("Calcular Camino Minimo");
		this.mntmCalcularCaminoMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.menuBar.add(this.mnMenu);
		this.mnMenu.add(this.mnAgregar);
		this.mnAgregar.add(this.mntmVertice);
		this.mnAgregar.add(this.mntmArista);
		this.mnMenu.add(this.mntmCalcularCaminoMinimo);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}
	
}
