import java.util.Hashtable; // permite manejar cuentas bancarias con número como clave y saldo como valor
import java.util.Scanner; // permite leer datos del usuario

public class Banco {
    public static void main(String[] args) {
        Hashtable<String, Double> cuentas = new Hashtable<>(); // estructura para guardar el número de cuenta y su saldo
        Scanner scanner = new Scanner(System.in);

        // Se crean algunas cuentas con saldos iniciales
        cuentas.put("12345", 5000.0);
        cuentas.put("23456", 3200.5);
        cuentas.put("34567", 150.0);

        System.out.print("Ingrese número de cuenta: ");
        String cuenta = scanner.nextLine(); // se guarda el número de cuenta ingresado

        if (cuentas.containsKey(cuenta)) { // se verifica si la cuenta existe
            System.out.println("Saldo actual: $" + cuentas.get(cuenta));

            System.out.print("Valor a retirar: ");
            double retiro = scanner.nextDouble();

            if (retiro <= cuentas.get(cuenta)) { // se comprueba si hay suficiente dinero para el retiro
                cuentas.put(cuenta, cuentas.get(cuenta) - retiro); // se actualiza el saldo restando el valor retirado
                System.out.println("Retiro exitoso. Saldo restante: $" + cuentas.get(cuenta));
            } else {
                System.out.println("Fondos insuficientes."); // si no hay suficiente dinero, se muestra este mensaje
            }
        } else {
            System.out.println("Cuenta no encontrada."); // si la cuenta no existe en el sistema
        }
    }
}
