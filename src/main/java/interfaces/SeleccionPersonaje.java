package interfaces;

import javax.swing.JPanel;

import componentesVisuales.BotonAnimado;
import componentesVisuales.BotonAnimadoNegro;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class SeleccionPersonaje extends JPanel {
	private Ventana ventana;

	public SeleccionPersonaje(Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JButton ATRAS = new BotonAnimadoNegro("ATR\u00C1S");
		ATRAS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("MenuPrincipal");
			}
		});
		ATRAS.setForeground(Color.BLACK);
		ATRAS.setBounds(644, 506, 119, 38);
		add(ATRAS);
		
		JLabel lblNewLabel = new JLabel("SELECCI\u00D3N DE PERSONAJE");
		lblNewLabel.setFont(new Font("Personal Services", Font.PLAIN, 45));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 10, 725, 99);
		add(lblNewLabel);
		
		JLabel MANCHA = new JLabel("");
		MANCHA.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\manchaBlanca.png"));
		MANCHA.setBounds(500, 425, 536, 151);
		add(MANCHA);
		
		JLabel FONDO = new JLabel("");
		FONDO.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\character_select.png"));
		FONDO.setBounds(0, 0, 800, 576);
		add(FONDO);
		
		
	}
}
