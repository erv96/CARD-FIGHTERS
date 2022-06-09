package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import componentesVisuales.BotonAnimado;
import componentesVisuales.BotonAnimadoNegro;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Resultado extends JPanel {
	private Ventana ventana;
	private String ganador;
	
	
	public Resultado(Ventana v, String g) {
		super();
		this.ventana = v;
		this.ganador = g;
		setLayout(null);
		
		JButton botonLuchar = new BotonAnimadoNegro("LUCHAR OTRA VEZ");
		botonLuchar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("SeleccionPersonaje");
			}
		});
		botonLuchar.setHorizontalAlignment(SwingConstants.LEADING);
		botonLuchar.setBounds(571, 499, 208, 33);
		add(botonLuchar);
		
		JButton botonMenu = new BotonAnimadoNegro("MEN\u00DA PRINCIPAL");
		botonMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("MenuPrincipal");
			}
		});
		botonMenu.setHorizontalAlignment(SwingConstants.LEADING);
		botonMenu.setBounds(2, 499, 231, 33);
		add(botonMenu);
		
		JLabel nombreGanador = new JLabel(g);
		nombreGanador.setFont(new Font("Personal Services", Font.PLAIN, 45));
		nombreGanador.setForeground(Color.black);
		nombreGanador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreGanador.setBounds(243, 296, 284, 80);
		add(nombreGanador);
		
		JLabel pantallaGanador = new JLabel("GANADOR");
		pantallaGanador.setForeground(Color.WHITE);
		pantallaGanador.setFont(new Font("Personal Services", Font.PLAIN, 55));
		pantallaGanador.setBounds(30, 20, 313, 87);
		add(pantallaGanador);
		
		JLabel manchaTop = new JLabel("");
		manchaTop.setIcon(new ImageIcon("./background/mancha.png"));
		manchaTop.setBounds(-382, -319, 1278, 582);
		add(manchaTop);
		
		JLabel manchaBlancaRight = new JLabel("");
		manchaBlancaRight.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\manchaBlanca.png"));
		manchaBlancaRight.setBounds(420, 385, 561, 215);
		add(manchaBlancaRight);
		
		JLabel manchaBlancaLeft = new JLabel("");
		manchaBlancaLeft.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\manchaBlancaInv.png"));
		manchaBlancaLeft.setBounds(-265, 385, 594, 215);
		add(manchaBlancaLeft);
		
		JLabel manchaRigth = new JLabel("");
		manchaRigth.setIcon(new ImageIcon("./background/splat.png"));
		manchaRigth.setBounds(243, 185, 880, 503);
		add(manchaRigth);
		
		JLabel manchaLeft = new JLabel("");
		manchaLeft.setIcon(new ImageIcon("./background/splat.png"));
		manchaLeft.setBounds(-454, 151, 801, 503);
		add(manchaLeft);
		
		
		
		JLabel manchaBottom = new JLabel("");
		manchaBottom.setIcon(new ImageIcon("./background/mancha.png"));
		manchaBottom.setBounds(-500, 250, 1577, 582);
		add(manchaBottom);
		
		
	}
}
