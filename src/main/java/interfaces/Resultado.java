package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import componentesVisuales.BotonAnimado;

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
		
		JButton botonLuchar = new BotonAnimado("LUCHAR OTRA VEZ");
		botonLuchar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("SeleccionPersonaje");
			}
		});
		botonLuchar.setHorizontalAlignment(SwingConstants.LEADING);
		botonLuchar.setBounds(571, 499, 208, 33);
		add(botonLuchar);
		
		JButton botonMenu = new BotonAnimado("MEN\u00DA PRINCIPAL");
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
		nombreGanador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreGanador.setBounds(243, 307, 284, 69);
		add(nombreGanador);
		
		JLabel pantallaGanador = new JLabel("GANADOR");
		pantallaGanador.setForeground(Color.WHITE);
		pantallaGanador.setFont(new Font("Personal Services", Font.PLAIN, 55));
		pantallaGanador.setBounds(30, 20, 313, 87);
		add(pantallaGanador);
		
		JLabel manchaTop = new JLabel("");
		manchaTop.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		manchaTop.setBounds(-382, -319, 1278, 582);
		add(manchaTop);
		
		JLabel manchaRigth = new JLabel("New label");
		manchaRigth.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\splat.png"));
		manchaRigth.setBounds(243, 185, 880, 503);
		add(manchaRigth);
		
		JLabel manchaLeft = new JLabel("");
		manchaLeft.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\splat.png"));
		manchaLeft.setBounds(-454, 151, 801, 503);
		add(manchaLeft);
		
		JLabel manchaTop_1 = new JLabel("");
		manchaTop_1.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		manchaTop_1.setBounds(-500, 250, 1577, 582);
		add(manchaTop_1);
		
		
	}
	
	
}
