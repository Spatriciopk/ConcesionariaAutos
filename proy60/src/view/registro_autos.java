package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.business_logic;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Color;

public class registro_autos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txt_marca;
	public JTextField txt_modelo;
	public JTextField txt_anio;
	public JTextField txt_klm;
	public JTextField txt_precio;
	public JTextField txt_color;
	public JTextField txt_placa;
	
    business_logic lb = new business_logic();
    ButtonGroup btn2 = new ButtonGroup();
    int i = 0;
    private JSpinner spn_nDuenio;
    private JComboBox cmb_tapiceria;
    private JComboBox cmb_cajaCambios;
    private JComboBox cmb_carroceria;
    private JRadioButton rbtnsi2;
    private JRadioButton rdbtnNo2;
    private JRadioButton rbtn_si1;
    private JRadioButton rdbtnNo1;
    private JButton btn_add1;
    private JButton btn_add;
    private JButton btn_add2;
    private JButton btn_save;
    private JButton btn_actual;
    private JButton btn_borrar;
    public boolean img1=false;
    public boolean img2=false;
    public boolean img3=false;
    public boolean img4=false;
    public String rutaimg1 ="";
    public String rutaimg2 ="";
    public String rutaimg3 ="";
    public String nomimg1 ="";
    public String nomimg2 ="";
    public String nomimg3 ="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			registro_autos dialog = new registro_autos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public registro_autos() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/imgProyect/img/editar.png"));
		setTitle("Registrar");
		setBounds(100, 100, 528, 833);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel pn_autos = new JPanel();
			pn_autos.setBackground(SystemColor.window);
			pn_autos.setBounds(0, 0, 527, 792);
			contentPanel.add(pn_autos);
			pn_autos.setLayout(null);
			{
				JLabel lblNewLabel_2 = new JLabel("Registro de vehiculo");
				lblNewLabel_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
				lblNewLabel_2.setForeground(SystemColor.window);
				lblNewLabel_2.setBounds(10, 10, 230, 27);
				pn_autos.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				
				lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir")+"/imgProyect/img/xs.png"));
				lblNewLabel.setBounds(0, -2, 517, 58);
				pn_autos.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Tipo:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 68, 63, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Marca:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 137, 63, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Modelo:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 174, 63, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("A\u00F1o:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 211, 63, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Kilometraje:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 249, 88, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Precio:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 286, 63, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Color:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 360, 63, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Placa:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 94, 63, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Tapiceria:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 546, 77, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Pintura:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 583, 114, 27);
				pn_autos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Imagenes:");
				lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 663, 114, 27);
				pn_autos.add(lblNewLabel_1);
			}
			
			txt_marca = new JTextField();
			txt_marca.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
			txt_marca.setColumns(10);
			txt_marca.setBounds(132, 144, 367, 26);
			pn_autos.add(txt_marca);
			
			txt_modelo = new JTextField();
			txt_modelo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
			txt_modelo.setColumns(10);
			txt_modelo.setBounds(132, 181, 367, 26);
			pn_autos.add(txt_modelo);
			
			txt_anio = new JTextField();
			txt_anio.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
			txt_anio.setColumns(10);
			txt_anio.setBounds(132, 218, 367, 26);
			pn_autos.add(txt_anio);
			
			txt_klm = new JTextField();
			txt_klm.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
			txt_klm.setColumns(10);
			txt_klm.setBounds(132, 256, 367, 26);
			pn_autos.add(txt_klm);
			
			txt_precio = new JTextField();
			txt_precio.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
			txt_precio.setColumns(10);
			txt_precio.setBounds(132, 293, 367, 26);
			pn_autos.add(txt_precio);
			
			txt_color = new JTextField();
			txt_color.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
			txt_color.setColumns(10);
			txt_color.setBounds(132, 367, 367, 26);
			pn_autos.add(txt_color);
			
			txt_placa = new JTextField();
			txt_placa.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
			txt_placa.setColumns(10);
			txt_placa.setBounds(132, 101, 367, 26);
			pn_autos.add(txt_placa);
			
			cmb_tapiceria = new JComboBox();
			cmb_tapiceria.setModel(new DefaultComboBoxModel(new String[] {"Excelente", "Regular","Malo"}));
			cmb_tapiceria.setBounds(132, 552, 234, 27);
			pn_autos.add(cmb_tapiceria);
			
			cmb_cajaCambios = new JComboBox();
			cmb_cajaCambios.setModel(new DefaultComboBoxModel(new String[] {"Excelente", "Regular","Malo"}));
			cmb_cajaCambios.setBounds(132, 583, 234, 27);
			pn_autos.add(cmb_cajaCambios);
			
			JRadioButton rdbtn_usado = new JRadioButton("Usado");
			JRadioButton rdbtn_nuevo = new JRadioButton("Nuevo");
			
			ButtonGroup btn = new ButtonGroup();
			btn.add(rdbtn_nuevo);
			btn.add(rdbtn_usado);
			rdbtn_usado.setSelected(true);
			
			JFileChooser chooser1 = new JFileChooser();
			JFileChooser chooser2 = new JFileChooser();
			JFileChooser chooser3 = new JFileChooser();
			
			btn_add = new JButton("A\u00F1adir");
			btn_add.setBorder(null);
			btn_add.setForeground(new Color(255, 255, 255));
			
			btn_add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "JPG & GIF Images", "jpg", "gif");
					    chooser1.setFileFilter(filter);
					    int returnVal = chooser1.showOpenDialog(getParent());
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					    	img1=true;
					    	rutaimg1=chooser1.getSelectedFile()+"";
					    	nomimg1=chooser1.getSelectedFile().getName();
					    }
					  
					       //System.out.println("You chose to open this file: " +
					    
					        //chooser.getSelectedFile().getName());
					       //System.out.println(chooser.getSelectedFile());
					     //  query.guardarImagen(chooser.getSelectedFile()+"", chooser.getSelectedFile().getName());
					       //ArrayList <Imagen> img = query.getImagenes();
					       /*for (Imagen im : img) {
					    	   System.out.println(im);
					       }*/
					      // ImageIcon im=new ImageIcon(img.get(0).getImagen().getScaledInstance(lbl_imagen.getWidth(), lbl_imagen.getHeight(), Image.SCALE_DEFAULT));
					   	//lbl_imagen.setIcon(im);
				}
			});
			btn_add.setBackground(new Color(0, 0, 0));
			btn_add.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
			btn_add.setBounds(134, 663, 63, 27);
			pn_autos.add(btn_add);
			{
				btn_save = new JButton("Guardar");
				btn_save.setBorder(null);
				btn_save.setForeground(new Color(255, 255, 255));
				btn_save.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
					
														/*if(btn_save.isValid()) {
									JOptionPane.showMessageDialog(null, "Datos guadados");
									ventana_principal pv = new ventana_principal();
									pv.setVisible(true);
									
								}else {
									JOptionPane.showMessageDialog(null, "Datos no guadados!!");
								}*/
							int choque=-1;
							int aire=-1;
							if(rbtn_si1.isSelected()) {
								choque = 1; //tiene choque
							}else if(rdbtnNo1.isSelected()) {
								choque =0; //no tiene choque
							}
							if(rbtnsi2.isSelected()) {
								aire=1; //tiene aire
							}else if(rdbtnNo2.isSelected()) {
								aire=0; //no tiene aire
										
							}
							
							if(rdbtn_nuevo.isSelected() && choque !=-1 && aire !=-1 && img1 && img2 && img3) {
								img1 = false;
								img2=false;
								img3 = false;
								lb.registrarAuto(0, txt_placa.getText(), txt_marca.getText(), 
										txt_modelo.getText(), Integer.parseInt(txt_anio.getText()),
										Integer.parseInt(txt_klm.getText()), 
										Double.parseDouble(txt_precio.getText()), 
										Integer.parseInt(spn_nDuenio.getValue()+""), 
										txt_color.getText(), cmb_tapiceria.getSelectedIndex(), 
										cmb_cajaCambios.getSelectedIndex(),
										cmb_carroceria.getSelectedIndex(), aire,choque);
								lb.guardarImagenAuto(rutaimg1, nomimg1, txt_placa.getText());
								lb.guardarImagenAuto(rutaimg2, nomimg2, txt_placa.getText());
								lb.guardarImagenAuto(rutaimg3, nomimg3, txt_placa.getText());
							}
							else if(rdbtn_usado.isSelected()  && choque !=-1 && aire !=-1 && img1 && img2 && img3) {
								img1 = false;
								img2=false;
								img3 = false;
								lb.registrarAuto(1, txt_placa.getText(), txt_marca.getText(), 
										txt_modelo.getText(), Integer.parseInt(txt_anio.getText()),
										Integer.parseInt(txt_klm.getText()), 
										Double.parseDouble(txt_precio.getText()), 
										Integer.parseInt(spn_nDuenio.getValue()+""), 
										txt_color.getText(), cmb_tapiceria.getSelectedIndex(), 
										cmb_cajaCambios.getSelectedIndex(),
										cmb_carroceria.getSelectedIndex(), aire,choque);
								lb.guardarImagenAuto(rutaimg1, nomimg1, txt_placa.getText());
								lb.guardarImagenAuto(rutaimg2, nomimg2, txt_placa.getText());
								lb.guardarImagenAuto(rutaimg3, nomimg3, txt_placa.getText());
							}
							else {
								JOptionPane.showMessageDialog(null, "Llene todos los campos");

							}
								
						
						
							}
					

				});
				btn_save.setBackground(new Color(0, 0, 0));
				btn_save.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				btn_save.setBounds(20, 709, 126, 27);
				pn_autos.add(btn_save);
			}
			{
				btn_actual = new JButton("Actualizacion");
				btn_actual.setBorder(null);
				btn_actual.setForeground(new Color(255, 255, 255));
				btn_actual.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cambiar frame = new cambiar();
						frame.setVisible(true);
					}
				});
				btn_actual.setBackground(new Color(0, 0, 0));
				btn_actual.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				btn_actual.setBounds(169, 709, 186, 27);
				pn_autos.add(btn_actual);
			}
			{
				btn_borrar = new JButton("Borrar");
				btn_borrar.setForeground(new Color(255, 255, 255));
				btn_borrar.setBorder(null);
				btn_borrar.setBackground(new Color(0, 0, 0));
				btn_borrar.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
				btn_borrar.setBounds(373, 709, 126, 27);
				pn_autos.add(btn_borrar);
			}
			
			rdbtn_nuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//btn.setSelected(rbtn_si1.getModel(), false);
					//btn2.clearSelection();
					spn_nDuenio.setValue(0);
					cmb_cajaCambios.setSelectedIndex(0);
					cmb_carroceria.setSelectedIndex(0);
					cmb_tapiceria.setSelectedIndex(0);
					txt_klm.setEditable(false);
					txt_klm.setText("0");
					
					spn_nDuenio.setEnabled(false);
					rdbtnNo1.setEnabled(false);
					rdbtnNo1.setSelected(true);
					
					rbtn_si1.setEnabled(false);
					
					cmb_tapiceria.setEnabled(false);
					cmb_cajaCambios.setEnabled(false);
					cmb_carroceria.setEnabled(false);
				}
			});
			rdbtn_nuevo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
			rdbtn_nuevo.setBounds(132, 74, 103, 21);
			pn_autos.add(rdbtn_nuevo);
			
			
			rdbtn_usado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txt_klm.setEditable(true);
					txt_klm.setText("0");
					
					spn_nDuenio.setEnabled(true);
					rdbtnNo1.setEnabled(true);
					rbtn_si1.setEnabled(true);
					
					cmb_tapiceria.setEnabled(true);
					cmb_cajaCambios.setEnabled(true);
					cmb_carroceria.setEnabled(true);
				}
			});
			rdbtn_usado.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
			rdbtn_usado.setBounds(263, 74, 103, 21);
			pn_autos.add(rdbtn_usado);
			
			JLabel lblNewLabel_1 = new JLabel("N due\u00F1os");
			lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(10, 397, 63, 27);
			pn_autos.add(lblNewLabel_1);
			
			spn_nDuenio = new JSpinner();
			spn_nDuenio.setBounds(142, 409, 77, 20);
			pn_autos.add(spn_nDuenio);
			
			rbtn_si1 = new JRadioButton("si");
			rbtn_si1.setBounds(57, 459, 103, 21);
			pn_autos.add(rbtn_si1);
			
			
			rdbtnNo1 = new JRadioButton("no");
			rdbtnNo1.setBounds(184, 459, 103, 21);
			pn_autos.add(rdbtnNo1);
			
			
			btn2.add(rdbtnNo1);
			btn2.add(rbtn_si1);
			
			JLabel lblNewLabel_3 = new JLabel("Choque:");
			lblNewLabel_3.setBounds(20, 440, 45, 13);
			pn_autos.add(lblNewLabel_3);
			
			JLabel lblNewLabel_1_1 = new JLabel("Aire acondicionado:");
			lblNewLabel_1_1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
			lblNewLabel_1_1.setBounds(24, 486, 151, 27);
			pn_autos.add(lblNewLabel_1_1);
			
			rbtnsi2 = new JRadioButton("si");
			rbtnsi2.setBounds(57, 519, 103, 21);
			pn_autos.add(rbtnsi2);
			
			rdbtnNo2 = new JRadioButton("no");
			rdbtnNo2.setBounds(184, 519, 103, 21);
			pn_autos.add(rdbtnNo2);
			
			
			ButtonGroup btn3 = new ButtonGroup();
			btn3.add(rbtnsi2);
			btn3.add(rdbtnNo2);
			JLabel lblNewLabel_1_2 = new JLabel("Carroceria:");
			lblNewLabel_1_2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
			lblNewLabel_1_2.setBounds(20, 626, 114, 27);
			pn_autos.add(lblNewLabel_1_2);
			
			cmb_carroceria = new JComboBox();
			cmb_carroceria.setBounds(132, 620, 234, 27);
			cmb_carroceria.setModel(new DefaultComboBoxModel(new String[] {"Excelente", "Regular","Malo"}));
			pn_autos.add(cmb_carroceria);
			
			btn_add1 = new JButton("A\u00F1adir");
			btn_add1.setBorder(null);
			btn_add1.setForeground(new Color(255, 255, 255));
			btn_add1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "JPG & GIF Images", "jpg", "gif");
					    chooser2.setFileFilter(filter);
					    int returnVal = chooser2.showOpenDialog(getParent());
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					    	img2=true;
					    	rutaimg2=chooser2.getSelectedFile()+"";
					    	nomimg2=chooser2.getSelectedFile().getName();
					    }
				}
			});
			btn_add1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
			btn_add1.setBackground(new Color(0, 0, 0));
			btn_add1.setBounds(234, 661, 63, 29);
			pn_autos.add(btn_add1);
			
			btn_add2 = new JButton("A\u00F1adir");
			btn_add2.setForeground(new Color(255, 255, 255));
			btn_add2.setBorder(null);
			btn_add2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "JPG & GIF Images", "jpg", "gif");
					    chooser3.setFileFilter(filter);
					    int returnVal = chooser3.showOpenDialog(getParent());
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					    	img3=true;
					    	rutaimg3=chooser3.getSelectedFile()+"";
					    	nomimg3=chooser3.getSelectedFile().getName();
					    }
				}
			});
			btn_add2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
			btn_add2.setBackground(new Color(0, 0, 0));
			btn_add2.setBounds(334, 662, 70, 29);
			pn_autos.add(btn_add2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.window);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
