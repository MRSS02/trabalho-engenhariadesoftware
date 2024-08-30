class ComandoReserva implements Comando {
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (usuario == null) {
            GerenciadorIO.getInstance().PrintReserva("UsuarioNull");
            return;
        }
        if (livro == null) {
            GerenciadorIO.getInstance().PrintReserva("LivroNull");
            return;
        }
        if (!exemplar.isDisponivel()) {
            GerenciadorIO.getInstance().PrintReserva("ExemplarNaoDisponivel");
            return;
        }
        
        usuario.reservarLivro(exemplar);
        exemplar.setIsReservado(true);
        exemplar.setIsReservadoPara(usuario.getCodigo());
        livro.adicionarReserva(exemplar);
        
        GerenciadorIO.getInstance().PrintReserva("Sucesso");

        
    }
}




