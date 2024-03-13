package day1BasicAssignment;

import java.util.Scanner;

public class Bai3 {
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd(b, a % b);
        }
    }
    public static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }
}
