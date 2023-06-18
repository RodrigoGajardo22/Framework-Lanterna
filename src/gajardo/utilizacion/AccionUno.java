package gajardo.utilizacion;

import gajardo.frameworks.Accion;

public class AccionUno implements Accion {

	@Override
	public String ejecutar() {
		return "Se ejecuto accion 1";

	}

	@Override
	public String nombreItemMenu() {

		return "Accion 1";
	}

	@Override
	public String descripcionItemMenu() {

		return "Busca posibles errores";
	}

}
