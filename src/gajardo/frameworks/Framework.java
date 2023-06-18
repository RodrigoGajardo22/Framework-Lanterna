package gajardo.frameworks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class Framework {
	private String                 fileConfig;
	protected Map<Integer, Accion> actions;

	public Framework(String ruta) {
		this.fileConfig = ruta;
		this.actions    = new HashMap<>();

	}

	public void init() throws IOException {
		this.cargarAcciones();
		this.menu();

	}

	public abstract void menu();

	public abstract void leerOpcion() throws IOException;

	private void cargarAcciones() {

		Properties properties = new Properties();
		try (InputStream configFile = getClass().getResourceAsStream(fileConfig)) {

			properties.load(configFile);
			String       acciones      = properties.getProperty("acciones");
			List<String> nombresClases = Arrays.asList(acciones.split(";"));

			int          opcion        = 1;
			for (String nombre : nombresClases) {

				Accion accion = (Accion) Class.forName(nombre).getDeclaredConstructor().newInstance(); // Este es el
																										// reflexion
				actions.put(opcion, accion);
				opcion++;
			}

		} catch (Exception e) {
			new RuntimeException("Error al cargar Acciones.");
		}

	}

}
