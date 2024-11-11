package Atividade_2;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PrimeFactorsCache cache = new PrimeFactorsCache();
        PrimeFactorizer factorizer = new PrimeFactorizer(cache);

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                int number = random.nextInt(100) + 2;
                System.out.println(Thread.currentThread().getName() + " calculando fatores primos de " + number);
                System.out.println("Fatores primos de " + number + ": " + factorizer.calculatePrimeFactors(number));
            });
        }

        executor.shutdown();
    }
}
