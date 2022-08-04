package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.business_logic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cambiar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_valCodigo;

	private JButton btn_aceptar;
	private JButton btn_cancelar;
	
	business_logic lb = new business_logic();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			cambiar dialog = new cambiar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public cambiar() {
		setTitle("Buscar");
		setBounds(100, 100, 450, 146);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 71);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 102, 38);
		panel.add(lblNewLabel);
		
		txt_valCodigo = new JTextField();
		txt_valCodigo.setBounds(88, 20, 301, 25);
		panel.add(txt_valCodigo);
		txt_valCodigo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/p6.jpg"));
		lblNewLabel_1.setBounds(0, 0, 436, 71);
		panel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_aceptar = new JButton("OK");
				btn_aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txt_valCodigo.getText()!=null) {
							JOptionPane.showMessageDialog(null, "Vehiculo encontrado");
						}else {
							JOptionPane.showMessageDialog(null, "Vehiculo no encontrado");
						}
					}
				});
				btn_aceptar.setActionCommand("OK");
				buttonPane.add(btn_aceptar);
				getRootPane().setDefaultButton(btn_aceptar);
			}
			{
				JButton btn_cancelar = new JButton("Cancel");
				btn_cancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registro_autos frame=new registro_autos();
						frame.setVisible(true);
					}
				});
				btn_cancelar.setActionCommand("Cancel");
				buttonPane.add(btn_cancelar);
				
			}
		}
	}
}
