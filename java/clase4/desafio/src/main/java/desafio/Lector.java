package desafio;

public class Lector extends Usuario {
    private int cantidadPrestamos;

    public Lector(String nombre, String dni) {
        super(nombre, dni);
        this.cantidadPrestamos = 0;
    }

    public void realizarPrestamo(Libro libro) {
        if (libro.prestar()) {
            cantidadPrestamos++;
            System.out.println(getNombre() + " realizo el prestamo de: " + libro.getTitulo());
        } else {
            System.out.println("No se pudo prestar '" + libro.getTitulo() + "' porque no esta disponible.");
        }
    }

    public void devolverLibro(Libro libro) {
        libro.devolver();
        if (cantidadPrestamos > 0) {
            cantidadPrestamos--;
        }
        System.out.println(getNombre() + " devolvio el libro: " + libro.getTitulo());
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Lector{nombre='" + getNombre() + "', dni='" + getDni() + "', cantidadPrestamos=" + cantidadPrestamos + "}");
    }

    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }
}
