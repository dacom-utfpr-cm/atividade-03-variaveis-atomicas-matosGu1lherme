package Atividade_4;

public class WorkerThread extends Thread {
    private final String nome;

    public WorkerThread(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int valorAtual = ContadorThreadLocal.incrementar();
            System.out.println(nome + " - Contador: " + valorAtual);
        }
        System.out.println(nome + " - Contador Final: " + ContadorThreadLocal.getContador());
    }
}
