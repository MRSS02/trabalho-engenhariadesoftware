class ObserverProfessor implements Observer {
    private int notificacoesRecebidas = 0;

    public void update() {
        notificacoesRecebidas++;
        System.out.println("Professor foi notificado. Total de notificações: " + notificacoesRecebidas);
    }
}
