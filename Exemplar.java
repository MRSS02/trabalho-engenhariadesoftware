abstract class Exemplar {
    private String codigo;
    private boolean disponivel = true;
    private Livro livro;
    private Usuario emprestadoPara;
    private String dataEmprestimo;
    private String dataDevolucaoPrevista;

    public Exemplar(Livro livro) {
        this.livro = livro;
    }
}

