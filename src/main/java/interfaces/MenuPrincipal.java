package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class MenuPrincipal extends JPanel {
	private Ventana ventana;

	public MenuPrincipal(Ventana v) {
		super();
		
		this.ventana = v;
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CARD FIGHTERS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 48));
		lblNewLabel_1.setBounds(148, 69, 408, 44);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u00A1LUCHAR!");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(286, 239, 131, 44);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\mancha small.png"));
		lblNewLabel_2.setBounds(25, -23, 642, 195);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\toled\\Desktop\\CENEC 2021 - 1\u00BA DAW\\Programaci\u00F3n\\3\u00BA Trimestre\\CARD-FIGHTERS\\background\\menu.jpg"));
		lblNewLabel.setBounds(0, 0, 720, 480);
		add(lblNewLabel);
		
		
	}
}
