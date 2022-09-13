import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Producto> productList = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        Producto a = new Producto("Agua", 25);
        Producto b = new Producto("Azúcar", 54);
        Producto c = new Producto("Detergente", 15);
        Producto d = new Producto("Leche", 88);
        Producto e = new Producto("Sal", 2);

        //agregar productos
        productList.add(a);
        productList.add(b);
        productList.add(c);
        productList.add(d);
        productList.add(e);

        //quitar productos
        productList.remove(b);

        System.out.println("*******************");

        //mostrar productos
        mostrarProductoStock();

        buscarProducto("Agua");

        modificarStock("Agua");

        ordenarPorStock();

    }

    public static void ordenarPorStock(){

        productList.sort(Comparator.comparingInt(Producto::getStock));
        System.out.println(productList);



    }
     public static void mostrarProductoStock(){
         System.out.println(productList);

     }

    public static Producto buscarProducto (String nombre){

        Producto encontrado = null;

        for (Producto elemento : productList) {

            if(elemento.getNombre()==nombre){

                //System.out.println("Producto encontrado");
                //System.out.println("");
                System.out.println(elemento.getNombre() + " " + elemento.getStock());
                return elemento;

                //encontrado = elemento;
            }
        }
        System.out.println("Producto no encontrado");
        return null;
    }
    public static Producto modificarStock (String nombre){
        Producto productoEncontrado = buscarProducto(nombre);
        if(productoEncontrado != null){
            int stockInicial = productoEncontrado.getStock();
            int stockFinal = 0;

            System.out.print("Coloque '0' si desea agregar stock o '1'- si desea quitar stock: ");
            int seleccion = teclado.nextInt();

            if(seleccion == 0){
                System.out.println("Ingrese la cantidad de Stock que desea agregar: ");
                int cantidad = teclado.nextInt();

                stockFinal = stockInicial + cantidad;
                productoEncontrado.setStock(stockFinal);

            }else if(seleccion == 1){
                System.out.println("Ingrese la cantidad de Stock que desea quitar: ");
                int cantidad = teclado.nextInt();

                if(cantidad > stockInicial){
                    System.out.println("No puede restar más stock del que hay");
                    return null;

                } else {
                    stockFinal = stockInicial - cantidad;
                    productoEncontrado.setStock(stockFinal);
                }
            }else{
                System.out.println("El número ingresado no es correcto");
                return null;
            }

            System.out.println("Stock actualizado");
            buscarProducto(nombre);
            //productoEncontrado.setStock();
        }

    return null;
    }


}