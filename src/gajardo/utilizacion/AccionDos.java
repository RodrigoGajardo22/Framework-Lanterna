package gajardo.utilizacion;

import gajardo.frameworks.Accion;

public class AccionDos implements Accion {

	@Override
	public String ejecutar() {
		return "Se ejecuto accion 2";

	}

	@Override
	public String nombreItemMenu() {
		return "Accion 2";
	}

	@Override
	public String descripcionItemMenu() {
		return "Inicia Mantenimiento de pc";
	}

}
