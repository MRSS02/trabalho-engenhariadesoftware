public class ComandoInvoker {
    private Map<String, Comando> comandos = new HashMap<>();

    public ComandoInvoker() {
        comandos.put("emp", new ComandoEmprestimo());
        comandos.put("dev", new ComandoDevolucao());
        comandos.put("res", new ComandoReserva());
        comandos.put("obs", new ComandoObservacao());
        comandos.put("liv", new ComandoConsultaLivro());
        comandos.put("usu", new ComandoConsultaUsuario());
        comandos.put("ntf", new ComandoConsultaNotificacoes());
        comandos.put("sai", new ComandoSair());
    }

    public void executarComando(String linhaComando) {
        String[] partes = linhaComando.split(" ");
        String cmd = partes[0];
        Comando comando = comandos.get(cmd);
        if (comando != null) {
            comando.executar(partes);
        } else {
            System.out.println("Comando nÃ£o reconhecido.");
        }
    }
}
