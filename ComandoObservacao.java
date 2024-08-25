class ComandoObservacao implements Comando {
    public void executar(String[] args) {
        // Implementar lógica de observação
       GerenciadorIO.getInstance().PrintObservacao();
    }
}




