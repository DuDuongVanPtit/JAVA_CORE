package day1ArrayAsignment;

import java.util.Arrays;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        Arrays.sort(a);
        int index = findInsertionIndex(a, x);
        int[] result = insertValue(a, x, index);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        scanner.close();
    }
    public static int findInsertionIndex(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < x) {
                left = mid + 1;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
    public static int[] insertValue(int[] a, int x, int index) {
        int n = a.length;
        int[] result = new int[n + 1];
        for (int i = 0; i < index; i++) {
            result[i] = a[i];
        }
        result[index] = x;
        for (int i = index; i < n; i++) {
            result[i + 1] = a[i];
        }
        return result;
    }
}
