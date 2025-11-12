import java.util.Arrays;
public class solucion {
    
    public static void main(String[] args) {
        
        int[][] grafo = {
            {0, 2, 0, 0},
            {2, 0, 1, 4},
            {0, 1, 0, 2},
            {0, 4, 2, 0}
        };
    int n = grafo.length;
    boolean[] verificado= new boolean[n];
    int []distancias=new int[n]; 
    int comienzo= 0;

    for (int i = 0; i < n; i++) distancias[i] = Integer.MAX_VALUE;
        distancias[comienzo] = 0;
     for (int i = 0; i < n - 1; i++) {
            int u = -1;
    for (int j = 0; j < n; j++) {
    if (!verificado[j] && (u == -1 || distancias[j] < distancias[u])) {
    u = j;

        }
      }
      verificado[u]=true;

      for (int v = 0; v < n; v++) {
                if (!verificado[v] && grafo[u][v] != 0 &&
                    distancias[u] != Integer.MAX_VALUE &&
                    distancias[u] + grafo[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + grafo[u][v];
                }
    }
    System.out.println("Distancias"+":"+comienzo);
    for (int j=0;j<n; j++){
      System.out.println("El nodo"+i+"="+distancias[i]);
    }
  }  
  //Burbija
 
    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

    }
    int[] burbuja = distancias.clone();
        burbuja(burbuja);
        System.out.println("Burbuja: " + Arrays.toString(burbuja));
   }
  }
  }
}


