package day1ArrayAsignment;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] A = new int[m][n];

        inputMatrix(scanner, A);
        int k = scanner.nextInt();
        int[][] B = new int[n][k];

        inputMatrix(scanner, B);
        int[][] result = multiplyMatrices(A, B);

        printMatrix(result);
        scanner.close();
    }
    public static void inputMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;

        int[][] result = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    result[i][j] += A[i][l] * B[l][j];
                }
            }
        }

        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
