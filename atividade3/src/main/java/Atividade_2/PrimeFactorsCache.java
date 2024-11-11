package Atividade_2;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PrimeFactorsCache {
    private final Map<Integer, List<Integer>> cache = new ConcurrentHashMap<>();

    public List<Integer> getPrimeFactors(int number) {
        return cache.get(number);
    }

    public void storePrimeFactors(int number, List<Integer> factors) {
        cache.putIfAbsent(number, Collections.unmodifiableList(factors));
    }
}
