class Professor extends Usuario {
    
    public Professor(String codigo, String nome) {
        super(codigo, nome, 7);
    }
 
    public boolean podeEmprestar() {
        return (this.getTempoEmprestimo() > 0);
    }

}
