package day1ArrayAsignment;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        int p = scanner.nextInt();
        int[] result = insertArray(a, b, p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        scanner.close();
    }
    public static int[] insertArray(int[] a, int[] b, int p) {
        int n = a.length;
        int m = b.length;
        int[] result = new int[n + m];
        for (int i = 0; i < p; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < m; i++) {
            result[p + i] = b[i];
        }
        for (int i = p; i < n; i++) {
            result[i + m] = a[i];
        }
        return result;
    }
}
