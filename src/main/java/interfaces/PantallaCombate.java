package interfaces;

import javax.swing.JPanel;

import clases.CampoCombate;
import clases.Carta;
import clases.Consumible;
import clases.Personaje;
import clases.PocionEnergia;
import clases.PocionFuerza;
import clases.PocionVida;
import componentesVisuales.BotonAnimado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
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
	private CampoCombate mapa;
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
	private byte posicionJ;
	private byte posicionR;
	private ArrayList<Carta> barajaRival;
	private ArrayList<Carta> barajaJugador;
	private byte distanciaJugadores;
	private byte turnos;

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
		this.posicionJ = 2;
		this.posicionR = 5;
		this.turnos = 1;

		jugador.setPosicion((byte) 2);
		rival.setPosicion((byte) 5);

		setLayout(null);

		final JPanel campoMapa = new JPanel();
		campoMapa.setBounds(32, 113, 734, 103);
		add(campoMapa);

		JScrollPane scrollCarta = new JScrollPane();
		scrollCarta.setBounds(25, 348, 741, 202);
		add(scrollCarta);

		JPanel cartasListaJ = new JPanel();
		cartasListaJ.setForeground(Color.BLACK);
		cartasListaJ.setBorder(new EmptyBorder(3, 3, 3, 3));
		cartasListaJ.setBackground(Color.BLACK);
		scrollCarta.setViewportView(cartasListaJ);
		cartasListaJ.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		if (jugador.getNombre().equals(rival.getNombre())) {
			jugador.setNombre(jugador.getNombre() + " (J)");
			rival.setNombre(rival.getNombre() + " (R)");

		}
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

		final JLabel energiaJugador = new JLabel(String.valueOf(this.energiaJ));
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

		final JLabel energiaRival = new JLabel(String.valueOf(this.energiaR));
		energiaRival.setHorizontalAlignment(SwingConstants.CENTER);
		energiaRival.setForeground(SystemColor.textHighlight);
		energiaRival.setFont(new Font("Personal Services", Font.PLAIN, 12));
		energiaRival.setBounds(700, 67, 39, 31);
		add(energiaRival);

		JButton usarCarta = new BotonAnimado("USAR CARTA");
		usarCarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random r = new Random();
				if (cartaElegida != null) {

					System.out.println("\n-------------TURNO: " + turnos + "-------------\n");

					cartaRival = barajaRival.get(r.nextInt(barajaRival.size()));

					//////////// OBTENIENDO INFORMACIÓN DE LA CARTA DEL JUGADOR

					if (cartaElegida.getTipo().equals("Especial")) {
						if (energiaJ >= cartaElegida.getCosteEnergia()) {
							System.out.println("Te preparas para atacar con: " + cartaElegida.getNombre());
							energiaJ = (byte) (energiaJ - cartaElegida.getCosteEnergia());
							energiaJugador.setText(String.valueOf(energiaJ));

						} else {
							energiaInsJ = true;
						}
					}

					if (cartaElegida.getTipo().equals("Ultimate")) {
						if (cartaElegida.getCosteEnergia() > 0) {
							if (energiaJ >= cartaElegida.getCosteEnergia()) {
								System.out.println("Te preparas para atacar con: " + cartaElegida.getNombre());
								energiaJ = (byte) (energiaJ - cartaElegida.getCosteEnergia());
								energiaJugador.setText(String.valueOf(energiaJ));

							} else {
								energiaInsJ = true;
							}
						} else {
							if (vidaJ > cartaElegida.getCosteVida()) {
								System.out.println("Te preparas para atacar con: " + cartaElegida.getNombre());
								vidaJ = (byte) (vidaJ - cartaElegida.getCosteVida());
								System.out.println(
										"Pierdes " + cartaElegida.getCosteVida() + " de vida por usar el movimiento");
								vidaJugador.setText(String.valueOf(vidaJ));
							} else {
								vidaInsJ = true;
							}
						}
					}

					////////////// OBTENIENDO INFORMACIÓN DE LA CARTA DEL RIVAL

					if (cartaRival.getTipo().equals("Especial")) {
						if (energiaR >= cartaRival.getCosteEnergia()) {
							System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
							energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());
							energiaRival.setText(String.valueOf(energiaR));

						} else {
							energiaInsR = true;
						}
					}

					if (cartaRival.getTipo().equals("Ultimate")) {
						if (cartaRival.getCosteEnergia() > 0) {
							if (energiaR >= cartaRival.getCosteEnergia()) {
								System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
								energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());
								energiaRival.setText(String.valueOf(energiaR));

							} else {
								energiaInsR = true;
							}
						} else {
							if (vidaR > cartaRival.getCosteVida()) {
								System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
								vidaR = (byte) (vidaR - cartaRival.getCosteVida());
								System.out.println(
										"El rival ha perdido " + cartaRival.getCosteVida() + " por usar su movimiento");
								vidaRival.setText(String.valueOf(vidaR));

							} else {
								vidaInsR = true;
							}
						}
					}
					
					distanciaJugadores = (byte) (posicionJ - posicionR);
					if (distanciaJugadores < 0) {
						distanciaJugadores = (byte) (distanciaJugadores * -1);
					}

					if (cartaElegida.getVelocidad() == cartaRival.getVelocidad()
							&& cartaElegida.getAlcance() == distanciaJugadores
							&& cartaRival.getAlcance() == distanciaJugadores) {
						System.out.println(
								"Habeis usado movimientos con la misma velocidad y mismo rango, nadie recibe daño");
					}
					if (cartaElegida.getVelocidad() == cartaRival.getVelocidad()
							&& cartaElegida.getAlcance() >= distanciaJugadores
							&& cartaRival.getAlcance() < distanciaJugadores) {
						System.out.println(
								"Habeis usado movimientos con la misma velocidad pero tu movimiento tiene más alcance que el del rival, tu ataque impacta");
						vidaR = (byte) (vidaR - cartaElegida.getPuntosAtaque());
						if (vidaR <= 0) {
							vidaR = 0;
							vidaRival.setText(String.valueOf(vidaR));
							JOptionPane.showMessageDialog(v, "¡Tu rival ha caido! Eres el ganador de este combate",
									"GANAS", JOptionPane.INFORMATION_MESSAGE);
							ventana.irAPantalla("Resultado", jugador.getNombre());
						} else {
							vidaRival.setText(String.valueOf(vidaR));
						}
					}
					
					if (cartaElegida.getVelocidad() == cartaRival.getVelocidad()
							&& cartaRival.getAlcance() >= distanciaJugadores
							&& cartaElegida.getAlcance() < distanciaJugadores) {
						System.out.println(
								"Habeis usado movimientos con la misma velocidad pero el movimiento de tu rival tiene más alcance que el tuyo, su ataque impacta");
						vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
						if (vidaJ <= 0) {
							vidaJ = 0;
							vidaJugador.setText(String.valueOf(vidaJ));
							JOptionPane.showMessageDialog(v, "¡Has caido! Tu rival es el ganador", "PIERDES",
									JOptionPane.INFORMATION_MESSAGE);
							ventana.irAPantalla("Resultado", rival.getNombre());
						} else {
							vidaJugador.setText(String.valueOf(vidaJ));
						}
					}

					////////////// INTERCAMBIO DE GOLPES JUGADOR

					

					if (vidaInsJ == true || energiaInsJ == true) {
						System.out.println("Coste insuficiente pierdes tu turno");
					} else {

						System.out.println("Usas la carta " + cartaElegida.getNombre() + " de daño "
								+ cartaElegida.getPuntosAtaque() + " y de velociad " + cartaElegida.getVelocidad()
								+ "\n");
						System.out.println("Tu rival usa la carta: " + cartaRival.getNombre() + " de daño "
								+ cartaRival.getPuntosAtaque() + " y de velociad " + cartaRival.getVelocidad() + "\n");

						if (cartaElegida.getNombre().equals("Bloqueo")) {

							System.out.println("Adoptas pose de bloqueo, el ataque del rival no surte efecto");

						} else if ((cartaElegida.getVelocidad() > cartaRival.getVelocidad())) {
							if (cartaElegida.getAlcance() >= distanciaJugadores) {
								System.out.println("Atacas primero con " + cartaElegida.getNombre() + " y haces "
										+ cartaElegida.getPuntosAtaque());
								vidaR = (byte) (vidaR - cartaElegida.getPuntosAtaque());
								if (vidaR <= 0) {
									vidaR = 0;
									vidaRival.setText(String.valueOf(vidaR));
									JOptionPane.showMessageDialog(v,
											"¡Tu rival ha caido! Eres el ganador de este combate", "GANAS",
											JOptionPane.INFORMATION_MESSAGE);
									ventana.irAPantalla("Resultado", jugador.getNombre());
								} else {
									vidaRival.setText(String.valueOf(vidaR));
								}
							} else {
								System.out.println(
										"Rango insuficiente tu carta " + cartaElegida.getNombre() + " no impacta");
								System.out.println(cartaElegida.getAlcance());
								System.out.println(distanciaJugadores);
								if (cartaRival.getAlcance() >= distanciaJugadores
										&& (vidaInsR == false || energiaInsR == false)) {
									System.out.println("La carta del rival " + cartaElegida.getNombre() + " impacta");
									vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
									if (vidaJ <= 0) {
										vidaJ = 0;
										vidaJugador.setText(String.valueOf(vidaJ));
										JOptionPane.showMessageDialog(v, "¡Has caido! tu rival ha ganado el combate",
												"PIERDES", JOptionPane.INFORMATION_MESSAGE);
										ventana.irAPantalla("Resultado", rival.getNombre());
									} else {
										vidaJugador.setText(String.valueOf(vidaJ));
									}
								}

							}

						}

						if (cartaElegida.getVelocidad() <= cartaRival.getVelocidad()
								&& (energiaInsR == true || vidaInsR == true)) {
							System.out.println(
									"El rival no tiene fuerzas para ejecutar su movimiento, atacas primero con \n"
											+ cartaElegida.getNombre());
							if (cartaElegida.getAlcance() >= distanciaJugadores) {
								vidaR = (byte) (vidaR - cartaElegida.getPuntosAtaque());
								if (vidaR <= 0) {
									vidaR = 0;
									vidaRival.setText(String.valueOf(vidaR));
									JOptionPane.showMessageDialog(v,
											"¡Tu rival ha caido! Eres el ganador de este combate", "GANAS",
											JOptionPane.INFORMATION_MESSAGE);
									ventana.irAPantalla("Resultado", jugador.getNombre());
								} else {
									vidaRival.setText(String.valueOf(vidaR));
								}
							} else {
								System.out.println("Tu carta " + cartaElegida.getNombre() + " no impacta");
								System.out.println(cartaElegida.getAlcance());
								System.out.println(distanciaJugadores);

							}

						}
					}

					////////////// INTERCAMBIO DE GOLPES RIVAL

					if (vidaInsR == true || energiaInsR == true) {

					} else {
						if (cartaRival.getNombre().equals("Bloqueo")) {
							System.out.println("Tu rival adopta la pose de bloqueo, tu ataque no hace daño");
						} else if ((cartaRival.getVelocidad() > cartaElegida.getVelocidad())) {
							if (cartaRival.getAlcance() >= distanciaJugadores) {
								System.out.println("Tu rival ataca primero con " + cartaRival.getNombre()
										+ " y te hace " + cartaRival.getPuntosAtaque());
								vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
								if (vidaJ <= 0) {
									vidaJ = 0;
									vidaJugador.setText(String.valueOf(vidaJ));
									JOptionPane.showMessageDialog(v, "¡Has caido! Tu rival es el ganador del combate",
											"PIERDES", JOptionPane.INFORMATION_MESSAGE);
									ventana.irAPantalla("Resultado", rival.getNombre());
								} else {
									vidaJugador.setText(String.valueOf(vidaJ));
								}
							} else {
								System.out.println("Rango insuficiente la carta del rival " + cartaRival.getNombre()
										+ " no impacta");
								System.out.println(cartaRival.getAlcance());
								System.out.println(distanciaJugadores);
								if ((cartaElegida.getAlcance() >= distanciaJugadores)
										&& (vidaInsJ == false || energiaInsJ == false)) {
									System.out.println("Tu carta " + cartaElegida.getNombre() + " impacta");
									vidaR = (byte) (vidaR - cartaElegida.getPuntosAtaque());
									if (vidaR <= 0) {
										vidaR = 0;
										vidaRival.setText(String.valueOf(vidaR));
										JOptionPane.showMessageDialog(v, "¡Tu rival ha caido! has ganado el combate",
												"GANAS", JOptionPane.INFORMATION_MESSAGE);
										ventana.irAPantalla("Resultado", jugador.getNombre());
									} else {
										vidaRival.setText(String.valueOf(vidaR));
									}
								}

							}

						}

						if (cartaRival.getVelocidad() < cartaElegida.getVelocidad()
								&& (energiaInsJ == true || vidaInsJ == true)) {
							System.out.println("Estas exahusto y no puedes realizar el movimiento, tu rival ataca con "
									+ cartaRival.getNombre());
							if (cartaRival.getAlcance() >= distanciaJugadores) {
								vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
								if (vidaJ <= 0) {
									vidaJ = 0;
									vidaJugador.setText(String.valueOf(vidaJ));
									JOptionPane.showMessageDialog(v, "¡Has caido! Tu rival es el ganador del combate",
											"GANAS", JOptionPane.INFORMATION_MESSAGE);
									ventana.irAPantalla("Resultado", rival.getNombre());
								} else {
									vidaJugador.setText(String.valueOf(vidaJ));
								}
							} else {
								System.out.println("Rango insficiente la carta del rival " + cartaRival.getNombre()
										+ " no impacta");
								System.out.println(cartaRival.getAlcance());
								System.out.println(distanciaJugadores);

							}

						}
					}

					barajaRival.remove(cartaRival);
					barajaJugador.remove(cartaElegida);

					cartaElegida = null;
				} else {
					JOptionPane.showMessageDialog(v, "Debes elegir una carta primero para usarla",
							"ERROR DE SELECCIÓN DE CARTA", JOptionPane.ERROR_MESSAGE);
				}

				turnos++;

			}
		});

		this.mapa = new CampoCombate("Playa Enigmática", this.posicionJ, this.posicionR);

		for (byte i = 0; i < mapa.getMapa().length; i++) {
			campoMapa.add(new Mapa(mapa.getMapa()[i]));
		}

		JButton derecha = new JButton("Derecha");
		derecha.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Random r = new Random();
				campoMapa.removeAll();
				posicionJ++;
				if (posicionJ > 7) {
					posicionJ = 7;
				}
				if (posicionJ == posicionR) {
					posicionJ = (byte) (posicionJ + 1);
				}
				mapa = new CampoCombate("Playa Enigmática", posicionJ, posicionR);

				for (byte i = 0; i < mapa.getMapa().length; i++) {
					campoMapa.add(new Mapa(mapa.getMapa()[i]));
				}
				campoMapa.revalidate();

				// OBTENIENDO INFROMACIÓN DE LA CARTA DEL RIVAL

				System.out.println("\n-------------TURNO: " + turnos + "-------------\n");

				cartaRival = barajaRival.get(r.nextInt(barajaRival.size()));

				if (cartaRival.getTipo().equals("Especial")) {
					if (energiaR >= cartaRival.getCosteEnergia()) {
						System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
						energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());
						energiaRival.setText(String.valueOf(energiaR));

					} else {
						energiaInsR = true;
					}
				}

				if (cartaRival.getTipo().equals("Ultimate")) {
					if (cartaRival.getCosteEnergia() > 0) {
						if (energiaR >= cartaRival.getCosteEnergia()) {
							System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
							energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());
							energiaRival.setText(String.valueOf(energiaR));

						} else {
							energiaInsR = true;
						}
					} else {
						if (vidaR > cartaRival.getCosteVida()) {
							System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
							vidaR = (byte) (vidaR - cartaRival.getCosteVida());
							System.out.println(
									"El rival ha perdido " + cartaRival.getCosteVida() + " por usar su movimiento");
							vidaRival.setText(String.valueOf(vidaR));

						} else {
							vidaInsR = true;
						}
					}
				}

				// EL RIVAL ATACA

				if (vidaInsR == true || energiaInsR == true) {

				} else {

					distanciaJugadores = (byte) (posicionJ - posicionR);
					if (distanciaJugadores < 0) {
						distanciaJugadores = (byte) (distanciaJugadores * -1);
					}
					if (cartaRival.getNombre().equals("Bloqueo")) {
						System.out.println("El rival adopta pose de bloqueo");
					} else if (cartaRival.getAlcance() >= distanciaJugadores) {
						System.out.println("El rival ataca con " + cartaRival.getNombre());
						vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
						vidaJugador.setText(String.valueOf(vidaJ));
						if (vidaJ <= 0) {
							vidaJ = 0;
							vidaJugador.setText(String.valueOf(vidaJ));
							JOptionPane.showMessageDialog(v, "¡Has caido! Tu rival ha ganado el combate", "PIERDES",
									JOptionPane.INFORMATION_MESSAGE);
							ventana.irAPantalla("Resultado", rival.getNombre());
						} else {
							vidaJugador.setText(String.valueOf(vidaJ));
						}

					} else {
						System.out.println("Rango insuficiente, el ataque " + cartaRival.getNombre() + " falla");
						System.out.println(distanciaJugadores);
					}

				}

				barajaRival.remove(cartaRival);
				turnos++;
			}
		});
		derecha.setBounds(604, 263, 175, 75);
		add(derecha);

		JButton izquierda = new JButton("Izquierda");
		izquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random r = new Random();
				campoMapa.removeAll();
				posicionJ--;
				if (posicionJ < 0) {
					posicionJ = 0;
				}
				if (posicionJ == posicionR) {
					posicionJ = (byte) (posicionJ - 1);
				}
				mapa = new CampoCombate("Playa Enigmática", posicionJ, posicionR);

				for (byte i = 0; i < mapa.getMapa().length; i++) {
					campoMapa.add(new Mapa(mapa.getMapa()[i]));
				}
				campoMapa.revalidate();

				// OBTENIENDO INFROMACIÓN DE LA CARTA DEL RIVAL

				System.out.println("\n-------------TURNO: " + turnos + "-------------\n");

				cartaRival = barajaRival.get(r.nextInt(barajaRival.size()));

				if (cartaRival.getTipo().equals("Especial")) {
					if (energiaR >= cartaRival.getCosteEnergia()) {
						System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
						energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());
						energiaRival.setText(String.valueOf(energiaR));

					} else {
						energiaInsR = true;
					}
				}

				if (cartaRival.getTipo().equals("Ultimate")) {
					if (cartaRival.getCosteEnergia() > 0) {
						if (energiaR >= cartaRival.getCosteEnergia()) {
							System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
							energiaR = (byte) (energiaR - cartaRival.getCosteEnergia());
							energiaRival.setText(String.valueOf(energiaR));

						} else {
							energiaInsR = true;
						}
					} else {
						if (vidaR > cartaRival.getCosteVida()) {
							System.out.println("El rival se prepara para atacar con: " + cartaRival.getNombre());
							vidaR = (byte) (vidaR - cartaRival.getCosteVida());
							System.out.println(
									"El rival ha perdido " + cartaRival.getCosteVida() + " por usar su movimiento");
							vidaRival.setText(String.valueOf(vidaR));

						} else {
							vidaInsR = true;
						}
					}
				}

				// EL RIVAL ATACA

				if (vidaInsR == true || energiaInsR == true) {

				} else {

					distanciaJugadores = (byte) (posicionJ - posicionR);
					if (distanciaJugadores < 0) {
						distanciaJugadores = (byte) (distanciaJugadores * -1);
					}
					if (cartaRival.getNombre().equals("Bloqueo")) {
						System.out.println("El rival adopta pose de bloqueo");
					} else if (cartaRival.getAlcance() >= distanciaJugadores) {
						System.out.println("El rival ataca con " + cartaRival.getNombre());
						vidaJ = (byte) (vidaJ - cartaRival.getPuntosAtaque());
						vidaJugador.setText(String.valueOf(vidaJ));
						if (vidaJ <= 0) {
							vidaJ = 0;
							vidaJugador.setText(String.valueOf(vidaJ));
							JOptionPane.showMessageDialog(v, "¡Has caido! Tu rival ha ganado el combate", "PIERDES",
									JOptionPane.INFORMATION_MESSAGE);
							ventana.irAPantalla("Resultado", rival.getNombre());
						} else {
							vidaJugador.setText(String.valueOf(vidaJ));
						}

					} else {
						System.out.println("Rango insuficiente, el ataque " + cartaRival.getNombre() + " falla");
						System.out.println(distanciaJugadores);
					}

				}

				barajaRival.remove(cartaRival);
				turnos++;
			}
		});
		izquierda.setBounds(10, 263, 175, 75);
		add(izquierda);
		usarCarta.setBounds(299, 291, 170, 21);
		add(usarCarta);

		JLabel fondoCartas = new JLabel("");
		fondoCartas.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		fondoCartas.setBounds(-489, 85, 1526, 580);
		add(fondoCartas);

		barajaJugador = jugador.getBaraja();
		Collections.shuffle(barajaJugador);
		ListaCarta cartita = null;

		for (byte i = 0; i < barajaJugador.size(); i++) {
			cartita = new ListaCarta(barajaJugador.get(i), this);
			cartasListaJ.add(cartita);
		}

		JButton imprimir = new JButton("Imprimir jugador y rival");
		imprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FileWriter rivales = new FileWriter("./combate_jugador_rival.txt", true);
					rivales.write("Personaje Jugador: " + jugador.getNombre() + "\nPersonaje Rival: "
							+ rival.getNombre() + "\n\n");
					rivales.flush();
					rivales.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(v, "Este combate se ha impreso con éxito", "Impresión realizada",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		imprimir.setBounds(308, 38, 141, 21);
		add(imprimir);

		JLabel manchaInfoR = new JLabel("");
		manchaInfoR.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\splat.png"));
		manchaInfoR.setBounds(250, -299, 1526, 580);
		add(manchaInfoR);

		JLabel manchaInfoP = new JLabel("");
		manchaInfoP.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\splat.png"));
		manchaInfoP.setBounds(-450, -300, 1526, 580);
		add(manchaInfoP);

		JLabel manchita = new JLabel("");
		manchita.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha_small.png"));
		manchita.setBounds(85, 120, 576, 312);
		add(manchita);

	}

	public void setCartaElegida(Carta cartaElegida) {
		this.cartaElegida = cartaElegida;
	}

	public Carta getCartaElegida() {
		return cartaElegida;
	}
}
