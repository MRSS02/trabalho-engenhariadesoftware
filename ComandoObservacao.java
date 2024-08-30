class ComandoObservacao implements Comando {
    public void executar(String[] args) {
       GerenciadorObserver.inscrever(Fabrica.cadastrarObservadorProfessor(args[1], args[2]));
       GerenciadorIO.getInstance().PrintAdicionadoObservador("Sucesso");
    }
}




