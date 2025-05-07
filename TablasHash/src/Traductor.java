import java.util.Hashtable; // Se importa la clase Hashtable para gestionar un diccionario de palabras y sus traducciones
import java.util.Scanner; // Se importa la clase Scanner para leer entradas del usuario

public class Traductor {
    public static void main(String[] args) {
        Hashtable<String, String> diccionario = new Hashtable<>(); // Se crea un Hashtable para almacenar las palabras en español como claves y sus traducciones en inglés como valores
        Scanner scanner = new Scanner(System.in);

        // Palabras iniciales en el diccionario
        diccionario.put("Casa", "House");
        diccionario.put("Perro", "Dog");
        diccionario.put("Libro", "Book");
        diccionario.put("Escuela", "School");

        System.out.print("Ingrese una palabra en español: "); // Se pide al usuario que ingrese una palabra en español
        String palabra = scanner.nextLine();

        if (diccionario.containsKey(palabra)) { // Se verifica si la palabra existe en el diccionario
            System.out.println("Traducción: " + diccionario.get(palabra)); // Si existe, se imprime su traducción
        } else {
            System.out.println("Palabra no registrada en el diccionario."); // Si no existe, se informa que no está registrada
        }
    }
}
