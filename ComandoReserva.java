class ComandoReserva implements Comando {
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (usuario == null) {
            GerenciadorIO.getInstance().PrintReserva("UsuarioNull", usuario, livro);
            return;
        }
        if (livro == null) {
            GerenciadorIO.getInstance().PrintReserva("LivroNull",  usuario, livro);
            return;
        }
        if (!exemplar.isDisponivel()) {
            GerenciadorIO.getInstance().PrintReserva("ExemplarNaoDisponivel",  usuario, livro);
            return;
        }
        if (usuario.getQuantidadeReservas() > 3) {
            GerenciadorIO.getInstance().PrintReserva("MuitasReservas",  usuario, livro);
            return;
        }
 
        usuario.reservarLivro(exemplar);
        exemplar.setIsReservado(true);
        exemplar.setIsReservadoPara(usuario.getCodigo());
        livro.adicionarReserva(exemplar);
        
        GerenciadorIO.getInstance().PrintReserva("Sucesso", usuario, livro);

        
    }
}




