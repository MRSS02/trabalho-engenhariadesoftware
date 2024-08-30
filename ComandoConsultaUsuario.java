class ComandoConsultaUsuario implements Comando {
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (usuario == null) {
            GerenciadorIO.getInstance().PrintConsultaUsuario("UsuarioNull");
            return;
        }
        GerenciadorIO.getInstance().PrintEmprestimo("Sucesso!");
        // Implementar lógica de consulta de usuário
    }
}
