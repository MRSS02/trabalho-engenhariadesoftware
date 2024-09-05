import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

class Exemplar {
    private int codigoLivro;
    private int codigoExemplar;
    private boolean isDisponivel;
    private Livro livro;
    private boolean isReservado;
    private int reservadoPara;    
    private int emprestadoPara;
    private LocalDate dataEmprestimo;
    private LocalDate dataReservada;
    private LocalDate dataDevolucaoPrevista;

    public Exemplar(int codigoLivro, int codigoExemplar) {
        this.codigoLivro = codigoLivro;
        this.codigoExemplar = codigoExemplar;
        this.isDisponivel = true;
        this.isReservado = false;
        this.livro = null;
        for(Livro livro : SistemaBiblioteca.getInstance().getListaLivros()) {
            if(livro.getCodigo() == codigoLivro ) {
                this.livro = livro;
                break;
            }
        }
        this.livro.adicionarExemplar(this);
      
    }

    public Livro getLivro() {
        return this.livro;
    }

    public int getCodigoLivro() {
        return this.codigoLivro;
    }

    public int getCodigoExemplar() {
        return this.codigoExemplar;
    }

    public void setIsDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    public void setIsReservado(boolean isReservado) {
        this.isReservado = isReservado;
    }

    public void setIsReservadoPara(int codigoUsuario) {
        this.reservadoPara = codigoUsuario;
    }

    public boolean isReservadoPara(int codigoUsuario) {
        return (this.reservadoPara == codigoUsuario);
    }

    public boolean isDisponivel() {
        return this.isDisponivel;
    }

    public boolean isReservado() {
        return this.isReservado;
    }


    public LocalDate getDataReservada() {
        return dataReservada;
    }

     public void setDataReservada(LocalDate dataReservada) {
        this.dataReservada = dataReservada;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public int getDiasDevolucao() {
       LocalDate epoch = LocalDate.ofEpochDay(0);
       return ((int) ChronoUnit.DAYS.between(getDataDevolucaoPrevista(), getDataEmprestimo()));
    }
    public Usuario getUsuarioReserva() {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        return biblioteca.getUsuarioByCodigo(this.reservadoPara);
    }
    public Usuario getUsuarioEmprestimo() {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        return biblioteca.getUsuarioByCodigo(this.emprestadoPara);
    }


}
