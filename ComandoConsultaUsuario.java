class ComandoConsultaUsuario implements Comando {
    @Override
    public void executar(String[] args) {
        // Implementar lógica de consulta de usuário
        GerenciadorIO.getInstance().PrintConsultaUsuario();
    }
}
