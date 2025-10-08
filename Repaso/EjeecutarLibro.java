public class EjeecutarLibro {
    public static void main(String[] args) {
        // Crear el arreglo de libros
        Libro[] libros = new Libro[5];

        // Inicializar los libros
        libros[0] = new Libro(1, "Libro A", 5000);
        libros[1] = new Libro(2, "Libro B", 8000);
        libros[2] = new Libro(3, "Libro C", 12000);
        libros[3] = new Libro(4, "Libro D", 9000);
        libros[4] = new Libro(5, "Libro E", 15000);

        // Buscar y mostrar el libro más caro
        Libro libroMasCaro = buscarLibroMasCaro(libros);
        System.out.println("El libro más caro es: " + libroMasCaro.toString());
    }

    // Método para buscar el libro más caro
    public static Libro buscarLibroMasCaro(Libro[] libros) {
        Libro libroMasCaro = libros[0]; // Suponemos que el primer libro es el más caro

        // Recorremos el arreglo de libros y comparamos los precios
        for (int i = 1; i < libros.length; i++) {
            if (libros[i].getPrecio() > libroMasCaro.getPrecio()) {
                libroMasCaro = libros[i]; // Actualizamos si encontramos un libro más caro
            }
        }

        return libroMasCaro; // Devolvemos el libro más caro
    }
}

