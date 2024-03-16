package day1ArrayAsignment;

import java.util.Scanner;

public class Bai4 {
    //TODO: đề bài ko giới hạn ko nên fix cứng giá trị
    static boolean[] isPrime = new boolean[10000001];

    //Các hàm viết cách nhau ra để code trông clear hơn
    //TODO: đề bài ko giới hạn ko nên fix cứng giá trị
    public static void sieve() {
        for(int i = 0; i <= 10000000;++i) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= 10000000; ++i) {
            if(isPrime[i]) {
                for(int j = i * i; j <= 10000000; j += i)
                    isPrime[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        sieve();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]  = scanner.nextInt();
        }
        int x = scanner.nextInt();
        int min = 10000000;
        int index = -1;
        for(int i = 0; i <= n; i++){
            if(isPrime[arr[i]]){
                //TODO: Có thể dùng cách khác để lấy giá trị tuyệt đối
//                int number = -5;
//                int absoluteValue = number >= 0 ? number : -number;
//                System.out.println("Giá trị tuyệt đối của số " + number + " là " + absoluteValue);

                if(min > Math.abs(arr[i] - x)){
                    min = Math.abs(arr[i] - x);
                    index = i;
                }
            }
        }
        System.out.println(index);
    }
}
