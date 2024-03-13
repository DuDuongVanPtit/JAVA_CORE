package day1ArrayAsignment;

import java.util.Arrays;
import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];
        inputMatrix(scanner, matrix);

        printMatrix(matrix);
        scanner.close();
    }
    public static void inputMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    public static void printMatrix(int[][] matrix) {
        int[] flattenedMatrix = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                flattenedMatrix[index++] = matrix[i][j];
            }
        }
        Arrays.sort(flattenedMatrix);
        for (int i = 0; i < flattenedMatrix.length; i++) {
            System.out.print(flattenedMatrix[i] + " ");
            if ((i + 1) % matrix[0].length == 0) {
                System.out.println();
            }
        }
    }
}
