package componentesVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Exactamente igual que la clase BotonAnimado pero el color predeterminado de las letras del botón es negro.
 * @author toled
 *
 */
public class BotonAnimadoNegro extends BotonAnimado {

	public BotonAnimadoNegro(String text) {
		super(text);
		estilosPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setOpaque(false);
				setBorderPainted(false);
				setForeground(new Color(255, 0, 0));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				setContentAreaFilled(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setContentAreaFilled(false);
				setForeground(new Color(120, 50, 50));
			}

		});
	}
	
	private void estilosPorDefecto() {
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
		this.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		this.setFocusable(false);
	}

}


