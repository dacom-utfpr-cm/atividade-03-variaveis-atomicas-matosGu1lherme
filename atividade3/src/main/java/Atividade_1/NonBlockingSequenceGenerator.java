package Atividade_1;
import java.util.concurrent.atomic.AtomicLong;

public class NonBlockingSequenceGenerator {
    private final AtomicLong sequence;

    public NonBlockingSequenceGenerator(long initialValue) {
        this.sequence = new AtomicLong(initialValue);
    }

    public long getNextSequence() {
        long current;
        long next;
        do {
            current = sequence.get();
            next = current + 1;
        } while (!sequence.compareAndSet(current, next));
        return next;
    }
}
