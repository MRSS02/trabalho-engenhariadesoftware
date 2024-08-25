import java.util.Map;

public class GerenciadorIO {

    private static GerenciadorIO instance; 

    private GerenciadorIO() {
    
    }

    public static GerenciadorIO getInstance() {
        if (instance == null) {
                instance = new GerenciadorIO();
        }
                return instance;   
    }

    public void ProcessarComandos(Map<String, Comando> comandos) {
        String linhaComando = System.console().readLine();
        String[] partes = linhaComando.split(" ");
        String cmd = partes[0];
        Comando comando = comandos.get(cmd);
        if (comando != null) {
            comando.executar(partes);
        } else {
            System.out.println("Comando não reconhecido.");
        }
    }

    // TODO: Implementar mensagens coerentes
    
    public void PrintReserva() {
         System.out.println("Reserva processada.");
    }
    public void PrintObservacao() {
         System.out.println("Observação processada.");
    }
    public void PrintEmprestimo() {
         System.out.println("Emprestimo processado.");
    }
    public void PrintDevolucao() {
         System.out.println("Devolução processada.");
    }
    public void PrintConsultaUsuario() {
         System.out.println("Consulta processada.");
    }
    public void PrintConsultaLivro() {
         System.out.println("Consulta processada.");
    }
    public void PrintConsultaNotificacao() {
         System.out.println("Consulta processada.");
    }


}
