package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import componentesVisuales.BotonAnimado;
import componentesVisuales.BotonAnimadoNegro;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;

/**
 * En esta clase mostraremos al ganador del combate
 * 
 * @author toled
 *
 */
public class Resultado extends JPanel {
	/**
	 * La variable interna ventana nos permite utilizar el método irAPantalla dentro
	 * del constructor de resultado para cambiar de pantalla y mantener las
	 * características generales definidas en las clase Ventana
	 */
	private Ventana ventana;
	/**
	 * Este String tendrá guardado el nombre del ganador del combate
	 */
	private String ganador;

	/**
	 * En el constructor de resultado tendrémos los botones de volver a luchar, o de
	 * volver al menú principal, además de eso en esta pantalla realizamos la
	 * escritura de archivos, en este caso imprimiremos al ganador del combate en el
	 * archivo.
	 * 
	 * @param v parámetro para que la pantalla resultado comparta las
	 *          características generales de nuestra ventana.
	 * @param g parámetro que contendrá el nombre del ganador y lo mostrará por
	 *          pantalla.
	 */
	public Resultado(final Ventana v, final String g) {
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

		JButton imprimirGanador = new BotonAnimado("IMPRIMIR GANADOR");
		imprimirGanador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FileWriter rivales = new FileWriter("./ganadores_combate.txt", true);
					rivales.write("GANADOR: " + g + "\n");
					rivales.flush();
					rivales.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(v, "El ganador se ha impreso con éxito.", "Impresión realizada",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		imprimirGanador.setBounds(257, 396, 284, 21);
		add(imprimirGanador);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"./background/mancha_peque\u00F1a.png"));
		lblNewLabel.setBounds(180, 311, 462, 156);
		add(lblNewLabel);

		JLabel nombreGanador = new JLabel(g);
		nombreGanador.setFont(new Font("Personal Services", Font.PLAIN, 45));
		nombreGanador.setForeground(Color.black);
		nombreGanador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreGanador.setBounds(257, 273, 284, 80);
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
		manchaBlancaRight.setIcon(new ImageIcon(
				"./background/manchaBlanca.png"));
		manchaBlancaRight.setBounds(420, 385, 561, 215);
		add(manchaBlancaRight);

		JLabel manchaBlancaLeft = new JLabel("");
		manchaBlancaLeft.setIcon(new ImageIcon(
				"./background/manchaBlancaInv.png"));
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
