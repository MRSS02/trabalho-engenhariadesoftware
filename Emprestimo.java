import java.time.LocalDate;

class Emprestimo {
    
    private int codigoLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean isFinalizado;

    public Emprestimo(int codigoLivro, LocalDate dataEmprestimo) {
        this.codigoLivro = codigoLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
        this.isFinalizado = false;
    }

    public int getCodigoLivro() {
        return this.codigoLivro;
    }

    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }

    public boolean isFinalizado() {
        return this.isFinalizado;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setIsFinalizado(boolean isFinalizado) {
        this.isFinalizado = isFinalizado;
    }

}
