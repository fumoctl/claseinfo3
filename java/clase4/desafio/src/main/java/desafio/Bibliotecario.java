package desafio;

public class Bibliotecario extends Usuario implements Gestionable {
    private Biblioteca biblioteca;

    public Bibliotecario(String nombre, String dni, Biblioteca biblioteca) {
        super(nombre, dni);
        this.biblioteca = biblioteca;
    }

    @Override
    public void registrarLibro(Libro libro) {
        biblioteca.agregarLibro(libro);
        System.out.println("Bibliotecario " + getNombre() + " registro el libro: " + libro.getTitulo());
    }

    @Override
    public void eliminarLibro(Libro libro) {
        biblioteca.eliminarLibro(libro);
        System.out.println("Bibliotecario " + getNombre() + " elimino el libro: " + libro.getTitulo());
    }
}
