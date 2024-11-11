package Atividade_4;

public class ContadorThreadLocal {
    private static final ThreadLocal<Integer> contador = ThreadLocal.withInitial(() -> 0);

    public static int incrementar() {
        contador.set(contador.get() + 1);
        return contador.get();
    }

    public static int getContador() {
        return contador.get();
    }
}
