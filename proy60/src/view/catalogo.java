package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import controller.bannerImagen;
import controller.business_logic;
import modelo.Imagen;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class catalogo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	business_logic lb = new business_logic() ;
	private JLabel lbl_IMG;
	private JLabel lbl_IMG_1;
	private JLabel lbl_IMG_2;
	int cont =0;
	int numreg ;
	private JButton btn_sigu;
	private JButton btn_ante;
	String placaaux="";
	int sig=3;
	public bannerImagen bi ;
	Thread imgH ;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lbl_tipo;
	private JLabel lblNewLabel_6;
	private JLabel lbl_placa;
	private JLabel lblNewLabel_5;
	private JLabel lbl_marca;
	private JLabel lblNewLabel_7;
	private JLabel lbl_modelo;
	private JLabel lblNewLabel_8;
	private JLabel lbl_anio;
	private JLabel lblNewLabel_9;
	private JLabel lbl_klm;
	private JLabel lblNewLabel_10;
	private JLabel lbl_placa_7;
	private JLabel lbl_color;
	private JLabel lbl_placa_9;
	private JLabel lbl_nDuenio;
	private JLabel lbl_placa_11;
	private JLabel lbl_placa_12;
	private JLabel lbl_choque;
	private JLabel lbl_aireAC;
	private JLabel lbl_placa_15;
	private JLabel lbl_placa_16;
	private JLabel lbl_tapiceria;
	private JLabel lbl_pintura;
	private JButton btn_comprar;
	private JSeparator separator;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_14;
	private JLabel LBL;
	private JLabel lblNewLabel_12;
	private JLabel lbl_carroceria;
	private JTextField txt_buscar;
	private JButton btnActualizar;
	private catalogo cat;
	private JLabel lblPrecio;
	private JLabel lblprecio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			catalogo dialog = new catalogo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public catalogo() {
		numreg=lb.numregistro();
		cat = this;
		setTitle("Cat\u00E1logo");
		setBounds(100, 100, 947, 626);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel pn_catalogo = new JPanel();
		pn_catalogo.setBackground(Color.WHITE);
		pn_catalogo.setBounds(0, 0, 618, 596);
		contentPanel.add(pn_catalogo);
		pn_catalogo.setLayout(null);

		lblNewLabel_11 = new JLabel("Ingrese su busqueda");
		lblNewLabel_11.setFont(new Font("Segoe UI Historic", Font.PLAIN, 10));
		lblNewLabel_11.setForeground(Color.GRAY);
		lblNewLabel_11.setBounds(74, 89, 404, 13);
		pn_catalogo.add(lblNewLabel_11);

		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(74, 79, 402, 2);
		pn_catalogo.add(separator);

		btn_comprar = new JButton("Cotizar");
		btn_comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprar_auto a = new comprar_auto(lbl_placa.getText(),"",0.0);
				a.setVisible(true);
				cat.setVisible(false);
			}
		});
		btn_comprar.setForeground(new Color(255, 255, 255));
		btn_comprar.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		btn_comprar.setBorder(null);
		btn_comprar.setBackground(Color.BLACK);
		btn_comprar.setBounds(492, 524, 116, 56);
		pn_catalogo.add(btn_comprar);

		lbl_pintura = new JLabel("...");
		lbl_pintura.setForeground(new Color(0, 0, 0));
		lbl_pintura.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_pintura.setBounds(310, 466, 90, 23);
		pn_catalogo.add(lbl_pintura);

		lbl_tapiceria = new JLabel("...");
		lbl_tapiceria.setForeground(new Color(0, 0, 0));
		lbl_tapiceria.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_tapiceria.setBounds(515, 466, 90, 23);
		pn_catalogo.add(lbl_tapiceria);

		lbl_placa_16 = new JLabel("Pintura:");
		lbl_placa_16.setForeground(new Color(0, 0, 0));
		lbl_placa_16.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_placa_16.setBounds(215, 466, 90, 21);
		pn_catalogo.add(lbl_placa_16);

		lbl_placa_15 = new JLabel("Tapiceria:");
		lbl_placa_15.setForeground(new Color(0, 0, 0));
		lbl_placa_15.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_placa_15.setBounds(420, 466, 90, 21);
		pn_catalogo.add(lbl_placa_15);

		lbl_choque = new JLabel("...");
		lbl_choque.setForeground(new Color(0, 0, 0));
		lbl_choque.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_choque.setBounds(310, 400, 90, 23);
		pn_catalogo.add(lbl_choque);

		lbl_aireAC = new JLabel("...");
		lbl_aireAC.setForeground(new Color(0, 0, 0));
		lbl_aireAC.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_aireAC.setBounds(310, 433, 90, 23);
		pn_catalogo.add(lbl_aireAC);

		lbl_placa_12 = new JLabel("Aire acond. :");
		lbl_placa_12.setForeground(new Color(0, 0, 0));
		lbl_placa_12.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_placa_12.setBounds(215, 433, 90, 21);
		pn_catalogo.add(lbl_placa_12);

		lbl_placa_11 = new JLabel("Choque:");
		lbl_placa_11.setForeground(new Color(0, 0, 0));
		lbl_placa_11.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_placa_11.setBounds(215, 400, 78, 23);
		pn_catalogo.add(lbl_placa_11);

		lbl_nDuenio = new JLabel("...");
		lbl_nDuenio.setForeground(new Color(0, 0, 0));
		lbl_nDuenio.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_nDuenio.setBounds(515, 400, 90, 23);
		pn_catalogo.add(lbl_nDuenio);

		lbl_placa_9 = new JLabel("N. Due\u00F1o:");
		lbl_placa_9.setForeground(new Color(0, 0, 0));
		lbl_placa_9.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_placa_9.setBounds(420, 400, 78, 23);
		pn_catalogo.add(lbl_placa_9);

		lbl_color = new JLabel("...");
		lbl_color.setForeground(new Color(0, 0, 0));
		lbl_color.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_color.setBounds(310, 367, 90, 23);
		pn_catalogo.add(lbl_color);

		lbl_placa_7 = new JLabel("Color:");
		lbl_placa_7.setForeground(new Color(0, 0, 0));
		lbl_placa_7.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_placa_7.setBounds(219, 367, 49, 23);
		pn_catalogo.add(lbl_placa_7);

		lblNewLabel_10 = new JLabel("Precio:");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(51, 557, 49, 23);
		pn_catalogo.add(lblNewLabel_10);

		lbl_klm = new JLabel("...");
		lbl_klm.setForeground(new Color(0, 0, 0));
		lbl_klm.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_klm.setBounds(79, 466, 90, 23);
		pn_catalogo.add(lbl_klm);

		lblNewLabel_9 = new JLabel("Kilom:");
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(20, 466, 49, 23);
		pn_catalogo.add(lblNewLabel_9);

		lbl_anio = new JLabel("...");
		lbl_anio.setForeground(new Color(0, 0, 0));
		lbl_anio.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_anio.setBounds(515, 433, 90, 23);
		pn_catalogo.add(lbl_anio);

		lblNewLabel_8 = new JLabel("A\u00F1o:");
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(449, 433, 49, 23);
		pn_catalogo.add(lblNewLabel_8);

		lbl_placa = new JLabel("...");
		lbl_placa.setForeground(new Color(0, 0, 0));
		lbl_placa.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_placa.setBounds(515, 367, 90, 23);
		pn_catalogo.add(lbl_placa);

		lblNewLabel_6 = new JLabel("Placa:");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(438, 367, 49, 23);
		pn_catalogo.add(lblNewLabel_6);

		lbl_tipo = new JLabel("...");
		lbl_tipo.setForeground(new Color(0, 0, 0));
		lbl_tipo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_tipo.setBounds(84, 367, 96, 23);
		pn_catalogo.add(lbl_tipo);

		lblNewLabel_4 = new JLabel("Tipo:");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(20, 362, 49, 23);
		pn_catalogo.add(lblNewLabel_4);

		lblNewLabel_3 = new JLabel("Datos del auto");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(10, 326, 160, 23);
		pn_catalogo.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("LSZMA");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(12, 8, 168, 23);
		pn_catalogo.add(lblNewLabel_1);

		txt_buscar = new JTextField();


		txt_buscar.setForeground(new Color(0, 0, 0));
		txt_buscar.setBackground(Color.WHITE);
		txt_buscar.setBorder(null);
		txt_buscar.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		txt_buscar.setBounds(74, 43, 404, 32);
		pn_catalogo.add(txt_buscar);
		txt_buscar.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Buscar:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 52, 72, 23);
		pn_catalogo.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("...");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(502, 50, 85, 23);
		pn_catalogo.add(btnNewButton);

		lbl_IMG = new JLabel("");
		lbl_IMG.setIcon(new ImageIcon((System.getProperty("user.dir")+"/imgProyect/img/auto1.png")));
		lbl_IMG.setBorder(null);
		lbl_IMG.setBounds(10, 122, 185, 184);
		pn_catalogo.add(lbl_IMG);

		btn_ante = new JButton("Anterior");
		btn_ante.setBorder(null);
		btn_ante.setForeground(new Color(255, 255, 255));
		btn_ante.setEnabled(false);
		btn_ante.setBackground(new Color(0, 0, 0));


		btn_ante.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		btn_ante.setBounds(273, 536, 98, 32);
		pn_catalogo.add(btn_ante);

		btn_sigu = new JButton("Siguiente");
		btn_sigu.setBorder(null);
		btn_sigu.setForeground(new Color(255, 255, 255));

		btn_sigu.setBackground(new Color(0, 0, 0));
		btn_sigu.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		btn_sigu.setBounds(384, 536, 98, 32);
		pn_catalogo.add(btn_sigu);

		lbl_IMG_1 = new JLabel("");
		lbl_IMG_1.setBorder(null);
		lbl_IMG_1.setBounds(205, 122, 185, 184);
		pn_catalogo.add(lbl_IMG_1);

		lbl_IMG_2 = new JLabel("");
		lbl_IMG_2.setBorder(null);
		lbl_IMG_2.setBounds(402, 122, 185, 184);
		lblprecio = new JLabel("0");
		lblprecio.setBounds(74, 545, 70, 15);
		pn_catalogo.add(lblprecio);
		pn_catalogo.add(lbl_IMG_2);
		if((cont+1) == numreg){
			btn_sigu.setEnabled(false);
		}
		ArrayList<JLabel> imagenes = new ArrayList<>();


		imagenes.add(lbl_IMG_2);
		imagenes.add(lbl_IMG_1);
		imagenes.add(lbl_IMG);

		lblNewLabel_5 = new JLabel("Marca:");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(20, 400, 49, 23);
		pn_catalogo.add(lblNewLabel_5);

		lbl_marca = new JLabel("...");
		lbl_marca.setForeground(new Color(0, 0, 0));
		lbl_marca.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_marca.setBounds(84, 400, 96, 23);
		pn_catalogo.add(lbl_marca);

		lblNewLabel_7 = new JLabel("Modelo:");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(20, 435, 63, 23);
		pn_catalogo.add(lblNewLabel_7);

		lbl_modelo = new JLabel("...");
		lbl_modelo.setForeground(new Color(0, 0, 0));
		lbl_modelo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lbl_modelo.setBounds(84, 435, 96, 23);
		pn_catalogo.add(lbl_modelo);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/barra.png"));
		lblNewLabel.setBounds(0, 0, 618, 38);
		pn_catalogo.add(lblNewLabel);

		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/c14.png"));
		lblNewLabel_14.setBounds(0, 104, 618, 220);
		pn_catalogo.add(lblNewLabel_14);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(618, 0, 317, 596);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_12_1 = new JLabel("IDEAL");
		lblNewLabel_12_1.setForeground(Color.WHITE);
		lblNewLabel_12_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		lblNewLabel_12_1.setBounds(149, 145, 87, 32);
		panel.add(lblNewLabel_12_1);

		lblNewLabel_12 = new JLabel("ELIGE TU AUTO");
		lblNewLabel_12.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setBounds(42, 126, 161, 32);
		panel.add(lblNewLabel_12);

		JLabel lblCarroceria = new JLabel("Carroceria:");
		lblCarroceria.setBounds(20, 514, 70, 15);
		pn_catalogo.add(lblCarroceria);

		lbl_carroceria = new JLabel("...");
		lbl_carroceria.setBounds(99, 514, 70, 15);
		pn_catalogo.add(lbl_carroceria);
		LBL = new JLabel("");
		LBL.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/pC.jpg"));
		LBL.setBounds(0, 0, 317, 596);
		panel.add(LBL);
		int cont2 = 0;
		ArrayList <Imagen> img = lb.obtenerImagenesAutos("SELECT * FROM imagenes LIMIT 3;");
		
		for (Imagen im : img) {

			ImageIcon imagen=new ImageIcon(im.getImagen().getScaledInstance(imagenes.get(cont2).getWidth(), imagenes.get(cont2).getHeight(), Image.SCALE_DEFAULT));
			imagenes.get(cont2).setIcon(imagen);
			cont2 ++;
		}
		btn_sigu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cont++;
			
				sig=sig+3;
				if((cont+1) == numreg){
					btn_sigu.setEnabled(false);

				}
				btn_ante.setEnabled(true);
				System.out.println(sig);
				placaaux = lb.obtenerPlacaSiguiente(sig);
				while(placaaux.equals("")) {
					sig=sig+3;
					placaaux = lb.obtenerPlacaSiguiente(sig);
				}
				System.out.println(placaaux);
				String sql ="Select * from auto where cod_auto = '"+placaaux+"';";
				lb.setearDatosAuto(lbl_tipo, lbl_marca, lbl_modelo, lbl_klm, lbl_color, lbl_choque, lbl_aireAC, lbl_pintura, lbl_placa, lbl_nDuenio, lbl_anio, lbl_tapiceria,lbl_carroceria,lblprecio, sql);
				int cont2 = 0;
				ArrayList <Imagen> img = lb.obtenerImagenesAutos("SELECT * FROM imagenes where cod_auto='"+placaaux+"' ;");
				for (Imagen im : img) {

					ImageIcon imagen=new ImageIcon(im.getImagen().getScaledInstance(imagenes.get(cont2).getWidth(), imagenes.get(cont2).getHeight(), Image.SCALE_DEFAULT));
					imagenes.get(cont2).setIcon(imagen);
					cont2 ++;
				}	
				imgH.stop();
				imgH = new bannerImagen(imagenes);
				imgH.start();



			}
		});
		btn_ante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cont--;
				sig=sig-3;
				if(cont==0) {
					btn_ante.setEnabled(false);
				}
				btn_sigu.setEnabled(true);
				placaaux = lb.obtenerPlacaSiguiente(sig);
				while(placaaux.equals("")) {
					sig=sig-3;
					placaaux = lb.obtenerPlacaSiguiente(sig);
				}
				String sql ="Select * from auto where cod_auto = '"+placaaux+"';";
				lb.setearDatosAuto(lbl_tipo, lbl_marca, lbl_modelo, lbl_klm, lbl_color, lbl_choque, lbl_aireAC, lbl_pintura, lbl_placa, lbl_nDuenio, lbl_anio, lbl_tapiceria,lbl_carroceria, lblprecio,sql);
				int cont2 = 0;
				ArrayList <Imagen> img = lb.obtenerImagenesAutos("SELECT * FROM imagenes where cod_auto='"+placaaux+"' ;");
				for (Imagen im : img) {

					ImageIcon imagen=new ImageIcon(im.getImagen().getScaledInstance(imagenes.get(cont2).getWidth(), imagenes.get(cont2).getHeight(), Image.SCALE_DEFAULT));
					imagenes.get(cont2).setIcon(imagen);
					cont2 ++;
				}
				imgH.stop();
				imgH = new bannerImagen(imagenes);
				imgH.start();
			}

		});
		txt_buscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!e.isConsumed()) {
					btn_ante.setEnabled(false);
					btn_sigu.setEnabled(false);
					String sql ="Select * from auto where cod_auto LIKE  '"+txt_buscar.getText()+"%' LIMIT 1;";
					lb.setearDatosAuto(lbl_tipo, lbl_marca, lbl_modelo, lbl_klm, lbl_color, lbl_choque, lbl_aireAC, lbl_pintura, lbl_placa, lbl_nDuenio, lbl_anio, lbl_tapiceria,lbl_carroceria,lblprecio, sql);
					
					int cont2 = 0;
					ArrayList <Imagen> img = lb.obtenerImagenesAutos("SELECT * FROM imagenes where cod_auto='"+lbl_placa.getText()+"' ;");
					for (Imagen im : img) {

						ImageIcon imagen=new ImageIcon(im.getImagen().getScaledInstance(imagenes.get(cont2).getWidth(), imagenes.get(cont2).getHeight(), Image.SCALE_DEFAULT));
						imagenes.get(cont2).setIcon(imagen);
						cont2 ++;
					}
					imgH.stop();
					imgH = new bannerImagen(imagenes);
					imgH.start();
				}

				if(txt_buscar.getText().length()==0) {
					//imgH.stop();
					if(cont!=0) {
						btn_ante.setEnabled(true);
					}else {
						btn_ante.setEnabled(false);
					}
					if((cont+1) != numreg){
						btn_sigu.setEnabled(true);

					}else {
						btn_sigu.setEnabled(false);
					}
				}
				
				
			}
		});


		imgH = new bannerImagen(imagenes);
		imgH.start();
		sig= lb.obtenerprimerId();
		placaaux = lb.obtenerPlacaSiguiente(sig);
		
		String sql ="Select * from auto where cod_auto = '"+placaaux+"';";
		lb.setearDatosAuto(lbl_tipo, lbl_marca, lbl_modelo, 
				lbl_klm, lbl_color, lbl_choque, lbl_aireAC,
				lbl_pintura, lbl_placa, lbl_nDuenio, lbl_anio, 
				lbl_tapiceria,lbl_carroceria,lblprecio, sql);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizar_autos aa = new actualizar_autos(lbl_placa.getText());
				aa.setVisible(true);
				cat.setVisible(false);
			}
		});
		btnActualizar.setBounds(141, 540, 117, 25);
		pn_catalogo.add(btnActualizar);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(20, 545, 49, 13);
		pn_catalogo.add(lblPrecio);
		
	

	}
}
