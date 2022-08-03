package n2exercici1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* BufferedReader – Esta clase es usada para hacer clases Reader de bajo nivel
como FileReader pero de una manera mas eficiente y mas fácil de usar.
Comparado con los FileReaders, los BufferedReaders leen relativamente grandes
cantidades de un archivo a la vez, y mantienen esta información en el buffer.
Cuando preguntamos por el siguiente caracter o la siguiente linea de
información, es recuperado del buffer, lo que minimiza el número de veces que
se tiene que leer desde el archivo, lo cual es una operación mas lenta. En
adición, la clase BufferedReader proveen métodos mas convenientes como
readLine(), el cual nos permite leer la siguiente linea de caracteres de un
archivo.

Podremos leer línea a línea, por lo que la lectura será más eficiente y el
código más claro.*/
public class MyBufferedReader {

	public String leer(String fichero) {

		String contenido = null;
		StringBuilder sb = null;

		File file = new File(fichero);

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file);

			bufferedReader = new BufferedReader(fileReader);

			sb = new StringBuilder();
			String linea = bufferedReader.readLine();
			while (linea != null) {
				sb.append(linea);
				linea = bufferedReader.readLine();
			}

		} catch (IOException ex) {
			System.err.println(ex.getMessage());

		} finally {

			if (bufferedReader != null) {
				try {

					bufferedReader.close();
				} catch (IOException ex) {

					System.err.println(ex.getMessage());
				}
			}

			if (fileReader != null) {
				try {

					fileReader.close();
				} catch (IOException ex) {

					System.err.println(ex.getMessage());
				}
			}
		}

		if (sb != null) {
			contenido = sb.toString();
		}
		return contenido;
	}
}