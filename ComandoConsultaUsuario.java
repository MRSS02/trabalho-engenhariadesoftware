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
        List<Exemplar> livrosReservados = usuario.getLivrosReservados();
            if (livrosReservados.isEmpty()) {
                System.out.println("Nenhum livro reservado.");
            } else {
                System.out.println("Livros reservados:");
                for (Exemplar reservado : livrosReservados) {
                    Livro reservado2 = reservado.getLivro();
                    System.out.println(reservado2.getTitulo());
                    System.out.println(reservado2.getQuantidadeReservas());
                    System.out.println(reservado2.getDataReservada());
                }
            }

            // Exibe os livros emprestados pelo usuário
        List<Exemplar> livrosEmprestados = usuario.getLivrosEmprestados();
            if (livrosEmprestados.isEmpty()) {
                System.out.println("Nenhum livro emprestado.");
            } else {
                System.out.println("Livros emprestados:");
                for (Exemplar emprestado : livrosEmprestados) {
                    Livro emprestado2 = emprestado.getLivro();
                    System.out.println(emprestado2.getTitulo());
                    System.out.println(emprestado.getDataEmprestimo());
                    System.out.println(emprestado.getDataDevolucaoPrevista())
                }
            }
        
        GerenciadorIO.getInstance().PrintEmprestimo("Sucesso");
        // Implementar lógica de consulta de usuário
    }
}
