package lso3;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = 49;
        System.out.println("Розрахунок " + n + " числа Фібоначчі");
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> fibonacci(n));
        System.out.println("Очікування результату...");
        int result = f.get();
        System.out.println("Результат: " + result);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}