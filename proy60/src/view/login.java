package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import controller.business_logic;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txt_nombre;
	private JPasswordField txt_psw;
	private JButton btn_regresar;
	public business_logic bl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			login dialog = new login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public login() {
		login l = this;
		bl = new business_logic();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/imgProyect/img/iniciar-sesion.png"));
		setTitle("Ingresar");
		setBounds(100, 100, 435, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel pn_login = new JPanel();
			pn_login.setBackground(new Color(255, 255, 255));
			pn_login.setBounds(0, 0, 421, 238);
			contentPanel.add(pn_login);
			pn_login.setLayout(null);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setForeground(Color.WHITE);
			separator_1.setBounds(63, 167, 294, 2);
			pn_login.add(separator_1);
			
			JLabel lblNewLabel_2_1 = new JLabel("Ingrese su contrase\u00F1a");
			lblNewLabel_2_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 11));
			lblNewLabel_2_1.setForeground(Color.GRAY);
			lblNewLabel_2_1.setBounds(63, 176, 170, 13);
			pn_login.add(lblNewLabel_2_1);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(new Color(255, 255, 255));
			separator.setBounds(63, 72, 294, 2);
			pn_login.add(separator);
			
			JLabel lblNewLabel_2 = new JLabel("Ingrese su usuario");
			lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 11));
			lblNewLabel_2.setForeground(new Color(128, 128, 128));
			lblNewLabel_2.setBounds(63, 81, 170, 13);
			pn_login.add(lblNewLabel_2);
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
			lblNewLabel.setBounds(63, 10, 65, 22);
			pn_login.add(lblNewLabel);
			
			JLabel lblPsw = new JLabel("PSW:");
			lblPsw.setForeground(new Color(255, 255, 255));
			lblPsw.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
			lblPsw.setBounds(63, 96, 65, 22);
			pn_login.add(lblPsw);
			
			txt_nombre = new JTextField();
			txt_nombre.setForeground(Color.WHITE);
			txt_nombre.setBorder(null);
			txt_nombre.setBackground(new Color(0, 0, 0));
			txt_nombre.setToolTipText("Ingresa tu nombre");
			txt_nombre.setBounds(63, 42, 294, 29);
			pn_login.add(txt_nombre);
			txt_nombre.setColumns(10);
			
			txt_psw = new JPasswordField();
			txt_psw.setForeground(Color.WHITE);
			txt_psw.setBackground(new Color(0, 0, 0));
			txt_psw.setBorder(null);
			txt_psw.setToolTipText("Ingresa tu psw");
			txt_psw.setBounds(63, 133, 294, 29);
			pn_login.add(txt_psw);
			
			JLabel lblNewLabel_1 = new JLabel("");
			

			lblNewLabel_1.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/login1.jpg"));
			lblNewLabel_1.setBounds(0, 0, 421, 238);
			pn_login.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				business_logic s = new business_logic();
				JButton btn_iniciar = new JButton("LOGIN");
				btn_iniciar.setForeground(new Color(255, 255, 255));
				btn_iniciar.setBackground(new Color(51, 51, 51));
				btn_iniciar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*if(s.verificarRegistroCl(txt_nombre.getText(), txt_psw.getText())) {
							registro_autos rg= new registro_autos	();
							rg.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "Usuario o psw incorrecta.");
						}*/
						if(bl.validarIngreso(txt_nombre.getText(), txt_psw.getText())) {
							registro_autos rg= new registro_autos	();
							rg.setVisible(true);
							l.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "Usuario o psw incorrecta.");
						}
						
					}

					
				});
				
				btn_regresar = new JButton("Regresar");
				btn_regresar.setBackground(new Color(51, 51, 51));
				btn_regresar.setForeground(new Color(255, 255, 255));
				btn_regresar.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
				btn_regresar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						principalCliente pC = new principalCliente();
						pC.setVisible(true);
						l.setVisible(false);
						}
				});
				buttonPane.add(btn_regresar);
				
				btn_iniciar.setActionCommand("OK");
				buttonPane.add(btn_iniciar);
				getRootPane().setDefaultButton(btn_iniciar);
			}
		}
	}
}
