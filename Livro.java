import java.util.ArrayList; 
import java.util.List; 

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

    public int getQuantidadeReservas() {
        return this.reservas.size();
    }

    public List<Exemplar> getExemplares() {
        return this.exemplares;
    }

    public void adicionarExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }

    public List<Exemplar> getReservas() {
        return this.reservas;
    }

    public List<Observer> getObservadores() {
        return this.observadores;
    }

    public void adicionarReserva(Exemplar exemplar) {
        this.reservas.add(exemplar);
        this.notificarObservadores();
    }

    public void removerReserva(Exemplar exemplar) {
        this.reservas.remove(exemplar);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
}
