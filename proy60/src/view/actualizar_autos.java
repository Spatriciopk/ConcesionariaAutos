package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.business_logic;
import modelo.Imagen;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class actualizar_autos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String placa="";
	private actualizar_autos aa;
	private JLabel Tipo;
	private JRadioButton radio_nuevo;
	private JRadioButton radio_usado;
	private JLabel lblPlaca;
	private JTextField txt_placa;
	private JTextField txt_marca;
	private JTextField txt_modelo;
	private JTextField txt_anio;
	private JTextField txt_km;
	private JTextField txt_precio;
	private JTextField txt_color;
	private JSpinner spn_duenio;
	private JRadioButton radio_aire_si;
	private JRadioButton radio_aire_no;
	private JRadioButton radio_choque_si;
	private JRadioButton radio_choque_no;
	private JLabel lblTapiceria;
	private JComboBox combo_tapiceria;
	private JComboBox combo_pintura;
	private JComboBox combo_carroceria;
	private JLabel lbl_imagen1;
	private JButton btn_imagen1;
	private JButton btn_imagen2;
	private JButton btn_imagen3;
	business_logic lb = new business_logic() ;
	private JLabel lbltapiceria;
	private JLabel lblpintura;
	private JLabel lblcarroceria;
	private JLabel lbl_imagen3;
	private JLabel lbl_imagen2;
	private ArrayList <Imagen> img ;
    public String rutaimg1 ="";
    public String rutaimg2 ="";
    public String rutaimg3 ="";
    public String nomimg1 ="";
    public String nomimg2 ="";
    public String nomimg3 ="";
    public boolean img1= false;
    public boolean img2= false;
    public boolean img3= false;
    private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			actualizar_autos dialog = new actualizar_autos(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public actualizar_autos(String placa) {
		aa = this;
		this.placa = placa;
		String a = placa;
		setBounds(100, 100, 684, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Tipo = new JLabel("Tipo:");
		Tipo.setHorizontalAlignment(SwingConstants.TRAILING);
		Tipo.setBounds(39, 24, 70, 15);
		contentPanel.add(Tipo);
		
		radio_nuevo = new JRadioButton("Nuevo");
		radio_nuevo.setBounds(123, 20, 149, 23);
		contentPanel.add(radio_nuevo);
		
		radio_usado = new JRadioButton("Usado");
		radio_usado.setBounds(276, 20, 149, 23);
		ButtonGroup btn_tipo = new ButtonGroup();
		btn_tipo.add(radio_nuevo);
		btn_tipo.add(radio_usado);
		//rdbtn_usado.setSelected(true);
		
		contentPanel.add(radio_usado);
		
		lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(63, 64, 70, 15);
		contentPanel.add(lblPlaca);
		
		txt_placa = new JTextField();
		txt_placa.setEditable(false);
		txt_placa.setBounds(137, 62, 200, 17);
		contentPanel.add(txt_placa);
		txt_placa.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(39, 91, 70, 15);
		contentPanel.add(lblMarca);
		
		txt_marca = new JTextField();
		txt_marca.setBounds(137, 89, 200, 15);
		contentPanel.add(txt_marca);
		txt_marca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(39, 118, 70, 15);
		contentPanel.add(lblModelo);
		
		txt_modelo = new JTextField();
		txt_modelo.setBounds(137, 116, 200, 17);
		contentPanel.add(txt_modelo);
		txt_modelo.setColumns(10);
		
		JLabel lblAo = new JLabel("Año:");
		lblAo.setBounds(39, 155, 70, 15);
		contentPanel.add(lblAo);
		
		txt_anio = new JTextField();
		txt_anio.setBounds(137, 153, 200, 15);
		contentPanel.add(txt_anio);
		txt_anio.setColumns(10);
		
		JLabel lblKilometraje = new JLabel("Kilometraje:");
		lblKilometraje.setBounds(39, 182, 70, 15);
		contentPanel.add(lblKilometraje);
		
		txt_km = new JTextField();
		txt_km.setBounds(137, 182, 200, 15);
		contentPanel.add(txt_km);
		txt_km.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(39, 209, 70, 15);
		contentPanel.add(lblPrecio);
		
		txt_precio = new JTextField();
		txt_precio.setBounds(137, 207, 200, 23);
		contentPanel.add(txt_precio);
		txt_precio.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(39, 247, 70, 15);
		contentPanel.add(lblColor);
		
		txt_color = new JTextField();
		txt_color.setBounds(137, 245, 200, 17);
		contentPanel.add(txt_color);
		txt_color.setColumns(10);
		
		JLabel lblNDueos = new JLabel("N Dueños");
		lblNDueos.setBounds(39, 274, 70, 15);
		contentPanel.add(lblNDueos);
		
		spn_duenio = new JSpinner();
		spn_duenio.setBounds(137, 272, 93, 17);
		contentPanel.add(spn_duenio);
		
		JLabel lblChoques = new JLabel("Choques:");
		lblChoques.setBounds(39, 301, 70, 15);
		contentPanel.add(lblChoques);
		
		radio_choque_si = new JRadioButton("Si");
		radio_choque_si.setBounds(123, 297, 63, 19);
		contentPanel.add(radio_choque_si);
		
		radio_choque_no = new JRadioButton("No");
		radio_choque_no.setBounds(190, 297, 70, 19);
		ButtonGroup btn_choque = new ButtonGroup();
		btn_choque.add(radio_choque_si);
		btn_choque.add(radio_choque_no);
		contentPanel.add(radio_choque_no);
		
		JLabel lblAireAcondicionado = new JLabel("Aire acondicionado");
		lblAireAcondicionado.setBounds(39, 340, 70, 15);
		contentPanel.add(lblAireAcondicionado);
		
		radio_aire_si = new JRadioButton("Si");
		radio_aire_si.setBounds(123, 336, 54, 23);
		contentPanel.add(radio_aire_si);
	
		radio_aire_no = new JRadioButton("No");
		radio_aire_no.setBounds(190, 336, 63, 19);
		ButtonGroup btn_aire = new ButtonGroup();
		btn_aire.add(radio_aire_si);
		btn_aire.add(radio_aire_no);
		contentPanel.add(radio_aire_no);
		
		lblTapiceria = new JLabel("Tapiceria:");
		lblTapiceria.setBounds(39, 367, 70, 15);
		contentPanel.add(lblTapiceria);
		
		combo_tapiceria = new JComboBox();
		combo_tapiceria.setBounds(123, 362, 182, 23);
		combo_tapiceria.addItem("EXCELENTE");
		combo_tapiceria.addItem("REGULAR");
		combo_tapiceria.addItem("MALA");
		contentPanel.add(combo_tapiceria);
		
		JLabel lblPintura = new JLabel("Pintura:");
		lblPintura.setBounds(39, 394, 70, 15);
		contentPanel.add(lblPintura);
		
		combo_pintura = new JComboBox();
		combo_pintura.setBounds(123, 389, 182, 20);
		combo_pintura.addItem("EXCELENTE");
		combo_pintura.addItem("REGULAR");
		combo_pintura.addItem("MALA");
		contentPanel.add(combo_pintura);
		
		JLabel lblCarroceria = new JLabel("Carroceria:");
		lblCarroceria.setBounds(39, 421, 70, 15);
		contentPanel.add(lblCarroceria);
		
		combo_carroceria = new JComboBox();
		combo_carroceria.setBounds(123, 416, 182, 23);
		combo_carroceria.addItem("EXCELENTE");
		combo_carroceria.addItem("REGULAR");
		combo_carroceria.addItem("MALA");
		contentPanel.add(combo_carroceria);
		
		lbl_imagen1 = new JLabel("");
		lbl_imagen1.setBounds(343, 52, 127, 146);
		contentPanel.add(lbl_imagen1);
		
		lbl_imagen2 = new JLabel("");
		lbl_imagen2.setBounds(482, 51, 127, 146);
		contentPanel.add(lbl_imagen2);
		
		lbl_imagen3 = new JLabel("");
		lbl_imagen3.setBounds(343, 211, 127, 146);
		contentPanel.add(lbl_imagen3);
		ArrayList<JLabel> imagenes = new ArrayList<>();
		imagenes.add(lbl_imagen1);
		imagenes.add(lbl_imagen2);
		imagenes.add(lbl_imagen3);
		img = lb.obtenerImagenesAutos("SELECT * FROM imagenes where cod_auto= '"+placa+"';");
		int cont2 = 0;
		for (Imagen im : img) {

			ImageIcon imagen=new ImageIcon(im.getImagen().getScaledInstance(imagenes.get(cont2).getWidth(), imagenes.get(cont2).getHeight(), Image.SCALE_DEFAULT));
			imagenes.get(cont2).setIcon(imagen);
			cont2 ++;
		}
		JFileChooser chooser1 = new JFileChooser();
		JFileChooser chooser2 = new JFileChooser();
		JFileChooser chooser3 = new JFileChooser();
		btn_imagen1 = new JButton("Imagen 1");
		btn_imagen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG & GIF Images", "jpg", "gif");
				    chooser1.setFileFilter(filter);
				    int returnVal = chooser1.showOpenDialog(getParent());
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	img1 = true;
				    	rutaimg1=chooser1.getSelectedFile()+"";
				    	nomimg1=chooser1.getSelectedFile().getName();
				    	String ruta = chooser1.getSelectedFile().getPath();
				    	
						ImageIcon imagen=new ImageIcon(ruta);
						Image imgEscalada = imagen.getImage().getScaledInstance(lbl_imagen1.getWidth(), lbl_imagen1.getHeight(), Image.SCALE_DEFAULT);			
						Icon iconoescalado = new ImageIcon(imgEscalada);
						lbl_imagen1.setIcon(iconoescalado);
				    	
				    }
			}
		});
		btn_imagen1.setBounds(498, 242, 117, 25);
		contentPanel.add(btn_imagen1);
		
		btn_imagen2 = new JButton("Imagen 2");
		btn_imagen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG & GIF Images", "jpg", "gif");
				    chooser2.setFileFilter(filter);
				    int returnVal = chooser2.showOpenDialog(getParent());
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	img2 = true;
				    	rutaimg2=chooser2.getSelectedFile()+"";
				    	nomimg2=chooser2.getSelectedFile().getName();
				    	String ruta = chooser2.getSelectedFile().getPath();
				    	
						ImageIcon imagen=new ImageIcon(ruta);
						Image imgEscalada = imagen.getImage().getScaledInstance(lbl_imagen2.getWidth(), lbl_imagen2.getHeight(), Image.SCALE_DEFAULT);			
						Icon iconoescalado = new ImageIcon(imgEscalada);
						lbl_imagen2.setIcon(iconoescalado);
				    }
			}
		});
		btn_imagen2.setBounds(498, 291, 117, 25);
		contentPanel.add(btn_imagen2);
		
		btn_imagen3 = new JButton("Imagen 3");
		btn_imagen3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG & GIF Images", "jpg", "gif");
				    chooser3.setFileFilter(filter);
				    int returnVal = chooser3.showOpenDialog(getParent());
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	img3 = true;
				    	rutaimg3=chooser3.getSelectedFile()+"";
				    	nomimg3=chooser3.getSelectedFile().getName();
				    	String ruta = chooser3.getSelectedFile().getPath();
				    	
						ImageIcon imagen=new ImageIcon(ruta);
						Image imgEscalada = imagen.getImage().getScaledInstance(lbl_imagen3.getWidth(), lbl_imagen3.getHeight(), Image.SCALE_DEFAULT);			
						Icon iconoescalado = new ImageIcon(imgEscalada);
						lbl_imagen3.setIcon(iconoescalado);
				    }
			}
		});
		btn_imagen3.setBounds(498, 335, 117, 25);
		lbltapiceria = new JLabel("");
		lbltapiceria.setBounds(324, 367, 101, 15);
		contentPanel.add(lbltapiceria);
		
		lblpintura = new JLabel("");
		lblpintura.setBounds(323, 394, 102, 15);
		contentPanel.add(lblpintura);
		
		lblcarroceria = new JLabel("");
		lblcarroceria.setBounds(323, 421, 93, 15);
		contentPanel.add(lblcarroceria);
		contentPanel.add(btn_imagen3);
		String sql ="Select * from auto where cod_auto = '"+placa+"';";
		//lb.setearDatosAuto(lbl_tipo, lbl_marca, lbl_modelo, lbl_klm, lbl_color, lbl_choque, lbl_aireAC, lbl_pintura, lbl_placa, lbl_nDuenio, lbl_anio, lbl_tapiceria,lbl_carroceria, sql);
		lb.setearDatosAutoAc(radio_nuevo, radio_usado, txt_placa, txt_marca, 
				txt_modelo, txt_anio, txt_km, txt_precio, txt_color, spn_duenio, 
				radio_choque_si, radio_choque_no, radio_aire_si, radio_aire_no, 
				lbltapiceria,lblpintura,lblcarroceria,sql);
		
		btnEliminar = new JButton("Borrar Auto del concesionario");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb.borrarAuto(a);
				lb.borrarAutoImagenes(a);
			}
		});
		btnEliminar.setBounds(435, 389, 237, 47);
		contentPanel.add(btnEliminar);
		
	
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(img1) {
							int id = lb.imagenActualizar(placa,1);
							lb.guardarNuImagen(rutaimg1, nomimg1, id);
							System.out.println(id);
						}
						if(img2) {
							int id = lb.imagenActualizar(placa,2);
							lb.guardarNuImagen(rutaimg2, nomimg2, id);
						}
						if(img3) {
							int id = lb.imagenActualizar(placa,3);
							lb.guardarNuImagen(rutaimg3, nomimg3, id);
						}
						int choque=-1;
						int aire=-1;
						if(radio_choque_si.isSelected()) {
							choque = 1; //tiene choque
						}else if(radio_choque_no.isSelected()) {
							choque =0; //no tiene choque
						}
						if(radio_aire_si.isSelected()) {
							aire=1; //tiene aire
						}else if(radio_aire_no.isSelected()) {
							aire=0; //no tiene aire		
						}
						
						if(radio_nuevo.isSelected() && choque !=-1 && aire !=-1 ) {
							lb.updateAutos(0, txt_marca.getText(), 
									txt_modelo.getText(), 
									Integer.parseInt(txt_anio.getText()),
									Integer.parseInt(txt_km.getText()),
									Double.parseDouble(txt_precio.getText()), 
									Integer.parseInt(spn_duenio.getValue()+""), 
									txt_color.getText(), 
									combo_tapiceria.getSelectedIndex(),
									combo_pintura.getSelectedIndex(), 
									combo_carroceria.getSelectedIndex(),
									aire,
									choque, a);
						
						
						}
						else if(radio_usado.isSelected()  && choque !=-1 && aire !=-1 ) {
							lb.updateAutos(1, txt_marca.getText(), 
									txt_modelo.getText(), 
									Integer.parseInt(txt_anio.getText()),
									Integer.parseInt(txt_km.getText()),
									Double.parseDouble(txt_precio.getText()), 
									Integer.parseInt(spn_duenio.getValue()+""), 
									txt_color.getText(), 
									combo_tapiceria.getSelectedIndex(),
									combo_pintura.getSelectedIndex(), 
									combo_carroceria.getSelectedIndex(),
									aire,
									choque, a);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Llene todos los campos");

						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						catalogo c = new catalogo();
						c.setVisible(true);
						aa.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
}
