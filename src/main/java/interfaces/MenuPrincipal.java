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

import componentesVisuales.BotonAnimado;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		TITULO.setBounds(25, 20, 510, 89);
		add(TITULO);
		
		JButton botonMenu_luch = new BotonAnimado("\u00A1LUCHAR!");
		botonMenu_luch.setBackground(Color.RED);
		botonMenu_luch.setBounds(60, 276, 131, 44);
		add(botonMenu_luch);
		
		JButton botonInst = new BotonAnimado("INSTRUCCIONES");
		botonInst.setBackground(Color.RED);
		botonInst.setBounds(302, 276, 199, 44);
		add(botonInst);
		
		JButton boton_atras = new BotonAnimado("SALIR");
		boton_atras.setText("ATRAS");
		boton_atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("PantallaTitulo");
			}
		});
		boton_atras.setBackground(Color.RED);
		boton_atras.setBounds(596, 276, 131, 44);
		add(boton_atras);
		
		JLabel tinta_1 = new JLabel("");
		tinta_1.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		tinta_1.setBounds(-316, 57, 1163, 363);
		add(tinta_1);
		
		JLabel tinta_2 = new JLabel("");
		tinta_2.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		tinta_2.setBounds(-298, -224, 1163, 363);
		add(tinta_2);
		
		JLabel tinta = new JLabel("");
		tinta.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		tinta.setBounds(-316, 330, 1163, 363);
		add(tinta);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\menu.png"));
		fondo.setBounds(0, 0, 800, 576);
		add(fondo);
		
		
	}
}
