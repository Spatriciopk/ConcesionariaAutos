package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class principalCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			principalCliente dialog = new principalCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public principalCliente() {
		principalCliente p = this;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/imgProyect/img/lavado-de-autos.png"));
		setTitle("USER");
		setBounds(100, 100, 502, 394);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel pn_iniciar = new JPanel();
			pn_iniciar.setBackground(new Color(255, 255, 255));
			pn_iniciar.setBounds(0, 0, 492, 362);
			contentPanel.add(pn_iniciar);
			pn_iniciar.setLayout(null);
			
			JButton btn_IniciarSesion = new JButton("Iniciar sesi\u00F3n");
			btn_IniciarSesion.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
			btn_IniciarSesion.setBackground(new Color(255, 255, 255));
			btn_IniciarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login ln = new login();
					ln.setVisible(true);
					p.setVisible(false);
					this.dispose();
				}

				private void dispose() {
					// TODO Auto-generated method stub
					
				}
			});
			btn_IniciarSesion.setBounds(296, 203, 183, 54);
			pn_iniciar.add(btn_IniciarSesion);
			
			JButton btn_regsistroCliente = new JButton("Registrar usuario");
			btn_regsistroCliente.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
			btn_regsistroCliente.setBackground(new Color(255, 255, 255));
			btn_regsistroCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registro_cliente registroCl = new registro_cliente();
					registroCl.setVisible(true);
					this.dispose();
					
				}

				private void dispose() {
					// TODO Auto-generated method stub
					
				}
			});
			btn_regsistroCliente.setBounds(296, 126, 183, 54);
			pn_iniciar.add(btn_regsistroCliente);
			
			JLabel lblNewLabel_2 = new JLabel("LSZMA");
			lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 17));
			lblNewLabel_2.setBounds(364, 93, 106, 23);
			pn_iniciar.add(lblNewLabel_2);
			
			JLabel lblNewLabel_4 = new JLabel("BIENVENIDO!");
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setFont(new Font("Stencil", Font.PLAIN, 19));
			lblNewLabel_4.setBounds(21, 89, 201, 48);
			pn_iniciar.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("So\u00F1ar con tu propio carro");
			lblNewLabel_5.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
			lblNewLabel_5.setForeground(new Color(255, 255, 255));
			lblNewLabel_5.setBounds(21, 173, 248, 47);
			pn_iniciar.add(lblNewLabel_5);
			
			JLabel lblNewLabel_5_1 = new JLabel("Si es posible");
			lblNewLabel_5_1.setForeground(new Color(204, 153, 0));
			lblNewLabel_5_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
			lblNewLabel_5_1.setBounds(21, 210, 248, 40);
			pn_iniciar.add(lblNewLabel_5_1);
			
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/p2.jpg"));
			lblNewLabel_3.setBounds(0, 0, 286, 360);
			pn_iniciar.add(lblNewLabel_3);
		}
	}
}
