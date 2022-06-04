package interfaces;

import javax.swing.JPanel;

import clases.Carta;
import clases.Personaje;

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

public class ListaCarta extends JPanel {
	private Ventana ventana;
	private Carta carta;

	public ListaCarta(Ventana v, Carta c) {
		super();
		setBackground(Color.BLACK);
		this.ventana = v;
		this.carta = c;
		setLayout(null);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 41, 31, 18, 35, 0 };
		gridBagLayout.rowHeights = new int[] { 46, 30, 30, 30, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		final JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 5;
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		JLabel nombre_Carta = new JLabel(carta.getNombre());
		nombre_Carta.setHorizontalAlignment(SwingConstants.CENTER);
		nombre_Carta.setFont(new Font("Tahoma", Font.BOLD, 8));
		nombre_Carta.setBounds(24, 10, 73, 13);
		panel.add(nombre_Carta);

		JLabel daño = new JLabel("Da\u00F1o");
		daño.setBounds(10, 48, 45, 13);
		panel.add(daño);

		JLabel numero_daño = new JLabel(String.valueOf(carta.getPuntosAtaque()));
		numero_daño.setHorizontalAlignment(SwingConstants.CENTER);
		numero_daño.setBounds(65, 48, 45, 13);
		panel.add(numero_daño);

		JLabel velocidad = new JLabel("Vel");
		velocidad.setBounds(10, 73, 45, 13);
		panel.add(velocidad);

		JLabel numero_Velocidad = new JLabel(String.valueOf(carta.getVelocidad()));
		numero_Velocidad.setHorizontalAlignment(SwingConstants.CENTER);
		numero_Velocidad.setBounds(65, 71, 45, 13);
		panel.add(numero_Velocidad);

		JLabel alcance = new JLabel("Alcance");
		alcance.setBounds(10, 96, 45, 13);
		panel.add(alcance);

		JLabel numero_Alcance = new JLabel(String.valueOf(carta.getAlcance()));
		numero_Alcance.setHorizontalAlignment(SwingConstants.CENTER);
		numero_Alcance.setBounds(65, 94, 45, 13);
		panel.add(numero_Alcance);

		JButton btnNewButton = new JButton("Usar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 7));
		btnNewButton.setBounds(38, 135, 55, 21);
		panel.add(btnNewButton);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("C:\\Users\\toled\\Downloads\\Webp.net-resizeimage.png"));
		fondo.setBounds(10, 71, 124, 187);
		panel.add(fondo);
	}
}
