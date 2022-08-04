package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libreria.configurable;



public class conection_bbdd implements parametrizable, configurable{

	protected Connection conn=null;
	protected Statement stmt=null;
	protected ResultSet res=null; //carga de datos 
	
	/**
	 * Método_que_se encarga_de abrir_la conexion_
	 * con_la_base de_datos
	 * @return connection
	 */
	//Abre_la _conexion
	public Connection open_conn() {
		try {
			Class.forName(driver); //genera_el enganche_entre el driver y la_aplicacion
			this.conn=DriverManager.getConnection(getURL()); //estableciendo_una_conexion
			
			if(conn!=null) 
				println("Conexcion exitosa!",1);
			
		} catch (ClassNotFoundException e) {
			
			println("Problemas con el Driver",1);
		} catch (SQLException e) {
			println("Problemas en la conexion",1);
		}
		return conn;
	}
	
	//Cerrar_la_conexion
	public boolean close_conn() {
			try {
				if(conn!=null) {
				conn.close(); //cerrando_la_conexion
				if(stmt!=null)
					stmt.close();
				return true;
				}
				else {
					return false;
				}
			} catch (SQLException e) {
				println("Problemas para cerrar la conexion",1);
				return false;
			}
	}
	@Override
	public String autor() {
		// TODO Auto-generated method stub
		return infoAutor();
	}

}
