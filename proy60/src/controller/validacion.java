package controller;

public class validacion {

	public boolean validacion_name(String nombres) {
		return nombres.matches("^([A-Z�-�]{1}([a-z]|[�-�])+[ ]){2,4}$");
	}
	
}
