package Atividade_2;
import java.util.concurrent.atomic.AtomicReference;

public class LockFreeStack<T> {
    private final AtomicReference<Node<T>> top = new AtomicReference<>(null);

    //Adiciona um elemento ao topo da pilha
    public void push(T value) {
        Node<T> newNode;
        Node<T> currentTop;
        do {
            currentTop = top.get(); //Pega o topo atual
            newNode = new Node<>(value, currentTop); //Cria um novo nó com o antigo atual como next
        } while (!top.compareAndSet(currentTop, newNode));  //Se o valor em top for igual a currentTop adiciona um novo nó, garantindo que "confiabilidade" da troca
    }

    //Remove elemento do topo da pilha
    public T pop() {
        Node<T> currentTop;
        Node<T> newTop;
        do {
            currentTop = top.get(); //Armezena o top atual
            if (currentTop == null) {
                return null; // Pilha vazia
            }
            newTop = currentTop.next; //Novo topo vai ser o proximo do topo
        } while (!top.compareAndSet(currentTop, newTop)); //Atualiza os valor com compareAndSet, passando o next como novo topo
        return currentTop.value;
    }

    public boolean isEmpty() {
        return top.get() == null;
    }
}