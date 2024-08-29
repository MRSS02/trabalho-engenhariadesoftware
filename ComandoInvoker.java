import java.util.HashMap;
import java.util.Map;

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

    public void executarComando() {
        GerenciadorIO.getInstance().ProcessarComandos(this.comandos);
    }
}
