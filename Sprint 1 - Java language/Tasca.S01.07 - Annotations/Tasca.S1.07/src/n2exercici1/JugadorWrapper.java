package n2exercici1;
/* 1. Descarga GSON:
https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/gson-2.6.2.jar

2. Agrega GSON a tu proyecto: Pulsa con el botón derecho sobre tu proyecto, y
en Build Path > Add External Archives, selecciona el jar descargado.

3. Importalo en la clase que requieras usarlo: import com.google.gson.*;

Jackson es otra librería que podéis usar para serializar/deserializar
mediante JSON:
https://www.baeldung.com/jackson-object-mapper-tutorial*/
import java.lang.annotation.Annotation;
import com.google.gson.*;

public class JugadorWrapper {

	public void serialitzarJugador(Jugador jugador) {

		String nomFitxer = this.getFileToSerialize();
		String contingutJSON = this.getJSONString(jugador);

		MyBufferedWriter myBufferedWriter = new MyBufferedWriter();
		myBufferedWriter.escribir(nomFitxer, contingutJSON, false);

	}

	public void serialitzaArrayJugadores(Jugador[] jugadores) {

		String nomFitxer = this.getFileToSerialize();
		String contingutJSON = this.getJSONString(jugadores);

		MyBufferedWriter myBufferedWriter = new MyBufferedWriter();
		myBufferedWriter.escribir(nomFitxer, contingutJSON, false);

	}

	private String getJSONString(Jugador jugador) {

		Gson gson = new Gson();
		String JSON = gson.toJson(jugador);
		return JSON;
	}

	private String getJSONString(Jugador[] jugador) {

		Gson gson = new Gson();
		String JSON = gson.toJson(jugador);
		return JSON;
	}

	public String getFileToSerialize() {
		String result = null;

		Class<?> metadataJugador = Jugador.class;

		Annotation[] classAnnotations = metadataJugador.getAnnotations();
		if (classAnnotations != null && classAnnotations.length > 0) {
			for (Annotation a : classAnnotations) {
				System.out.println(a.toString());

				if (a instanceof FileDestinationAnnotation) {
					FileDestinationAnnotation fileDestinationAnnotation = (FileDestinationAnnotation) a;
					result = fileDestinationAnnotation.Folder() + fileDestinationAnnotation.FileName();
				}
			}
		}

		return result;
	}

}