import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    private static final int arr_Len = 10000;

    public static void main(String[] args) {
        int[] in1 = gen_Array();
        int[] in2 = gen_Array();
        int[] result = new int[arr_Len];


        long time1 = System.currentTimeMillis();
        for (int i = 0; i < arr_Len; i++) {
            result[i] = mult(in1[i], in2[i]);
        }
        long syncTime = System.currentTimeMillis() - time1;
        System.out.printf("Sync: %d ms\n", syncTime);


        long time2 = System.currentTimeMillis();
        IntStream.range(0, arr_Len).parallel().forEach(i -> result[i] = mult(in1[i], in2[i]));
        long parallelTime = System.currentTimeMillis() - time2;
        System.out.printf("Parallel stream: %d ms\n", parallelTime);
    }

    private static int[] gen_Array() {
        Random random = new Random();
        int[] array = new int[arr_Len];
        for (int i = 0; i < arr_Len; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    private static int mult(int num1, int num2) {
        int sleep = 0;
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return num1 * num2;
    }
}