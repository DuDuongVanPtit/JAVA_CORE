package day1BasicAssignment;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                if(n / i == i){
                    System.out.println(i + " ");
                    cnt += 1;
                }
                else{
                    System.out.print(i + " " + n / i + " ");
                    cnt += 2;
                }
            }
        }
        System.out.println("\nso luong uoc so cua " + n + " la: " + cnt);
    }
}
//16: 1, 2, 4, 8, 16