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
import java.io.File;
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
	private Personaje jugador;
	private Personaje rival;
	private String[] mapa;

	// CONSUMIBLES

	Consumible pEnergia = new PocionEnergia();
	Consumible pFuerza = new PocionFuerza();
	Consumible pVida = new PocionVida();

	// ESCENARIOS
	

	public PantallaCombate(Ventana v, Personaje jugador, Personaje rival) {
		this.ventana = v;
		setLayout(null);
		
		JPanel campoPosicion = new JPanel();
		campoPosicion.setBounds(25, 123, 741, 100);
		add(campoPosicion);

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
		CampoCombate playa = new CampoCombate("Playa enigmática");
		this.mapa = playa.generaMapa();
		for (byte i = 0; i < mapa.length; i++) {
			campoPosicion.add(new Mapa(ventana,mapa[i]));
		}


	}

	public PantallaCombate() {}

	

	public void pelear(Personaje jugador, Personaje rival, Carta elegida) {
		Random r = new Random();
		ArrayList<Carta> barajaR = rival.getBaraja();
		byte vidaJ = jugador.getVida();
		byte vidaR = rival.getVida();
		byte energiaR = rival.getEnergia();
		byte energiaJ = jugador.getEnergia();
		boolean energiaInsR = false;
		boolean vidaInsR = false;
		boolean energiaInsJ = false;
		boolean vidaInsJ = false;

		System.out.println("EMPIEZA EL COMBATE");

		System.out.println("Jugador_vida \t" + vidaJ);
		System.out.println("Jugador_energia \t" + energiaJ + "\n");
		System.out.println("Rival_vida \t" + vidaR);
		System.out.println("Rival_energia \t" + energiaR + "\n");

		Carta cartaRival = barajaR.get(r.nextInt(barajaR.size()));
		
		////////////OBTENIENDO INFORMACIÓN DE LA CARTA DEL JUGADOR

		if (elegida.getTipo().equals("Especial")) {
			if (energiaJ >= elegida.getCosteEnergia()) {
				System.out.println("Te preparas para atacar con: " + elegida.getNombre());
				energiaJ = (byte) (energiaJ - elegida.getCosteEnergia());

			} else {
				energiaInsJ = true;
			}
		}

		if (elegida.getTipo().equals("Ultimate")) {
			if (elegida.getCosteEnergia() > 0) {
				if (energiaJ >= elegida.getCosteEnergia()) {
					System.out.println("Te preparas para atacar con: " + elegida.getNombre());
					energiaJ = (byte) (energiaJ - elegida.getCosteEnergia());

				} else {
					energiaInsJ = true;
				}
			} else {
				if (vidaJ > elegida.getCosteVida()) {
					System.out.println("Te preparas para atacar con: " + elegida.getNombre());
					vidaJ = (byte) (vidaJ - elegida.getCosteVida());
					System.out.println("Pierdes " + elegida.getCosteVida() + " de vida por usar el movimiento");

				} else {
					vidaInsJ = true;
				}
			}
		}

		
		//////////////OBTENIENDO INFORMACIÓN DE LA CARTA DEL RIVAL

		if (cartaRival.getTipo().equals("Especial")) {
			if (energiaR >= cartaRival.getCosteEnergia()) {
				System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
				energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());

			} else {
				energiaInsR = true;
			}
		}

		if (cartaRival.getTipo().equals("Ultimate")) {
			if (cartaRival.getCosteEnergia() > 0) {
				if (energiaR >= cartaRival.getCosteEnergia()) {
					System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
					energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());

				} else {
					energiaInsR = true;
				}
			} else {
				if (vidaR > cartaRival.getCosteVida()) {
					System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
					vidaR = (byte) (vidaR - cartaRival.getCosteVida());
					System.out.println("El rival ha perdido " + cartaRival.getCosteVida() + " por usar su movimiento");

				} else {
					vidaInsR = true;
				}
			}
		}
		
		//INTERCAMBIO DE GOLPES JUGADOR

		if (vidaInsJ == true || energiaInsJ == true) {
			System.out.println("Coste insuficiente pierdes tu turno");
		} else {
			if (elegida.getVelocidad() > cartaRival.getVelocidad()) {
				if (elegida.getNombre().equals("Bloqueo")) {
					System.out.println("Adoptas pose de bloqueo, el ataque del rival no surte efecto");
				} else {
					System.out.println(
							"Atacas primero con " + elegida.getNombre() + " y haces " + elegida.getPuntosAtaque());
					vidaR = (byte) (vidaR - elegida.getPuntosAtaque());
				}

			}
			if (elegida.getVelocidad() <= cartaRival.getVelocidad() && (energiaInsR == true || vidaInsR == true)) {
				System.out.println("El rival no tiene fuerzas para ejecutar su movimiento, atacas primero con "
						+ elegida.getNombre());
				vidaR = (byte) (vidaR - elegida.getPuntosAtaque());
			}
			if (elegida.getVelocidad() == cartaRival.getVelocidad()) {
				System.out.println("Habeis usado movimientos con la misma velocidad, nadie recibe daño");
			}
		}
		
		//INTERCAMBIO DE GOLPES RIVAL

		if (vidaInsR == true || energiaInsR == true) {

		} else {
			if (cartaRival.getVelocidad() > elegida.getVelocidad()) {
				if (cartaRival.getNombre().equals("Bloqueo")) {
					System.out.println("El rival adopta pose de bloqueo, tu ataque no surte efecto");
				} else {
					System.out.println("El rival ataca primero con " + cartaRival.getNombre());
					vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
				}
			}
			if (cartaRival.getVelocidad() <= elegida.getVelocidad() && (energiaInsJ == true || vidaInsJ == true)) {
				System.out.println("No tienes fuerzas para ejecutar tu movimiento, el rival ataca con "
						+ cartaRival.getNombre() + " y te hace " + cartaRival.getPuntosAtaque() + " de daño.");
				vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
			}
		}

		System.out.println("\nFINAL DEL TURNO\n");

		System.out.println("Vida jugador: " + vidaJ);
		System.out.println("Energía jugador: " + energiaJ);
		System.out.println("Vida rival: " + vidaR);
		System.out.println("Energía rival: " + energiaR + "\n");

		System.out.println("Se ha eliminado la " + cartaRival + " del mazo del rival" + "\n");
		barajaR.remove(cartaRival);

	}
}
