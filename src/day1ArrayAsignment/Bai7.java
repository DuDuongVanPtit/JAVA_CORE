package day1ArrayAsignment;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int maxStartIndex = 0;
        int maxRunLength = 1;
        int currentRunStartIndex = 0;
        int currentRunLength = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] >= a[i - 1]) {
                currentRunLength++;
                if (currentRunLength > maxRunLength) {
                    maxStartIndex = currentRunStartIndex;
                    maxRunLength = currentRunLength;
                }
            } else {
                currentRunStartIndex = i;
                currentRunLength = 1;
            }
        }
        System.out.println(maxStartIndex + " " + maxRunLength);

        scanner.close();
    }
}
