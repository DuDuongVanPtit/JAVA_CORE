package day1ArrayAsignment;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        inputMatrix(scanner, matrix);

        int dcc = sumDcc(matrix);
        int dcp = sumDcp(matrix);

        System.out.println(dcc);
        System.out.println(dcp);

        scanner.close();
    }
    public static void inputMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    //tổng các phần tử trên đường chéo chính của ma trận
    public static int sumDcc(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    //tổng các phần tử trên đường chéo phụ của ma trận
    public static int sumDcp(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }
}
