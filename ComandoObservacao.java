class ComandoObservacao implements Comando {
    public void executar(String[] args) {
       SistemaBiblioteca biblioteca = SistemaBiblioteca.getInstance();
       GerenciadorObserver.getInstance().inscrever(Fabrica.cadastrarObservadorProfessor(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
       Usuario usuario = biblioteca.getUsuarioByCodigo(Integer.parseInt(args[1]));
       Livro livro = biblioteca.getLivroByCodigo(Integer.parseInt(args[2]));
       GerenciadorIO.getInstance().PrintAdicionadoObservador("Sucesso", usuario, livro);
    }
}




