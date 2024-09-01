import java.time.LocalDate;

class Reserva {
    
    private int codigoLivro;
    private LocalDate dataSolicitacao;
    
    public Reserva(int codigoLivro, LocalDate dataSolicitacao) {
        this.codigoLivro = codigoLivro;
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getCodigoLivro() {
        return this.codigoLivro;
    }

    public LocalDate getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

}
