class ComandoConsultaNotificacoes implements Comando {
    public void executar(String[] args) {
        // Implementar lógica de consulta de notificações
        Observer observador = GerenciadorObserver.getInstance().getObservadorByCodigo(Integer.parseInt(args[1]));
        GerenciadorIO.getInstance().PrintConsultaNotificacao(observador);
    }
}

