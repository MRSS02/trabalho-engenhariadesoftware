class ComandoConsultaLivro implements Comando {
    @Override
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
        GerenciadorIO gerenciadorIO = GerenciadorIO.getInstance();
        // Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (livro == null) {
            gerenciadorIO.PrintConsultaLivro("LivroNull", usuario, livro);
            return;
        }
          
        // Exibir informações do livro
            // Exibir quantidade de reservas
            int quantidadeReservas = livro.getQuantidadeReservas();
            // Exibir nomes dos usuários que fizeram reservas, se houver
            if (quantidadeReservas > 0) {
                gerenciadorIO.PrintConsultaLivro("QuantidadeReservas", usuario, livro);
            }

        // Exibir informações dos exemplares
            gerenciadorIO.PrintConsultaExemplares(usuario, livro);    
    }
}

