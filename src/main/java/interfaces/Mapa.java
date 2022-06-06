package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

public class Mapa extends JPanel{
	private Personaje rival;
	private Personaje jugador;
	private Ventana ventana;
	
	
	public Mapa(Ventana v, String icono) {
		setBackground(Color.WHITE);
		this.ventana = v;
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{75, 0};
		gridBagLayout.rowHeights = new int[]{70, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(icono));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
	}
}
