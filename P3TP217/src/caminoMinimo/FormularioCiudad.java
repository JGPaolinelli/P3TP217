package caminoMinimo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class FormularioCiudad extends JPanel {
	
	JPanel jPanel_Ciudad;
	JLabel lblVertice;
	JTextField textField_NombreCiudad;
	JTextField textField_Latitud;
	JTextField textField_Longitud;
	JLabel lblNombreCiudad;
	JLabel lblLatitud;
	JLabel lblLongitud;
	JButton btnCancelarCiudad;
	JButton btnAceptarCiudad;

	public FormularioCiudad() {
		this.lblNombreCiudad = new JLabel("Nombre:");
		this.lblNombreCiudad.setBounds(10, 44, 76, 14);	
		this.textField_NombreCiudad = new JTextField();
		textField_NombreCiudad.setBounds(69, 41, 111, 20);
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
		this.lblVertice = new JLabel("Vertice");
		this.lblVertice.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		this.lblVertice.setBounds(69, 0, 62, 30);
		this.jPanel_Ciudad = new JPanel();
		this.jPanel_Ciudad.setBounds(769, 369, 205, 160);
		this.jPanel_Ciudad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.jPanel_Ciudad.setLayout(null);
		this.jPanel_Ciudad.add(this.lblVertice);
		this.jPanel_Ciudad.add(this.lblNombreCiudad);
		this.jPanel_Ciudad.add(this.lblLatitud);
		this.jPanel_Ciudad.add(this.lblLongitud);
		this.jPanel_Ciudad.add(this.textField_NombreCiudad);
		this.jPanel_Ciudad.add(this.textField_Latitud);
		this.jPanel_Ciudad.add(this.textField_Longitud);
		this.btnAceptarCiudad = new JButton("Aceptar");
		this.btnAceptarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		this.btnAceptarCiudad.setBounds(109, 128, 86, 24);
		
		this.btnCancelarCiudad = new JButton("Cancelar");
		this.btnCancelarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.btnCancelarCiudad.setBounds(10, 128, 86, 24);
		this.jPanel_Ciudad.add(this.btnAceptarCiudad);
		this.jPanel_Ciudad.add(this.btnCancelarCiudad);
	}

	public JPanel getjPanel_Ciudad() {
		return jPanel_Ciudad;
	}

}
