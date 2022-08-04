package controller;

public class validacion {

	public boolean validacion_name(String nombres) {
		return nombres.matches("^([A-ZÁ-Ú]{1}([a-z]|[á-ú])+[ ]){2,4}$");
	}
	
}
