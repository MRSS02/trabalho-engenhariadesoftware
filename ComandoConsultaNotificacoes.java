class ComandoConsultaNotificacoes implements Comando {
    public void executar(String[] args) {
        // Implementar lógica de consulta de notificações
        GerenciadorIO.getInstance().PrintConsultaNotificacao();
    }
}

