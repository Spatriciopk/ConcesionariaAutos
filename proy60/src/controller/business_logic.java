package controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import libreria.configurable;
import modelo.Imagen;
import modelo.archivos;
import view.catalogo;
import view.panel_proyecto;
import view.registro_cliente;

import modelo.query;

public class business_logic implements configurable{

	public panel_proyecto pnProyect;
	public registro_cliente rg;
	public validacion v;
	public archivos c;
	private catalogo ct;
	public query query;

	private ArrayList<File>carpetas;

	public business_logic() {
		query= new query();
		c=new archivos();
	}
	public business_logic(catalogo ct_) {
		this.ct=ct_;
	}
	public business_logic(panel_proyecto pnProyect) {
		super();
		this.pnProyect = pnProyect;
		v = new validacion();
	}

	public business_logic(registro_cliente rg) {
		super();
		this.rg = rg;
		c = new archivos();
		v = new validacion();
	}

	public String leer(String pathname) {
		String texto="";
		//String linea="";
		File documento = new File(pathname);
		try {
			FileReader archivo = new FileReader(documento);
			BufferedReader entrada = new BufferedReader(archivo);
			//linea= entrada.readLine();
			//texto=entrada.readLine();
			//Leer todas las lineas dentro del archivo
			while(entrada.readLine()!=null) {
				//linea=entrada.readLine() + "\n";
				texto += entrada.readLine() + "\n";
			}
			entrada.close();
			archivo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encontro el archivo para leer");
			e.printStackTrace();
		}
		catch(IOException ioe){
			System.out.println("Error al leer");
		}
		//return linea;
		return texto;
	}

	public void print(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}

