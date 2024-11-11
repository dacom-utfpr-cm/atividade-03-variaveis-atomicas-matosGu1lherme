package Atividade_2;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizer {
    private volatile PrimeFactorsCache cache;

    public PrimeFactorizer(PrimeFactorsCache cache) {
        this.cache = cache;
    }

    public List<Integer> calculatePrimeFactors(int number) {
        List<Integer> cachedFactors = cache.getPrimeFactors(number);
        if (cachedFactors != null) {
            return cachedFactors;
        }

        List<Integer> factors = new ArrayList<>();
        int n = number;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }

        cache.storePrimeFactors(number, factors);
        return factors;
    }
}
