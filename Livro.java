import java.util.ArrayList; // import the ArrayList class
import java.util.List; // import the List class

class Livro {
    private int codigo;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int anoPublicacao;
    private List<Exemplar> exemplares = new ArrayList<>();
    private List<Exemplar> reservas = new ArrayList<>();
    private List<Observer> observadores = new ArrayList<>();

    public Livro(int codigo, String titulo, String editora, String autores, String edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
    }

    public void registrarObservador(Observer observer) {
        observadores.add(observer);
    }

    public void notificarObservadores() {
        if (this.reservas.size() > 2) {
            GerenciadorObserver.getInstance().notificar(this.getCodigo());  
        }
    }

    public void adicionarReserva(Exemplar exemplar) {
        this.reservas.add(exemplar);
        this.notificarObservadores();
    }

    public void removerReserva(Exemplar exemplar) {
        this.reservas.remove(exemplar);
    }


    // Métodos para gerenciar exemplares e reservas

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
}
