class ComandoConsultaLivro implements Comando {
    @Override
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (livro == null) {
            GerenciadorIO.getInstance().PrintConsultaLivro("LivroNull");
            return;
        }
        
        // Implementar lógica de consulta de livro
        GerenciadorIO.getInstance().PrintConsultaLivro("Sucesso");
    }
}

