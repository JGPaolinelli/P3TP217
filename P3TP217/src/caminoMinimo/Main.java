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

		JMapViewer jMapViewer = new JMapViewer();
		jMapViewer.setBounds(10, 11, 964, 359);
		frame.getContentPane().add(jMapViewer);
		contid = 0;
		contruta = 0;

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(430, 408, 255, 122);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBounds(719, 381, 255, 169);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		List<Vertice> vertices = new ArrayList<Vertice>();
		List<Arista> aristas = new ArrayList<Arista>();

		JButton btnAgregarCiudad = new JButton("Agregar Ciudad");
		btnAgregarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
			}
		});
		btnAgregarCiudad.setBounds(86, 415, 136, 23);
		frame.getContentPane().add(btnAgregarCiudad);

		JButton btnAgregarCamino = new JButton("Agregar Camino");
		btnAgregarCamino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panel_1.isVisible()) {
					panel_1.setVisible(false);
					panel.setVisible(true);
				} else {
					panel.setVisible(true);
				}

			}
		});
		btnAgregarCamino.setBounds(86, 460, 136, 23);
		frame.getContentPane().add(btnAgregarCamino);

		// btnAsd.setBounds(69, 283, 89, 23);
		// frame.getContentPane().add(btnAsd);

		JLabel lblNewLabel = new JLabel("Nombre de la ciudad:");
		lblNewLabel.setBounds(10, 11, 121, 14);
		panel_1.add(lblNewLabel);

		JLabel lblLatitud = new JLabel("Latitud:");
		lblLatitud.setBounds(10, 36, 111, 14);
		panel_1.add(lblLatitud);

		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(10, 61, 121, 14);
		panel_1.add(lblLongitud);

		textField_NombreCiudad = new JTextField();
		textField_NombreCiudad.setBounds(131, 8, 111, 20);
		panel_1.add(textField_NombreCiudad);
		textField_NombreCiudad.setColumns(10);

		textField_Latitud = new JTextField();
		textField_Latitud.setBounds(131, 33, 111, 20);
		panel_1.add(textField_Latitud);
		textField_Latitud.setColumns(10);

		textField_Longitud = new JTextField();
		textField_Longitud.setBounds(131, 58, 111, 20);
		panel_1.add(textField_Longitud);
		textField_Longitud.setColumns(10);

		JButton btnAceptarCiudad = new JButton("Aceptar");
		btnAceptarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_NombreCiudad.getText().equals("") && !textField_Latitud.getText().equals("")
						&& !textField_Longitud.getText().equals("")) {
					textField_Latitud.setText(textField_Latitud.getText().replace('.', ','));
					textField_Longitud.setText(textField_Longitud.getText().replace('.', ','));
					if (!isNumeric(textField_Latitud.getText())) {
						alerta("No ingresaste una latitud correcta!", "Latitud invalido");
					} else if (!isNumeric(textField_Longitud.getText())) {
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
		btnAceptarCiudad.setBounds(91, 89, 89, 23);
		panel_1.add(btnAceptarCiudad);

		JLabel lblNombreCamino = new JLabel("Nombre del camino:");
		lblNombreCamino.setBounds(10, 11, 122, 14);
		panel.add(lblNombreCamino);

		JLabel lblInicio = new JLabel("Inicio: ");
		lblInicio.setBounds(10, 36, 111, 14);
		panel.add(lblInicio);

		JLabel lblFin = new JLabel("Fin: ");
		lblFin.setBounds(10, 61, 46, 14);
		panel.add(lblFin);

		JLabel lblDistancia = new JLabel("Distancia: ");
		lblDistancia.setBounds(10, 89, 111, 14);
		panel.add(lblDistancia);

		JLabel lblPeaje = new JLabel("Tiene peaje?");
		lblPeaje.setBounds(10, 114, 111, 14);
		panel.add(lblPeaje);

		textField_NombreCamino = new JTextField();
		textField_NombreCamino.setColumns(10);
		textField_NombreCamino.setBounds(131, 8, 111, 20);
		panel.add(textField_NombreCamino);

		textField_Inicio = new JTextField();
		textField_Inicio.setColumns(10);
		textField_Inicio.setBounds(131, 33, 111, 20);
		panel.add(textField_Inicio);

		textField_Fin = new JTextField();
		textField_Fin.setColumns(10);
		textField_Fin.setBounds(131, 58, 111, 20);
		panel.add(textField_Fin);

		textField_Distancia = new JTextField();
		textField_Distancia.setColumns(10);
		textField_Distancia.setBounds(131, 83, 111, 20);
		panel.add(textField_Distancia);

		textField_Peaje = new JTextField();
		textField_Peaje.setColumns(10);
		textField_Peaje.setBounds(131, 108, 111, 20);
		panel.add(textField_Peaje);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Grafo g = new Grafo(vertices, aristas);
				LinkedList<Vertice> camino = null;
				String cantidadPeajes = JOptionPane.showInputDialog(frame, "Ingresa la cantidad de peajes:");
				String ciudadInicial = JOptionPane.showInputDialog(frame, "Ingresa desde que ciudad queres partir:");
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
			}
		});
		btnCalcular.setBounds(109, 507, 91, 23);
		frame.getContentPane().add(btnCalcular);
		btnCalcular.setVisible(false);

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
						} else if (!isNumeric(textField_Distancia.getText())) {
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
						if (aristas.size() >= 2) {
							btnCalcular.setVisible(true);
						}
					}
				}
			}
		});
		btnAceptarCamino.setBounds(90, 139, 89, 23);
		panel.add(btnAceptarCamino);

		jMapViewer.setDisplayPositionByLatLon(-34.6083, -58.3712, 5);

	}

	public static void alerta(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, "Error: " + titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	private static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
