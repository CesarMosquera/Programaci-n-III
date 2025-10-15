import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenColaMapa {

    static class ColaCircularEnteros {
        private int[] datos;
        private int cabeza;
        private int cola;
        private int tam;

        public ColaCircularEnteros(int capacidad) {
            datos = new int[capacidad];
            cabeza = 0;
            cola = 0;
            tam = 0;
        }

        public boolean estaVacia() { return tam == 0; }
        public boolean estaLlena() { return tam == datos.length; }

        public void encolar(int x) {
            if (estaLlena()) throw new IllegalStateException("Cola llena");
            datos[cola] = x;
            cola = (cola + 1) % datos.length;
            tam++;
        }

        public int desencolar() {
            if (estaVacia()) throw new IllegalStateException("Cola vacía");
            int v = datos[cabeza];
            cabeza = (cabeza + 1) % datos.length;
            tam--;
            return v;
        }
    }

    // (50 pts) Calcula el balance de paréntesis encolando +1 y -1
    public static int balanceConCola(String s) {
    // Se crea la cola y tiene la misma longitud del string
        ColaCircularEnteros cola = new ColaCircularEnteros(s.length());

        // Recorremos caracter por caracter con un ciclo for
        for (int i = 0; i < s.length(); i++) {
            char P = s.charAt(i); // Se toma el caracter que se tiene actual

            // Si el caracter es '(' se va encolar un +1
            if (P == '(') {
                cola.encolar(1);
            } 
            // Si el caracter es ')' se va encolar un -1
            else if (P == ')') {
                cola.encolar(-1);
            }
        }

        // Se inicializa la suma en 0 
        int suma = 0;
        // se crea un ciclo while para recorrer cada caracter
        // si la cola no esta vacia va sumar y desencolar caratcer por caracter
        while (!cola.estaVacia()) {
            suma += cola.desencolar(); // Se suma cada valor
        }

        // Retornamos la suma final (segun los parentesis)
        return suma;
    }
    

    // (50 pts) Registra intentos por nombre en un mapa
    public static int registrarIntento(Map<String,Integer> intentos, String nombre) {
        // TODO: incrementar si existe o iniciar en 1 si no existe
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balance cola: " + balanceConCola(cadena));

        Map<String,Integer> intentos = new HashMap<String,Integer>();
        System.out.println("Intentos (Ana): " + registrarIntento(intentos, "Ana"));
        System.out.println("Intentos (Ana): " + registrarIntento(intentos, "Ana"));

        sc.close();
    }
}