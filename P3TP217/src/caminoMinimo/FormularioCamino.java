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
	
	public FormularioCamino(){
		lblArista = new JLabel("Arista");
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
				//TODO
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
		
}
