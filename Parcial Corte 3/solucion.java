import java.util.ArrayList;
import java.util.Arrays;

public class solucion {

    
    static String[] ciudades = { "Cali", "Buga", "Medellin", "Monteria", "Cartagena" };

    public static void main(String[] args) {


        ArrayList<ArrayList<int[]>> grafo = new ArrayList<>();

        for (int i = 0; i < ciudades.length; i++) {
            grafo.add(new ArrayList<>()); 
        }


        // Cali - Buga - Medellín - Montería - Cartagena
        agregarArista(grafo, 0, 1, 67);   // Cali - Buga
        agregarArista(grafo, 1, 2, 240);  // Buga - Medellin
        agregarArista(grafo, 2, 3, 400);  // Medellin - Montería
        agregarArista(grafo, 3, 4, 180);  // Montería - Cartagena

     
        int inicio = 0;  // Cali
        int fin = 4;     // Cartagena

        int[] distancias = dijkstra(grafo, inicio);

        System.out.println("Distancia más corta de " + ciudades[inicio] +
                " a " + ciudades[fin] + ": " + distancias[fin] + " km");

       
        int[] resultados = Arrays.copyOf(distancias, distancias.length);
        burbuja(resultados);

        System.out.println("\nDistancias ordenadas (burbuja):");
        for (int d : resultados) {
            System.out.println(d + " km");
        }
    }

    
    static void agregarArista(ArrayList<ArrayList<int[]>> grafo, int origen, int destino, int distancia) {
        grafo.get(origen).add(new int[]{ destino, distancia }); 
        grafo.get(destino).add(new int[]{ origen, distancia }); 
    }

    
    static int[] dijkstra(ArrayList<ArrayList<int[]>> grafo, int inicio) {

        int n = grafo.size();
        int[] dist = new int[n];
        boolean[] visitado = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[inicio] = 0;

        for (int i = 0; i < n - 1; i++) {

            
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            visitado[u] = true;

        
            for (int[] par : grafo.get(u)) {
                int vecino = par[0];
                int peso = par[1];

                if (dist[u] + peso < dist[vecino]) {
                    dist[vecino] = dist[u] + peso;
                }
            }
        }

        return dist;
    }

   
    static void burbuja(int[] arr) {
        boolean cambiado;
        do {
            cambiado = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    cambiado = true;
                }
            }
        } while (cambiado);
    }
}


