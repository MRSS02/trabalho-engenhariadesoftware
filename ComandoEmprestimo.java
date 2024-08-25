class ComandoEmprestimo implements Comando {
    public void executar(String[] args) {
        // Implementar lógica de reserva
        GerenciadorIO.getInstance().PrintEmprestimo();
    }
}



