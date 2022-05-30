package interfaces;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	
	private JPanel pantallaActual;
	
	public Ventana() {
		this.setTitle("Card Fighters");
		this.setSize(800, 576);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./icon/punch.png").getImage());
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pantallaActual = new MenuPrincipal(this);
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
		case "MenuPrincipal":
			this.pantallaActual = new MenuPrincipal(this);
			

			break;
		default:
			break;
		}
		
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}

}
