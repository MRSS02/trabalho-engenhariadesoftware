class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome, 3, 3);
    }

    @Override
    public boolean podeEmprestar(Livro livro) {
        // Implementar regras específicas
        return true;
    }
}
