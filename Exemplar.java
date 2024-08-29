import java.time.temporal.ChronoUnit;
import java.time.LocalDate;


abstract class Exemplar {
    private String codigo;
    private boolean disponivel = true;
    private Livro livro;
    private Usuario emprestadoPara;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;

    public Exemplar(Livro livro) {
        this.livro = livro;
    }

    public Livro getLivro() {
        return this.livro;
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

