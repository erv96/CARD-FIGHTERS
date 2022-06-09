package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import componentesVisuales.BotonAnimado;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author toled
 *
 */
public class PantallaTitulo extends JPanel {
	private Ventana ventana;
	
	
	public PantallaTitulo(Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel titulo = new JLabel("CARD FIGHTERS");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Personal Services", Font.PLAIN, 66));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(80, 10, 617, 127);
		add(titulo);
		
		JButton empezar = new BotonAnimado("EMPEZAR");
		empezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("MenuPrincipal");
			}
		});
		empezar.setBounds(281, 204, 215, 73);

		add(empezar);
		
		JButton salir = new BotonAnimado("SALIR");
		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.dispose();
			}
		});
		salir.setBounds(284, 332, 215, 73);
		add(salir);
		
		JLabel mancha = new JLabel("");
		mancha.setIcon(new ImageIcon("./background/mancha_small.png"));
		mancha.setHorizontalAlignment(SwingConstants.CENTER);
		mancha.setBounds(65, 103, 644, 229);
		add(mancha);
		
		JLabel mancha_2 = new JLabel("");
		mancha_2.setIcon(new ImageIcon("./background/mancha_small.png"));
		mancha_2.setHorizontalAlignment(SwingConstants.CENTER);
		mancha_2.setBounds(53, 233, 644, 229);
		add(mancha_2);
		
		JLabel fighter = new JLabel("");
		mancha_2.setLabelFor(fighter);
		fighter.setForeground(Color.WHITE);
		fighter.setBackground(Color.YELLOW);
		fighter.setHorizontalAlignment(SwingConstants.CENTER);
		fighter.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\logo.png"));
		fighter.setBounds(348, 10, 726, 673);
		add(fighter);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./background/pantallaTitulo.jpg"));
		fondo.setBounds(0, 0, 800, 579);
		add(fondo);
		
		
	}
}
