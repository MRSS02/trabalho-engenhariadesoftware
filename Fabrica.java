public class Fabrica {
		
    public static Usuario cadastrarProfessor(int codigo, String nome) {
        return new Professor(codigo, nome); 
    }
    public static Usuario cadastrarAlunoGraduacao(int codigo, String nome) {
        return new AlunoGraduacao(codigo, nome); 
    }
    public static Usuario cadastrarAlunoPos(int codigo, String nome) {
        return new AlunoPos(codigo, nome); 
    }
    public static Exemplar cadastrarExemplar(int codigo, int codigoExemplar, boolean isDisponivel) {
        return new Exemplar(codigo, codigoExemplar, isDisponivel); 
    }
    public static Livro cadastrarLivro(int codigo, String titulo, String editora, String autores, String edicao, int anoPublicacao) {
        return new Livro(codigo, titulo, editora, autores, edicao, anoPublicacao); 
    }
    public static Observer cadastrarObservadorProfessor(int codigoProfessor, int codigoLivro) {
        return new ObserverProfessor(codigoProfessor, codigoLivro); 
    }
    
    
}
