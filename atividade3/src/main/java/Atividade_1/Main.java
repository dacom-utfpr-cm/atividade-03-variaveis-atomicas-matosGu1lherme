package Atividade_1;

public class Main {
    public static void main(String[] args) {
        NonBlockingSequenceGenerator generator = new NonBlockingSequenceGenerator(0);

        Runnable tarefa = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Próxima Sequência: " + generator.getNextSequence());
            }
        };

        Thread thread1 = new Thread(tarefa);
        Thread thread2 = new Thread(tarefa);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
