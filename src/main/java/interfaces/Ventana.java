package interfaces;

import java.awt.Cursor;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.CampoCombate;
import clases.Consumible;
import clases.Personaje;
import clases.PocionEnergia;
import clases.PocionFuerza;
import clases.PocionVida;

public class Ventana extends JFrame {

	private JPanel pantallaActual;
	
	// PERSONAJES
	
	Personaje steven = new Personaje("Steven");
	
	// CANCIONES
	
	Sound sound = new Sound();
	
	File selector = new File("./songs/selector.wav");
	File main_title = new File("./songs/main_title.wav");
	
	// CONSUMIBLES
	
	Consumible pEnergia = new PocionEnergia();
	Consumible pFuerza = new PocionFuerza();
	Consumible pVida = new PocionVida();
	
	// ESCENARIOS
	CampoCombate playa = new CampoCombate("Playa enigmática");
	CampoCombate dojo = new CampoCombate("Dojo");
	
	public Ventana() {
		loop(main_title);
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
	
	public void irAPantalla(String nombrePantalla) {
		/*
		 * Iterator it = this.pantallas.values().iterator(); while(it.hasNext()) {
		 * JPanel actual =(JPanel)it.next(); actual.setVisible(false); }
		 * this.pantallas.get(nombrePantalla).setVisible(true);
		 * this.setContentPane(this.pantallas.get(nombrePantalla));
		 */
		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;
		switch (nombrePantalla) {
		
		case "PantallaTitulo":
			this.pantallaActual = new PantallaTitulo(this);
			
			break;
			
		case "MenuPrincipal":
			sound.stop();
			this.pantallaActual = new MenuPrincipal(this);
			loop(main_title);
			break;
			
			
		case "SeleccionPersonaje":
			sound.stop();
			this.pantallaActual = new SeleccionPersonaje(this);
			loop(selector);
			break;
		default:
			break;
		}
		
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}
	
	public void playMusic(File sonido) {
		sound.setFile(sonido);
		sound.play();
	}
	
	public void loop(File sonido) {
		sound.setFile(sonido);
		sound.loop();
	}
	
	public void stop(File sonido) {
		sound.stop();
	}
	

}
