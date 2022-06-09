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
	 * se definen los m�todos void mouseEntered, Exited y Pressed.
	 * 
	 * @param text
	 */
	public BotonAnimado(String text) {
		super(text);
		estilosPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Cuando se pasa el rat�n sobre un bot�n su color cambiar� a rojo.
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
			 * Cuando se clicke sobre el bot�n, el bot�n obtendr� una tonalidad rojiza
			 * distina.
			 */
			public void mousePressed(MouseEvent e) {
				setContentAreaFilled(false);
				setForeground(new Color(120, 50, 50));
			}

			@Override
			/**
			 * Cuando el rat�n deje de estar sobre el bot�n, volver� a su estado original
			 * gracias al m�todo estilosPorDefecto
			 */
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}

		});
	}

	/**
	 * M�todo que define las caracter�sticas de nuestro bot�n por defecto, es decir,
	 * antes de estar pulsado o con el rat�n encima.
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
