package Atividade_1;
import java.util.concurrent.atomic.AtomicLong;

public class NonBlockingSequenceGenerator {
    private final AtomicLong sequence;      //Variavel atomica

    public NonBlockingSequenceGenerator(long initialValue) {
        this.sequence = new AtomicLong(initialValue);
    }

    //Gera o proximo numero da sequencia
    public long getNextSequence() {
        long current;
        long next;

        //Obtem o valor atual e tenta trocar o valor para o next
        //Caso de errado ele recalcula os valores e tenta novemnte
        do {
            current = sequence.get();
            next = current + 1;
        } while (!sequence.compareAndSet(current, next));
        return next;
    }
}
