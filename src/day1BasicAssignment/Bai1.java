package day1BasicAssignment;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("nhap 1 de lam y a\nnhap 2 de lam y b\nnhap 3 de thoat");
            int o = scanner.nextInt();
            if(o == 1){
                int n = scanner.nextInt();
                int sum = 0;
                if(n % 2 == 0){
                    for(int i = 2; i <= n; i+= 2){
                        sum += i;
                    }
                }
                else{
                    for(int i = 1; i <= n; i += 2){
                        sum += i;
                    }
                }
                System.out.println(sum);
            }
            else if(o == 2){
                double sum = 0.0;
                int n = scanner.nextInt();
                for(int i = 1; i <= n; i++){
                    sum += 1.0 / i;
                }
                System.out.println(sum);
            }
            else{
                return;
            }
        }

    }
}
