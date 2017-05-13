package caminoMinimo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		FormularioCamino formularioCamino = new FormularioCamino();
		jMapViewer.add(formularioCamino.getPanel());
		
		Menu menu = new Menu();
		frame.setJMenuBar(menu.getMenuBar());
		
		menu.getMntmVertice().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (formularioCamino.isVisible()) {
					formularioCamino.setVisible(false);
					formularioCiudad.setVisible(true);
				} else {
					formularioCiudad.setVisible(true);
				}
			}
		});
		menu.getMntmArista().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (formularioCiudad.isVisible()) {
					formularioCiudad.setVisible(false);
					formularioCamino.setVisible(true);
				} else {
					formularioCamino.setVisible(true);
				}
			}
		});
		menu.getMntmCalcularCaminoMinimo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calcularCaminoMinimo(vertices, aristas, jMapViewer);
			}
		});
	}
}
