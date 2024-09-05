import java.util.List; 

class ComandoConsultaUsuario implements Comando {
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));

        if (usuario == null) {
            GerenciadorIO.getInstance().PrintConsultaUsuario("UsuarioNull", usuario);
            return;
        }

        GerenciadorIO.getInstance().PrintConsultaUsuario("Nome", usuario);

        // Exibe os livros reservados pelo usuário
        List<Reserva> historicoReservas = usuario.getHistoricoReservas();
        GerenciadorIO.getInstance().PrintLivrosReservados(historicoReservas);

        // Exibe os livros emprestados pelo usuário
        List<Emprestimo> historicoEmprestimos = usuario.getHistoricoEmprestimos();
        GerenciadorIO.getInstance().PrintLivrosEmprestados(historicoEmprestimos);

    }
}

