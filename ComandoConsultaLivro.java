class ComandoConsultaLivro implements Comando {
    @Override
    public void executar(String[] args) {
        // Implementar lógica de consulta de livro
        GerenciadorIO.getInstance().PrintConsultaLivro();
    }
}

