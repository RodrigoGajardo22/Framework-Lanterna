package gajardo.utilizacion;

import gajardo.frameworks.Accion;

public class AccionTres implements Accion {

	@Override
	public String ejecutar() {
		return "Se ejecuto accion 3";

	}

	@Override
	public String nombreItemMenu() {
		return "Accion 3";
	}

	@Override
	public String descripcionItemMenu() {
		return "Volver a punto de restauracion";
	}

}
