import java.util.Map;
import java.util.List;

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

    public void PrintReserva(String tipoMensagem, Usuario usuario, Livro livro) {
        switch (tipoMensagem) {
            case "UsuarioNull": 
                System.out.println("O usuário não existe.");
                break;
            case "LivroNull":
                System.out.println("O livro não existe.");
                break;
            case "ExemplarNaoDisponivel":
                System.out.println("Um exemplar não está disponível.");
                break;
            case "MuitasReservas":
                System.out.println("O usuário" + usuario.getQuantidadeReservas() 
                        + "já possui três reservas, a quantidade máxima.");
                break;

            case "Sucesso":
                System.out.println("Livro \"" + livro.getTitulo() + 
                " reservado para " + usuario.getNome());
                break;
            default:
                System.out.println("Erro desconhecido.");
        }

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
            case "ExemplarNaoDisponivel":
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
                System.out.println("Título do livro: " + livro.getTitulo() + 
                        "\nQuantidade de reservas:" + livro.getQuantidadeReservas()
                        + "Usuários que realizaram reservas:");
                for (Exemplar reserva : livro.getReservas()) {
                    Usuario usuarioReserva = reserva.getUsuarioReserva();
                    if (usuarioReserva != null) {
                        System.out.println(" - " + usuarioReserva.getNome());
                    }
                } 
                break;
            case "SemReservas":
                System.out.println("Não há reservas para o livro " + livro.getTitulo());
            break;
            default:
                System.out.println("Erro desconhecido.");
        }

    }

    public void PrintConsultaExemplares(Usuario usuario, Livro livro) {
        System.out.println("Exemplares:");
        for (Exemplar exemplar : livro.getExemplares()) {
            System.out.println("Código do Exemplar: " + exemplar.getCodigoExemplar());
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

    public void PrintLivrosReservados(List<Reserva> livrosReservados) {
    if (livrosReservados.isEmpty()) {
        System.out.println("Nenhum livro reservado.");
    } else {
        System.out.println("Livros reservados:");
        for (Reserva reserva : livrosReservados) {
            Livro livro = SistemaBiblioteca.getInstance().getLivroByCodigo(reserva.getCodigoLivro());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Data Reservada: " + reserva.getDataSolicitacao() + "\n");
        }
    }
}

    public void PrintLivrosEmprestados(List<Emprestimo> livrosEmprestados) {
        if (livrosEmprestados.isEmpty()) {
            System.out.println("Nenhum livro emprestado.");
        } else {
            System.out.println("Livros emprestados:");
            for (Emprestimo emprestimo : livrosEmprestados) {
                Livro livro = SistemaBiblioteca.getInstance().getLivroByCodigo(emprestimo.getCodigoLivro());
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
                if (emprestimo.isFinalizado()) {
                    System.out.println("Data que fora relizada a devolução: " + emprestimo.getDataDevolucao());
                } else {
                    System.out.println("Data Prevista para devolução: " + emprestimo.getDataDevolucao());
                }
            }
        }
    }

}
