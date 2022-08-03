package n2exercici1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/* BufferedWriter – Esta clase es usada para hacer clases de bajo nivel como
FileWriters de una manera mas eficiente y mas fáciles de usar. Comparado con
las clases FileWriter, los BufferedWriters escribe relativamente grandes
cantidades de información a un archivo, lo cual minimiza el número de veces
que las operaciones de escritura de archivos se llevan a cabo, las cuales son
operaciones mas lentas. La clase BufferedWriter tambien provee un método
llamado newLine() el cual crea separadores de linea específicos de la
plataforma de manera automática.*/
public class MyBufferedWriter {

	public void escribir(String fichero, String contenido, boolean agregarAlContenidoExistente) {
		File file = new File(fichero);
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter(file, agregarAlContenidoExistente);

			bufferedWriter = new BufferedWriter(fileWriter);

			if (contenido != null && contenido.length() > 0) {
				bufferedWriter.write(contenido);
				System.out.println("S'ha generat el fitxer: " + fichero);

			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		finally {

			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
			
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
			
		}
	}

}
