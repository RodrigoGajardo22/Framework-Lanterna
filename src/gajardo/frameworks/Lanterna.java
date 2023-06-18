package gajardo.frameworks;

import java.io.IOException;
import java.util.Map;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Lanterna extends Framework {

	private Screen       screen;
	private TextGraphics textGraphics;

	public Lanterna(String ruta) {
		super(ruta);
	}

	public void menu() {
		try {
			Terminal terminal = new DefaultTerminalFactory().createTerminal();
			screen = new TerminalScreen(terminal);
			screen.startScreen();
			screen.clear();

			textGraphics = screen.newTextGraphics();
			textGraphics.putString(0, 0, "Bienvenido, estas son sus opciones: ");

			int row = 2;
			for (Map.Entry<Integer, Accion> entry : actions.entrySet()) {
				String texto = entry.getKey() + ". " + entry.getValue().nombreItemMenu() + " "
						+ entry.getValue().descripcionItemMenu();
				textGraphics.putString(0, row++, texto);
			}
			textGraphics.putString(0, row++, "4. Salir");

			screen.refresh();

			this.leerOpcion();

//			// Detener la pantalla y cerrar el terminal
//			screen.stopScreen();
//			terminal.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leerOpcion() throws IOException {
		KeyStroke key;
		boolean   salir = false;

		while (!salir) {
			key = screen.readInput();
			if (key.getKeyType() == KeyType.Character) {
				char caracter = key.getCharacter();
				int  opcion   = Character.getNumericValue(caracter);

				if ((actions.size() + 1) == opcion) {
					salir = true;
					System.out.println("Saliendo.");
				}

				if (!salir && !actions.containsKey(opcion)) {
					System.out.println("Elige una opcion valida.");
				}

				if (actions.containsKey(opcion)) {
					System.out.println("entro opcion: " + opcion);
					ejecutarAccion(actions.get(opcion));
				}

			}

		}

		screen.stopScreen();

	}

	private void ejecutarAccion(Accion accion) {

		String texto = accion.ejecutar();
		textGraphics = screen.newTextGraphics();
		textGraphics.putString(0, actions.size() + 4, texto);
		try {
			screen.refresh();
		} catch (IOException e) {
			new RuntimeException("Algo malio sal.");
		}

	}
}
