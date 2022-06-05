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
import javax.swing.UIManager;

public class PantallaCombate extends JPanel {
	private Ventana ventana;
	private Carta cartaElegidaJ;
	private Carta cartaElegidaR;
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
		this.ventana = v;
		this.jugador = jugador;
		this.rival = rival;
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 348, 741, 202);
		add(scrollPane);

		JPanel cartasListaJ = new JPanel();
		cartasListaJ.setForeground(Color.BLACK);
		cartasListaJ.setBorder(new EmptyBorder(3, 3, 3, 3));
		cartasListaJ.setBackground(Color.BLACK);
		scrollPane.setViewportView(cartasListaJ);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		lblNewLabel.setBounds(-489, 114, 1526, 551);
		add(lblNewLabel);

		ArrayList<Carta> baraja = jugador.getBaraja();
		Collections.shuffle(baraja);
		for (byte i = 0; i < baraja.size(); i++) {
			cartasListaJ.add(new ListaCarta(ventana, baraja.get(i), jugador, rival));
		}

	}
	
	public PantallaCombate() {

	}

	public void pelear(Personaje jugador, Personaje rival, Carta elegida) {
		Random r = new Random();
		ArrayList<Carta> barajaR = rival.getBaraja();
		byte vidaJ = jugador.getVida();
		byte vidaR = rival.getVida();
		byte energiaR = rival.getEnergia();
		byte energiaJ = rival.getEnergia();

		System.out.println("Jugador_vida \t" + vidaJ);
		System.out.println("Jugador_energia \t" + energiaJ + "\n");
		System.out.println("Rival_vida \t" + vidaR);
		System.out.println("Rival_energia \t" + energiaR + "\n");

		Carta cartaRival = barajaR.get(r.nextInt(barajaR.size()));

		switch (cartaRival.getTipo()) {
		case "Especial":
			if (rival.getEnergia() >= cartaRival.getCosteEnergia()) {
				System.out.println("Rival se prepara para atacar con: " + cartaRival.getNombre());
				energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());
				System.out.println("La energía del rival se reduce a " + energiaR);
			} else {
				System.out.println("Energía insuficiente");
			}
			break;
		case "Ultimate":
			if (cartaRival.getCosteEnergia() > 0) {
				if (rival.getEnergia() >= cartaRival.getCosteEnergia()) {
					System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
					energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());
					System.out.println("La energía del rival se reduce a: " + energiaR);
				} else {
					System.out.println("Energía insuficiente");
				}
			} else if (cartaRival.getCosteVida() > 0) {
				if (rival.getVida() > cartaRival.getCosteVida()) {
					System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
					vidaR = (byte) (vidaR - cartaRival.getCosteVida());
					System.out.println("La vida del rival se reduce a: " + vidaR);
				} else {
					System.out.println("Vida insuficiente");
				}
			}
		}

		switch (elegida.getTipo()) {
		case "Especial":
			if (jugador.getEnergia() >= elegida.getCosteEnergia()) {
				System.out.println("Atacas con : " + elegida.getNombre());
				energiaJ = (byte) (energiaJ - elegida.getCosteEnergia());
				System.out.println("Tu energía se reduce a: " + energiaJ);
			} else {
				System.out.println("Energía insuficiente");
			}
			break;
		case "Ultimate":
			if (elegida.getCosteEnergia() > 0) {
				if (jugador.getEnergia() >= elegida.getCosteEnergia()) {
					System.out.println("Atacas con: " + elegida.getNombre());
					energiaJ = (byte) (energiaJ - elegida.getCosteEnergia());
					System.out.println("Tu energía se reduce a: " + energiaJ);
				} else {
					System.out.println("Energía insuficiente");
				}
			} else if (elegida.getCosteVida() > 0) {
				if (jugador.getVida() > elegida.getCosteVida()) {
					System.out.println("Te preparas para atacar con: " + elegida.getNombre());
					vidaJ = (byte) (vidaJ - elegida.getCosteVida());
					System.out.println("Tu vida se reduce a: " + vidaJ);
				} else {
					System.out.println("Vida insuficiente");
				}
			}
		}

		if (cartaRival.getVelocidad() > elegida.getVelocidad()) {
			if(cartaRival.getNombre().equals("Bloqueo")) {
				System.out.println("Tu rival está bloqueando, tu movimiento no surte efecto en él");
			}else {
				System.out.println("Tu rival es más rapido, lanza la carta: " + cartaRival.getNombre());
				vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
				System.out.println("Recibes " + cartaRival.getPuntosAtaque() + " de daño");
				System.out.println("Tu vida se reduce a: " + vidaJ);
			}
			
		} else if(elegida.getVelocidad() > cartaRival.getVelocidad()) {
			if(elegida.getNombre().equals("Bloqueo")) {
				System.out.println("Adoptas la pose de bloqueo, el ataque del rival no surte efecto");
			}else {
				System.out.println("Eres más rapido que el rival, golpeas con " + elegida.getNombre() + " y haces "
						+ elegida.getPuntosAtaque() + " puntos de daño");
				vidaR = (byte) (vidaR - elegida.getPuntosAtaque());
				System.out.println("La vida del rival se reduce a " + vidaR);
			}
			
		} else if(elegida.getVelocidad() == cartaRival.getVelocidad()) {
			System.out.println("EMPATE, vuestros puños chocan y no llegais a conectar un buen golpe.");
		}

		System.out.println("Se ha eliminado la " + cartaRival + " del mazo del rival" + "\n");
		barajaR.remove(cartaRival);

	}
}
