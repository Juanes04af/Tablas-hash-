import java.util.Hashtable; // se importa Hashtable para guardar las notas de los estudiantes asociadas a su nombre
import java.util.Scanner; // se importa Scanner para leer datos que escriba el usuario

public class RegistroNotas {
    public static void main(String[] args) {
        Hashtable<String, Double> notas = new Hashtable<>(); // estructura que guarda el nombre del estudiante como clave y su nota como valor
        Scanner scanner = new Scanner(System.in);

        // Se agregan algunos estudiantes con sus notas
        notas.put("Laura", 4.3);
        notas.put("Andrés", 2.8);
        notas.put("Camila", 3.7);

        System.out.print("Ingrese el nombre del estudiante: ");
        String estudiante = scanner.nextLine(); // se lee el nombre ingresado

        if (notas.containsKey(estudiante)) { // se verifica si el nombre existe en la tabla
            double nota = notas.get(estudiante); // se obtiene la nota correspondiente
            System.out.println("Nota final de " + estudiante + ": " + nota);

            // Se evalúa si la nota es suficiente para aprobar
            if (nota >= 3.0) {
                System.out.println("Estado: Aprobado");
            } else {
                System.out.println("Estado: Reprobado");
            }
        } else {
            System.out.println("Estudiante no registrado."); // mensaje para cuando el nombre no se encuentra en la lista
        }
    }
}
