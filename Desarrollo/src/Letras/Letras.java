package Letras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase que indica la letra que sean extremo de una palabras que se repita más
 * veces. <br>
 */
public class Letras extends EjercicioOIA {
	/**
	 * Letras que son extremo de una palabras. <br>
	 */
	private Map<Character, Palabra> letras = new HashMap<Character, Palabra>();
	/**
	 * Palabras del poema. <br>
	 */
	private List<String> palabras = new ArrayList<String>();

	/**
	 * Carga las palabras utilizadas en un poema. <br>
	 * 
	 * @param entrada
	 *            Archivo de entrada. <br>
	 * @param salida
	 *            Archivo de salida. <br>
	 */
	public Letras(final File entrada, final File salida) {
		super(entrada, salida);
		try {
			this.leerArchivo(super.entrada);
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
			e.printStackTrace();
		} catch (ArithmeticException a) {
			a.getMessage();
			a.printStackTrace();
		}
	}

	/**
	 * Lee el archivo de entrada y carga los datos correspondientes. <br>
	 * 
	 * @param path
	 *            Archivo de entrada. <br>
	 * @throws IOException
	 *             Si el archivo no existe o tiene problemas, sale. <br>
	 * @throws ArithmeticException
	 *             Si los datos de entrada no cumplen con los requisitos del
	 *             enunciado, sale. <br>
	 */
	private void leerArchivo(final File path) throws IOException, ArithmeticException {
		try {
			Scanner sc = new Scanner(path);
			String palabra;
			int cantidadPalabras = 0;
			sc.nextLine();
			while (sc.hasNextLine()) {
				palabra = sc.nextLine();
				if (palabra.length() > 10) {
					this.limiteSuperado("tamaño de palabra");
				}
				cantidadPalabras++;
				if (cantidadPalabras > 250) {
					this.limiteSuperado("cantidad de palabras");
				}
				this.palabras.add(palabra);
			}
			if (cantidadPalabras == 0) {
				this.limiteSuperado("cantidad de palabras");
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Resuelve el ejercicio. <br>
	 */
	@Override
	public void resolver() {

	}

	/**
	 * Indica que supera el límite aceptado. <br>
	 */
	private void limiteSuperado(final String text) {
		throw new ArithmeticException("Cantidad superada de " + text + ".");
	}
}
