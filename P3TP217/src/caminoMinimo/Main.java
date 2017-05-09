package caminoMinimo;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;
import org.openstreetmap.gui.jmapviewer.interfaces.MapRectangle;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.xml.bind.ParseConversionEvent;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Integer contid;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		frame.setBounds(100, 100, 746, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JMapViewer jMapViewer = new JMapViewer();
		jMapViewer.setBounds(0, 0, 400, 258);
		frame.getContentPane().add(jMapViewer);
		contid=0;

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(444, 108, 276, 184);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBounds(444, 108, 276, 184);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		List<Vertice> v = new ArrayList<Vertice>();
		

		JButton btnAsd = new JButton("asd");
		btnAsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jMapViewer.addMapMarker(new MapMarkerDot(-34.6083, -58.3712));
				jMapViewer.addMapMarker(new MapMarkerDot(-31.4, -64.1833));

				Coordinate one = new Coordinate(-34.6083, -58.3712);
				Coordinate two = new Coordinate(-31.4, -64.1833);
				List<Coordinate> route = new ArrayList<Coordinate>(Arrays.asList(one, two, two));
				MapPolygonImpl r = new MapPolygonImpl(route);
				r.setColor(Color.BLACK);
				jMapViewer.addMapPolygon(r);
				jMapViewer.setDisplayPositionByLatLon(-34.6083, -58.3712, 5);

			}
		});

		JButton btnAgregarCiudad = new JButton("Agregar Ciudad");
		btnAgregarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
			}
		});
		btnAgregarCiudad.setBounds(505, 40, 119, 23);
		frame.getContentPane().add(btnAgregarCiudad);

		JButton btnNewButton = new JButton("Agregar Camino");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panel_1.isVisible()){
					panel_1.setVisible(false);
					panel.setVisible(true);
				}
				else{
					panel.setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(505, 74, 119, 23);
		frame.getContentPane().add(btnNewButton);

		btnAsd.setBounds(69, 283, 89, 23);
		frame.getContentPane().add(btnAsd);

		JLabel lblNewLabel = new JLabel("Nombre de la ciudad:");
		lblNewLabel.setBounds(10, 11, 111, 14);
		panel_1.add(lblNewLabel);

		JLabel lblLatitud = new JLabel("Latitud:");
		lblLatitud.setBounds(10, 36, 111, 14);
		panel_1.add(lblLatitud);

		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(10, 61, 46, 14);
		panel_1.add(lblLongitud);

		textField_1 = new JTextField();
		textField_1.setBounds(131, 8, 111, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(131, 33, 111, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(131, 58, 111, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().equals("") && !textField_2.getText().equals("") && !textField_3.getText().equals("")){
					v.add(new Vertice(Integer.toString(contid), textField_1.getText(), new Double (textField_2.getText()),new Double (textField_3.getText())));
					jMapViewer.addMapMarker(new MapMarkerDot(new Double (textField_2.getText()),new Double (textField_3.getText())));
					textField_1.setText("");textField_2.setText("");textField_3.setText("");
					contid++;
				}			
			}
		});
		btnAceptar.setBounds(93, 123, 89, 23);
		panel_1.add(btnAceptar);

		JLabel lblNombreDeLa = new JLabel("Nombre de la ruta:");
		lblNombreDeLa.setBounds(10, 11, 111, 14);
		panel.add(lblNombreDeLa);

		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(10, 36, 111, 14);
		panel.add(lblInicio);

		JLabel lblFin = new JLabel("Fin:");
		lblFin.setBounds(10, 61, 46, 14);
		panel.add(lblFin);

		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setBounds(10, 89, 46, 14);
		panel.add(lblDistancia);

		JLabel lblPeaje = new JLabel("Peaje:");
		lblPeaje.setBounds(10, 114, 46, 14);
		panel.add(lblPeaje);
		
		JButton button = new JButton("Aceptar");
		button.setBounds(93, 160, 89, 23);
		panel.add(button);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(131, 8, 111, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(131, 33, 111, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(131, 58, 111, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(131, 83, 111, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(131, 108, 111, 20);
		panel.add(textField_8);
		
		
		
		
		jMapViewer.setDisplayPositionByLatLon(-34.6083, -58.3712, 5);

	}
}
