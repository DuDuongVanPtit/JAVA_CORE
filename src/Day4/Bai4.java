package Day4;

import java.util.Scanner;

public class Bai4 {
    public static void find(String s){
        int index = 0;
        int max = 0;
        String[] words = s.split("\\s+");
        for(int i = 0; i < (words.length); i++){
            if(words[i].length() > max){
                max = words[i].length();
                index = i + 1;//Người códe có thể hiểu bắt đầu duyệt từ O nhưnng người dùng chưa chắc hiểu nên phải +1
            }
        }
        System.out.println(max + " " + index);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        find(scanner.nextLine());
    }
}
