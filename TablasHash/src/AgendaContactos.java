import java.util.Hashtable; // importa la clase Hashtable que nos permite crear un tipo de diccionario con claves y valores
import java.util.Scanner; // importa la clase Scanner para poder recibir datos del usuario

public class AgendaContactos {
    public static void main(String[] args) {
        Hashtable<String, String> agenda = new Hashtable<>(); // se crea una estructura tipo Hashtable donde se guardarán los nombres y teléfonos
        Scanner scanner = new Scanner(System.in); // se crea el objeto scanner para recibir datos del usuario
        int opcion;

        do { // se inicia un bucle que se repetirá hasta que el usuario decida salir (opción 5)
            System.out.println("\n--- AGENDA DE CONTACTOS ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); // se guarda la opción elegida por el usuario
            scanner.nextLine(); // se limpia el buffer para evitar errores al ingresar texto después de un número

            switch (opcion) { // estructura switch para decidir qué hacer según la opción que eligió el usuario
                case 1: // si elige la opción 1, se agregará un nuevo contacto
                    System.out.print("Nombre del contacto: "); // se pide el nombre del contacto
                    String nombre = scanner.nextLine(); // se guarda el nombre ingresado
                    System.out.print("Número telefónico: "); // se pide el número telefónico
                    String telefono = scanner.nextLine(); // se guarda el número ingresado
                    agenda.put(nombre, telefono); // se guarda el nombre como clave y el número como valor en la agenda
                    System.out.println("Contacto guardado."); // se le avisa al usuario que se guardó correctamente
                    break;

                case 2: // si elige la opción 2, se buscará un contacto
                    System.out.print("Ingrese el nombre del contacto a buscar: "); // se pide el nombre que se quiere buscar
                    String buscar = scanner.nextLine();
                    if (agenda.containsKey(buscar)) { // se verifica si ese nombre está dentro de la agenda
                        System.out.println("Teléfono: " + agenda.get(buscar)); // si lo encuentra, muestra el número
                    } else {
                        System.out.println("Contacto no encontrado."); // si no lo encuentra, muestra un mensaje diciendo que no existe
                    }
                    break;

                case 3: // si elige la opción 3, se eliminará un contacto
                    System.out.print("Nombre del contacto a eliminar: "); // se pide el nombre del contacto a borrar
                    String eliminar = scanner.nextLine();
                    if (agenda.remove(eliminar) != null) { // si al intentar eliminar el contacto el resultado no es null, significa que sí existía
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("No se encontró el contacto."); // mensaje en caso de que el contacto no exista
                    }
                    break;

                case 4:
                    System.out.println("Listado de contactos:");
                    for (String key : agenda.keySet()) { // se recorre cada clave (nombre) en la agenda
                        System.out.println(key + " → " + agenda.get(key)); // se imprime el nombre y el teléfono correspondiente
                    }
                    break;

                case 5: // si elige la opción 5, se saldrá del programa
                    System.out.println("Saliendo...");
                    break;

                default: // en caso de que el usuario digite una opción que no existe
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5); // el bucle continuará ejecutándose hasta que la opción sea 5 (salir)
    }
}
