package Letras;

import java.io.File;

import org.junit.Test;

public class TestLetras {

	private String pathIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";
	private String pathOut = "Ejecucion de Prueba/Salida Obtenida/";

	@Test
	public void test() {
		Letras app = new Letras(new File(pathIn + "00_enunciado.in"), new File(pathOut + "00_enunciado.out"));
		app.resolver();
		app.grabaArchivo();
	}
}
