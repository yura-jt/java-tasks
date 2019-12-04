package PerfectNumberFinder;

public class PerfectNumberFinder {
    public static void main(String[] args) {
        long n = 10_000;
        long[] perfectNumbers = getPerfectNumbers(n);
        printResult(perfectNumbers);
    }

    public static long[] getPerfectNumbers(long upperLimit) {
        validateUpperLimit(upperLimit);
        long[] result = new long[100];
        int count = 0;

        for (long i = 1; i <= upperLimit; i++) {
            boolean isPerfect = checkIfNumberIsPerfect(i);
            if (isPerfect) {
                result[count++] = i;
            }
        }
        result = trimArray(result, count);
        return result;
    }

    private static boolean checkIfNumberIsPerfect(long number) {
        long sum = 0;
        for (long i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        return sum == number;
    }

    private static void validateUpperLimit(long n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Upper-bound limit is not positive number");
        }
    }

    private static long[] trimArray(long[] array, int count) {
        long[] result = new long[count];
        for (int i = 0; i < count; i++) {
            result[i] = array[i];
        }
        return result;
    }

    private static void printResult(long[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
