package caminoMinimo;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class Main {

	private JFrame frame;
	private JTextField textField_NombreCiudad;
	private JTextField textField_Latitud;
	private JTextField textField_Longitud;
	private Integer contid, contruta;
	private JTextField textField_NombreCamino;
	private JTextField textField_Inicio;
	private JTextField textField_Fin;
	private JTextField textField_Distancia;
	private JTextField textField_Peaje;

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
		frame.getContentPane().setLayout(null);

		List<Vertice> vertices = new ArrayList<Vertice>();
		List<Arista> aristas = new ArrayList<Arista>();

		JMapViewer jMapViewer = new JMapViewer();
		jMapViewer.setBounds(0, 0, 984, 540);
		frame.getContentPane().add(jMapViewer);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(769, 369, 205, 160);
		jMapViewer.add(panel_1);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 44, 76, 14);
		panel_1.add(lblNewLabel);

		JLabel lblLatitud = new JLabel("Latitud:");
		lblLatitud.setBounds(10, 72, 76, 14);
		panel_1.add(lblLatitud);

		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(10, 100, 76, 14);
		panel_1.add(lblLongitud);

		textField_NombreCiudad = new JTextField();
		textField_NombreCiudad.setBounds(69, 41, 111, 20);
		panel_1.add(textField_NombreCiudad);
		textField_NombreCiudad.setColumns(10);

		textField_Latitud = new JTextField();
		textField_Latitud.setBounds(69, 69, 111, 20);
		panel_1.add(textField_Latitud);
		textField_Latitud.setColumns(10);

		textField_Longitud = new JTextField();
		textField_Longitud.setBounds(69, 97, 111, 20);
		panel_1.add(textField_Longitud);
		textField_Longitud.setColumns(10);

		JButton btnAceptarCiudad = new JButton("Aceptar");
		btnAceptarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_NombreCiudad.getText().equals("") && !textField_Latitud.getText().equals("")
						&& !textField_Longitud.getText().equals("")) {
					textField_Latitud.setText(textField_Latitud.getText().replace('.', ','));
					textField_Longitud.setText(textField_Longitud.getText().replace('.', ','));
					if (!esNumero(textField_Latitud.getText())) {
						alerta("No ingresaste una latitud correcta!", "Latitud invalido");
					} else if (!esNumero(textField_Longitud.getText())) {
						alerta("No ingresaste una longitud correcta!", "Latitud invalido");
					} else {
						vertices.add(new Vertice(Integer.toString(contid), textField_NombreCiudad.getText(),
								new Double(textField_Latitud.getText()), new Double(textField_Longitud.getText())));
						jMapViewer.addMapMarker(new MapMarkerDot(new Double(textField_Latitud.getText()),
								new Double(textField_Longitud.getText())));
						textField_NombreCiudad.setText("");
						textField_Latitud.setText("");
						textField_Longitud.setText("");
						contid++;
					}
				} else {
					if (textField_NombreCiudad.getText().equals("") && textField_Latitud.getText().equals("")
							&& textField_Longitud.getText().equals("")) {
						alerta("Campos vacios!", "Ciudad invalido");
					} else if (textField_NombreCiudad.getText().equals("")) {
						alerta("No ingresaste un nombre!", "Ciudad invalido");
					} else if (textField_Latitud.getText().equals("")) {
						alerta("No ingresaste la latiud!", "Ciudad invalida");
					} else if (textField_Longitud.getText().equals("")) {
						alerta("No ingresaste la longitud!", "Ciudad invalida");
					}

				}

			}
		});
		btnAceptarCiudad.setBounds(109, 128, 86, 24);
		panel_1.add(btnAceptarCiudad);
		
		JLabel lblVertice = new JLabel("Vertice");
		lblVertice.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblVertice.setBounds(69, 0, 62, 30);
		panel_1.add(lblVertice);
		
		JButton btnCancelarCiudad = new JButton("Cancelar");
		btnCancelarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
			}
		});
		btnCancelarCiudad.setBounds(10, 128, 86, 24);
		panel_1.add(btnCancelarCiudad);

		JPanel panel = new JPanel();
		panel.setBounds(769, 329, 205, 200);
		jMapViewer.add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		panel.setVisible(false);

		JLabel lblNombreCamino = new JLabel("Nombre:");
		lblNombreCamino.setBounds(10, 39, 61, 14);
		panel.add(lblNombreCamino);

		JLabel lblInicio = new JLabel("Desde: ");
		lblInicio.setBounds(10, 64, 61, 14);
		panel.add(lblInicio);

		JLabel lblFin = new JLabel("Hasta: ");
		lblFin.setBounds(10, 89, 61, 14);
		panel.add(lblFin);

		JLabel lblDistancia = new JLabel("Distancia: ");
		lblDistancia.setBounds(10, 114, 61, 14);
		panel.add(lblDistancia);

		JLabel lblPeaje = new JLabel("Peaje:");
		lblPeaje.setBounds(10, 139, 61, 14);
		panel.add(lblPeaje);

		textField_NombreCamino = new JTextField();
		textField_NombreCamino.setColumns(10);
		textField_NombreCamino.setBounds(72, 36, 111, 20);
		panel.add(textField_NombreCamino);

		textField_Inicio = new JTextField();
		textField_Inicio.setColumns(10);
		textField_Inicio.setBounds(72, 61, 111, 20);
		panel.add(textField_Inicio);

		textField_Fin = new JTextField();
		textField_Fin.setColumns(10);
		textField_Fin.setBounds(72, 86, 111, 20);
		panel.add(textField_Fin);

		textField_Distancia = new JTextField();
		textField_Distancia.setColumns(10);
		textField_Distancia.setBounds(72, 111, 111, 20);
		panel.add(textField_Distancia);

		textField_Peaje = new JTextField();
		textField_Peaje.setColumns(10);
		textField_Peaje.setBounds(72, 136, 111, 20);
		panel.add(textField_Peaje);

		JButton btnAceptarCamino = new JButton("Aceptar");
		btnAceptarCamino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean peaje = false;
				Vertice verticeAux_1 = null;
				Vertice verticeAux_2 = null;
				boolean hayError = false;
				if (vertices.size() <= 1) {
					alerta("No hay dos o mas ciudades para agregarle un camino!", "Camino invalido!");
				}
				if (textField_Inicio.getText().equals("") && textField_Inicio.getText().equals("")
						&& textField_Fin.getText().equals("") && textField_Distancia.getText().equals("")) {
					alerta("Campos vacios!", "Camino invalido!");
				} else {

					if (!textField_Peaje.getText().equals("")) {
						textField_Peaje.setText(textField_Peaje.getText().toLowerCase());
						if (textField_Peaje.getText().equals("si")) {
							peaje = true;
						}
					}

					for (Vertice vertice : vertices) {
						if (vertice.getNombre().equals(textField_Inicio.getText())) {
							verticeAux_1 = vertice;
						}
						if (vertice.getNombre().equals(textField_Fin.getText())) {
							verticeAux_2 = vertice;
						}
					}
					if (verticeAux_1 == null) {
						alerta("El nombre de inicio no existe!", "No se creo el camino");
						hayError = true;
					}
					if (verticeAux_2 == null) {
						alerta("El nombre de fin no existe!", "No se creo el camino");
						hayError = true;
					}
					if (!hayError && !textField_NombreCamino.getText().equals("")
							&& !textField_Distancia.getText().equals("")) {
						if (verticeAux_1.equals(verticeAux_2)) {
							alerta("No se pueden agregar bucles!", "No se creo el camino");
							hayError = true;
						} else if (!esNumero(textField_Distancia.getText())) {
							alerta("No ingresaste una distancia correcta!", "Distancia invalido");
							hayError = true;
						} else {
							aristas.add(new Arista(textField_NombreCamino.getText(), verticeAux_1, verticeAux_2,
									new Integer(textField_Distancia.getText()), peaje));
						}
					} else {
						if (textField_NombreCamino.getText().equals("")) {
							alerta("No agregarte un nombre", "Camino invalido");
						} else if (textField_Distancia.getText().equals("")) {
							alerta("No agregaste una distancia", "Camino invalido");
						}
						hayError = true;
					}
					if (!hayError) {
						Coordinate one = new Coordinate(aristas.get(contruta).getSalida().getLongitud(),
								aristas.get(contruta).getSalida().getLatitud());
						Coordinate two = new Coordinate(aristas.get(contruta).getDestino().getLongitud(),
								aristas.get(contruta).getDestino().getLatitud());
						List<Coordinate> route = new ArrayList<Coordinate>(Arrays.asList(one, two, two));
						MapPolygonImpl r = new MapPolygonImpl(route);
						if (peaje) {
							r.setColor(Color.RED);
						} else {
							r.setColor(Color.BLACK);
						}
						textField_NombreCamino.setText("");
						textField_Inicio.setText("");
						textField_Fin.setText("");
						textField_Distancia.setText("");
						textField_Peaje.setText("");
						peaje = false;
						jMapViewer.addMapPolygon(r);
						contruta++;
					}
				}
			}
		});
		btnAceptarCamino.setBounds(106, 164, 86, 24);
		panel.add(btnAceptarCamino);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
		btnCancelar.setBounds(10, 164, 86, 24);
		panel.add(btnCancelar);
		
		JLabel lblArista = new JLabel("Arista");
		lblArista.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblArista.setBounds(75, 11, 52, 14);
		panel.add(lblArista);
		contid = 0;
		contruta = 0;

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenu mnAgregar = new JMenu("Agregar");
		mnAgregar.setIcon(new ImageIcon(Main.class.getResource("/org/openstreetmap/gui/jmapviewer/images/plus.png")));
		mnMenu.add(mnAgregar);

		JMenuItem mntmVertice = new JMenuItem("Vertice");
		mntmVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (panel.isVisible()) {
					panel.setVisible(false);
					panel_1.setVisible(true);
				} else {
					panel_1.setVisible(true);
				}
			}
		});
		mnAgregar.add(mntmVertice);

		JMenuItem mntmArista = new JMenuItem("Arista");
		mntmArista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel_1.isVisible()) {
					panel_1.setVisible(false);
					panel.setVisible(true);
				} else {
					panel.setVisible(true);
				}
			}
		});
		mnAgregar.add(mntmArista);

		JMenuItem mntmCalcularCaminoMinimo = new JMenuItem("Calcular Camino Minimo");
		mntmCalcularCaminoMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aristas.size() >= 2) {
					Grafo g = new Grafo(vertices, aristas);
					LinkedList<Vertice> camino = null;
					String cantidadPeajes = JOptionPane.showInputDialog(frame, "Ingresa la cantidad de peajes:");
					String ciudadInicial = JOptionPane.showInputDialog(frame,
							"Ingresa desde que ciudad queres partir:");
					String ciudadFinal = JOptionPane.showInputDialog(frame, "Ingresa a que ciudad queres llegar:");
					Dijkstra d = new Dijkstra(g, new Integer(cantidadPeajes));
					for (Vertice vertice : vertices) {
						if (vertice.getNombre().equals(ciudadInicial)) {
							d.ejecutar(vertices.get(new Integer(vertice.getId())));
						}
						if (vertice.getNombre().equals(ciudadFinal)) {
							camino = d.getCamino(vertices.get(new Integer(vertice.getId())));
						}
					}

					for (int i = 0; i < camino.size(); i++) {
						if (i + 1 < camino.size()) {
							Coordinate one = new Coordinate(camino.get(i).getLongitud(), camino.get(i).getLatitud());
							Coordinate two = new Coordinate(camino.get(i + 1).getLongitud(),
									camino.get(i + 1).getLatitud());
							List<Coordinate> route = new ArrayList<Coordinate>(Arrays.asList(one, two, two));
							MapPolygonImpl r = new MapPolygonImpl(route);
							r.setColor(Color.GREEN);
							jMapViewer.addMapPolygon(r);
						} else {
							break;
						}
					}
				} else {
					alerta("No hay las suficientes aristas para calcular un camino!", "Incalculable");
				}
			}
		});
		mnMenu.add(mntmCalcularCaminoMinimo);

		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnMenu.add(mntmCerrar);

		jMapViewer.setDisplayPositionByLatLon(-34.6083, -58.3712, 5);

	}

	public static void alerta(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, "Error: " + titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	private static boolean esNumero(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
