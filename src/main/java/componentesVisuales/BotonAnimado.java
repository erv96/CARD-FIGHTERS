package componentesVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * Clase que define el aspecto general de los botones de la interfaz.
 * 
 * @author toled
 *
 */
public class BotonAnimado extends JButton {
	/**
	 * Constructor de boton que posee un MouseListener dentro, en este MouseListener
	 * se definen los métodos void mouseEntered, Exited y Pressed.
	 * 
	 * @param text
	 */
	public BotonAnimado(String text) {
		super(text);
		estilosPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Cuando se pasa el ratón sobre un botón su color cambiará a rojo.
			 */
			public void mouseEntered(MouseEvent e) {
				setOpaque(false);
				setBorderPainted(false);
				setForeground(new Color(255, 0, 0));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				setContentAreaFilled(false);
			}

			@Override
			/**
			 * Cuando se clicke sobre el botón, el botón obtendrá una tonalidad rojiza
			 * distina.
			 */
			public void mousePressed(MouseEvent e) {
				setContentAreaFilled(false);
				setForeground(new Color(120, 50, 50));
			}

			@Override
			/**
			 * Cuando el ratón deje de estar sobre el botón, volverá a su estado original
			 * gracias al método estilosPorDefecto
			 */
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}

		});
	}

	/**
	 * Método que define las características de nuestro botón por defecto, es decir,
	 * antes de estar pulsado o con el ratón encima.
	 */
	private void estilosPorDefecto() {
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		this.setFocusable(false);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	}

}
