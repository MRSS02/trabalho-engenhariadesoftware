import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

abstract class Usuario {
    private int codigo;

    private String nome;
    private int tempoEmprestimo;
    private int tempoEmprestimoBase;
    private List<Exemplar> livrosEmprestados = new ArrayList<>();
    private List<Exemplar> livrosReservados = new ArrayList<>();
    private List<Emprestimo> historicoEmprestimos = new ArrayList<>();
    private List<Reserva> historicoReservas = new ArrayList<>();  

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
        this.livrosReservados.add(exemplar);
        this.historicoReservas.add(Fabrica.cadastrarReserva(exemplar.getCodigoLivro(), 
                    LocalDate.now()));
    }

    public void pegarEmprestado(Exemplar exemplar) {
        this.livrosEmprestados.add(exemplar);
        this.livrosReservados.remove(exemplar);
        this.historicoEmprestimos.add(Fabrica.cadastrarEmprestimo(exemplar.getCodigoLivro(), 
                    LocalDate.now()));
    }

    public void finalizarEmprestimo(Exemplar exemplar) {
        for(Emprestimo emprestimo : this.historicoEmprestimos) {
            if(emprestimo.getCodigoLivro() == exemplar.getCodigoLivro() ) {
                emprestimo.setIsFinalizado(true);
                emprestimo.setDataDevolucao(LocalDate.now());
            }
        }

    }

    public void devolver(Livro livro) {
        Exemplar exemplar = this.getExemplarByCodigoLivro(livro.getCodigo());
        this.finalizarEmprestimo(exemplar);
        this.livrosEmprestados.remove(exemplar);
        if (livrosEmprestados.size() == 0) {
            this.resetTempoEmprestimo();
        } else {
            int tempoEmprestimo = this.getTempoEmprestimoBase();
            for(Exemplar exemplarIterator : this.livrosEmprestados) {
            int diasDevolucao = exemplar.getDiasDevolucao();
            if(diasDevolucao < tempoEmprestimo ) {
                tempoEmprestimo = diasDevolucao;
            }
            }
            this.tempoEmprestimo = tempoEmprestimo;

        }
    }
    
    public Exemplar getExemplarByCodigoLivro(int codigoLivro) {
        for(Exemplar exemplar : this.livrosEmprestados) {
            if(exemplar.getCodigoLivro() == codigoLivro) {
                return exemplar;
            }
        }
        return null;

    }

    public int getQuantidadeReservas() {
        return this.livrosReservados.size();
    }

    public List<Exemplar> getLivrosReservados() {
         return this.livrosReservados;
    }

    public List<Exemplar> getLivrosEmprestados() {
         return this.livrosEmprestados;
    }


}
