import java.util.ArrayList;
import java.util.List;


abstract class Usuario {
    private int codigo;

    private String nome;
    private int tempoEmprestimo;
    private int tempoEmprestimoBase;
    private List<Exemplar> LivrosEmprestados = new ArrayList<>();
    private List<Exemplar> LivrosReservados = new ArrayList<>();

    public Usuario(int codigo, String nome, int tempoEmprestimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.tempoEmprestimo = tempoEmprestimo;

    }

    public abstract boolean podeEmprestar();

    public abstract String getTipoUsuario(); 
    
    public String getNome() {
        return this.nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    }

    public int getTempoEmprestimoBase() {
        return this.tempoEmprestimoBase;
    }

    public void resetTempoEmprestimo() {
        this.tempoEmprestimo = this.getTempoEmprestimoBase();
    }

    public void reservarLivro(Exemplar Exemplar) {
        LivrosReservados.add(Exemplar);
    }
    
    public List<Exemplar> getLivrosReservados {
         return this.LivrosReservados;
    }
  
    public void pegarEmprestado(Exemplar Exemplar) {
        LivrosEmprestados.add(Exemplar);
    }

}
