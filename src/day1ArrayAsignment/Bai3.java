package day1ArrayAsignment;

import java.util.Scanner;

public class Bai3 {
    public static void count(int[] array) {
         int[] cnt = new int[100001];
         int max = 0;
         for(int x : array){
             cnt[x]++;
         }
         for(int i = 0; i <= 100000; i++){
             if(cnt[i] != 0){
                 System.out.println(i + " " + cnt[i]);
                 max = Math.max(max, cnt[i]);
             }
         }
        System.out.println(max);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]  = scanner.nextInt();
        }
        count(arr);
    }
}
