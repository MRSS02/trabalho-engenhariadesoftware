class Professor extends Usuario {
    public Professor(String codigo, String nome) {
        super(codigo, nome, Integer.MAX_VALUE, 7);
    }

    @Override
    public boolean podeEmprestar(Livro livro) {
        // Implementar regras específicas
        return true;
    }
}
