public class EjeecutarLibro{
public static void main(String[] args) {


Libro [] Libro = new Libro[5];

Libro [0]= new Libro(1, "Lo",5000);
Libro [1]= new Libro(2, "Lo2",3000);
Libro [2]= new Libro(3, "Lo3",8000);
Libro [3]= new Libro(4, "Lo4",9000);
Libro [4]= new Libro(5, "Lo5",2000);

 System.out.println("El costo total de los libros es: " + Libro[3].calcularPrecios(Libro) + " US");


}







}


