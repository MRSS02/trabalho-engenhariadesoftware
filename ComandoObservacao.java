class ComandoObservacao implements Comando {
    public void executar(String[] args) {
       GerenciadorObserver.getInstance().inscrever(Fabrica.cadastrarObservadorProfessor(Integer.parseInt(args[1]), Integer.parseInt(args[1])));
       GerenciadorIO.getInstance().PrintAdicionadoObservador("Sucesso");
    }
}




