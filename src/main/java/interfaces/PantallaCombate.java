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
import javax.swing.SwingConstants;

public class PantallaCombate extends JPanel{
	private Ventana ventana;
	private Carta CartaElegidaJugador;
	private Carta CartaElegidRival;
	private Personaje jugador;
	private Personaje rival;

	// CONSUMIBLES

	Consumible pEnergia = new PocionEnergia();
	Consumible pFuerza = new PocionFuerza();
	Consumible pVida = new PocionVida();

	// ESCENARIOS
	CampoCombate playa = new CampoCombate("Playa enigmática");
	CampoCombate dojo = new CampoCombate("Dojo");
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public PantallaCombate(Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel prueba = new JLabel("PRUEBA");
		prueba.setHorizontalAlignment(SwingConstants.CENTER);
		prueba.setFont(new Font("Personal Services", Font.PLAIN, 45));
		prueba.setBackground(Color.BLACK);
		prueba.setBounds(250, 238, 279, 112);
		add(prueba);
		System.out.println("soy ventana");
			
	}
	
	
	public PantallaCombate(Personaje jugador, Personaje rival) {
		super();
		System.out.println("soy jugador");
		this.jugador = jugador;
		this.rival = rival;
	}
	
	
	

}
