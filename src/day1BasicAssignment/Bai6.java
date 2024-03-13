package day1BasicAssignment;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 2; i <= (int)Math.sqrt(n); ){
            while(n % i == 0){
                System.out.print(i + " ");
                n /= i;
            }
            i++;
        }
        if(n > 1){
            System.out.println(n);
        }
    }
}
