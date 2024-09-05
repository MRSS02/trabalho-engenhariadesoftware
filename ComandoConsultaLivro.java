class ComandoConsultaLivro implements Comando {
    public void executar(String[] args) {
        SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
        Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[1]));
        GerenciadorIO gerenciadorIO = GerenciadorIO.getInstance();
        // Exemplar exemplar = biblioteca.getExemplarByCodigoLivro(Integer.parseInt(args[2]));
        if (livro == null) {
            gerenciadorIO.PrintConsultaLivro("LivroNull", livro);
            return;
        }
          
        // Exibir informações do livro
            // Exibir quantidade de reservas
            int quantidadeReservas = livro.getQuantidadeReservas();
            // Exibir nomes dos usuários que fizeram reservas, se houver
            if (quantidadeReservas > 0) {
                gerenciadorIO.PrintConsultaLivro("QuantidadeReservas", livro);
            } else {
                gerenciadorIO.PrintConsultaLivro("Sem reservas", livro);
            }

        // Exibir informações dos exemplares
            gerenciadorIO.PrintConsultaExemplares(livro);    
    }
}

