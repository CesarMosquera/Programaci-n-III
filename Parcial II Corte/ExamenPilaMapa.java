import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 si está vacía

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() { return tope == -1; }
        public boolean estaLlena() { return tope == datos.length - 1; }

        public void apilar(int x) {
            if (estaLlena()) throw new IllegalStateException("Pila llena");
            tope++;
            datos[tope] = x;
        }

        public int desapilar() {
            if (estaVacia()) throw new IllegalStateException("Pila vacía");
            int v = datos[tope];
            tope--;
            return v;
        }
    }

    // (50 pts) Verifica si los paréntesis están balanceados
    public static boolean esBalanceado(String s) {
        // Se usa la pila que se creo para guardar los parentesis que abren
        PilaEnteros pila = new PilaEnteros(s.length());
        // se recorre con un cilo for 
        for (int i = 0; i < s.length(); i++) {
            char A = s.charAt(i);

            // Si es un parentesis que abre, lo apilamos
            if (A == '(') {
                pila.apilar(1);
            }
            // Si es un parentesis de cierre, verificamos que haya uno que cerrar
            else if (A == ')') {
                if (pila.estaVacia()) {
                    // retorna falso si hay un parentesis que cierra sin haber antes uno que abre
                    return false;
                }
                pila.desapilar();
            }
        }

        // Si la pila esta vacia, esta balanceado
        return pila.estaVacia();
    }

    // (50 pts) Actualiza la calificación si existe el id y el nuevo valor está entre 0 y 100
    public static boolean actualizarCalificacion(Map<Integer, Integer> CalificacionporId, int id, int nota) {
        // Se valida que el id exista en el mapa
        if (!CalificacionporId.containsKey(id)) {
            // No existe el id
            System.out.println("El id no existe");
            return false;
        }

        // Validar que la nota esté en el rango permitido
        if (nota < 0 || nota > 100) {
            // Esto pasa si la nota esta fuera del rango, es false
            System.out.println("La nota esta fuera del rango");
            return false;
        }

        // Actualizar la calificación utilizando un put
        CalificacionporId.put(id, nota);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        mapa.put(101, 70);
        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 101, 80));
        sc.close();
    }
}
