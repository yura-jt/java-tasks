package MatrixRotator;

import java.util.concurrent.ThreadLocalRandom;

public class MatrixRotator {
    public static void main(String[] args) {
        int[][] matrix = getRandomMatrix();
        printMatrix(matrix);

        int[][] rotatedMatrix = rotateCounterClockwise(matrix);
        printMatrix(rotatedMatrix);
    }

    public static int[][] rotateCounterClockwise(int[][] matrix) {
        validateMatrix(matrix);

        int rowLength = matrix.length;
        int[][] result = new int[rowLength][rowLength];
        int newIndex = rowLength;

        for (int i = 0; i < rowLength; i++) {
            newIndex = newIndex - 1;
            for (int j = 0; j < rowLength; j++) {
                result[i][j] = matrix[j][newIndex];
            }
        }
        return result;
    }

    private static int[][] getRandomMatrix() {
        int side = ThreadLocalRandom.current().nextInt(2, 6);
        int[][] matrix = new int[side][side];

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(-99, 100);
            }
        }
        return matrix;
    }

    private static void validateMatrix(int[][] matrix) {
        if (matrix == null || !checkIsMatrixSquare(matrix)) {
            throw new IllegalArgumentException("Input matrix is not valid");
        }
    }

    private static boolean checkIsMatrixSquare(int[][] matrix) {
        int rowLength = matrix.length;

        if (rowLength == 0) {
            return false;
        }

        for (int i = 0; i < rowLength; i++) {
            if (matrix[i] == null) {
                return false;
            }
            int columnLength = matrix[i].length;
            if ((columnLength == 0) | (columnLength != rowLength)) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}