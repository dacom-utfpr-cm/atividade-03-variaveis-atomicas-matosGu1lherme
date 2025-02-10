package Atividade_2;

public class Main {
    public static void main(String[] args) {
        LockFreeStack<Integer> stack = new LockFreeStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // imprimir 3
        System.out.println(stack.pop()); // imprimir 2
        System.out.println(stack.pop()); // imprimir 1
        System.out.println(stack.pop()); // null
    }
}
