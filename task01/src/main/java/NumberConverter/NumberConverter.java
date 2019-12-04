package NumberConverter;

import java.util.concurrent.ThreadLocalRandom;

public class NumberConverter {
    private final static int BINARY_RADIX = 2;
    private final static int OCTAL_RADIX = 8;
    private final static int HEX_RADIX = 16;

    public static void main(String[] args) {
        int number = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
        printResult(number);

        String binaryFormattedResult = convertToBinary(number);
        String octalFormattedResult = convertToOctal(number);
        String hexFormattedResult = convertToHex(number);

        printResult(binaryFormattedResult);
        printResult(octalFormattedResult);
        printResult(hexFormattedResult);
    }

    public static String convertToBinary(int number) {
        return convertToOtherSystem(number, BINARY_RADIX);
    }

    public static String convertToOctal(int number) {
        return convertToOtherSystem(number, OCTAL_RADIX);
    }

    public static String convertToHex(int number) {
        return convertToOtherSystem(number, HEX_RADIX);
    }

    private static String convertToOtherSystem(int number, int radix) {
        String[] hexLetters = {"A", "B", "C", "D", "E", "F"};

        String result = "";
        while (number > 0) {
            int remainder = number % radix;
            number = number / radix;
            if (radix == 16 && remainder >= 10) {
                result = result + hexLetters[remainder - 10];
            } else {
                result = result + remainder;
            }
        }
        result = reverseString(result);
        return result;
    }

    private static String reverseString(String str) {
        String result = "";
        char[] source = str.toCharArray();
        for (int i = source.length - 1; i >= 0; i--) {
            result = result + source[i];
        }
        return result;
    }

    private static void printResult(String result) {
        System.out.println(result);
    }

    private static void printResult(int result) {
        System.out.println(result);
    }
}
