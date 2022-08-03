package n2exercici1;

//creació d'annotation

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) 
@Target(TYPE)
public @interface FileDestinationAnnotation {
	String Folder();

	String FileName();
}