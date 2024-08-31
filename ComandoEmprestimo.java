import java.time.LocalDate;

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
            GerenciadorIO.getInstance().PrintEmprestimo("ExemplarNaoDisponivel");
            return;
        }
        if (usuario.getTempoEmprestimo() <= 0) {
            GerenciadorIO.getInstance().PrintEmprestimo("Devedor");
        }
        if (!usuario.getTipoUsuario() == "Professor" && exemplar.isReservado() && !exemplar.isReservadoPara(usuario.getCodigo())) {
            GerenciadorIO.getInstance().PrintEmprestimo("Reservado");
            return;
        }
        usuario.pegarEmprestado(exemplar);
        exemplar.setDataEmprestimo(LocalDate.now());
        exemplar.setDataDevolucaoPrevista(LocalDate.now().plusDays(usuario.getTempoEmprestimoBase()));
        exemplar.setIsReservado(false);
        exemplar.setIsDisponivel(false);
        GerenciadorIO.getInstance().PrintEmprestimo("Sucesso");

        
    }
}



