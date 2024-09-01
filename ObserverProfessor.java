class ObserverProfessor implements Observer {
    private String nomeObservador;
    private String tituloLivro;
    private int codigoLivro;
    private int codigoUsuario;
    private int vezesNotificado; 

    public ObserverProfessor(int codigoUsuario, int codigoLivro) {
        SistemaBiblioteca sistemaBiblioteca = SistemaBiblioteca.getInstance();
        this.tituloLivro = sistemaBiblioteca.getLivroByCodigo(codigoLivro).getTitulo();
        this.nomeObservador = sistemaBiblioteca.getUsuarioByCodigo(codigoUsuario).getNome();
        this.codigoLivro = codigoLivro;
        this.codigoUsuario = codigoUsuario;
        this.vezesNotificado = 0;
    }

    public void update(int codigoLivro) {
            this.vezesNotificado++;
            GerenciadorIO.getInstance().PrintNotificacaoProfessor(nomeObservador, tituloLivro);
    }

    public int getVezesNotificado() {
        return this.vezesNotificado;
    }

    public String getNome() {
        return this.nomeObservador;
    }

    public int getCodigoLivro() {
        return this.codigoLivro;
    }

    public int getCodigoUsuario() {
        return this.codigoUsuario;
    }

}
