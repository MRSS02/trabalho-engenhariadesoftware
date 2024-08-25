class ComandoDevolucao implements Comando {
    public void executar(String[] args) {
        // Implementar lógica de devolução
        GerenciadorIO.getInstance().PrintDevolucao();
    }
}
