package n2.AbstractFactory;

public class EnglishFactory extends AbstractFactory {

    public EnglishFactory(String nombre, String telefono, String direccion) {
        super(nombre, telefono, direccion);
    }

    @Override
    public String getTelefono(){
        return "Telefono: +44 " + telefono;
    }

    @Override
    public String getDireccion(){
        return "Direccion: " + direccion + ", England.";
    }
}
