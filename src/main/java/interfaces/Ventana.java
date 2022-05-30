package interfaces;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	
	private JPanel pantallaActual;
	
	public Ventana() {
		this.setTitle("Card Fighters");
		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("./icon/punch.png").getImage());
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setContentPane(this.pantallaActual); 
		this.setVisible(true);
		
	}

}
