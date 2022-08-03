package n2.AbstractFactory;

public class SpanishFactory extends AbstractFactory{

    public SpanishFactory(String nombre, String telefono, String direccion) {
        super(nombre, telefono, direccion);
    }

    @Override
    public String getTelefono(){
        return "Telefono: +34 " + telefono;
    }

    @Override
    public String getDireccion(){
        return "Direccion: " + direccion + ", Spain.";
    }
}
