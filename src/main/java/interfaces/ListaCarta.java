package interfaces;

import javax.swing.JPanel;

import clases.Carta;
import clases.Personaje;
import clases.Ultimate;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JRadioButton;

/**
 * Esta clase nos servirá para definir el tamaño de cada carta del jugador, es
 * como una especie de plantilla que se le añadirá a cada carta que se encuentre
 * en el ArrayList baraja del personaje, todas estas cartas se representarán
 * dentro de un JPanel que se encuentra en la clase PantallaCombate.
 * 
 * @author toled
 *
 */
public class ListaCarta extends JPanel {
	/**
	 * Esta variable representa cada carta del ArrayList de baraja del jugador.
	 */
	private Carta elegida;
	/**
	 * Esta variable de tipo PantallaCombate la utilizamos para invocar al método
	 * setCartaElegida y getCartaElegida, los cuales nos ayudarán a enviar la carta
	 * que elige el jugador a la clase PantallaCombate para realizar los calculos
	 * necesarios.
	 */
	private PantallaCombate pantallaC;
	/**
	 * La variable interna ventana nos permite utilizar el método irAPantalla dentro
	 * del constructor de instrucciones para cambiar de pantalla y mantener las
	 * características generales definidas en las clase Ventana
	 */
	private Ventana ventana;

	/**
	 * En el siguiente constructor definimos la forma y el aspecto que tendrán las
	 * cartas que mostraremos por pantalla, dentro de este constructor también hemos
	 * realizado varios ifs para distinguir entre qué tipo de carta recibimos y
	 * mostrar su coste de vida o energía.
	 * 
	 * @param c       Este parámetro es cada carta del ArrayList de baraja del
	 *                jugador, en la clase PantallaCombate, mediante un bucle for
	 *                recorremos todo el ArrayList de baraja y en ese mismo bucle a
	 *                un JPanel creado en la clase PantallaCombate, le añadimos un
	 *                objeto de tipo ListaCarta que irá iterando hasta que toda la
	 *                baraja este definida.
	 * @param combate Objeto de tipo PantallaCombate que nos permitirá invocar a los
	 *                métodos get y set cartaElegida para traspasar la elección del
	 *                jugador a la clase PantallaCombate
	 */

