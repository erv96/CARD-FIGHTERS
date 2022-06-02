package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import componentesVisuales.BotonAnimado;
import componentesVisuales.BotonAnimadoNegro;

import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class SeleccionPersonaje extends JPanel {
	private Ventana ventana;

	Personaje jugador;
	Personaje rival;

	public SeleccionPersonaje(final Ventana v) {
		this.ventana = v;
		setLayout(null);
		

		JLabel tituloPantalla = new JLabel("SELECCI\u00D3N DE PERSONAJE");
		tituloPantalla.setFont(new Font("Personal Services", Font.PLAIN, 45));
		tituloPantalla.setForeground(Color.WHITE);
		tituloPantalla.setBounds(20, 10, 725, 99);
		add(tituloPantalla);
		
		JLabel lblNewLabel = new JLabel("VS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Personal Services", Font.PLAIN, 55));
		lblNewLabel.setBounds(302, 271, 192, 91);
		add(lblNewLabel);
		
		JLabel riv_title = new JLabel("RIVAL");
		riv_title.setHorizontalAlignment(SwingConstants.CENTER);
		riv_title.setForeground(Color.BLACK);
		riv_title.setFont(new Font("Personal Services", Font.PLAIN, 45));
		riv_title.setBounds(465, 139, 248, 71);
		add(riv_title);
		
		JLabel jug_title = new JLabel("JUGADOR");
		jug_title.setHorizontalAlignment(SwingConstants.CENTER);
		jug_title.setForeground(Color.BLACK);
		jug_title.setFont(new Font("Personal Services", Font.PLAIN, 45));
		jug_title.setBounds(77, 139, 248, 71);
		add(jug_title);

		// LISTA JUGADOR

		JScrollPane scrollJugador = new JScrollPane();
		scrollJugador.setBounds(30, 220, 347, 195);
		add(scrollJugador, BorderLayout.CENTER);

		final JList lista_Jugador = new JList();
		scrollJugador.setViewportView(lista_Jugador);

		final ArrayList<String> todosJugador = Personaje.getTodos();
		lista_Jugador.setModel(new AbstractListModel() {
			public int getSize() {
				return todosJugador.size();
			}

			public Object getElementAt(int index) {
				return todosJugador.get(index);
			}

		});

		// LISTA RIVAL

		JScrollPane scrollRival = new JScrollPane();
		scrollRival.setBounds(416, 220, 347, 195);
		add(scrollRival, BorderLayout.CENTER);

		final JList lista_Rival = new JList();
		scrollRival.setViewportView(lista_Rival);

		final ArrayList<String> todosRival = Personaje.getTodos();
		lista_Rival.setModel(new AbstractListModel() {
			public int getSize() {
				return todosRival.size();
			}

			public Object getElementAt(int index) {
				return todosRival.get(index);
			}

		});
		
		//BOTONES
		
		JButton ATRAS = new BotonAnimadoNegro("ATR\u00C1S");
		ATRAS.setForeground(Color.BLACK);
		ATRAS.setBounds(31, 506, 119, 38);
		add(ATRAS);
		ATRAS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("MenuPrincipal");
			}
		});
		
		JButton COMENZAR = new BotonAnimadoNegro("ATR\u00C1S");
		COMENZAR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lista_Jugador.getSelectedValue()!=null && lista_Rival.getSelectedValue()!=null) {
					String nombreJ = (String)lista_Jugador.getSelectedValue();
					jugador = new Personaje(nombreJ);
					String nombreR = (String)lista_Rival.getSelectedValue();
					rival = new Personaje(nombreR);
					ventana.irAPantalla("PantallaCombate");
					PantallaCombate combate = new PantallaCombate(jugador,rival);
				}else {
					JOptionPane.showMessageDialog(v, "Tanto el jugador como el rival deben ser seleccionados","ERROR DE SELECCIÓN",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		COMENZAR.setText("COMENZAR");
		COMENZAR.setForeground(Color.BLACK);
		COMENZAR.setBounds(613, 506, 142, 38);
		add(COMENZAR);

		// IMÁGENES

		JLabel MANCHA = new JLabel("");
		MANCHA.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\manchaBlanca.png"));
		MANCHA.setBounds(461, 425, 536, 151);
		add(MANCHA);
		
		JLabel MANCHA_1 = new JLabel("");
		MANCHA_1.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\manchaBlancaInv.png"));
		MANCHA_1.setBounds(-328, 425, 536, 151);
		add(MANCHA_1);

		JLabel FONDO = new JLabel("");
		FONDO.setIcon(new ImageIcon(
				"C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\character_select.png"));
		FONDO.setBounds(0, 0, 800, 576);
		add(FONDO);

	}
}
