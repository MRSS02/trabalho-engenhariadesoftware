class ComandoConsultaLivro implements Comando {
    @Override
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (livro == null) {
            GerenciadorIO.getInstance().PrintConsultaLivro("LivroNull");
            return;
        }
          // Exibir informações do livro
            System.out.println("Título: " + livro.getTitulo());

            // Exibir quantidade de reservas
            int quantidadeReservas = livro.getQuantidadeReservas();
            System.out.println("Quantidade de reservas: " + quantidadeReservas);

            // Exibir nomes dos usuários que fizeram reservas, se houver
            if (quantidadeReservas > 0) {
                System.out.println("Usuários que realizaram reservas:");
                for (Exemplar reserva : livro.getReservas()) {
                    Usuario usuarioReserva = reserva.getUsuarioReserva();
                    if (usuarioReserva != null) {
                        System.out.println(" - " + usuarioReserva.getNome());
                    }
                }
            }

            // Exibir informações dos exemplares
            System.out.println("Exemplares:");
            for (Exemplar exemplar : livro.getExemplares()) {
                System.out.println("Código do Exemplar: " + exemplar.getCodigo());
                if (exemplar.isReservado()) {
                    System.out.println("Status: Reservado");
                    Usuario usuarioReserva = exemplar.getUsuarioReserva();
                    if (usuarioReserva != null) {
                        System.out.println("Reservado por: " + usuarioReserva.getNome());
                    }
                } else if (!exemplar.isDisponivel()) {
                    Usuario usuarioEmprestimo = exemplar.getUsuarioEmprestimo();
                    System.out.println("Status: Emprestado");
                    System.out.println("Usuário: " + usuarioEmprestimo.getNome());
                    System.out.println("Data de Empréstimo: " + exemplar.getDataEmprestimo());
                    System.out.println("Data Prevista para Devolução: " + exemplar.getDataDevolucaoPrevista());
                } else {
                    System.out.println("Status: Disponível");
                }
            }
        // Implementar lógica de consulta de livro
        GerenciadorIO.getInstance().PrintConsultaLivro("Sucesso");
    }
}

