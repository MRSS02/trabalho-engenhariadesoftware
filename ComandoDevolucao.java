class ComandoDevolucao implements Comando {
    public void executar(String[] args) {
        // Implementar lógica de devolução
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        if (usuario == null) {
            GerenciadorIO.getInstance().PrintDevolucao("UsuarioNull", usuario, livro);
            return;
        }
        if (livro == null) {
            GerenciadorIO.getInstance().PrintDevolucao("LivroNull", usuario, livro);
            return;
        }
        if (usuario.getExemplarByCodigoLivro(Integer.parseInt(args[2])) == null) {
            GerenciadorIO.getInstance().PrintDevolucao("LivroNaoEmprestado", usuario, livro);
            return;
        }
        Exemplar exemplar = usuario.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        exemplar.setIsReservado(false);
        livro.removerReserva(exemplar);
        usuario.devolver(livro);
        GerenciadorIO.getInstance().PrintDevolucao("Sucesso", usuario, livro);
    }
}