	public ListaCarta(final Carta c, final PantallaCombate combate) {
		setBackground(Color.BLACK);
		this.elegida = c;
		this.pantallaC = combate;
		setLayout(null);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 41, 31, 18, 35, 0 };
		gridBagLayout.rowHeights = new int[] { 46, 29, 30, 30, 19, 12, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 6;
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		JLabel nombre_Carta = new JLabel(elegida.getNombre());
		nombre_Carta.setHorizontalAlignment(SwingConstants.CENTER);
		nombre_Carta.setFont(new Font("Tahoma", Font.BOLD, 10));
		nombre_Carta.setBounds(10, 10, 100, 13);
		panel.add(nombre_Carta);

		JLabel daño = new JLabel("Da\u00F1o");
		daño.setFont(new Font("Tahoma", Font.BOLD, 10));
		daño.setBounds(10, 35, 45, 13);
		panel.add(daño);

		JLabel numero_daño = new JLabel(String.valueOf(elegida.getPuntosAtaque()));
		numero_daño.setFont(new Font("Tahoma", Font.BOLD, 10));
		numero_daño.setHorizontalAlignment(SwingConstants.CENTER);
		numero_daño.setBounds(65, 33, 45, 13);
		panel.add(numero_daño);

		JLabel velocidad = new JLabel("Vel");
		velocidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		velocidad.setBounds(10, 50, 45, 13);
		panel.add(velocidad);

		JLabel numero_Velocidad = new JLabel(String.valueOf(elegida.getVelocidad()));
		numero_Velocidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		numero_Velocidad.setHorizontalAlignment(SwingConstants.CENTER);
		numero_Velocidad.setBounds(65, 50, 45, 13);
		panel.add(numero_Velocidad);

		JLabel alcance = new JLabel("Alcance");
		alcance.setFont(new Font("Tahoma", Font.BOLD, 10));
		alcance.setBounds(10, 65, 63, 13);
		panel.add(alcance);

		JLabel numero_Alcance = new JLabel(String.valueOf(elegida.getAlcance()));
		numero_Alcance.setFont(new Font("Tahoma", Font.BOLD, 10));
		numero_Alcance.setHorizontalAlignment(SwingConstants.CENTER);
		numero_Alcance.setBounds(65, 65, 45, 13);
		panel.add(numero_Alcance);

		/**
		 * El JButton elegir nos permitirá elegir la carta que queramos usar, al
		 * pulsarlo, comprobará si la variable cartaElegida de PantallaCombate es null,
		 * si lo es, su valor será el de la carta que hemos pulsado, la carta
		 * desaparecerá. Si cartaElegida es distinto de null, osea, ya tiene un valor
		 * asignado, se nos mostrará un JOptionPane indicándonos que ya hemos elegido
		 * una carta, junto con la carta que elegimos en un principio.
		 */

		final JButton elegir = new JButton("Elegir");
		elegir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pantallaC.getCartaElegida() == null) {
					pantallaC.setCartaElegida(c);
					setVisible(false);
				} else if (pantallaC.getCartaElegida() != null) {
					JOptionPane.showMessageDialog(combate, "Ya hay una carta elegida: " + pantallaC.getCartaElegida(),
							"Carta ya elegida", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		elegir.setFont(new Font("Tahoma", Font.BOLD, 9));
		elegir.setBounds(10, 135, 100, 21);
		panel.add(elegir);

		/**
		 * Mediante esta dos setencias if comprobamos si alguna de las cartas que se listan
		 * es ultimate o especial, según lo que sean, se mostrará en las cartas su coste
		 * de vida o de energía
		 */

		if (elegida.getTipo().equals("Ultimate")) {

			JLabel vida = new JLabel("C.vida");
			vida.setFont(new Font("Tahoma", Font.BOLD, 10));
			vida.setForeground(Color.RED);
			vida.setBounds(10, 80, 63, 13);
			panel.add(vida);

			JLabel c_Energia = new JLabel("C.energ");
			c_Energia.setForeground(new Color(0, 51, 255));
			c_Energia.setFont(new Font("Tahoma", Font.BOLD, 10));
			c_Energia.setBounds(10, 96, 63, 13);
			panel.add(c_Energia);

			JLabel numeroEnergia = new JLabel(String.valueOf(elegida.getCosteEnergia()));
			numeroEnergia.setForeground(new Color(0, 51, 204));
			numeroEnergia.setFont(new Font("Tahoma", Font.BOLD, 10));
			numeroEnergia.setHorizontalAlignment(SwingConstants.CENTER);
			numeroEnergia.setBounds(65, 96, 45, 13);
			panel.add(numeroEnergia);

			JLabel vidaNumero = new JLabel(String.valueOf(String.valueOf(elegida.getCosteVida())));
			vidaNumero.setHorizontalAlignment(SwingConstants.CENTER);
			vidaNumero.setForeground(Color.RED);
			vidaNumero.setFont(new Font("Tahoma", Font.BOLD, 10));
			vidaNumero.setBounds(65, 80, 45, 13);
			panel.add(vidaNumero);
		}

		if (elegida.getTipo().equals("Especial")) {

			JLabel c_Energia = new JLabel("C.energ");
			c_Energia.setForeground(new Color(0, 51, 255));
			c_Energia.setFont(new Font("Tahoma", Font.BOLD, 10));
			c_Energia.setBounds(10, 96, 63, 13);
			panel.add(c_Energia);

			JLabel numeroEnergia = new JLabel(String.valueOf(elegida.getCosteEnergia()));
			numeroEnergia.setForeground(new Color(0, 51, 204));
			numeroEnergia.setFont(new Font("Tahoma", Font.BOLD, 10));
			numeroEnergia.setHorizontalAlignment(SwingConstants.CENTER);
			numeroEnergia.setBounds(65, 96, 45, 13);
			panel.add(numeroEnergia);
		}

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./background/splat (1).png"));
		fondo.setBounds(10, 58, 124, 187);
		panel.add(fondo);

	}
}
