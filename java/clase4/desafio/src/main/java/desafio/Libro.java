package desafio;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }

    public boolean prestar() {
        if (!disponible) {
            return false;
        }
        disponible = false;
        return true;
    }

    public void devolver() {
        disponible = true;
    }

    public void mostrarInfo() {
        System.out.println("Libro{titulo='" + titulo + "', autor='" + autor + "', ISBN='" + isbn + "', disponible=" + disponible + "}");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
