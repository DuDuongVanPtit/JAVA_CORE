package day1ArrayAsignment;

import java.util.Scanner;

public class Bai3 {
    public static void count(int[] array) {
        //TODO: đề bài ko giới hạn ko nên fix cứng giá trị
         int[] cnt = new int[100001];
         int max = 0;
         for(int x : array){
             cnt[x]++;
         }
        //TODO: đề bài ko giới hạn ko nên fix cứng giá trị
         for(int i = 0; i <= 100000; i++){
             if(cnt[i] != 0){
                 System.out.println(i + " " + cnt[i]);
                 //TODO: viết hàm kiểm tra số phần tử xuất hiện nhiều nhất trong mảng
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
