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

    public void PrintReserva(Usuario usuario, Livro livro) {
        System.out.println("Livro \"" + livro.getTitulo() + 
                " reservado para " + usuario.getNome());
    }
    public void PrintObservacao(Usuario usuario, Livro livro) {
        System.out.println("A partr de agora " + usuario.getNome() 
                + " será notificado quando houver múltiplas reservas simultâneas do livro "
                + livro.getTitulo());
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


    public void PrintConsultaLivro(String tipoMensagem, Usuario usuario, Livro livro) {
        switch (tipoMensagem) {
            case "LivroNull":
                System.out.println("O livro não existe.");
                break;
            case "QuantidadeReservas":
                System.out.println("Usuários que realizaram reservas:");
                for (Exemplar reserva : livro.getReservas()) {
                    Usuario usuarioReserva = reserva.getUsuarioReserva();
                    if (usuarioReserva != null) {
                        System.out.println(" - " + usuarioReserva.getNome());
                    }
                } 
                break;
            default:
                System.out.println("Erro desconhecido.");
        }

    }

    public void PrintConsultaExemplares(Usuario usuario, Livro livro) {
        System.out.println("Exemplares:");
        for (Exemplar exemplar : livro.getExemplares()) {
            System.out.println("Código do Exemplar: " + exemplar.getCodigo());
            if (exemplar.isReservado()) {
                System.out.println("Status: Reservado");
                Usuario usuarioReserva = exemplar.getUsuarioReserva();
                if (usuarioReserva != null) {
                    System.out.println("Reservado por: " + usuarioReserva.getNome());
                }
            } else if (!exemplar.isDisponivel()) {
                Usuario usuarioEmprestimo = exemplar.getUsuarioEmprestimo();
                System.out.println("Status: Emprestado");
                System.out.println("Usuário: " + usuarioEmprestimo.getNome());
                System.out.println("Data de Empréstimo: " + exemplar.getDataEmprestimo());
                System.out.println("Data Prevista para Devolução: " 
                        + exemplar.getDataDevolucaoPrevista());
            } else {
                System.out.println("Status: Disponível.");
            }
        }

    }
    public void PrintConsultaNotificacao(Observer observador) {

        System.out.println(observador.getNome() + " foi notificado " 
                + observador.getVezesNotificado() + "vezes."); 

    }
    public void PrintSair() {
        System.out.println("Encerrando programa...");
    }
    public void PrintNotificacaoProfessor(String nomeObservador, String nomeLivro) {
        System.out.println("Professor " + nomeObservador + ", o livro" + 
                nomeLivro + " foi reservado mais de uma vez simultaneamente.");

    }


}
