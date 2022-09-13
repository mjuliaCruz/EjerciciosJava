import java.util.ArrayList;
import java.util.List;

public class Producto {
    //atributos
    String nombre = "";
    int stock = 0;

    //constructores
    public Producto(){

    }
    public Producto(String nombre, int stock){
        this.nombre = nombre;
        this.stock = stock;

    }

    //metodos

    @Override
    public String toString() {
        return "Producto: " + nombre + " con un Stock de: " + stock;
    }
    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
