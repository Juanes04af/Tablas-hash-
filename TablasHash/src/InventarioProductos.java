import java.util.Hashtable; // se importa la clase Hashtable para poder crear un diccionario donde se guarden productos y sus cantidades
import java.util.Scanner; // se importa la clase Scanner para poder pedirle datos al usuario

public class InventarioProductos {
    public static void main(String[] args) {
        Hashtable<String, Integer> inventario = new Hashtable<>(); // se crea una estructura tipo Hashtable donde la clave será el nombre del producto y el valor la cantidad
        Scanner scanner = new Scanner(System.in); // se crea un objeto Scanner para leer lo que escriba el usuario
        int opcion; // se declara una variable entera que servirá para guardar la opción elegida por el usuario

        // Inventario inicial con algunos productos
        inventario.put("Arroz", 50); // se guarda el producto "Arroz" con una cantidad inicial de 50 unidades
        inventario.put("Frijoles", 30); // se guarda el producto "Frijoles" con 30 unidades
        inventario.put("Aceite", 20); // se guarda el producto "Aceite" con 20 unidades

        do { // se crea un bucle que se repetirá hasta que el usuario elija salir (opción 4)
            System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
            System.out.println("1. Consultar producto");
            System.out.println("2. Reabastecer producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); // se guarda la opción ingresada
            scanner.nextLine(); // se limpia el buffer para evitar errores al leer cadenas después de números

            switch (opcion) { // se crea un switch para ejecutar diferentes instrucciones según la opción elegida
                case 1:
                    System.out.print("Nombre del producto: "); // se le pide al usuario que escriba el nombre del producto
                    String producto = scanner.nextLine();
                    if (inventario.containsKey(producto)) { // se verifica si el producto existe en el inventario
                        System.out.println("Cantidad en stock: " + inventario.get(producto)); // si existe, se imprime cuántas unidades hay
                    } else {
                        System.out.println("Producto no encontrado."); // si no existe, se le dice al usuario que no se encontró el producto
                    }
                    break;

                case 2:
                    System.out.print("Producto a reabastecer: "); // se le pide el nombre del producto que quiere aumentar
                    String nombre = scanner.nextLine();
                    System.out.print("Cantidad a añadir: "); // se pide cuántas unidades quiere añadir
                    int cantidad = scanner.nextInt(); //
                    if (inventario.containsKey(nombre)) { // si el producto ya existe
                        inventario.put(nombre, inventario.get(nombre) + cantidad); // se suma la cantidad nueva a la ya existente
                    } else {
                        inventario.put(nombre, cantidad); // si el producto no existía, se agrega por primera vez con la cantidad ingresada
                    }
                    System.out.println("Inventario actualizado."); // se le informa al usuario que se hizo el cambio
                    break;

                case 3:
                    System.out.println("Inventario completo:");
                    for (String key : inventario.keySet()) { // se recorre cada producto
                        System.out.println(key + ": " + inventario.get(key) + " unidades"); // se imprime el nombre del producto y la cantidad
                    }
                    break;

                case 4:
                    System.out.println("Saliendo..."); // mensaje para indicar que se está cerrando el programa
                    break;

                default: // si escribe un número que no corresponde a ninguna opción
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4); // el bucle se repetirá mientras la opción no sea 4
    }
}
