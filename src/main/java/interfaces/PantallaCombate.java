package interfaces;

import javax.swing.JPanel;

import clases.CampoCombate;
import clases.Carta;
import clases.Consumible;
import clases.Personaje;
import clases.PocionEnergia;
import clases.PocionFuerza;
import clases.PocionVida;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class PantallaCombate extends JPanel {
	private Ventana ventana;
	protected Carta CartaElegidaJ;
	protected Carta CartaElegidaR;
	private Personaje jugador;
	private Personaje rival;

	// CONSUMIBLES

	Consumible pEnergia = new PocionEnergia();
	Consumible pFuerza = new PocionFuerza();
	Consumible pVida = new PocionVida();

	// ESCENARIOS
	CampoCombate playa = new CampoCombate("Playa enigmática");
	CampoCombate dojo = new CampoCombate("Dojo");


	public PantallaCombate(Ventana v, Personaje jugador, Personaje rival) {
		Random r = new Random();
		this.ventana = v;
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 362, 790, 196);
		add(scrollPane);

		JPanel cartasListaJ = new JPanel();
		cartasListaJ.setBorder(new EmptyBorder(3, 3, 3, 3));
		cartasListaJ.setBackground(Color.BLACK);
		scrollPane.setViewportView(cartasListaJ);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		lblNewLabel.setBounds(-489, 114, 1526, 551);
		add(lblNewLabel);

		ArrayList<Carta> baraja = jugador.getBaraja();
		Collections.shuffle(baraja);
		for (byte i = 0; i < baraja.size(); i++) {
			cartasListaJ.add(new ListaCarta(ventana, baraja.get(i)));
		}
		
		
		
		

	}

}
