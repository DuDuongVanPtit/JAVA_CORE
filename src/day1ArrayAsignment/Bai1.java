package day1ArrayAsignment;

import java.util.Scanner;

public class Bai1 {
    public static String checkSymmetricArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] != array[right]) {
                return "Mảng nhập vào không đối xứng!";
            }
            left++;
            right--;
        }
        return "Mảng nhập vào đối xứng";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử có trong mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i]  = scanner.nextInt();
        }
        System.out.println(checkSymmetricArray(arr));
    }
}
