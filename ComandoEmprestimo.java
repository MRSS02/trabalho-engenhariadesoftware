class ComandoEmprestimo implements Comando {
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (usuario == null) {
            GerenciadorIO.getInstance().PrintEmprestimo("UsuarioNull");
            return;
        }
        if (livro == null) {
            GerenciadorIO.getInstance().PrintEmprestimo("LivroNull");
            return;
        }
        if (exemplar == null) {
            GerenciadorIO.getInstance().PrintEmprestimo("ExemplarNull");
            return;
        }
        if (usuario.getTempoEmprestimo() <= 0) {
            GerenciadorIO.getInstance().PrintEmprestimo("Devedor");
        }
        if (!usuario.isProfessor() && exemplar.isReserved() && !exemplar.isReservedTo(usuario.codigo)) {
            GerenciadorIO.getInstance().PrintEmprestimo("Reservado");
            return;
        }
        usuario.pegarEmprestado(exemplar);
        exemplar.setIsReservado(true);
        exemplar.setIsReservadoPara(usuario.getCodigo());
        GerenciadorIO.getInstance().PrintEmprestimo("Sucesso");

        
    }
}



