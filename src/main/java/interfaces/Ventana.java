package interfaces;

import java.awt.Cursor;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.CampoCombate;
import clases.Carta;
import clases.Consumible;
import clases.Personaje;
import clases.PocionEnergia;
import clases.PocionFuerza;
import clases.PocionVida;

/**
 * Clase en la que se definen las caracter�sticas generales de nuestras
 * pantallas y aporta el m�todo irAPantalla que nos permitir� intercambiar entre
 * pantallas.
 * 
 * @author toled
 *
 */
public class Ventana extends JFrame {
	// ESTA VARIABLE NOS SERVIR� EN EL M�TODO "irAPantalla" PARA HACER QUE LA
	// VENTANA QUE SE ESTA EJECUTANDO ACTUALMENTE CAMBIE A NULL Y SE PUEDA
	// INTERCAMBIAR POR OTRA VENTANA DISTINTA.
	private JPanel pantallaActual;

	// CANCIONES

	// CON ESTE OBJETO SOUND LLAMO A LOS M�TODOS DE LA CLASE SOUND: loop, play o
	// stop.
	Sound sound = new Sound();

	// RUTA DE LAS CANCIONES PARA CADA PANTALLA
	File selector = new File("./songs/selector.wav");
	File main_title = new File("./songs/main_title.wav");
	File combate_playa = new File("./songs/combate_playa.wav");
	File instrucciones = new File("./songs/instrucciones.wav");
	
	

	/**
	 * Constructor que nos permite definir las propiedades generales de las
	 * pantallas con las que queremos trabajar, en este constructor definimos cual
	 * ser� la pantalla principal de nuestro proyecto que guardaremos en
	 * pantallaActual para luego modificar valores en el m�todo irAPantalla, en este
	 * constructor tambi�n definimos la canci�n de fondo de la pantalla principal y
	 * dem�s propiedades.
	 */
	public Ventana() {
		sound.loop(main_title);
		this.setTitle("Card Fighters");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./icon/punch.png").getImage());
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pantallaActual = new PantallaTitulo(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
	}

	/**
	 * M�todo para intercambiar pantallas, gracias a nuestra variable interna
	 * pantallaActual, pantallaActual tendr� en su interior la pantalla de la que
	 * queremos salir por lo que en el m�todo la ponemos en setVisible(false) para
	 * que desaparezca y la igualamos a null. Luego en un switch mediante un String
	 * que contendr� el nombre de la pantalla a la que queremos ir creamos varios
	 * "cases" para cada pantalla que tengamos disponible, en cada case instanciamos
	 * en pantallaActual la pantalla a la que nos queremos dirigir junto con la
	 * propia clase Ventana (this) para que las caracter�sticas definidas en el
	 * constructor se mantengan de una pantalla a otra. Luego de esto, fuera del
	 * switch, indicamos el setVisible(True) y el contentPane(pantallaActual) que ya
	 * tendr� el valor de la pantalla de destino.
	 * 
	 * @param nombrePantalla Par�metro por el cual indicamos la pantalla de destino.
	 */
	public void irAPantalla(String nombrePantalla) {

		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;
		switch (nombrePantalla) {

		case "PantallaTitulo":
			this.pantallaActual = new PantallaTitulo(this);

			break;

		case "MenuPrincipal":
			sound.stop();
			sound.loop(main_title);
			this.pantallaActual = new MenuPrincipal(this);

			break;

		case "SeleccionPersonaje":
			sound.stop();
			this.pantallaActual = new SeleccionPersonaje(this);
			sound.loop(selector);
			break;
			
		case "Instrucciones":
			sound.stop();
			this.pantallaActual = new Instrucciones(this);
			sound.loop(instrucciones);

		default:
			break;
		}

		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);

	}

	/**
	 * M�todo que cumple la misma funci�n que el anterior, en este a�ado dos
	 * argumentos de tipo Personaje referenciando al jugador y al rival debido a que
	 * es necesario transferir estos dos objetos a la pantalla PantallaCombate para
	 * operar con las variables internas de los personajes que el usuario elige,
	 * este m�todo es llamado en SeleccionPersonaje y ah� se definen qu� personaje
	 * elige el jugador y qu� personaje es el rival.
	 * 
	 * @param nombrePantalla Par�metro por el cual indicamos la pantalla de destino.
	 * @param jugador        Personaje elegido por el jugador en la pantalla
	 *                       SeleccionPersonaje.
	 * @param rival          Personaje elegido para el rival en la pantalla
	 *                       SeleccionPersonaje.
	 */

	public void irAPantalla(String nombrePantalla, Personaje jugador, Personaje rival) {

		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;
		switch (nombrePantalla) {

		case "PantallaCombate":
			sound.stop();
			this.pantallaActual = new PantallaCombate(this, jugador, rival);
			sound.loop(combate_playa);

		default:
			break;
		}

		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}

}
