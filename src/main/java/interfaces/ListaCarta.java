package interfaces;

import javax.swing.JPanel;

import clases.Carta;
import clases.Personaje;
import clases.Ultimate;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
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

public class ListaCarta extends JPanel {
	private Carta elegida;
	

	public ListaCarta(final Carta c) {
		setBackground(Color.BLACK);
		this.elegida = c;
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

		JLabel da�o = new JLabel("Da\u00F1o");
		da�o.setFont(new Font("Tahoma", Font.BOLD, 10));
		da�o.setBounds(10, 35, 45, 13);
		panel.add(da�o);

		JLabel numero_da�o = new JLabel(String.valueOf(elegida.getPuntosAtaque()));
		numero_da�o.setFont(new Font("Tahoma", Font.BOLD, 10));
		numero_da�o.setHorizontalAlignment(SwingConstants.CENTER);
		numero_da�o.setBounds(65, 33, 45, 13);
		panel.add(numero_da�o);

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
		

		final JButton usarButton = new JButton("Usar");
		usarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
				
			}
		});
		usarButton.setFont(new Font("Tahoma", Font.BOLD, 9));
		usarButton.setBounds(10, 135, 100, 21);
		panel.add(usarButton);

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
		fondo.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\splat (1).png"));
		fondo.setBounds(10, 58, 124, 187);
		panel.add(fondo);
		
	}

	public Carta getElegida() {
		return elegida;
	}
}