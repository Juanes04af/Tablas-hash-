import java.util.*;

class Grafo {
    private final Map<String, List<Par>> adjList = new HashMap<>();

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarArista("A", "B", 10);
        grafo.agregarArista("B", "C", 5);
        grafo.agregarArista("B", "D", 1);
        grafo.agregarArista("C", "D", 10);
        grafo.agregarArista("A", "D", 1);

            Scanner scanner = new Scanner(System.in);

            int opcion;

            do {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Agregar arista");
                System.out.println("2. Calcular caminos mínimos (Dijkstra)");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Nodo origen: ");
                        String origen = scanner.nextLine().toUpperCase();

                        System.out.print("Nodo destino: ");
                        String destino = scanner.nextLine().toUpperCase();

                        System.out.print("Peso (distancia): ");
                        int peso = scanner.nextInt();
                        scanner.nextLine();

                        grafo.agregarArista(origen, destino, peso);
                        System.out.println("Arista agregada: " + origen + " -> " + destino + " con peso " + peso);
                        break;

                    case 2:
                        System.out.print("Nodo de inicio: ");
                        String inicio = scanner.nextLine().toUpperCase();
                        System.out.println("\n--- Distancias mínimas desde " + inicio + " ---");
                        grafo.dijkstra(inicio);
                        break;

                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }

            } while (opcion != 3);


    }

    public void agregarArista(String origen, String destino, int peso) {
        adjList.putIfAbsent(origen, new ArrayList<>());
        adjList.get(origen).add(new Par(peso, destino));
    }

    public void dijkstra(String inicio) {
        Map<String, Integer> distancias = new HashMap<>();
        PriorityQueue<Par> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));

        distancias.put(inicio, 0);
        pq.add(new Par(0, inicio));

        while (!pq.isEmpty()) {
            Par actualPar = pq.poll();
            int distancia = actualPar.peso;
            String actual = actualPar.destino;

            if (!adjList.containsKey(actual)) continue;

            for (Par vecino : adjList.get(actual)) {
                String vecinoNodo = vecino.destino;
                int peso = vecino.peso;
                int nuevaDistancia = distancia + peso;
                if (nuevaDistancia < distancias.getOrDefault(vecinoNodo, Integer.MAX_VALUE)) {
                    distancias.put(vecinoNodo, nuevaDistancia);
                    pq.add(new Par(nuevaDistancia, vecinoNodo));
                }
            }
        }

        distancias.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

class Par {
    int peso;
    String destino;

    public Par(int peso, String destino) {
        this.peso = peso;
        this.destino = destino;
    }
}
