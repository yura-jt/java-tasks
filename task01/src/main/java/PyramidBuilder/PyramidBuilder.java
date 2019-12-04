package PyramidBuilder;

import java.util.concurrent.ThreadLocalRandom;

public class PyramidBuilder {
    public static void main(String[] args) {
        int n = ThreadLocalRandom.current().nextInt(1, 10);

        int[][] pyramid = buildPyramid(n);

        printMatrix(pyramid);
    }

    public static int[][] buildPyramid(int n) {
        validateHeight(n);

        int[][] result = new int[n][(n * 2) - 1];
        int halfX = result[0].length / 2;
        int minIndexY = result.length - 1;
        int step = -1;

        for (int x = 0; x < result[0].length; x++) {
            if (x == halfX) {
                step = 1;
            }
            int number = 1;

            for (int y = minIndexY; minIndexY >= 0 && y < result.length; y++) {
                result[y][x] = number++;
            }
            minIndexY = minIndexY + step;
        }
        return result;
    }

    private static void validateHeight(int n) {
        if (n < 1 || n > 9) {
            throw new IllegalArgumentException("Pyramid height is out of valid range");
        }
    }

    private static void printMatrix(int[][] pyramid) {
        for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[0].length; j++) {
                if (pyramid[i][j] != 0) {
                    System.out.print(pyramid[i][j]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
