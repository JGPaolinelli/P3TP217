package caminoMinimo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		List<Vertice> vertices = new ArrayList<Vertice>();
		List<Arista> aristas = new ArrayList<Arista>();

		JMapViewer jMapViewer = new JMapViewer();
		jMapViewer.setBounds(0, 0, 984, 540);
		frame.getContentPane().add(jMapViewer);

		FormularioCiudad formularioCiudad = new FormularioCiudad(vertices, jMapViewer);
		jMapViewer.add(formularioCiudad.getjPanel_Ciudad());

		FormularioCamino formularioCamino = new FormularioCamino(vertices, aristas, jMapViewer, frame);
		jMapViewer.add(formularioCamino.getPanel());
		jMapViewer.setDisplayPositionByLatLon(-34.6083, -58.3712, 5);

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
				formularioCamino.calcularCaminoMinimo(vertices, aristas, jMapViewer);
			}
		});
	}
}
