import java.time.LocalDate;

class ComandoEmprestimo implements Comando {
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (usuario == null) {
            GerenciadorIO.getInstance().PrintEmprestimo("UsuarioNull", null, null);
            return;
        }
        if (livro == null) {
            GerenciadorIO.getInstance().PrintEmprestimo("LivroNull", null, null);
            return;
        }
        if (exemplar == null) {
            GerenciadorIO.getInstance().PrintEmprestimo("ExemplarNaoDisponivel", null, null);
            return;
        }
        if (usuario.getTempoEmprestimo() <= 0) {
            GerenciadorIO.getInstance().PrintEmprestimo("Devedor", null, null);
        }
        if (!(usuario.podeEmprestimosIlimitados()) && exemplar.isReservado() && !exemplar.isReservadoPara(usuario.getCodigo())) {
            GerenciadorIO.getInstance().PrintEmprestimo("Reservado", null, null);
            return;
        }
        usuario.pegarEmprestado(exemplar);
        exemplar.setDataEmprestimo(LocalDate.now());
        exemplar.setDataDevolucaoPrevista(LocalDate.now().plusDays(usuario.getTempoEmprestimoBase()));
        exemplar.setIsReservado(false);
        exemplar.setIsDisponivel(false);
        GerenciadorIO.getInstance().PrintEmprestimo("Sucesso", usuario, livro);

        
    }
}



