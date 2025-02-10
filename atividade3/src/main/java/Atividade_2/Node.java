package Atividade_2;

public class Node<T> {
    final T value;          //Valor do nó
    final Node<T> next;     //Caminho para o nó

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}