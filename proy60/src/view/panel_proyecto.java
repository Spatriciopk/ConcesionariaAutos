package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.border.SoftBevelBorder;

import libreria.configurable;
import controller.business_logic;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panel_proyecto extends JPanel implements configurable{

	public JPanel contentPane;
	/**
	 * Create the panel.
	 */
	
	private business_logic bl;
	
	public panel_proyecto() {
		setLayout(null);
		
		JPanel pn_proyect = new JPanel();
		pn_proyect.setForeground(new Color(255, 255, 255));
		pn_proyect.setBorder(new MatteBorder(3, 0, 3, 1, (Color) new Color(0, 0, 0)));
		pn_proyect.setBackground(new Color(255, 255, 255));
		pn_proyect.setBounds(0, 0, 671, 719);
		add(pn_proyect);
		pn_proyect.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("BIENVENIDO A NUESTRO SISTEMA DE VEHICULOS");
		lblNewLabel_3.setFont(new Font("Gunplay", Font.PLAIN, 17));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(221, 335, 450, 48);
		pn_proyect.add(lblNewLabel_3);
		
		//registro_cliente rc = new registro_cliente(p,this);
		//FUNCION DE PARA INGRESAR A LA VENTANA DE USUARIO
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				principalCliente registroC = new principalCliente();
				registroC.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(161, 8, 108, 41);
		pn_proyect.add(btnNewButton);
		
		JButton btnCatalogo = new JButton("CAT\u00C1LOGO");
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catalogo ca = new catalogo();
				ca.setVisible(true);
			}

		
		});
		btnCatalogo.setForeground(Color.WHITE);
		btnCatalogo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		btnCatalogo.setBackground(Color.BLACK);
		btnCatalogo.setBounds(279, 8, 108, 41);
		pn_proyect.add(btnCatalogo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/c2.png"));
		lblNewLabel_1.setBounds(0, 69, 671, 314);
		pn_proyect.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		
		lblNewLabel_2.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/marca1.png"));
		lblNewLabel_2.setBounds(10, 393, 45, 58);
		pn_proyect.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		
		lblNewLabel_4.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/marca2.png"));
		lblNewLabel_4.setBounds(78, 406, 75, 32);
		pn_proyect.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/acur.png"));
		lblNewLabel_5.setBounds(178, 393, 75, 79);
		pn_proyect.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/v.png"));
		lblNewLabel_6.setBounds(279, 394, 48, 56);
		pn_proyect.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/aguill.png"));
		lblNewLabel_7.setBounds(354, 393, 66, 70);
		pn_proyect.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/rauas.png"));
		lblNewLabel_8.setBounds(442, 406, 75, 35);
		pn_proyect.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/ch.png"));
		lblNewLabel_9.setBounds(527, 393, 122, 79);
		pn_proyect.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("TU AUTO IDEAL ");
		lblNewLabel_11.setForeground(new Color(139, 0, 0));
		lblNewLabel_11.setFont(new Font("Cambria", Font.BOLD, 19));
		lblNewLabel_11.setBounds(267, 552, 142, 21);
		pn_proyect.add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/autoss.png"));
		lblNewLabel_10.setBounds(-15, 482, 710, 185);
		pn_proyect.add(lblNewLabel_10);
		
		JLabel lblNewLabel_13 = new JLabel("ACERCA DE LOS DESARROLLADORES");
		lblNewLabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				println(autor(),3);
			}
		});
		lblNewLabel_13.setFont(new Font("Segoe UI Historic", Font.PLAIN, 10));
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setBounds(10, 688, 243, 21);
		pn_proyect.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("\u00A9 2022 LSZMA");
		lblNewLabel_14.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_14.setForeground(new Color(255, 255, 255));
		lblNewLabel_14.setBounds(575, 692, 86, 13);
		pn_proyect.add(lblNewLabel_14);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/xs.png"));
		lblNewLabel_12.setBounds(0, 677, 671, 42);
		pn_proyect.add(lblNewLabel_12);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/M.png"));
		lblNewLabel_15.setBounds(22, 0, 45, 48);
		pn_proyect.add(lblNewLabel_15);
		
		JLabel lblNewLabel_14_1 = new JLabel(" LSZMA");
		lblNewLabel_14_1.setForeground(Color.WHITE);
		lblNewLabel_14_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNewLabel_14_1.setBounds(73, 22, 66, 13);
		pn_proyect.add(lblNewLabel_14_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/xs.png"));
		lblNewLabel.setBackground(new Color(47, 79, 79));
		lblNewLabel.setBounds(0, 0, 671, 70);
		pn_proyect.add(lblNewLabel);

	}
	@Override
	public String autor() {
		// TODO Auto-generated method stub
		return "Programadores: \n";
	}
}
