package caminoMinimo;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class Prueba {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba window = new Prueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMapViewer jMapViewer = new JMapViewer();
		jMapViewer.setBounds(0, 0, 984, 540);
		frame.getContentPane().add(jMapViewer);
		
		FormularioCiudad formularioCiudad = new FormularioCiudad();
		jMapViewer.add(formularioCiudad.getjPanel_Ciudad());
		
		Menu menu = new Menu();
		frame.setJMenuBar(menu.getMenuBar());
	}
}
