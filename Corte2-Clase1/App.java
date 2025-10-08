import java.util.Stack;
 
public class App {
    public static void main(String[] args) throws Exception {
        //creador la pila con la clase satack
        Stack<Integer> pila = new Stack<>();
        //Agregar elementos a la pila
        pila.push(3);
        pila.push(8);
        pila.push(10);
        pila.push(9);
        pila.push(6);
        pila.push(15);
        //Imprimir la pila
        System.out.println(pila);
        //Validar si la pila esta vacia
        System.out.println(pila.empty());
        //Mostrar el tope de la fila sin eliminar
        System.out.println(pila.peek());
        //Eliminar unn elemento de la pila
        System.out.println(pila.pop());
        //Imprimir pila
        System.out.println(pila);
        //Buscar cada elemento para conocer su posicion dentro de la pila
        System.out.println(pila.search(6));
        System.out.println(pila.search(9));
        System.out.println(pila.search(10));
        System.out.println(pila.search(8));
        System.out.println(pila.search(3));
        //obtener el tamaño de la fila
        System.out.println(pila.size());

 
 
 
       
   }
}

