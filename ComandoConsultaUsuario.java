import java.util.List; 

class ComandoConsultaUsuario implements Comando {
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));

        if (usuario == null) {
            GerenciadorIO.getInstance().PrintConsultaUsuario("UsuarioNull");
            return;
        }

        // Exibe os livros reservados pelo usuário
        List<Exemplar> livrosReservados = usuario.getLivrosReservados();
        GerenciadorIO.getInstance().PrintLivrosReservados(livrosReservados);

        // Exibe os livros emprestados pelo usuário
        List<Exemplar> livrosEmprestados = usuario.getLivrosEmprestados();
        GerenciadorIO.getInstance().PrintLivrosEmprestados(livrosEmprestados);

    }
}

