import java.util.ArrayList; // import the ArrayList class
import java.util.List; // import the List class

class Livro extends Exemplar {
    private String codigo;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int ano;
    private List<Exemplar> exemplares = new ArrayList<>();
    private List<Usuario> reservas = new ArrayList<>();
    private List<Observer> observadores = new ArrayList<>();

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, int ano) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.ano = ano;
    }

    public void registrarObservador(Observer observer) {
        observadores.add(observer);
    }

    public void notificarObservadores() {
        if (reservas.size() > 2) {
            for (Observer observer : observadores) {
                observer.update();
            }
        }
    }

    // Métodos para gerenciar exemplares e reservas

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
}
