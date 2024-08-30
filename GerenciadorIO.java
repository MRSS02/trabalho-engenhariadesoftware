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
    public void PrintEmprestimo(String tipoMensagem) {
        switch (tipoMensagem) {
         case "UsuarioNull": 
         System.out.println("O usuário não existe.");
         break;
         case "LivroNull":
         System.out.println("O livro não existe.");
         break;
         case "ExemplarNull":
         System.out.println("O exemplar não existe.");
         break;
         case "Devedor":
         System.out.println("O usuário deve um empréstimo.");
         break;
         case "Reservado":
         System.out.println("O livro está reservado.");
         break;
         case "Sucesso":
         System.out.println("Sucesso!");
         break;
         default:
         System.out.println("Erro desconhecido.");

        }
         
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
    public void PrintSair() {
        System.out.println("Encerrando programa...");
    }


}
