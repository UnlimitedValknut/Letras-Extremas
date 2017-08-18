package Letras;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que administra la cantidad de palabras que tienen una letra en su
 * extremo. <br>
 */
public class Palabra {
	/**
	 * Palabras con la letra extrema. <br>
	 */
	private List<String> palabras = new ArrayList<String>();

	/**
	 * Carga la palabra. <br>
	 * 
	 * @param palabra
	 *            Palabra a incluir en la lista. <br>
	 */
	public void cargarPalabra(final String palabra) {
		this.palabras.add(palabra);
	}

	/**
	 * Devuelve la cantidad de palabras que tienen la letra extrema. <br>
	 * 
	 * @return Cantidad de palabras. <br>
	 */
	public int getCantidadPalabras() {
		return this.palabras.size();
	}

	/**
	 * Devuelve las palabras que contienen la letra extrema. <br>
	 * 
	 * @return Palabras con la letra extrema. <br>
	 */
	public List<String> getPalabras() {
		return this.palabras;
	}
}