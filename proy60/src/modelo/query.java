package modelo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import modelo.Imagen;

public class query extends conection_bbdd{

	/**
	 * Sirve_para realizar_consultas mediante_la instruccion_SQL SELECT
	 * @param sentenciaSQL_ejemplo: SELECT * FROM name_table
	 * @return ResultSet
	 */
	public ResultSet getQuery(String sentenciaSQL) {
		try {
			this.stmt=(Statement)open_conn().createStatement(); //Abrir_conexion
			res=stmt.executeQuery(sentenciaSQL); //Manteniendo_la_conexion
		} catch (SQLException e) {
			println("Error para abrir la consulta",1);
		}
		return res; //devuelve_toda la_consulta
	}
	
	/**
	 * Permite_implementar operaciones_SQL tales_como:
	 * INSERT, UPDATE, DELETE
	 * @param sentenciaSQL_Ejemplo: DELETE * FROM name_table WHERE id_table = 1
	 * @return boolean
	 */
	public boolean setQuery(String sentenciaSQL) {
		try {
			this.stmt=(Statement)open_conn().createStatement();
			 this.stmt.executeUpdate(sentenciaSQL);
			 return close_conn();
		} catch (SQLException e) {
			println("Error al realizar una operacion de actualizacion en la bbdd",1);
			return false;
		}
	}
	
	public int obtenerImagenplaca(String placa,int aux) {
		String sql = "Select * from imagenes where cod_auto = '"+placa+"'";;
		try {
			this.stmt=(Statement)open_conn().createStatement(); //Abrir_conexion
			//res=stmt.executeQuery(sentenciaSQL); //Manteniendo_la_conexion "SELECT imagen,nombre FROM Imagenes"
			ResultSet rs = stmt.executeQuery(sql); 
			int cont = 1;
			while (rs.next())
			{	
				
				Imagen imagen=new Imagen();
				Blob blob = rs.getBlob("imagen");
				String nombre = rs.getObject("nombre").toString();
				byte[] data = blob.getBytes(1, (int)blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {
					//Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
				}
				
				
				//imagen.setImagen(img);
				//imagen.setNombre(nombre);
				if(cont ==aux) {
					return rs.getInt("idImagen");
				}
				else {
					cont++;
				}
			}
			rs.close();
		} catch (SQLException ex) {
			//Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 0;
	}
	
	public boolean guardarNImagen(String ruta,String nombre,int id){
		String insert = "Update imagenes set imagen=?, nombre=?  where idImagen = "+id+";";
		FileInputStream fis = null;
		PreparedStatement ps = null;
		try {
			open_conn();
			//conexion.setAutoCommit(false);
			File file = new File(ruta);
			fis = new FileInputStream(file);
			ps = open_conn().prepareStatement(insert);
			ps.setBinaryStream(1,fis,(int)file.length());
			ps.setString(2, nombre);
			
			ps.executeUpdate();
			open_conn().commit();
			return true;
		} catch (Exception ex) {
			//Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			try {
				ps.close();
				fis.close();
			} catch (Exception ex) {
				//Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
			}
		}        
		return false;
	}
	
	
	
	public boolean guardarImagen(String ruta,String nombre,String cod_auto){
		String insert = "insert into imagenes(imagen,nombre,cod_auto) values(?,?,?)";
		FileInputStream fis = null;
		PreparedStatement ps = null;
		try {
			open_conn();
			//conexion.setAutoCommit(false);
			File file = new File(ruta);
			fis = new FileInputStream(file);
			ps = open_conn().prepareStatement(insert);
			ps.setBinaryStream(1,fis,(int)file.length());
			ps.setString(2, nombre);
			ps.setString(3, cod_auto);
			ps.executeUpdate();
			open_conn().commit();
			return true;
		} catch (Exception ex) {
			//Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			try {
				ps.close();
				fis.close();
			} catch (Exception ex) {
				//Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
			}
		}        
		return false;
	}
	public ArrayList < Imagen > getImagenes(String sql) {
		ArrayList < Imagen > lista = new ArrayList();
		try {
			this.stmt=(Statement)open_conn().createStatement(); //Abrir_conexion
			//res=stmt.executeQuery(sentenciaSQL); //Manteniendo_la_conexion "SELECT imagen,nombre FROM Imagenes"
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next())
			{
				Imagen imagen=new Imagen();
				Blob blob = rs.getBlob("imagen");
				String nombre = rs.getObject("nombre").toString();
				byte[] data = blob.getBytes(1, (int)blob.length());
				BufferedImage img = null;
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {
					//Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
				}
				
				imagen.setImagen(img);
				imagen.setNombre(nombre);
				lista.add(imagen);
			}
			rs.close();
		} catch (SQLException ex) {
			//Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;
	}
	
}
