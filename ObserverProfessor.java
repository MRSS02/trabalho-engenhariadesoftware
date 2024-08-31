class ObserverProfessor implements Observer {
    private String nomeObservador;
    private String nomeLivro;
    private int codigoLivro;
    private int vezesNotificado; 

    public ObserverProfessor(String nomeObservador, String nomeLivro, int codigoLivro) {
        this.nomeLivro = nomeLivro;
        this.nomeObservador = nomeObservador;
        this.codigoLivro = codigoLivro;
        this.vezesNotificado = 0;
    }

    public void update(int codigoLivro) {
            this.vezesNotificado++;
            GerenciadorIO.getInstance().PrintNotificacaoProfessor(nomeObservador, nomeLivro);
    }

    public int getCodigoLivro() {
        return this.codigoLivro;
    }

}
