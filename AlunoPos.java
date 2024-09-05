class AlunoPos extends Usuario {

    private int limiteEmprestimos;

    public AlunoPos(int codigo, String nome) {
        super(codigo, nome, 5);
        this.limiteEmprestimos = 4;
    }

     public int getLimiteEmprestimos() {
        return this.limiteEmprestimos;
    }

    public boolean podeEmprestar() {
        return (this.getLimiteEmprestimos() > 0 && this.getTempoEmprestimo() > 0);
    }

    public boolean podeEmprestimosIlimitados() {
        return false;
    }
 

}
