package day1BasicAssignment;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Nhập số 1 để làm ý a.\nNhập số 2 để làm ý a.\nNhập các giá trị khác để thoát.\n");
            System.out.print("Nhập giá trị để lựa chọn phương án: ");
            int o = scanner.nextInt();
            if(o == 1){
                System.out.print("Nhập N từ bàn phím: ");
                int n = scanner.nextInt();
                int sum = 0;
                if(n % 2 == 0){
                    for(int i = 2; i <= n; i+= 2){
                        sum += i;
                    }
                } else{
                    for(int i = 1; i <= n; i += 2){
                        sum += i;
                    }
                }
                System.out.println("Giá trị S nhận được: " + sum + "\n");
            } else if(o == 2){
                double sum = 0.0;
                System.out.print("Nhập N từ bàn phím: ");
                int n = scanner.nextInt();
                for(int i = 1; i <= n; i++){
                    sum += 1.0 / i;
                }

                //TODO: làm tròn chữ số thập phân hàng trăm
                System.out.println("Giá trị S nhận được: " + sum + "\n");
            } else{
                return;
            }
        }

    }
}
