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

public class Instrucciones extends JPanel {
	private Ventana ventana;

	public Instrucciones(Ventana v) {
		super();
		setBackground(Color.WHITE);
		this.ventana = v;
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("INSTRUCCIONES");
		lblNewLabel_1.setFont(new Font("Personal Services", Font.PLAIN, 55));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(325, 478, 454, 79);
		add(lblNewLabel_1);
		
		JButton ATRAS = new BotonAnimado("ATR\u00C1S");
		ATRAS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("MenuPrincipal");
			}
		});
		ATRAS.setBounds(32, 26, 116, 21);
		add(ATRAS);
		
		JTextPane txtpnBienvenidoACard = new JTextPane();
		txtpnBienvenidoACard.setText("BIENVENIDO A CARD FIGHTERS, EN ESTA PANTALLA TE CONTAR\u00C9 C\u00D3MO FUNCIONAN LAS MEC\u00C1NICAS DEL JUEGO.\r\n\r\nTODOS LOS PERSONAJES TIENEN 20 PUNTOS DE VIDA Y UN M\u00C1XIMO DE 5 PUNTOS DE ENERG\u00CDA.\r\n\r\nCUANDO EMPIECE EL COMBATE CADA JUGADOR TENDR\u00C1 20 CARTAS EN SU MANO PARA ELEGIR, HAY 3 TIPOS DE CARTAS: \r\n\r\n- TIPO B\u00C1SICO: SON CARTAS COMUNES QUE TANTO T\u00DA COMO TU RIVAL LAS POSEEIS, SON PU\u00D1ETAZO, ACOMETIDA Y BLOQUEO. \r\nBLOQUEO ES UNA DE LAS CARTAS MAS CRUCIALES EN EL COMBATE, ESTA CARTA SIEMPRE IR\u00C1 ANTES QUE CUALQUIERA Y BLOQUEAR\u00C1 POR COMPLETO EL GOLPE DE TU RIVAL Y NO RECIBIR\u00C1S DA\u00D1O.\r\n\r\n- TIPO ESPECIAL: COMO BIEN DICE SU NOMBRE SON CARTAS ESPECIALES EXCLUSIVAS DE CADA PERSONAJE, PERO A DIFERENCIA DE LAS B\u00C1SICAS TIENEN UN COSTE DE ENERG\u00CDA QUE SE MOSTRAR\u00C1 EN COLOR AZUL EN LA CARTA. \r\n\r\n- TIPO ULTIMATE: ES LA CARTA M\u00C1S PODEROSA DEL PERSONAJE, TIENEN COSTE DE VIDA POR LO QUE DEBER\u00C1S PLANTEAR LA SITUACI\u00D3N PERFECTA PARA USARLA, YA QUE UN USO INDEBIDO PUEDE LLEVARTE A LA DERROTA, EL COSTE DE VIDA APARECER\u00C1 EN COLOR ROJO EN LA CARTA.\r\n\r\nCARACTER\u00CDSTICAS PRINCIPALES COMUNES DE TODAS LAS CARTAS: \r\n\r\n- DA\u00D1O: LA CANTIDAD DE PUNTOS DE ATAQUE QUE LE HAR\u00C1S AL RIVAL SI IMPACTAS CON LA CARTA. \r\n\r\n- VELOCIDAD: SI TU CARTA ES M\u00C1S RAPIDA QUE LA DEL RIVAL, ACERTAR\u00C1S CON ELLA, SINO TU ATAQUE SER\u00C1 INTERRUMPIDO Y PERDER\u00C1S TANTO LA CARTA COMO EL TURNO. \r\n\r\n- ALCANCE: ES EL RANGO EN EL QUE LA CARTA PUEDE SER IMPACTADA.\r\n\r\nLISTO, HORA DE LUCHAR.");
		txtpnBienvenidoACard.setForeground(Color.BLACK);
		txtpnBienvenidoACard.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		txtpnBienvenidoACard.setEditable(false);
		txtpnBienvenidoACard.setBackground(Color.WHITE);
		txtpnBienvenidoACard.setBounds(0, 67, 800, 384);
		add(txtpnBienvenidoACard);
		
		JLabel MANCHA_TOP = new JLabel("");
		MANCHA_TOP.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		MANCHA_TOP.setBounds(-409, -373, 1588, 608);
		add(MANCHA_TOP);
		
		JLabel MANCHA_BOTTOM = new JLabel("");
		MANCHA_BOTTOM.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha.png"));
		MANCHA_BOTTOM.setBounds(-409, 264, 1467, 398);
		add(MANCHA_BOTTOM);
	}
}
