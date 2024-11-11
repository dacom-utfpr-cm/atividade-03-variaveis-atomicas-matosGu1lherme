package Atividade_4;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new WorkerThread("Thread-1");
        Thread thread2 = new WorkerThread("Thread-2");
        Thread thread3 = new WorkerThread("Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
