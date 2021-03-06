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

/**
 * Esta clase representa el menú principal del juego, es el núcleo de acciones
 * del programa, nos permitirá ir a la pantalla instrucciones o ir a la pantalla
 * de SeleccionPersonaje para librar un combate o volver a la pantalla de titulo
 * para salir del juego.
 * 
 * @author toled
 *
 */
public class MenuPrincipal extends JPanel {
	/**
	 * La variable interna ventana nos permite utilizar el método irAPantalla dentro
	 * del constructor de MenuPrincipal para cambiar de pantalla y mantener las
	 * características generales definidas en las clase Ventana
	 */
	private Ventana ventana;

	/**
	 * Constructor de MenuPrincipal en el que definimos la personalización de esta
	 * pantalla y que recibe un objeto de tipo Ventana que nos permite mantener las
	 * carcterísticas generales de cada pantalla definidas en la clase Ventana
	 * 
	 * @param v objeto de tipo ventana que contiene la información de las
	 *          características generales definidas en la clase Ventana
	 */
	public MenuPrincipal(Ventana v) {
		super();

		this.ventana = v;
		setLayout(null);

		JLabel TITULO = new JLabel("MEN\u00DA PRINCIPAL");
		TITULO.setHorizontalAlignment(SwingConstants.CENTER);
		TITULO.setForeground(Color.WHITE);
		TITULO.setFont(new Font("Personal Services", Font.PLAIN, 55));
		TITULO.setBounds(22, 10, 510, 109);
		add(TITULO);

		JButton LUCHAR = new BotonAnimado("\u00A1LUCHAR!");
		LUCHAR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("SeleccionPersonaje");
			}
		});
		LUCHAR.setBackground(Color.RED);
		LUCHAR.setBounds(60, 276, 131, 44);
		add(LUCHAR);

		JButton INST = new BotonAnimado("INSTRUCCIONES");
		INST.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("Instrucciones");
			}
		});
		INST.setBackground(Color.RED);
		INST.setBounds(302, 276, 199, 44);
		add(INST);

		JButton ATRAS = new BotonAnimado("SALIR");
		ATRAS.setText("ATR\u00C1S");
		ATRAS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("PantallaTitulo");
			}
		});
		ATRAS.setBackground(Color.RED);
		ATRAS.setBounds(596, 276, 131, 44);
		add(ATRAS);

		JLabel tinta_1 = new JLabel("");
		tinta_1.setIcon(new ImageIcon(
				"./background/mancha.png"));
		tinta_1.setBounds(-316, 46, 1163, 363);
		add(tinta_1);

		JLabel tinta_2 = new JLabel("");
		tinta_2.setIcon(new ImageIcon(
				"./background/mancha.png"));
		tinta_2.setBounds(-298, -224, 1163, 363);
		add(tinta_2);

		JLabel tinta = new JLabel("");
		tinta.setIcon(new ImageIcon(
				"./background/mancha.png"));
		tinta.setBounds(-316, 330, 1163, 363);
		add(tinta);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(
				"./background/menu.png"));
		fondo.setBounds(0, 0, 800, 576);
		add(fondo);

	}
}
