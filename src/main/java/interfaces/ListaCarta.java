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
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class ListaCarta extends JPanel {
	private Ventana ventana;
	private Carta carta;	


	public ListaCarta(Ventana v, final Carta c,final Personaje jugador, final Personaje rival) {

		setBackground(Color.BLACK);
		this.ventana = v;
		this.carta = c;
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

		JLabel nombre_Carta = new JLabel(carta.getNombre());
		nombre_Carta.setHorizontalAlignment(SwingConstants.CENTER);
		nombre_Carta.setFont(new Font("Tahoma", Font.BOLD, 10));
		nombre_Carta.setBounds(10, 10, 100, 13);
		panel.add(nombre_Carta);

		JLabel daño = new JLabel("Da\u00F1o");
		daño.setFont(new Font("Tahoma", Font.BOLD, 10));
		daño.setBounds(10, 35, 45, 13);
		panel.add(daño);

		JLabel numero_daño = new JLabel(String.valueOf(carta.getPuntosAtaque()));
		numero_daño.setFont(new Font("Tahoma", Font.BOLD, 10));
		numero_daño.setHorizontalAlignment(SwingConstants.CENTER);
		numero_daño.setBounds(65, 33, 45, 13);
		panel.add(numero_daño);

		JLabel velocidad = new JLabel("Vel");
		velocidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		velocidad.setBounds(10, 50, 45, 13);
		panel.add(velocidad);

		JLabel numero_Velocidad = new JLabel(String.valueOf(carta.getVelocidad()));
		numero_Velocidad.setFont(new Font("Tahoma", Font.BOLD, 10));
		numero_Velocidad.setHorizontalAlignment(SwingConstants.CENTER);
		numero_Velocidad.setBounds(65, 50, 45, 13);
		panel.add(numero_Velocidad);

		JLabel alcance = new JLabel("Alcance");
		alcance.setFont(new Font("Tahoma", Font.BOLD, 10));
		alcance.setBounds(10, 65, 63, 13);
		panel.add(alcance);

		JLabel numero_Alcance = new JLabel(String.valueOf(carta.getAlcance()));
		numero_Alcance.setFont(new Font("Tahoma", Font.BOLD, 10));
		numero_Alcance.setHorizontalAlignment(SwingConstants.CENTER);
		numero_Alcance.setBounds(65, 65, 45, 13);
		panel.add(numero_Alcance);

		JButton btnNewButton = new JButton("Usar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				PantallaCombate pelea = new PantallaCombate();
				pelea.pelear(jugador, rival, c);
			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton.setBounds(10, 135, 100, 21);
		panel.add(btnNewButton);
		
		if(carta.getTipo().equals("Ultimate")) {
			
			
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
			
			JLabel numeroEnergia = new JLabel(String.valueOf(carta.getCosteEnergia()));
			numeroEnergia.setForeground(new Color(0, 51, 204));
			numeroEnergia.setFont(new Font("Tahoma", Font.BOLD, 10));
			numeroEnergia.setHorizontalAlignment(SwingConstants.CENTER);
			numeroEnergia.setBounds(65, 96, 45, 13);
			panel.add(numeroEnergia);
			
			JLabel vidaNumero = new JLabel(String.valueOf(String.valueOf(carta.getCosteVida())));
			vidaNumero.setHorizontalAlignment(SwingConstants.CENTER);
			vidaNumero.setForeground(Color.RED);
			vidaNumero.setFont(new Font("Tahoma", Font.BOLD, 10));
			vidaNumero.setBounds(65, 80, 45, 13);
			panel.add(vidaNumero);
		}
		
		if(carta.getTipo().equals("Especial")) {
			
			JLabel c_Energia = new JLabel("C.energ");
			c_Energia.setForeground(new Color(0, 51, 255));
			c_Energia.setFont(new Font("Tahoma", Font.BOLD, 10));
			c_Energia.setBounds(10, 96, 63, 13);
			panel.add(c_Energia);
			
			JLabel numeroEnergia = new JLabel(String.valueOf(carta.getCosteEnergia()));
			numeroEnergia.setForeground(new Color(0, 51, 204));
			numeroEnergia.setFont(new Font("Tahoma", Font.BOLD, 10));
			numeroEnergia.setHorizontalAlignment(SwingConstants.CENTER);
			numeroEnergia.setBounds(65, 96, 45, 13);
			panel.add(numeroEnergia);
		}
		
		

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("C:\\Users\\toled\\Downloads\\Webp.net-resizeimage.png"));
		fondo.setBounds(10, 76, 124, 187);
		panel.add(fondo);
		}
		

	}

