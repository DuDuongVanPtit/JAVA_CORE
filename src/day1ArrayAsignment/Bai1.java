package day1ArrayAsignment;

import java.util.Scanner;

public class Bai1 {
    public static String checkSymmetricArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] != array[right]) {
                return "mang khong doi xung";
            }
            left++;
            right--;
        }
        return "mang doi xung";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]  = scanner.nextInt();
        }
        System.out.println(checkSymmetricArray(arr));
    }
}
