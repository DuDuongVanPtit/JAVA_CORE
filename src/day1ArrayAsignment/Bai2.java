package day1ArrayAsignment;

import java.util.Arrays;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử có trong mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i]  = scanner.nextInt();
        }
        // TODO: Không dùng sort() của java. viết hàm sort
        Arrays.sort(arr);

        //hàm sắp xếp
        int[] array = new int[n];
        array = sort1(arr, n);

        // TODO: Không dùng toString() để hiển thị arr
        System.out.println(Arrays.toString(arr));

        //Cách hiển thị arr
        System.out.println("Mảng sau khi sắp xếp là: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    private static int[] sort1(int[] array, int n) {
        int tempSort;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (array[i] > array[j]) {
                    tempSort = array[i];
                    array[i] = array[j];
                    array[j] = tempSort;
                }
            }
        }

        return array;
    }
}
