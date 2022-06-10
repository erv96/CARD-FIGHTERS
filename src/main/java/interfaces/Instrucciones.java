package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import componentesVisuales.BotonAnimado;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase de la interfaz de instrucciones, en esta pantalla se muestran las
 * instrucciones y algunos fundamentos del juego
 * 
 * @author toled
 *
 */
public class Instrucciones extends JPanel {
	/**
	 * La variable interna ventana nos permite utilizar el m�todo irAPantalla dentro
	 * del constructor de instrucciones para cambiar de pantalla y mantener las
	 * caracter�sticas generales definidas en las clase Ventana
	 */
	private Ventana ventana;

	/**
	 * Constructor de instrucciones que recibe un objeto de tipo Ventana que nos
	 * permite mantener las carcter�sticas generales de cada pantalla definidas en
	 * la clase Ventana. En este constructor utilizamos un ScrollPane el cual
	 * contiene un JTextArea (en el cual est�n escritas las instrucciones del
	 * juego)para aprovechar el espacio general de la pantalla.
	 * 
	 * @param v objeto de tipo ventana que contiene la informaci�n de las
	 *          caracter�sticas generales definidas en la clase Ventana
	 */
	public Instrucciones(Ventana v) {
		super();
		setBackground(Color.WHITE);
		this.ventana = v;
		setLayout(null);

		JLabel tituloInstrucciones = new JLabel("INSTRUCCIONES");
		tituloInstrucciones.setFont(new Font("Personal Services", Font.PLAIN, 55));
		tituloInstrucciones.setForeground(Color.WHITE);
		tituloInstrucciones.setBounds(325, 478, 454, 79);
		add(tituloInstrucciones);

		JButton ATRAS = new BotonAnimado("ATR\u00C1S");
		ATRAS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("MenuPrincipal");
			}
		});
		ATRAS.setBounds(34, 36, 116, 21);
		add(ATRAS);

		JTextArea textito = new JTextArea();
		textito.setEditable(false);
		textito.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		textito.append(
				"\nBIENVENIDO A CARD FIGHTERS, EN ESTA PANTALLA TE CONTAR� C�MO FUNCIONAN LAS MEC�NICAS DE JUEGO, PARA EMPEZAR,\n"
						+ "EN EL MAPA TU PERSONAJE ESTAR� REPRESENTADO POR UN ICONO NEGRO Y EL DEL RIVAL POR UNO ROJO.\r\n"
						+ "\r\n"
						+ "TODOS LOS PERSONAJES TIENEN 20 PUNTOS DE VIDA Y UN M�XIMO DE 4 PUNTOS DE ENERG�A. CUANDO EMPIECE EL\n"
						+ "COMBATE CADA JUGADOR TENDR� 20 CARTAS EN SU MANO PARA ELEGIR, HAY 3 TIPOS DE CARTAS: \r\n"
						+ "\r\n"
						+ "     - TIPO B�SICO: SON CARTAS COMUNES QUE TANTO T� COMO TU RIVAL LAS POSEEIS, SON PU�ETAZO, ACOMETIDA Y \n"
						+ "     BLOQUEO.\n\n"
						+ "     BLOQUEO ES UNA DE LAS CARTAS M�S CRUCIALES EN EL COMBATE, ESTA CARTA SIEMPRE IR� ANTES QUE \n"
						+ "     CUALQUIERA Y BLOQUEAR� POR COMPLETO EL GOLPE DE TU RIVAL Y NO RECIBIR�S DA�O, SOLO TENDR�S UNA EN\n"
						+ "     TU MAZO AS� QUE USALA CON CABEZA.\r\n" + "\r\n"
						+ "     - TIPO ESPECIAL: COMO BIEN DICE SU NOMBRE SON CARTAS ESPECIALES EXCLUSIVAS DE CADA PERSONAJE, PERO \n"
						+ "     A DIFERENCIA DE LAS B�SICAS TIENEN UN COSTE DE ENERG�A QUE SE MOSTRAR� EN COLOR AZUL EN LA CARTA. \r\n"
						+ "\r\n"
						+ "     - TIPO ULTIMATE: ES LA CARTA M�S PODEROSA DEL PERSONAJE, TIENEN COSTE DE VIDA POR LO QUE DEBER�S \n"
						+ "     PLANTEAR LA SITUACI�N PERFECTA PARA USARLA, YA QUE UN USO INDEBIDO PUEDE LLEVARTE A LA DERROTA, \n"
						+ "     EL COSTE DE VIDA APARECER� EN COLOR ROJO EN LA CARTA.\r\n"
						+ "\nCARACTER�STICAS PRINCIPALES COMUNES DE TODAS LAS CARTAS: \r\n" + "\r\n"
						+ "     - DA�O: LA CANTIDAD DE PUNTOS DE ATAQUE QUE LE HAR�S AL RIVAL SI IMPACTAS CON LA CARTA. \r\n"
						+ "\r\n"
						+ "     - VELOCIDAD: SI TU CARTA ES M�S RAPIDA QUE LA DEL RIVAL, ACERTAR�S CON ELLA, SINO TU ATAQUE SER� \n"
						+ "     INTERRUMPIDO Y PERDER�S TANTO LA CARTA COMO EL TURNO. \r\n" + "\r\n"
						+ "     - ALCANCE: ES EL RANGO EN EL QUE LA CARTA PUEDE SER IMPACTADA.\r\n" + "\r\n"
						+ "�C�MO FUNCIONAN LOS COSTES DE VIDA Y ENERG�A?: \n\n"
						+ "     SI REALIZAS UN ESPECIAL O UN ULTIMATE QUE NO PUEDAS PAGAR, LA CARTA SE PERDER� Y ADEM�S TE QUEDAR�S\n"
						+ "     INCAPACITADO POR EL CANSANCIO, ESTO SIGNIFICA QUE SEA CUAL SEA LA VELOCIAD DE TU CARTA O LA DEL RIVAL\n"
						+ "     EL RIVAL ATACAR� PRIMERO Y SUFRIR�S DA�O, OBSERVA BIEN LOS COSTES Y PIENSA BIEN ANTES DE ELEGIR.\n\n"
						+ "�QU� PASA SI MI CARTA Y LA DEL RIVAL TIENEN LA MISMA VELOCIDAD?\n\n"
						+ "     SI AMBAS CARTAS TIENEN LA MISMA VELOCIDAD SE PROCEDER� A HACER UNA COMPARACI�N DE RANGO, POR EJEMPLO\n"
						+ "     SUPONGAMOS QUE ENTRE TU RIVAL Y TU HAY 3 DE DISTANCIA, T� UTILIZAS 'HADOUKEN' Y TU RIVAL USA 'ACOMETIDA'\n"
						+ "     AMBOS MOVIMIENTOS TIENEN LA MISMA VELOCIDAD, PERO 'HADOUKEN' TIENE 3 DE RANGO MIENTRAS 'ACOMETIDA' TIENE 2 \n"
						+ "     VUESTRAS VELOCIDADES ESTAN EMPATADAS PERO LA 'ACOMETIDA' DEL RIVAL NO LLEGA A GOLPEARTE, SIN EMBARGO\n"
						+ "     TU CARTA'HADOUKEN' SI QUE EST� EN SU RANGO DE IMPACTO, AS� QUE EN ESTE CASO GANAR�AS EL INTERCAMBIO.\n "
						+ "     COMO PUEDES OBSERVAR MOVERTE PARA IMPACTAR CON EL RANGO DE TUS CARTAS ES MUY IMPORTANTE PERO DEBER�S\n"
						+ "     HACERLO SABIAMENTE PORQUE GASTAR�S TU TURNO S�LO EN MOVERTE Y EL RIVAL TENDR� OPORTUNIDAD DE GOLPEARTE.\n\n"
						+ "�QUE PASA SI ME QUEDO SIN CARTAS?\n\n"
						+ "     TANTO EL RIVAL COMO TU USAIS CARTAS A LO LARGO DEL COMBATE, SI SE TE ACABAN LAS CARTAS PERDER�S\n"
						+ "     SI SE OS ACABAN LAS CARTAS AL MISMO TIEMPO GANAR� QUIEN TENGA MAYOR VIDA RESTANTE.\n\n"
						+ "�VAYA CREO QUE TE HE DADO UN POCO LA CHAPA!, �AHORA A LUCHAR!\n");

		JScrollPane scrollPane = new JScrollPane(textito);
		scrollPane.setBounds(22, 110, 750, 300);
		add(scrollPane);

		JLabel MANCHA_TOP = new JLabel("");
		MANCHA_TOP.setIcon(new ImageIcon("./background/mancha.png"));
		MANCHA_TOP.setBounds(-409, -373, 1588, 608);
		add(MANCHA_TOP);

		JLabel MANCHA_BOTTOM = new JLabel("");
		MANCHA_BOTTOM.setIcon(new ImageIcon("./background/mancha.png"));
		MANCHA_BOTTOM.setBounds(-409, 264, 1467, 398);
		add(MANCHA_BOTTOM);
	}
}
