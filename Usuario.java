import java.util.ArrayList;
import java.util.List;

abstract class Usuario {
    private String codigo;
    private String nome;
    private int tempoEmprestimo;
    private List<Exemplar> LivrosEmprestados = new ArrayList<>();
    private List<Exemplar> LivrosReservados = new ArrayList<>();

    public Usuario(String codigo, String nome, int tempoEmprestimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.tempoEmprestimo = tempoEmprestimo;

    }

    public abstract boolean podeEmprestar();
    
    public String getNome() {
        return this.nome;
    }

    public int getTempoEmprestimo() {
        return this.tempoEmprestimo;
    }



}
