package interfaces;

import javax.swing.JPanel;
import clases.Personaje;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

/**
 * Esta clase nos servir� para definir el tama�o de cada posici�n del Array de
 * String con las rutas de los iconos que mencionamos en la clase CampoCombate,
 * b�sicamente es como una plantilla para cada posici�n.
 * 
 * @author toled
 *
 */
public class Mapa extends JPanel {

	/**
	 * El constructor de mapa recibir� un String que ser� la ruta del icono que
	 * definimos para "jugador" y "rival", en la posici�n de jugador estar� la ruta
	 * hacia el icono de jugador, y para rival lo mismo, en PantallaCombate
	 * realizamos un bucle for para introducir cada una de estas plantillas junto
	 * con el icono del jugador correspondiente.
	 * 
	 * @param icono ruta del icono para jugador y rival.
	 */
	public Mapa(String icono) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 75, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(icono));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
	}
}
