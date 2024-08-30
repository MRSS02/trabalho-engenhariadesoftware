class ObserverProfessor implements Observer {
    private String nomeObservador;
    private String nomeLivro;
    private int codigoLivro;

    public ObserverProfessor(String nomeObservador, String nomeLivro, int codigoLivro) {
        this.nomeLivro = nomeLivro;
        this.nomeObservador = nomeObservador;
        this.codigoLivro = codigoLivro;
    }

    public void update(int codigoLivro) {
        if (this.codigoLivro == codigoLivro) {
            GerenciadorIO.getInstance().PrintNotificacaoProfessor(nomeObservador, nomeLivro);
        }
    }

}
