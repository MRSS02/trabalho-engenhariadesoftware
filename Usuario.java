abstract class Usuario {
    private String codigo;
    private String nome;
    private int limiteEmprestimos;
    private int tempoEmprestimo;

    public Usuario(String codigo, String nome, int limiteEmprestimos, int tempoEmprestimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.limiteEmprestimos = limiteEmprestimos;
        this.tempoEmprestimo = tempoEmprestimo;
    }

    public abstract boolean podeEmprestar(Livro livro);
    
    public String getNome() {
        return nome;
    }
}
