package Atividade_3;

public class Main {
    public static void main(String[] args) {
        LockFreeQueue<Integer> queue = new LockFreeQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.dequeue()); // null
    }
}

