class AlunoGraduacao extends Usuario {

    private int limiteEmprestimos;

    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome, 3);
        this.limiteEmprestimos = 3;
    }

    public int getLimiteEmprestimos() {
        return this.limiteEmprestimos;
    }

    public boolean podeEmprestar() {
        return (this.getLimiteEmprestimos() > 0 && this.getTempoEmprestimo() > 0);
    }

}


