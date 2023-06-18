package gajardo.frameworks;

import java.io.IOException;

public class Start {

	private Framework framework;

	public Start(String ruta) {
		this.framework = new Lanterna(ruta);
	}

	public void init() throws IOException {
		this.framework.init();
	}
}
