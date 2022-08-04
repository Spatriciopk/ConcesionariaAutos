package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controller.business_logic;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class registro_cliente extends JDialog {

	public final JPanel contentPanel = new JPanel();
	public JTextField txt_nombre;
	
	private business_logic lb;
	private JTextField txt_apellido;
	
	public business_logic lb_;
	private JTextField txt_nombre2;
	private JPasswordField psw1;

	public registro_cliente rc ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			registro_cliente dialog = new registro_cliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public registro_cliente() {
		lb_ = new business_logic();
		rc = this;
		setTitle("USER");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/imgProyect/img/perfil.png"));
		setBounds(100, 100, 640, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel pn_cliente = new JPanel();
			pn_cliente.setBounds(0, 0, 626, 343);
			contentPanel.add(pn_cliente);
			pn_cliente.setLayout(null);
			{
				JPanel info_cliente = new JPanel();
				info_cliente.setLayout(null);
				info_cliente.setBackground(new Color(0, 0, 0));
				info_cliente.setBounds(0, 116, 626, 217);
				pn_cliente.add(info_cliente);
				{
					JLabel lblNewLabel = new JLabel("Ingrese su nombre de usuario");
					lblNewLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 11));
					lblNewLabel.setForeground(Color.GRAY);
					lblNewLabel.setBounds(90, 78, 211, 13);
					info_cliente.add(lblNewLabel);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Datos del usuario");
					lblNewLabel_2.setForeground(new Color(255, 255, 255));
					lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(10, 8, 170, 24);
					info_cliente.add(lblNewLabel_2);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("PSW:");
					lblNewLabel_2_1.setForeground(Color.WHITE);
					lblNewLabel_2_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 13));
					lblNewLabel_2_1.setBounds(362, 44, 44, 24);
					info_cliente.add(lblNewLabel_2_1);
				}
				{
					txt_nombre = new JTextField();
					txt_nombre.setForeground(Color.WHITE);
					txt_nombre.setBorder(null);
					txt_nombre.setBackground(new Color(0, 0, 0));
					txt_nombre.setToolTipText("Ingresa tu nombre");
					txt_nombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					txt_nombre.setColumns(10);
					txt_nombre.setBounds(90, 42, 211, 26);
					info_cliente.add(txt_nombre);
				}
				{
					txt_apellido = new JTextField();
					txt_apellido.setForeground(Color.WHITE);
					txt_apellido.setBorder(null);
					txt_apellido.setBackground(Color.BLACK);
					txt_apellido.setToolTipText("Ingresa tu nombre");
					txt_apellido.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					txt_apellido.setColumns(10);
					txt_apellido.setBounds(90, 156, 211, 26);
					info_cliente.add(txt_apellido);
				}
				{
					txt_nombre2 = new JTextField();
					txt_nombre2.setForeground(Color.WHITE);
					txt_nombre2.setBorder(null);
					txt_nombre2.setBackground(Color.BLACK);
					txt_nombre2.setToolTipText("Ingresa tu nombre");
					txt_nombre2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					txt_nombre2.setColumns(10);
					txt_nombre2.setBounds(90, 97, 211, 26);
					info_cliente.add(txt_nombre2);
				}
				
				psw1 = new JPasswordField();
				psw1.setForeground(Color.WHITE);
				psw1.setBorder(null);
				psw1.setBackground(Color.BLACK);
				psw1.setBounds(416, 44, 176, 20);
				info_cliente.add(psw1);
				{
					JLabel lblNewLabel_2 = new JLabel("Usuario:");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(10, 42, 70, 24);
					info_cliente.add(lblNewLabel_2);
				}
				{
					JSeparator separator = new JSeparator();
					separator.setBounds(90, 73, 211, 2);
					info_cliente.add(separator);
				}
				{
					JSeparator separator = new JSeparator();
					separator.setBounds(90, 128, 211, 2);
					info_cliente.add(separator);
				}
				{
					JLabel lblIngreseSuNombre = new JLabel("Ingrese su nombre ");
					lblIngreseSuNombre.setForeground(Color.GRAY);
					lblIngreseSuNombre.setFont(new Font("Segoe UI Historic", Font.PLAIN, 11));
					lblIngreseSuNombre.setBounds(90, 133, 211, 13);
					info_cliente.add(lblIngreseSuNombre);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Nombre:");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(10, 97, 70, 24);
					info_cliente.add(lblNewLabel_2);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Apellido:");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(10, 156, 70, 24);
					info_cliente.add(lblNewLabel_2);
				}
				{
					JSeparator separator = new JSeparator();
					separator.setBounds(90, 189, 211, 2);
					info_cliente.add(separator);
				}
				{
					JLabel lblIngreseSuApellido = new JLabel("Ingrese su apellido");
					lblIngreseSuApellido.setForeground(Color.GRAY);
					lblIngreseSuApellido.setFont(new Font("Segoe UI Historic", Font.PLAIN, 11));
					lblIngreseSuApellido.setBounds(90, 194, 211, 13);
					info_cliente.add(lblIngreseSuApellido);
				}
				{
					JSeparator separator = new JSeparator();
					separator.setBounds(416, 74, 172, 20);
					info_cliente.add(separator);
				}
				{
					JLabel lblIngreseSuContrasea = new JLabel("Ingrese su contrase\u00F1a");
					lblIngreseSuContrasea.setForeground(Color.GRAY);
					lblIngreseSuContrasea.setFont(new Font("Segoe UI Historic", Font.PLAIN, 11));
					lblIngreseSuContrasea.setBounds(416, 79, 172, 12);
					info_cliente.add(lblIngreseSuContrasea);
				}
			}
			{
				JLabel lblNewLabel_1 = new JLabel("BIENVENIDO!");
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
				lblNewLabel_1.setBounds(232, 43, 169, 24);
				pn_cliente.add(lblNewLabel_1);
			}
			{
				JLabel lbl_tittulo = new JLabel("");
				lbl_tittulo.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/regi1.png"));
				lbl_tittulo.setBackground(SystemColor.inactiveCaption);
				lbl_tittulo.setBounds(0, 0, 626, 343);
				pn_cliente.add(lbl_tittulo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton btn_ok = new JButton("OK");
				btn_ok.setFont(new Font("Segoe UI Historic", Font.PLAIN, 10));
				btn_ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//lb.validarIngresoClientes();
						//lb.escribirTexto();
						if(lb_.ingresarUsuario(txt_nombre.getText(), txt_nombre2.getText(), txt_apellido.getText(), psw1.getText())) {
							JOptionPane.showMessageDialog(null, "Usuario registrado.");
							rc.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "campos vacios o nombre ya existe");
						}
					}
				});
				btn_ok.setBackground(new Color(255, 255, 255));
				btn_ok.setActionCommand("OK");
				buttonPane.add(btn_ok);
				getRootPane().setDefaultButton(btn_ok);
			}
			{
				JButton btn_cancel = new JButton("cancel");
				btn_cancel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 10));
				btn_cancel.setBackground(new Color(255, 255, 255));
				btn_cancel.setActionCommand("Cancel");
				buttonPane.add(btn_cancel);
				
			}
			
		}
		lb=new business_logic(this);
		
	}
}
