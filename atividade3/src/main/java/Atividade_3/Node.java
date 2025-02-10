package Atividade_3;
import java.util.concurrent.atomic.AtomicReference;

public class Node<T> {
    final T value;
    final AtomicReference<Node<T>> next;

    public Node(T value) {
        this.value = value;
        this.next = new AtomicReference<>(null);
    }
}