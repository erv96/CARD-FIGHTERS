package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MenuPrincipal extends JPanel {
	private Ventana ventana;

	public MenuPrincipal(Ventana v) {
		super();
		
		this.ventana = v;
		setLayout(null);
		
		JLabel TITULO = new JLabel("CARD FIGHTERS");
		TITULO.setHorizontalAlignment(SwingConstants.CENTER);
		TITULO.setForeground(Color.WHITE);
		TITULO.setFont(new Font("Personal Services", Font.PLAIN, 55));
		TITULO.setBounds(24, 28, 510, 89);
		add(TITULO);
		
		JButton botonMenu_luch = new JButton("\u00A1LUCHAR!");
		botonMenu_luch.setFont(UIManager.getFont("Menu.font"));
		botonMenu_luch.setBackground(Color.RED);
		botonMenu_luch.setBounds(60, 276, 131, 44);
		add(botonMenu_luch);
		
		JButton botonInst = new JButton("INSTRUCCIONES");
		botonInst.setFont(UIManager.getFont("Menu.font"));
		botonInst.setBackground(Color.RED);
		botonInst.setBounds(327, 276, 131, 44);
		add(botonInst);
		
		JButton boton_salir = new JButton("SALIR");
		boton_salir.setFont(UIManager.getFont("Menu.font"));
		boton_salir.setBackground(Color.RED);
		boton_salir.setBounds(596, 276, 131, 44);
		add(boton_salir);
		
		JLabel tinta_2 = new JLabel("");
		tinta_2.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		tinta_2.setBounds(-292, -190, 1163, 363);
		add(tinta_2);
		
		JLabel tinta = new JLabel("");
		tinta.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		tinta.setBounds(-316, 299, 1163, 363);
		add(tinta);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\menu.png"));
		fondo.setBounds(0, 0, 800, 576);
		add(fondo);
		
		
	}
}
