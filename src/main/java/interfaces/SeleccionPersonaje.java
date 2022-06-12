package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import componentesVisuales.BotonAnimado;
import componentesVisuales.BotonAnimadoNegro;
import exceptions.ArchivoNoExisteException;
import main.Main;

import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

/**
 * Clase que nos permite elegir nuestro personaje y el del rival, en esta clase
 * usamos el m�todo definido en personaje llamado getTodos, el cual nos devuelve
 * un ArrayList con toda la lista de personajes disponibles, adem�s, en esta
 * clase utilizamos los argumentos de programa para realizar una selecci�n
 * autom�tica de personaje si se pulsa el bot�n de comenzar sin elegir ninguno.
 * 
 * @author toled
 *
 */
public class SeleccionPersonaje extends JPanel {
	/**
	 * La variable interna ventana nos permite utilizar el m�todo irAPantalla dentro
	 * del constructor de SeleccionPersonaje para cambiar de pantalla y mantener las
	 * caracter�sticas generales definidas en las clase Ventana
	 */
	private Ventana ventana;
	/**
	 * La variable jugador nos permite definir el personaje elegido por el jugador.
	 */
	private Personaje jugador;
	/**
	 * La variable rival nos permite definir el personaje elegido para el rival.
	 */
	private Personaje rival;
	/**
	 * En este array de String almacenamos los argumentos de programa definidos en
	 * la variable "args" de nuestro main.
	 */
	private String[] argumentosPersonaje;

