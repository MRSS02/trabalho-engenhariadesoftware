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
        this.tempoEmprestimoBase = tempoEmprestimo;

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

    public void reservarLivro(Exemplar exemplar) {
        this.LivrosReservados.add(exemplar);
    }

    public void pegarEmprestado(Exemplar exemplar) {
        this.LivrosEmprestados.add(exemplar);
        this.LivrosReservados.remove(exemplar);
    }
    public void devolver(Livro livro) {
        Exemplar exemplar = this.getExemplarByCodigoLivro(livro.getCodigo()); 
        this.LivrosEmprestados.remove(exemplar);
        if (LivrosEmprestados.size() == 0) {
            this.resetTempoEmprestimo();
        } else {
            int tempoEmprestimo = this.getTempoEmprestimoBase();
            for(Exemplar exemplarIterator : this.LivrosEmprestados) {
            int diasDevolucao = exemplar.getDiasDevolucao();
            if(diasDevolucao < tempoEmprestimo ) {
                tempoEmprestimo = diasDevolucao;
            }
            }
            this.tempoEmprestimo = tempoEmprestimo;

        }
    }
    
    public Exemplar getExemplarByCodigoLivro(int codigo) {
        for(Exemplar exemplar : this.LivrosEmprestados) {
            if(exemplar.getCodigo() == codigo ) {
                return exemplar;
            }
        }
        return null;

    }

    public List<Exemplar> getLivrosReservados() {
         return this.LivrosReservados;
    }

    public List<Exemplar> getLivrosEmprestados() {
         return this.LivrosEmprestados;
    }


}
