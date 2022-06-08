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
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

public class PantallaCombate extends JPanel {
	private Ventana ventana;
	private String[] mapa;
	private byte vidaJ;
	private Carta cartaElegida;
	private Carta cartaRival;
	private byte vidaR;
	private byte energiaR;
	private byte energiaJ;
	private boolean energiaInsR = false;
	private boolean vidaInsR = false;
	private boolean energiaInsJ = false;
	private boolean vidaInsJ = false;
	private ArrayList<Carta> barajaRival;

	// CONSUMIBLES

	Consumible pEnergia = new PocionEnergia();
	Consumible pFuerza = new PocionFuerza();
	Consumible pVida = new PocionVida();

	// ESCENARIOS
	

	public PantallaCombate(final Ventana v, final Personaje jugador, final Personaje rival) {
		this.ventana = v;
		this.vidaJ = jugador.getVida();
		this.vidaR = rival.getVida();
		this.energiaJ = jugador.getEnergia();
		this.energiaR = rival.getEnergia();
		this.barajaRival = rival.getBaraja();
		
		jugador.setPosicion((byte)2);
		rival.setPosicion((byte)5);
		
		setLayout(null);
		
		JPanel campoMapa = new JPanel();
		campoMapa.setBounds(25, 123, 741, 100);
		add(campoMapa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 348, 741, 202);
		add(scrollPane);

		JPanel cartasListaJ = new JPanel();
		cartasListaJ.setForeground(Color.BLACK);
		cartasListaJ.setBorder(new EmptyBorder(3, 3, 3, 3));
		cartasListaJ.setBackground(Color.BLACK);
		scrollPane.setViewportView(cartasListaJ);
		cartasListaJ.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel personaje_Jugador = new JLabel(jugador.getNombre());
		personaje_Jugador.setHorizontalAlignment(SwingConstants.CENTER);
		personaje_Jugador.setForeground(Color.WHITE);
		personaje_Jugador.setFont(new Font("Personal Services", Font.BOLD, 16));
		personaje_Jugador.setBounds(0, 10, 125, 35);
		add(personaje_Jugador);
		
		final JLabel vidaJugador = new JLabel(String.valueOf(this.vidaJ));
		vidaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		vidaJugador.setForeground(Color.RED);
		vidaJugador.setFont(new Font("Personal Services", Font.PLAIN, 12));
		vidaJugador.setBounds(47, 44, 39, 31);
		add(vidaJugador);
		vidaJugador.repaint();
		
		JLabel energiaJugador = new JLabel(String.valueOf(this.energiaJ));
		energiaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		energiaJugador.setForeground(SystemColor.textHighlight);
		energiaJugador.setFont(new Font("Personal Services", Font.PLAIN, 12));
		energiaJugador.setBounds(47, 67, 39, 31);
		add(energiaJugador);
		
		JLabel personajeRival = new JLabel(rival.getNombre());
		personajeRival.setHorizontalAlignment(SwingConstants.CENTER);
		personajeRival.setForeground(Color.WHITE);
		personajeRival.setFont(new Font("Personal Services", Font.BOLD, 16));
		personajeRival.setBounds(654, 10, 125, 35);
		add(personajeRival);
		
		final JLabel vidaRival = new JLabel(String.valueOf(this.vidaR));
		vidaRival.setHorizontalAlignment(SwingConstants.CENTER);
		vidaRival.setForeground(Color.RED);
		vidaRival.setFont(new Font("Personal Services", Font.PLAIN, 12));
		vidaRival.setBounds(700, 44, 39, 31);
		add(vidaRival);
		
		JLabel energiaRival = new JLabel(String.valueOf(this.energiaR));
		energiaRival.setHorizontalAlignment(SwingConstants.CENTER);
		energiaRival.setForeground(SystemColor.textHighlight);
		energiaRival.setFont(new Font("Personal Services", Font.PLAIN, 12));
		energiaRival.setBounds(700, 67, 39, 31);
		add(energiaRival);

		JLabel fondoCartas = new JLabel("");
		fondoCartas.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		fondoCartas.setBounds(-489, 85, 1526, 580);
		add(fondoCartas);
		

		ArrayList<Carta> baraja = jugador.getBaraja();
		Collections.shuffle(baraja);
		ListaCarta cartita=null;

		for (byte i = 0; i < baraja.size(); i++) {
			cartita = new ListaCarta(baraja.get(i));
			cartasListaJ.add(cartita);
		}
				
		CampoCombate playa = new CampoCombate("Playa enigmática");
		this.mapa = playa.generaMapa(jugador.getPosicion(),rival.getPosicion());
		
		JButton imprimir = new JButton("Imprimir jugador y rival");
		imprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FileWriter rivales = new FileWriter("./combate_jugador_rival.txt",true);
					rivales.write("Personaje Jugador: "+jugador.getNombre()+"\nPersonaje Rival: "+rival.getNombre()+"\n\n");
					rivales.flush();
					rivales.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(v,"Este combate se ha impreso con éxito","Impresión realizada",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		imprimir.setBounds(308, 38, 141, 21);
		add(imprimir);
		
		JLabel manchaInfoR = new JLabel("");
		manchaInfoR.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\splat.png"));
		manchaInfoR.setBounds(250, -299, 1526, 580);
		add(manchaInfoR);
		
		JLabel manchaInfoP = new JLabel("");
		manchaInfoP.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\splat.png"));
		manchaInfoP.setBounds(-450, -300, 1526, 580);
		add(manchaInfoP);
		
		JButton btnNewButton = new JButton("Empezar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			byte[] vidas =pelear(jugador,rival,jugador.getBaraja().get(3));
			vidaJ = vidas[0];
			vidaR = vidas[1];
			System.out.println(vidaJ);
			vidaJugador.setText(String.valueOf(vidaJ));
			vidaRival.setText(String.valueOf(vidaR));
				
			}
		});
		btnNewButton.setBounds(330, 280, 85, 21);
		add(btnNewButton);
		
		
		for (byte i = 0; i < mapa.length; i++) {
			campoMapa.add(new Mapa(mapa[i]));
		}
		
		

		
	}

	//public PantallaCombate() {}


	public byte[] pelear(Personaje jugador, Personaje rival, Carta elegida) {
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
		byte[] vidas = {vidaJ,vidaR};
		return vidas;

	}
}