	public void ventana_ld(String texto, registro_cliente rg2) {
		JOptionPane.showMessageDialog(rg2, texto);
	}
	/*public void escribirTexto() {
		if((!rg.txt_nombre.getText().equals("")) && (!rg.txt_psw.getText().equals(""))) {
			if(c.escribirClientes(rg.txt_nombre.getText(),rg.txt_psw.getText()))
				print("Datos guardados");
			else
				print("Proceso denegado");
		}
		else 
			print("El campo esta vacio");
	}*/
	public boolean verificarRegistroCl(String name, String psw) {
		name=" " +name;
		try {
			String obtenerTxt= c.leer();
			String [] clientes = obtenerTxt.split(",");
			ArrayList<String[]> datos = new ArrayList<String[]>();
			for(int i =0; i<clientes.length;i++	) {
				String[] datos2 = clientes[i].split(" ");
				datos.add(datos2);
				//datos.add(datos2[1]);
				//datos.add(datos2[2]);

			}

			for(int i =0; i<datos.size();i++) {
				String datos3 = "";
				String clave = "";
				for(int j =0; j<datos.get(i).length;j++) {
					//System.out.println(datos.get(i)[j]);
					if(j<2) {
						datos3 = datos3+" "+datos.get(i)[j];	
					}else {
						clave=datos.get(i)[j];
					}

				}
				/*System.out.println(datos3);
				System.out.println(name);
				System.out.println(clave);
				System.out.println(psw);*/

				if(name.equals(datos3) && psw.equals(clave)) {

					System.out.println("Usuario correcto");
					return true;
				}
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void validarIngresoClientes() {
		if(!v.validacion_name(rg.txt_nombre.getText()+" "))
			ventana_ld("Formato incorrecto de nombre",rg);
	}
	@Override
	public String autor() {
		// TODO Auto-generated method stub
		return null;
	}
	public void crearVehiculo(String nombreDirec) {
		File directorio=new File("vehiculos/"+nombreDirec);
		directorio.mkdir();
	}

	public void crearText(String ruta, String contenido) {
		try {
			File file = new File(ruta);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String Guardar1(String ruta,String rutaIma) {
		try {

			BufferedImage bi=ImageIO.read(new File(rutaIma));
			BufferedImage imagen=toBufferedImage(bi);
			save(imagen,"jpg");
			return "todo bien";
		} catch (IOException e) {
			return "todo mal";
		}
	}

	private static void save(BufferedImage image, String ext) {
		String fileName = "savingAnImage";
		File file = new File(fileName + "." + ext);
		try {
			ImageIO.write(image, ext, file); // ignore returned boolean
		} catch(IOException e) {
			System.out.println("Write error for " + file.getPath() +
					": " + e.getMessage());
		}
	}

	private static BufferedImage toBufferedImage(Image src) {
		int w = src.getWidth(null);
		int h = src.getHeight(null);
		int type = BufferedImage.TYPE_INT_RGB; // other options
		BufferedImage dest = new BufferedImage(w, h, type);
		Graphics2D g2 = dest.createGraphics();
		g2.drawImage(src, 0, 0, null);
		g2.dispose();
		return dest;
	}

	public boolean carpetaExist(String vehiculo) {
		File file = new File("/vehiculos/");
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public String isUsado(boolean usado) {
		if(usado == true) {
			return "usado";
		}else {
			return "nuevo";
		}
	}

	//Validar si el usuario y contrasenia son correctas
	public boolean validarIngreso(String usuario, String psw) {
		ResultSet res = query.getQuery("select name_usuario, psw from usuarios");
		try {
			while(res.next()) {
				if(res.getString("name_usuario").equals(usuario) && res.getString("psw").equals(psw)) {
					return true;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean verificarNameUser(String name_usuario) {
		ResultSet res = query.getQuery("select name_usuario from usuarios");
		try {
			while(res.next()) {
				if(res.getString("name_usuario").equals(name_usuario) ) {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public boolean verificarCampVacios(String campo) {
		if(campo.equals("")) {
			return false;
		}else {
			return true;
		}
	}
	public boolean ingresarUsuario(String name_user, String nombre, String apellido, String psw) {
		boolean c1=verificarCampVacios(name_user);
		boolean c2=verificarCampVacios(nombre);
		boolean c3=verificarCampVacios(apellido);
		boolean c4=verificarCampVacios(psw);
		if(c1 && c2 && c3 && c4) {
			if(verificarNameUser(name_user)) {
				String sql = "insert into usuarios values (null,'"+name_user+"','"+
						nombre+"','"+apellido+"','"+psw+"')"; 
				query.setQuery(sql);
				return true;
			}
		}
		return false;
	}
	public boolean registrarAuto(int tipoAuto,String placa,String marca,String modelo,int anio,int km,double precio,int num_duenio,String color,int tapiceria,int pintura,int carroceria,int aire_acondicionado,int choque) {
			
			if(tipoAuto ==0) { //Ingreso Auto Nuevo
				String sql = "INSERT INTO auto VALUES (null,'"+placa+"','"+marca+"','"+modelo+"',"
						+""+anio+","+km+","+precio+","+num_duenio+","+choque+","+aire_acondicionado+","+tapiceria+","+pintura+","+carroceria+",0,'"+color+"');";
				query.setQuery(sql);
				return true;
			}
			else if(tipoAuto==1) { //Ingreso Auto Usado
				String sql = "INSERT INTO auto VALUES (null,'"+placa+"','"+marca+"','"+modelo+"',"
						+""+anio+","+km+","+precio+","+num_duenio+","+choque+","+aire_acondicionado+","+tapiceria+","+pintura+","+carroceria+",1,'"+color+"');";
				query.setQuery(sql);
				return true;
			}
		return false;
	}
	
	public boolean updateAutos(int tipoAuto,
			String marca,String modelo,
			int anio,int km,double precio,
			int num_duenio,String color,
			int tapiceria,int pintura,
			int carroceria,int aire_acondicionado,
			int choque,String id) {
		
		if(tipoAuto ==0) { //Ingreso Auto Nuevo
		
			String sql = "Update auto set  marca = '"+marca+"',modelo='"+modelo+"',"
					+"anio="+anio+",kilometraje="+km+",valor_venta="+precio+",num_duenio="+num_duenio+",choque="+choque+",aire_acondicionado="+aire_acondicionado+",tapiceria="+tapiceria
					+",pintura="+pintura+",carroceria="+carroceria+",tipo=0,color='"+color+"' where cod_auto = '"+id+"';";
			query.setQuery(sql);
			return true;
		}
		else if(tipoAuto==1) { //Ingreso Auto Usado
			String sql = "Update auto set  marca = '"+marca+"',modelo='"+modelo+"',"
					+"anio="+anio+",kilometraje="+km+",valor_venta="+precio+",num_duenio="+num_duenio+",choque="+choque+",aire_acondicionado="+aire_acondicionado+",tapiceria="+tapiceria
					+",pintura="+pintura+",carroceria="+carroceria+",tipo=1,color='"+color+"' where cod_auto = '"+id+"';";
			query.setQuery(sql);
			return true;
		}
	return false;
}

	public void guardarImagenAuto(String ruta,String nombre,String cod) {
		query.guardarImagen(ruta, nombre, cod);
	}
	
	public void guardarNuImagen(String ruta,String nombre,int cod) {
		query.guardarNImagen(ruta, nombre, cod);
	}
	public ArrayList < Imagen > obtenerImagenesAutos(String sql) {
		return query.getImagenes(sql);
	}
	
	public ArrayList < Imagen > obtenerImagenesAutosSig_Ant(String sql) {
		return query.getImagenes(sql);
	}
	public int numregistro() {
		ResultSet res=query.getQuery("Select count(*) as "
				+ "total from auto");
		try {
			if(res.next()) {
				return res.getInt("total");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public String obtenerPlacaSiguiente(int sig) {
		String sql = "SELECT cod_auto FROM imagenes WHERE "
				+ "idImagen = (SELECT idImagen FROM imagenes WHERE "
				+ "idImagen = "+sig+");";
		ResultSet res=query.getQuery(sql);
		
		try {
			if(res.next()) {
				
				return res.getString("cod_auto");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/*public String filtro(JTextField d) {
		String sql = "select * from "
	}*/
	public int obtenerprimerId() {
		String sql ="select * from imagenes limit 1";
		ResultSet res=query.getQuery(sql);
		
		try {
			if(res.next()) {
				//System.out.println(res.getInt("idImagen"));
				return res.getInt("idImagen");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
	}
	public void setearDatosAuto(JLabel tipo , JLabel marca, JLabel modelo , JLabel klm,JLabel color,JLabel choque,JLabel aire,JLabel pintura,JLabel placa,JLabel duenio,JLabel anio,JLabel tapiceria,JLabel carroceria,JLabel precio,String sql) {
		ResultSet res=query.getQuery(sql);
		
		try {
			while(res.next()) {
				if(res.getInt("tipo") == 0) {
					tipo.setText("Nuevo");
				}
				else {
					tipo.setText("Usado");
				}
				marca.setText(res.getString("marca"));
				modelo.setText(res.getString("modelo"));
				klm.setText(res.getInt("kilometraje")+"");
				color.setText(res.getString("color"));
				precio.setText(res.getDouble("valor_venta")+"");
				if(res.getInt("choque") == 0) {
					choque.setText("NO");
				}
				else {
					choque.setText("SI");
				}
				if(res.getInt("aire_acondicionado") == 0) {
					aire.setText("NO");
				}
				else {
					aire.setText("SI");
				}
				if(res.getInt("pintura") == 0) {
					pintura.setText("EXCELENTE");
				}
				else if(res.getInt("pintura") == 1) {
					pintura.setText("REGULAR");
				}
				else {
					pintura.setText("MALA");
				}
				placa.setText(res.getString("cod_auto"));
				duenio.setText(res.getInt("num_duenio")+"");
				anio.setText(res.getInt("anio")+"");
				if(res.getInt("tapiceria") == 0) {
					tapiceria.setText("EXCELENTE");
				}
				else if(res.getInt("tapiceria") == 1) {
					tapiceria.setText("REGULAR");
				}
				else {
					tapiceria.setText("MALA");
				}
				if(res.getInt("carroceria") == 0) {
					carroceria.setText("EXCELENTE");
				}
				else if(res.getInt("carroceria") == 1) {
					carroceria.setText("REGULAR");
				}
				else {
					carroceria.setText("MALA");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setearDatosAutoAc(JRadioButton nuevo,
			JRadioButton usado,
			JTextField placa,
			JTextField marca,
			JTextField modelo,
			JTextField anio,
			JTextField km,
			JTextField precio,
			JTextField color,
			JSpinner duenios,
			JRadioButton choque_si,
			JRadioButton choque_no,
			JRadioButton aire_si,
			JRadioButton aire_no,
			JLabel tapiceria,
			JLabel pintura,
			JLabel carroceria,
			String sql) {
		ResultSet res=query.getQuery(sql);
		
		try {
			while(res.next()) {
				if(res.getInt("tipo") == 0) {
					nuevo.setSelected(true);
				}
				else {
					usado.setSelected(true);
				}
				marca.setText(res.getString("marca"));
				modelo.setText(res.getString("modelo"));
				km.setText(res.getInt("kilometraje")+"");
				color.setText(res.getString("color"));
				precio.setText(res.getDouble("valor_venta")+"");
				if(res.getInt("choque") == 0) {
					
					choque_no.setSelected(true);
				}
				else {
					choque_si.setSelected(true);
				
				}
				if(res.getInt("aire_acondicionado") == 0) {
			
					aire_no.setSelected(true);
				}
				else {
					aire_si.setSelected(true);
					
				}
				if(res.getInt("pintura") == 0) {
					pintura.setText("EXCELENTE");
				}
				else if(res.getInt("pintura") == 1) {
					pintura.setText("REGULAR");
				}
				else {
					pintura.setText("MALA");
				}
				if(res.getInt("tapiceria") == 0) {
					tapiceria.setText("EXCELENTE");
				}
				else if(res.getInt("tapiceria") == 1) {
					tapiceria.setText("REGULAR");
				}
				else {
					tapiceria.setText("MALA");
				}
				if(res.getInt("carroceria") == 0) {
					carroceria.setText("EXCELENTE");
				}
				else if(res.getInt("carroceria") == 1) {
					carroceria.setText("REGULAR");
				}
				else {
					carroceria.setText("MALA");
				}
				placa.setText(res.getString("cod_auto"));
				duenios.setValue(res.getInt("num_duenio"));
				anio.setText(res.getInt("anio")+"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int imagenActualizar(String placa,int aux) {
		return query.obtenerImagenplaca(placa,aux);
	}
	
	public void borrarAuto(String placa) {
		query.setQuery("Delete from auto where cod_auto = '"+placa+"';");
	}
	
	public void borrarAutoImagenes(String placa) {
		query.setQuery("Delete from imagenes where cod_auto = '"+placa+"';");
	}
	
	
}
