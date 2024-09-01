import java.time.LocalDate;

class Reserva {
    
    private int codigoExemplar;
    private LocalDate dataSolicitacao;
    
    public Reserva(int codigoExemplar, LocalDate dataSolicitacao) {
        this.codigoExemplar = codigoExemplar;
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getCodigoExemplar() {
        return this.codigoExemplar;
    }

    public LocalDate getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setCodigoExemplar(int codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

}
