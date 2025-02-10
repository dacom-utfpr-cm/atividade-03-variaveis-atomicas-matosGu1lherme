package Atividade_3;
import java.util.concurrent.atomic.AtomicReference;

public class LockFreeQueue<T> {
    private final AtomicReference<Node<T>> head;    //Aponta para o primeiro elemento
    private final AtomicReference<Node<T>> tail;    //Aponta para o ultimo elemento

    public LockFreeQueue() {
        Node<T> dummy = new Node<>(null);
        head = new AtomicReference<>(dummy);
        tail = new AtomicReference<>(dummy);
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);     //Cria novo nó com o valor recebido
        Node<T> currentTail;

        //Roda o loop até conseguir realizar a inserção
        while (true) {
            currentTail = tail.get();
            Node<T> next = currentTail.next.get(); //Pegando o nó atual
            if (currentTail == tail.get()) {    //Verifica se tail é valido
                if (next == null) { //Verifica se é o ultimo elemento
                    if (currentTail.next.compareAndSet(null, newNode)) {    //Faz o nó apontar para novo topo (Atualiza o next do currentTail com o novo nó)
                        tail.compareAndSet(currentTail, newNode);   //Atualiza o tail com o novo nó inserido
                        return;
                    }
                } else {
                    tail.compareAndSet(currentTail, next); //Se next for difente de Null atualiza o tail para o proximo nó
                }
            }
        }
    }

    public T dequeue() {
        Node<T> currentHead;

        while (true) {
            currentHead = head.get();
            Node<T> currentTail = tail.get();
            Node<T> next = currentHead.next.get();
            if (currentHead == head.get()) {    //Verifica se head é valido
                if (currentHead == currentTail) {   //Pode ser que a fila esteja vazia
                    if (next == null) {
                        return null; // Fila vazia
                    }
                    tail.compareAndSet(currentTail, next);  //Ajusta tail
                } else {
                    if (head.compareAndSet(currentHead, next)) { //Joga o head para o proxima elemento
                        return next.value;
                    }
                }
            }
        }
    }

    public boolean isEmpty() {
        return head.get().next.get() == null;
    }
}