class Professor extends Usuario {
    
    public Professor(int codigo, String nome) {
        super(codigo, nome, 7);
    }
 
    public boolean podeEmprestar() {
        return (this.getTempoEmprestimo() > 0);
    }

    public String getTipoUsuario() {
        return "Professor";
    }


}
