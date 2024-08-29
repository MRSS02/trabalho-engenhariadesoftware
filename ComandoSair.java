class ComandoSair implements Comando {
    public void executar(String[] args) {
        GerenciadorIO.getInstance().PrintSair();
        System.exit(0);
    }
}




