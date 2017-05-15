package caminoMinimo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

@SuppressWarnings("serial")
public class FormularioCamino extends JPanel{

	private JPanel panel;
	private JTextField textField_NombreCamino;
	private JTextField textField_Inicio;
	private JTextField textField_Fin;
	private JTextField textField_Distancia;
	private JTextField textField_Peaje;
	private JLabel lblNombreCamino;
	private JLabel lblInicio;
	private JLabel lblFin;
	private JLabel lblDistancia;
	private JLabel lblPeaje;
	private JButton btnAceptarCamino;
	private JButton btnCancelar;
	private JLabel lblArista;
	private int contruta;
	private JFrame frame;
	
	public FormularioCamino(List<Vertice> vertices, List<Arista> aristas, JMapViewer jMapViewer, JFrame frame){
		lblArista = new JLabel("Ruta");
		lblArista.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblArista.setBounds(75, 11, 52, 14);
		lblNombreCamino = new JLabel("Nombre:");
		lblNombreCamino.setBounds(10, 39, 61, 14);
		lblInicio = new JLabel("Desde: ");
		lblInicio.setBounds(10, 64, 61, 14);
		lblFin = new JLabel("Hasta: ");
		lblFin.setBounds(10, 89, 61, 14);
		lblDistancia = new JLabel("Distancia: ");
		lblDistancia.setBounds(10, 114, 61, 14);
		lblPeaje = new JLabel("Peaje:");
		lblPeaje.setBounds(10, 139, 61, 14);
		textField_NombreCamino = new JTextField();
		textField_NombreCamino.setColumns(10);
		textField_NombreCamino.setBounds(72, 36, 111, 20);
		textField_Inicio = new JTextField();
		textField_Inicio.setColumns(10);
		textField_Inicio.setBounds(72, 61, 111, 20);
		textField_Fin = new JTextField();
		textField_Fin.setColumns(10);
		textField_Fin.setBounds(72, 86, 111, 20);
		textField_Distancia = new JTextField();
		textField_Distancia.setColumns(10);
		textField_Distancia.setBounds(72, 111, 111, 20);
		textField_Peaje = new JTextField();
		textField_Peaje.setColumns(10);
		textField_Peaje.setBounds(72, 136, 111, 20);
		btnAceptarCamino = new JButton("Aceptar");
		btnAceptarCamino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarArista(vertices, aristas, jMapViewer);
			}
		});
		btnAceptarCamino.setBounds(106, 164, 86, 24);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				textField_NombreCamino.setText("");
				textField_Inicio.setText("");
				textField_Fin.setText("");
				textField_Distancia.setText("");
				textField_Peaje.setText("");
			}
		});
		btnCancelar.setBounds(10, 164, 86, 24);
		panel = new JPanel();
		panel.setBounds(769, 329, 205, 200);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		panel.setVisible(false);
		panel.add(lblNombreCamino);
		panel.add(lblInicio);
		panel.add(lblFin);
		panel.add(lblDistancia);
		panel.add(lblPeaje);
		panel.add(textField_NombreCamino);
		panel.add(textField_Inicio);
		panel.add(textField_Fin);
		panel.add(textField_Distancia);
		panel.add(textField_Peaje);
		panel.add(btnAceptarCamino);
		panel.add(btnCancelar);
		panel.add(lblArista);
		this.frame = frame;
	}


	public JPanel getPanel() {
		return panel;
	}
	
	public boolean isVisible(){
		return panel.isVisible();
	}
	
	public void setVisible(boolean visible){
		panel.setVisible(visible);
	}
	
	private void agregarArista(List<Vertice> vertices, List<Arista> aristas, JMapViewer jMapViewer) {
		boolean peaje = false;
		Vertice verticeAux_1 = null;
		Vertice verticeAux_2 = null;
		boolean hayError = false;
		if (vertices.size() <= 1) {
			alerta("No hay dos o mas vertices para agregar una arista!","Arista invalida");
		}
		if (textField_Inicio.getText().equals("") && textField_Inicio.getText().equals("")
				&& textField_Fin.getText().equals("") && textField_Distancia.getText().equals("")) {
			alerta("Campos vacios!","Arista invalida");
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
				alerta("El nombre de inicio no existe!","Arista invalida");
				hayError = true;
			}
			if (verticeAux_2 == null) {
				alerta("El nombre de fin no existe!","Arista invalida");
				hayError = true;
			}
			if (!hayError && !textField_NombreCamino.getText().equals("")
					&& !textField_Distancia.getText().equals("")) {
				if (verticeAux_1.equals(verticeAux_2)) {
					alerta("No se pueden agregar bucles!","Arista invalida");
					hayError = true;
				} else {
					aristas.add(new Arista(textField_NombreCamino.getText(), verticeAux_1, verticeAux_2,
							new Integer(textField_Distancia.getText()), peaje));
				}
			} else {
				if (textField_NombreCamino.getText().equals("")) {
					alerta("No agregaste un nombre","Arista invalida");
				} else if (textField_Distancia.getText().equals("")) {
					alerta("No agregaste una distancia","Arista invalida");
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
	
	protected void calcularCaminoMinimo(List<Vertice> vertices, List<Arista> aristas, JMapViewer jMapViewer) {
		if (aristas.size() >= 2) {
			Grafo g = new Grafo(vertices, aristas);
			LinkedList<Vertice> camino = null;
			String cantidadPeajes = inputUsuario(frame, "Ingresa la cantidad de peajes:");
			if (!esNumero(cantidadPeajes)) {
				alerta("Ingresaste una cantidad de peajes invalida!", "404");
			} else {
				String ciudadInicial = inputUsuario(frame, "Ingresa el vertice inicial: ");
				String ciudadFinal = inputUsuario(frame, "Ingresa el vertice final: ");
				Vertice verticeAux_1 = null;
				Vertice verticeAux_2 = null;
				for (Vertice vertice : vertices) {
					if (vertice.getNombre().equals(ciudadInicial)) {
						verticeAux_1 = vertice;
					}
					if (vertice.getNombre().equals(ciudadFinal)) {
						verticeAux_2 = vertice;
					}
				}
				if (verticeAux_1 == null) {
					alerta("El vertice inicial no existe!", "404");
				} else if (verticeAux_2 == null) {
					alerta("El vertice final no existe!", "404");
				} else {
					// TODO QUE PASA SI NO EXISTE LA ARISTA PARA LLEGAR AL
					// CAMINO DESEADO
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
			}

		} else {
			alerta("No hay las suficientes aristas para calcular un camino!", "Incalculable");
		}
	}
	
	private static boolean esNumero(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	private static String inputUsuario(Frame frame, String mensaje) {
		return JOptionPane.showInputDialog(frame, mensaje);
	}
	
	private static void alerta(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, "Error: " + titulo, JOptionPane.INFORMATION_MESSAGE);
	}
		
}
