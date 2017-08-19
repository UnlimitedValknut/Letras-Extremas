package Letras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
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
	 * Letra que aparece más veces. <br>
	 */
	private char letraMaxima;

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
		} catch (IOException | ArithmeticException e) {
			e.getMessage();
		}
	}

	/**
	 * Lee el archivo de entrada y carga los datos correspondientes. <br>
	 * 
	 * @param path
	 *            Archivo de entrada. <br>
	 * @throws IOException
	 *             Si el archivo no existe, sale. <br>
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
			throw new IOException("Error al abrir el archivo.");
		}
	}

	/**
	 * Resuelve el ejercicio. <br>
	 */
	@Override
	public void resolver() {
		for (ListIterator<String> iterator = this.palabras.listIterator(); iterator.hasNext();) {
			String palabra = iterator.next();
			if (!this.letras.containsKey(palabra.charAt(0))) {
				this.letras.put(palabra.charAt(0), new Palabra());
			}
			this.letras.get(palabra.charAt(0)).cargarPalabra(palabra);
			if (palabra.charAt(palabra.length() - 1) != palabra.charAt(0)) {
				if (!this.letras.containsKey(palabra.charAt(palabra.length() - 1))) {
					this.letras.put(palabra.charAt(palabra.length() - 1), new Palabra());
				}
				this.letras.get(palabra.charAt(palabra.length() - 1)).cargarPalabra(palabra);
			}
		}
		int maximaCantidad = 0;
		for (Map.Entry<Character, Palabra> entry : this.letras.entrySet()) {
			if (maximaCantidad < entry.getValue().getCantidadPalabras()) {
				this.letraMaxima = entry.getKey();
				maximaCantidad = entry.getValue().getCantidadPalabras();
			}
		}
	}

	/**
	 * Graba el archivo con el resultado final. <br>
	 */
	public void grabaArchivo() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(super.salida));
			salida.println(this.letraMaxima);
			List<String> palabrasExtremas = this.letras.get(this.letraMaxima).getPalabras();
			for (ListIterator<String> iterator = palabrasExtremas.listIterator(); iterator.hasNext();) {
				salida.println(iterator.next());
			}
			salida.close();
		} catch (IOException e) {
			System.out.println("Error al grabar el archivo.");
		}
	}

	/**
	 * Indica que supera el límite aceptado. <br>
	 */
	private void limiteSuperado(final String text) {
		throw new ArithmeticException("Cantidad superada de " + text + ".");
	}
}
