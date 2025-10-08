import java.util.Stack;

public class CuadradosCubos {
    public static boolean compararCuadradosycubos(int a, int b){
        Stack<Integer> pila = new Stack<>();
        pila.push(a);
        pila.push(b);

        int NumeroB= pila.pop();
        int NumeroA= pila.pop();

        double RaizA= Math.sqrt(NumeroA);
        double RaizB= Math.cbrt(NumeroB);

        return Math.abs(RaizA - RaizB) < 0.0001;

    }
}
