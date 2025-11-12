import java.util.Arrays;

public class MetodosOrdenamientoDijkstra {
    public static void main(String[] args) {

        int[][] grafo = {
            {0, 2, 5, 0},
            {2, 0, 1, 4},
            {5, 1, 0, 2},
            {0, 4, 2, 0}
        };

        int n = 4;
        int origen = 0;
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];


        for (int i = 0; i < n; i++) distancia[i] = Integer.MAX_VALUE;
        distancia[origen] = 0;

        //Algoritmo de Dijkstra
        for (int i = 0; i < n - 1; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visitado[j] && (u == -1 || distancia[j] < distancia[u])) {
                    u = j;
                }
            }
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 &&
                    distancia[u] != Integer.MAX_VALUE &&
                    distancia[u] + grafo[u][v] < distancia[v]) {
                    distancia[v] = distancia[u] + grafo[u][v];
                }
            }
        }

        System.out.println("Distancias desde el nodo " + origen + ": " + Arrays.toString(distancia));

        //USAMOS LAS DISTANCIAS COMO ARREGLO BASE
        int[] arreglo = distancia.clone();

        System.out.println("Arreglo original (distancias Dijkstra): " + Arrays.toString(arreglo));

        // BURBUJA
        int[] burbuja = arreglo.clone();
        burbuja(burbuja);
        System.out.println("Burbuja: " + Arrays.toString(burbuja));

        // INSERCIÓN
        int[] insercion = arreglo.clone();
        insercion(insercion);
        System.out.println("Inserción: " + Arrays.toString(insercion));

        // SELECCIÓN
        int[] seleccion = arreglo.clone();
        seleccion(seleccion);
        System.out.println("Selección: " + Arrays.toString(seleccion));

        // QUICK SORT 
        int[] quick = arreglo.clone();
        quickSort(quick, 0, quick.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quick));

        // MERGE SORT 
        int[] merge = arreglo.clone();
        mergeSort(merge, 0, merge.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(merge));
    }

    // MÉTODO BURBUJA 
    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // MÉTODO DE INSERCIÓN 
    public static void insercion(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // MÉTODO DE SELECCIÓN
    public static void seleccion(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //  MÉTODO QUICK SORT 
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pi = particion(arr, inicio, fin);
            quickSort(arr, inicio, pi - 1);
            quickSort(arr, pi + 1, fin);
        }
    }

    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = (inicio - 1);
        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }

    // MÉTODO MERGE SORT 
    public static void mergeSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(arr, inicio, medio);
            mergeSort(arr, medio + 1, fin);
            merge(arr, inicio, medio, fin);
        }
    }

    public static void merge(int[] arr, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[inicio + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[medio + 1 + j];

        int i = 0, j = 0;
        int k = inicio;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
