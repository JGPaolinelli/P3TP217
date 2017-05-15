package caminoMinimo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

@SuppressWarnings("serial")
public class FormularioCiudad extends JPanel {

	private JPanel jPanel_Ciudad;
	private JLabel lblCiudad;
	private JTextField textField_NombreCiudad;
	private JTextField textField_Latitud;
	private JTextField textField_Longitud;
	private JLabel lblNombreCiudad;
	private JLabel lblLatitud;
	private JLabel lblLongitud;
	private JButton btnCancelarCiudad;
	private JButton btnAceptarCiudad;
	int contid;

	public FormularioCiudad(List<Vertice> vertices, JMapViewer jMapViewer) {
		this.lblNombreCiudad = new JLabel("Nombre:");
		this.lblNombreCiudad.setBounds(10, 44, 76, 14);
		this.textField_NombreCiudad = new JTextField();
		this.textField_NombreCiudad.setBounds(69, 41, 111, 20);
		this.textField_NombreCiudad.setColumns(10);
		this.lblLatitud = new JLabel("Latitud:");
		this.lblLatitud.setBounds(10, 72, 76, 14);
		this.textField_Latitud = new JTextField();
		this.textField_Latitud.setBounds(69, 69, 111, 20);
		this.textField_Latitud.setColumns(10);
		this.lblLongitud = new JLabel("Longitud:");
		this.lblLongitud.setBounds(10, 100, 76, 14);
		this.textField_Longitud = new JTextField();
		this.textField_Longitud.setBounds(69, 97, 111, 20);
		this.textField_Longitud.setColumns(10);
		this.lblCiudad = new JLabel("Ciudad");
		this.lblCiudad.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		this.lblCiudad.setBounds(69, 0, 62, 30);
		this.btnAceptarCiudad = new JButton("Aceptar");
		this.btnAceptarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarVertice(vertices, jMapViewer);
			}
		});
		this.btnAceptarCiudad.setBounds(109, 128, 86, 24);
		this.btnCancelarCiudad = new JButton("Cancelar");
		this.btnCancelarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_NombreCiudad.setText("");
				textField_Latitud.setText("");
				textField_Longitud.setText("");
			}
		});
		this.btnCancelarCiudad.setBounds(10, 128, 86, 24);
		this.jPanel_Ciudad = new JPanel();
		this.jPanel_Ciudad.setBounds(769, 369, 205, 160);
		this.jPanel_Ciudad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.jPanel_Ciudad.setLayout(null);
		this.jPanel_Ciudad.setVisible(false);
		this.jPanel_Ciudad.add(this.lblCiudad);
		this.jPanel_Ciudad.add(this.lblNombreCiudad);
		this.jPanel_Ciudad.add(this.lblLatitud);
		this.jPanel_Ciudad.add(this.lblLongitud);
		this.jPanel_Ciudad.add(this.textField_NombreCiudad);
		this.jPanel_Ciudad.add(this.textField_Latitud);
		this.jPanel_Ciudad.add(this.textField_Longitud);
		this.jPanel_Ciudad.add(this.btnAceptarCiudad);
		this.jPanel_Ciudad.add(this.btnCancelarCiudad);
	}

	public JPanel getjPanel_Ciudad() {
		return this.jPanel_Ciudad;
	}

	public boolean isVisible() {
		return this.jPanel_Ciudad.isVisible();
	}

	public void setVisible(boolean visible) {
		this.jPanel_Ciudad.setVisible(visible);
	}

	private void agregarVertice(List<Vertice> vertices, JMapViewer jMapViewer) {
		if (!textField_NombreCiudad.getText().equals("") && !textField_Latitud.getText().equals("")
				&& !textField_Longitud.getText().equals("")) {
			vertices.add(new Vertice(Integer.toString(contid), textField_NombreCiudad.getText(),
					new Double(textField_Latitud.getText()), new Double(textField_Longitud.getText())));
			jMapViewer.addMapMarker(new MapMarkerDot(new Double(textField_Latitud.getText()),
					new Double(textField_Longitud.getText())));
			textField_NombreCiudad.setText("");
			textField_Latitud.setText("");
			textField_Longitud.setText("");
			contid++;
			// }
		} else {
			if (textField_NombreCiudad.getText().equals("") && textField_Latitud.getText().equals("")
					&& textField_Longitud.getText().equals("")) {
				alerta("Campos vacios!", "Vertice invalido");
			} else if (textField_NombreCiudad.getText().equals("")) {
				alerta("No ingresaste un nombre!", "Vertice invalido");
			} else if (textField_Latitud.getText().equals("")) {
				alerta("No ingresaste la latiud!", "Vertice invalido");
			} else if (textField_Longitud.getText().equals("")) {
				alerta("No ingresaste la longitud!", "Vertice invalido");
			}

		}
	}

	private static void alerta(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, "Error: " + titulo, JOptionPane.INFORMATION_MESSAGE);
	}

}
