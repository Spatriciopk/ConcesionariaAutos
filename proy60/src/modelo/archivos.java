package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class archivos {

	
	public boolean escribirClientes(String texto, String texto2) {
		try {
		FileWriter archivo = new FileWriter("usuario/clientes.txt",true);
		archivo.write(texto+" "+texto2+",");
		archivo.close();
		return true;
		}catch(	FileNotFoundException fne) {
			System.out.println("No se encontro el archivo");
			return false;
		}
		catch (IOException e){
			System.out.println("Error al escribir");
			return false;
		}
	}
	public String leer() throws IOException {
		File doc = new File("usuario/clientes.txt");

		  BufferedReader obj = new BufferedReader(new FileReader(doc));

		  String strng;
		  
		  return (strng = obj.readLine());
	}
}
