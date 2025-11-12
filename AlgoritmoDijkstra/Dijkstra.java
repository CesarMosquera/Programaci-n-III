public class Dijkstra {
    public static void main(String[] args) {
        int n = 4;
        int[][] grafo = {
            {0, 2, 0, 0},
            {2, 0, 1, 4},
            {0, 1, 0, 2},
            {0, 4, 2, 0}
        };

        int origen = 0;
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];

        // Inicializar con "infinito"
        for (int i = 0; i < n; i++) distancia[i] = Integer.MAX_VALUE;
        distancia[origen] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = -1;
            // Escoger nodo no visitado con menor distancia
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && (u == -1 || distancia[j] < distancia[u])) {
                    u = j;
                }
            }

            visitado[u] = true;

            // Actualizar distancias de los vecinos de u
            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 &&
                    distancia[u] != Integer.MAX_VALUE &&
                    distancia[u] + grafo[u][v] < distancia[v]) {

                    distancia[v] = distancia[u] + grafo[u][v];
                }
            }
        }

        System.out.println("Distancias mínimas desde el nodo " + origen + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Nodo " + i + " : " + distancia[i]);
        }
    }
}

