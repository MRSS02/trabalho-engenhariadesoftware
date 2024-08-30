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
         System.out.println("Um exemplar não está disponível.");
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
    public void PrintDevolucao(String tipoMensagem) {
         switch (tipoMensagem) {
         case "UsuarioNull": 
         System.out.println("O usuário não existe.");
         break;
         case "LivroNull":
         System.out.println("O livro não existe.");
         break;
         case "Sucesso":
         System.out.println("Sucesso!");
         break;
         default:
         System.out.println("Erro desconhecido.");

        }
    }

    public void PrintConsultaUsuario(String tipoMensagem) {
        switch (tipoMensagem) {
        case "UsuarioNull": 
         System.out.println("O usuário não existe.");
         break;
        case "Sucesso":        
         System.out.println("Consulta processada.");
         break;
        default:
         System.out.println("Erro desconhecido.");

        }
    }

    public void PrintAdicionadoObservador(String tipoMensagem) {
        switch (tipoMensagem) {
        case "Sucesso":        
             System.out.println("Observador adicionado.");
         break;
        default:
         System.out.println("Erro desconhecido.");

        }
    }


    public void PrintConsultaLivro(String tipoMensagem) {
        switch (tipoMensagem) {
         case "LivroNull":
         System.out.println("O livro não existe.");
         break;
         case "Sucesso":
         System.out.println("Sucesso!");
         break;
         default:
         System.out.println("Erro desconhecido.");
        }
         
    }
    public void PrintConsultaNotificacao() {
        System.out.println("Consulta processada.");
    }
    public void PrintSair() {
        System.out.println("Encerrando programa...");
    }
    public void PrintNotificacaoProfessor(String nomeObservador, String nomeLivro) {
        System.out.println("Professor " + nomeObservador + ", o livro" + nomeLivro + " foi reservado mais de uma vez simultaneamente");

    }


}
