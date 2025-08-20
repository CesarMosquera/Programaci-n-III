public class Estudiantes {
    // Atributos
    private int id;
    private String nombre;
    private String facultad;
 
    //constructor
 
    public Estudiantes (int id, String nombre,String facultad){
        this.id = id;
        this.nombre = nombre;
        this.facultad = facultad;
    }
 
    public String toString () {
        return "Estudiantes { id: " + id + " nombre: " + nombre + " facultad "+ facultad + "}";
    }
 
    public int cantidadEstudiantes (String facultad){
        //logica del metodo
        return 0;
 
    }
    }
 
public class EjecutarEstudiante {
    public static void main(String[] args) {
        // creacion de objetos Estudiante
        Estudiantes objEst1 = new Estudiantes(768, "Byron", "Ingenieria");
        Estudiantes objEst2 = new Estudiantes(456, "juan", "Ingenieria");
 
        Estudiantes[] e = new Estudiantes[3];
        e[0] = objEst1;
        e[1] = objEst2;
        e[2] = new Estudiantes(123, "Ana", "Ingenieria");
 
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }
}
 