	/**
	 * En este constructor definimos el aspecto de nuestra pantalla de seleccion de
	 * personaje, en ella hemos instroducido un JList al que le a�adimos todos los
	 * personajes disponibles gracias al m�todo getTodos presente en la clase
	 * Personaje, adem�s, en esta clase realizamos el requisito de argumentos de
	 * programa, en la variable argumentosPersonaje guardamos los argumentos que
	 * hayamos definido con el m�todo del main getArgs, luego de eso, mediante un
	 * m�todo mouseClicked en el bot�n comenzar, realizamos varios ifs y
	 * comprobaciones para comprobar si el usuario ha elegido personajes o no, si no
	 * ha elegido ninguno, y hay argumentos de programa definidos, se le mostrar� un
	 * JOption que le informar� que se proceder� a la selecci�n autom�tica de
	 * personajes, si hay argumentos pero mal definidos, se mostrar� una pantalla
	 * que informar� de ello, si no hay argumentos de programa y el usuario no elige
	 * ni jugador ni rival se mostrar� un JOptionaPane en el se indicar� un error de
	 * selecci�n e indicar� que debe elegirse un jugador y un rival para comenzar.
	 * 
	 * Adem�s, en esta pantalla hemos realizado la lectura de archivos, el cual nos
	 * leer� el .txt que contiene a los anteriores personajes que han ganado un
	 * combate, hemos a�adido una excepci�n para que si el archivo no existe a�n, el
	 * programa no reviente, si el archivo no existe se nos mostrar� un JOptionPane
	 * indic�ndonos que debemos imprimir los ganadores de al menos un combate para
	 * que se muestre algo
	 * 
	 * @param v par�metro que usamos para que esta pantalla comparta las
	 *          caracter�sticas generales de la clase ventana.
	 */
	public SeleccionPersonaje(final Ventana v) {
		this.argumentosPersonaje = Main.getArgs();
		this.ventana = v;
		setLayout(null);

		JLabel tituloPantalla = new JLabel("SELECCI\u00D3N DE PERSONAJE");
		tituloPantalla.setFont(new Font("Personal Services", Font.PLAIN, 45));
		tituloPantalla.setForeground(Color.WHITE);
		tituloPantalla.setBounds(20, 10, 725, 99);
		add(tituloPantalla);

		JLabel versus = new JLabel("VS");
		versus.setForeground(Color.BLACK);
		versus.setHorizontalAlignment(SwingConstants.CENTER);
		versus.setFont(new Font("Personal Services", Font.PLAIN, 55));
		versus.setBounds(300, 271, 192, 91);
		add(versus);

		JLabel riv_title = new JLabel("RIVAL");
		riv_title.setHorizontalAlignment(SwingConstants.CENTER);
		riv_title.setForeground(Color.BLACK);
		riv_title.setFont(new Font("Personal Services", Font.PLAIN, 45));
		riv_title.setBounds(497, 139, 248, 71);
		add(riv_title);

		JLabel jug_title = new JLabel("JUGADOR");
		jug_title.setHorizontalAlignment(SwingConstants.CENTER);
		jug_title.setForeground(Color.BLACK);
		jug_title.setFont(new Font("Personal Services", Font.PLAIN, 45));
		jug_title.setBounds(59, 139, 248, 71);
		add(jug_title);

		// LISTA JUGADOR

		JScrollPane scrollJugador = new JScrollPane();
		scrollJugador.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		scrollJugador.setBounds(8, 220, 347, 195);
		add(scrollJugador, BorderLayout.CENTER);
		scrollJugador.setFocusable(false);

		final JList lista_Jugador = new JList();
		scrollJugador.setViewportView(lista_Jugador);
		lista_Jugador.setFocusable(false);

		final ArrayList<String> todosJugador = Personaje.getTodos();
		lista_Jugador.setModel(new AbstractListModel() {
			public int getSize() {
				return todosJugador.size();
			}

			public Object getElementAt(int index) {
				return todosJugador.get(index);
			}

		});

		// LISTA RIVAL

		JScrollPane scrollRival = new JScrollPane();
		scrollRival.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		scrollRival.setBounds(433, 220, 347, 195);
		add(scrollRival, BorderLayout.CENTER);

		final JList lista_Rival = new JList();
		scrollRival.setViewportView(lista_Rival);
		lista_Jugador.setFocusable(false);

		final ArrayList<String> todosRival = Personaje.getTodos();
		lista_Rival.setModel(new AbstractListModel() {
			public int getSize() {
				return todosRival.size();
			}

			public Object getElementAt(int index) {
				return todosRival.get(index);
			}

		});

		// BOTONES

		JButton ATRAS = new BotonAnimadoNegro("ATR\u00C1S");
		ATRAS.setForeground(Color.BLACK);
		ATRAS.setBounds(31, 506, 119, 38);
		add(ATRAS);
		ATRAS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("MenuPrincipal");
			}
		});
		/**
		 * En este bot�n se encuentran todas las acciones que realizamos con los
		 * argumentos de programa.
		 */
		JButton COMENZAR = new BotonAnimadoNegro("ATR\u00C1S");
		COMENZAR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (lista_Jugador.getSelectedValue() != null && lista_Rival.getSelectedValue() != null) {
					String nombreJ = (String) lista_Jugador.getSelectedValue();
					jugador = new Personaje(nombreJ);
					String nombreR = (String) lista_Rival.getSelectedValue();
					rival = new Personaje(nombreR);
					ventana.irAPantalla("PantallaCombate", jugador, rival);

				} else if (lista_Jugador.getSelectedValue() == null && lista_Rival.getSelectedValue() == null
						&& (argumentosPersonaje.length == 0 || argumentosPersonaje.length <= 3
								|| argumentosPersonaje.length > 4)
						|| (lista_Jugador.getSelectedValue() == null && lista_Rival.getSelectedValue() != null)
						|| (lista_Jugador.getSelectedValue() != null && lista_Rival.getSelectedValue() == null)) {
					JOptionPane.showMessageDialog(v,
							"Se debe elegir tanto un personaje para el jugador como para el rival.",
							"ERROR DE SELECCI�N", JOptionPane.ERROR_MESSAGE);
				}
				if (lista_Jugador.getSelectedValue() == null && lista_Rival.getSelectedValue() == null
						&& argumentosPersonaje.length == 4) {
					String jugadorArg = "";
					String rivalArg = "";
					for (byte i = 0; i < argumentosPersonaje.length; i++) {
						if (argumentosPersonaje[i].equals("-jugador")) {
							jugadorArg = argumentosPersonaje[i + 1];
						}
						if (argumentosPersonaje[i].equals("-rival")) {
							rivalArg = argumentosPersonaje[i + 1];
						}

					}

					JOptionPane.showMessageDialog(v,
							"El jugador no ha elegido ning�n personaje ni ning�n rival se proceder� a la selecci�n autom�tica por argumentos.",
							"SELECCI�N POR ARGUMENTOS", JOptionPane.INFORMATION_MESSAGE);

					jugador = new Personaje(jugadorArg);
					rival = new Personaje(rivalArg);
					ventana.irAPantalla("PantallaCombate", jugador, rival);
				}

				if ((argumentosPersonaje.length == 0 || argumentosPersonaje.length <= 3
						|| argumentosPersonaje.length > 4) && lista_Jugador.getSelectedValue() == null
						&& lista_Rival.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(v,
							"No hay argumentos disponibles, son insuficientes o has puesto demasiados para la selecci�n, por favor elije un personaje jugador y rival.",
							"ERROR SELECCI�N POR ARGUMENTOS", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		/**
		 * Bot�n en el que usamos el BufferedReader, dentro de �l introducimos un File
		 * con la ruta del archivo que hemos generado en la pantalla Resultado, si
		 * existe, nos leer� el archivo, sino, saltar� un JOptionPane con el mensaje de
		 * la excepci�n que hemos programado
		 */
		BotonAnimado leerFichero = new BotonAnimado("ATR\u00C1S");
		leerFichero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BufferedReader lector;
				File archivoTexto = new File("./ganadores_combate.txt");

				try {
					if (archivoTexto.exists()) {
						lector = new BufferedReader(new FileReader(archivoTexto));
						String linea = lector.readLine();
						String texto = "";
						while (linea != null) {
							texto = texto + linea + "\n";
							linea = lector.readLine();
						}
						JOptionPane.showMessageDialog(v, texto, "Impresi�n de ganadores", JOptionPane.DEFAULT_OPTION);
					} else {
						throw new ArchivoNoExisteException(
								"El archivo a�n no existe, libra un combate e imprime al ganador en la pantalla resultado");

					}

				} catch (IOException | ArchivoNoExisteException e1) {
					JOptionPane.showMessageDialog(v, e1.getMessage(), "ARCHIVO NO EXISTE", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		leerFichero.setText("LEER FICHERO DE GANADORES");
		leerFichero.setForeground(Color.WHITE);
		leerFichero.setBounds(218, 506, 332, 38);
		add(leerFichero);
		COMENZAR.setText("COMENZAR");
		COMENZAR.setForeground(Color.BLACK);
		COMENZAR.setBounds(613, 506, 142, 38);
		add(COMENZAR);

		// IM�GENES

		JLabel MANCHA = new JLabel("");
		MANCHA.setIcon(new ImageIcon("./background/manchaBlanca.png"));
		MANCHA.setBounds(461, 425, 536, 151);
		add(MANCHA);

		JLabel MANCHA_1 = new JLabel("");
		MANCHA_1.setIcon(new ImageIcon("./background/manchaBlancaInv.png"));
		MANCHA_1.setBounds(-328, 425, 536, 151);
		add(MANCHA_1);

		JLabel FONDO = new JLabel("");
		FONDO.setIcon(new ImageIcon("./background/character_select.png"));
		FONDO.setBounds(0, 0, 800, 576);
		add(FONDO);

	}
}
