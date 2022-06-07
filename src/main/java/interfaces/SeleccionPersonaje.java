package interfaces;

import javax.swing.JPanel;

import clases.Personaje;
import componentesVisuales.BotonAnimado;
import componentesVisuales.BotonAnimadoNegro;
import main.Main;

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
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class SeleccionPersonaje extends JPanel {
	private Ventana ventana;
	private Personaje jugador;
	private Personaje rival;
	private String[] argumentosPersonaje = Main.getArgs();

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
		lblNewLabel.setBounds(300, 271, 192, 91);
		add(lblNewLabel);
		
		JLabel riv_title = new JLabel("RIVAL");
		riv_title.setHorizontalAlignment(SwingConstants.CENTER);
		riv_title.setForeground(Color.BLACK);
		riv_title.setFont(new Font("Personal Services", Font.PLAIN, 45));
		riv_title.setBounds(497, 139, 248, 71);
		add(riv_title);
		
		JLabel jug_title = new JLabel("JUGADOR");
		jug_title.setHorizontalAlignment(SwingConstants.CENTER);
		jug_title.setForeground(Color.BLACK);
		jug_title.setFont(new Font("Personal Services", Font.PLAIN, 45));
		jug_title.setBounds(59, 139, 248, 71);
		add(jug_title);

		// LISTA JUGADOR

		JScrollPane scrollJugador = new JScrollPane();
		scrollJugador.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		scrollJugador.setBounds(8, 220, 347, 195);
		add(scrollJugador, BorderLayout.CENTER);
		scrollJugador.setFocusable(false);

		final JList lista_Jugador = new JList();
		scrollJugador.setViewportView(lista_Jugador);
		lista_Jugador.setFocusable(false);

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
		scrollRival.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		scrollRival.setBounds(433, 220, 347, 195);
		add(scrollRival, BorderLayout.CENTER);

		final JList lista_Rival = new JList();
		scrollRival.setViewportView(lista_Rival);
		lista_Jugador.setFocusable(false);

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
					ventana.irAPantalla("PantallaCombate",jugador,rival);
					
				}else if(lista_Jugador.getSelectedValue()==null && lista_Rival.getSelectedValue()==null){
					String jugadorArg="";
					String rivalArg="";
					for (byte i = 0; i < argumentosPersonaje.length; i++) {
						if (argumentosPersonaje[i].equals("-jugador")) {
							jugadorArg = argumentosPersonaje[i + 1];
						}
						if (argumentosPersonaje[i].equals("-rival")) {
							rivalArg = argumentosPersonaje[i + 1];
						}
						
					}
					
					JOptionPane.showMessageDialog(v, "El jugador no ha elegido ningún personaje ni ningún rival se procederá a la selección automática por argumentos","SELECCIÓN POR ARGUMENTOS",JOptionPane.INFORMATION_MESSAGE);

					jugador = new Personaje(jugadorArg);
					rival = new Personaje(rivalArg);
					ventana.irAPantalla("PantallaCombate",jugador,rival);
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
