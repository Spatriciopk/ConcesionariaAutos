package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.business_logic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class comprar_auto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String placa="";
	private String placa_nuevo="";
	private comprar_auto cmauto;
	private JLabel lbl_tipo;
	private JLabel lbl_marca;
	private JLabel lbl_modelo;
	private JLabel lbl_klm;
	private JLabel lbl_color;
	private JLabel lbl_choque;
	private JLabel lbl_aireAC;
	private JLabel lbl_pintura;
	private JLabel lbl_placa;
	private JLabel lbl_nDuenio;
	private JLabel lbl_anio;
	private JLabel lbl_tapiceria;
	private JLabel lbl_carroceria;
	private JLabel lblprecio;
	business_logic lb = new business_logic() ;
	private JButton btn_pago;
	private Double resto=0.0;
	private JButton btn_comprar;
	private JButton btn_cancelar;
	private JLabel lblNewLabel_11;
	private JLabel lbl_abono;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			comprar_auto dialog = new comprar_auto(null,null,0.0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public comprar_auto(String cod,String cod_nuevo,Double resto) {
		this.placa = cod;
		this.placa_nuevo = cod_nuevo;
		this.resto = resto;
		cmauto = this;
		System.out.println(placa);
		setBounds(100, 100, 533, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setBounds(12, 12, 70, 15);
		contentPanel.add(lblNewLabel);
		
		lbl_tipo = new JLabel("");
		lbl_tipo.setBounds(60, 12, 123, 15);
		contentPanel.add(lbl_tipo);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(12, 39, 70, 15);
		contentPanel.add(lblNewLabel_1);
		
		lbl_marca = new JLabel("");
		lbl_marca.setBounds(70, 39, 113, 15);
		contentPanel.add(lbl_marca);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setBounds(12, 66, 70, 15);
		contentPanel.add(lblNewLabel_2);
		
		lbl_modelo = new JLabel("");
		lbl_modelo.setBounds(80, 66, 70, 15);
		contentPanel.add(lbl_modelo);
		
		JLabel lblNewLabel_3 = new JLabel("Kilometraje:");
		lblNewLabel_3.setBounds(12, 93, 70, 15);
		contentPanel.add(lblNewLabel_3);
		
		lbl_klm = new JLabel("");
		lbl_klm.setBounds(90, 93, 130, 15);
		contentPanel.add(lbl_klm);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(12, 123, 70, 15);
		contentPanel.add(lblColor);
		
		lbl_color = new JLabel("");
		lbl_color.setBounds(60, 123, 137, 15);
		contentPanel.add(lbl_color);
		
		JLabel lblChoque = new JLabel("Choque:");
		lblChoque.setBounds(12, 150, 70, 15);
		contentPanel.add(lblChoque);
		
		lbl_choque = new JLabel("");
		lbl_choque.setBounds(80, 150, 117, 15);
		contentPanel.add(lbl_choque);
		
		JLabel lblNewLabel_4 = new JLabel("Aire Acondicionado:");
		lblNewLabel_4.setBounds(12, 180, 70, 15);
		contentPanel.add(lblNewLabel_4);
		
		lbl_aireAC = new JLabel("");
		lbl_aireAC.setBounds(94, 177, 70, 15);
		contentPanel.add(lbl_aireAC);
		
		JLabel lblNewLabel_5 = new JLabel("Pintura:");
		lblNewLabel_5.setBounds(227, 12, 70, 15);
		contentPanel.add(lblNewLabel_5);
		
		lbl_pintura = new JLabel("");
		lbl_pintura.setBounds(297, 12, 123, 15);
		contentPanel.add(lbl_pintura);
		
		JLabel lblNewLabel_6 = new JLabel("Placa:");
		lblNewLabel_6.setBounds(227, 39, 70, 15);
		contentPanel.add(lblNewLabel_6);
		
		lbl_placa = new JLabel("");
		lbl_placa.setBounds(297, 39, 70, 15);
		contentPanel.add(lbl_placa);
		
		JLabel lblNewLabel_7 = new JLabel("Dueños:");
		lblNewLabel_7.setBounds(227, 66, 70, 15);
		contentPanel.add(lblNewLabel_7);
		
		lbl_nDuenio = new JLabel("");
		lbl_nDuenio.setBounds(297, 77, 105, 15);
		contentPanel.add(lbl_nDuenio);
		
		JLabel lblNewLabel_8 = new JLabel("Año:");
		lblNewLabel_8.setBounds(227, 93, 70, 15);
		contentPanel.add(lblNewLabel_8);
		
		lbl_anio = new JLabel("");
		lbl_anio.setBounds(297, 93, 105, 15);
		contentPanel.add(lbl_anio);
		
		JLabel lblNewLabel_9 = new JLabel("Tapicería:");
		lblNewLabel_9.setBounds(227, 123, 70, 15);
		contentPanel.add(lblNewLabel_9);
		
		lbl_tapiceria = new JLabel("");
		lbl_tapiceria.setBounds(297, 123, 123, 15);
		contentPanel.add(lbl_tapiceria);
		
		JLabel lblNewLabel_10 = new JLabel("Carrocería:");
		lblNewLabel_10.setBounds(227, 150, 70, 15);
		contentPanel.add(lblNewLabel_10);
		
		lbl_carroceria = new JLabel("");
		lbl_carroceria.setBounds(297, 150, 105, 15);
		contentPanel.add(lbl_carroceria);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(227, 180, 70, 15);
		contentPanel.add(lblPrecio);
		
		lblprecio = new JLabel("");
		lblprecio.setBounds(297, 180, 70, 15);
		String sql ="Select * from auto where cod_auto = '"+placa+"';";
		lb.setearDatosAuto(lbl_tipo, lbl_marca, lbl_modelo, 
				lbl_klm, lbl_color, lbl_choque, lbl_aireAC,
				lbl_pintura, lbl_placa, lbl_nDuenio, lbl_anio, 
				lbl_tapiceria,lbl_carroceria,lblprecio, sql);
		contentPanel.add(lblprecio);
		lblprecio.setText((Double.parseDouble(lblprecio.getText()+"")-resto)+"");
		btn_pago = new JButton("Dar como forma pago otro carro");
		btn_pago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forma_pago fp = new forma_pago(placa);
				fp.setVisible(true);
				cmauto.setVisible(false);
			}
		});
		btn_pago.setBounds(104, 211, 263, 25);
		contentPanel.add(btn_pago);
		
		btn_comprar = new JButton("Comprar");
		btn_comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb.borrarAuto(placa);
				lb.borrarAutoImagenes(placa);
				JOptionPane.showMessageDialog(null, "Auto vendido correctamente");
				cmauto.setVisible(false);
				catalogo c = new catalogo();
				c.setVisible(true);
				
			}
		});
		btn_comprar.setBounds(239, 236, 117, 25);
		contentPanel.add(btn_comprar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(placa_nuevo.length()>=0) {
					lb.borrarAuto(placa_nuevo);
					lb.borrarAutoImagenes(placa_nuevo);
				}
				cmauto.setVisible(false);
				catalogo c = new catalogo();
				c.setVisible(true);
			

			}
		});
		btn_cancelar.setBounds(80, 236, 117, 25);
		contentPanel.add(btn_cancelar);
		
		lblNewLabel_11 = new JLabel("Abono:");
		lblNewLabel_11.setBounds(413, 150, 70, 15);
		contentPanel.add(lblNewLabel_11);
		
		lbl_abono = new JLabel("");
		lbl_abono.setBounds(472, 150, 49, 15);
		contentPanel.add(lbl_abono);
		lbl_abono.setText(resto+"");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
