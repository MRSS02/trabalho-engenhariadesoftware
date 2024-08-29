import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

class Exemplar {
    private int codigo;
    private int codigoExemplar;
    private boolean isDisponivel;
    private Livro livro;
    private Usuario emprestadoPara;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;

    public Exemplar(int codigo, int codigoExemplar, boolean isDisponivel) {
        this.codigo = codigo;
        this.codigoExemplar = codigoExemplar;
        this.isDisponivel = isDisponivel;
        this.livro = null;
        for(Livro livro : SistemaBiblioteca.getListaLivros()) {
            if(livro.getCodigo() == codigo ) {
            this.livro = livro;
            }
        }
      
    }

    public Livro getLivro() {
        return this.livro;
    }

    public boolean isDisponivel() {
        return this.isDisponivel;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public int getDiasDevolucao() {
       LocalDate epoch = LocalDate.ofEpochDay(0);
       return (ChronoUnit.DAYS.between(epoch, getDataDevolucaoPrevista()) - ChronoUnit.DAYS.between(epoch, getDataEmprestimo()));
    }
}

