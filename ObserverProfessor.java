class ObserverProfessor implements Observer {
    private String nomeObservador;
    private String nomeLivro;

    public void update(String nomeLivro) {
        if (this.nomeLivro == nomeLivro) {
            GerenciadorIO.PrintNotificacaoProfessor(nomeObservador, nomeLivro);
        }
    }
}
