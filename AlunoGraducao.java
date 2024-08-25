class AlunoPos extends Usuario {
    public AlunoPos(String codigo, String nome) {
        super(codigo, nome, 4, 5);
    }

    @Override
    public boolean podeEmprestar(Livro livro) {
        // Implementar regras específicas
        return true;
    }
}


