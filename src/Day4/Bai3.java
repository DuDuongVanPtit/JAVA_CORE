package Day4;

import java.util.Scanner;

public class Bai3 {
    public static String standardization(String s){
        StringBuilder result = new StringBuilder();
        String[] words = s.split("\\s+");
        for(int i = 0; i < words.length; i++){
            result.append(words[i].substring(0, 1).toUpperCase());
            result.append(words[i].substring(1).toLowerCase() + " ");
        }
        return result.toString().trim();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(standardization(scanner.nextLine()));
    }
}
