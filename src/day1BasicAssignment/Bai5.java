package day1BasicAssignment;

import java.util.Scanner;

public class Bai5 {
    public static int sum(int n){
        int s = 0;
        while(n != 0){
            s += n % 10;
            n /= 10;
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(sum(n));
    }
}
