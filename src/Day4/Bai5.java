package Day4;

import java.util.Scanner;

public class Bai5 {
    public static String convertName(String s){
        StringBuilder result = new StringBuilder();
        String[] words = s.split("\\s+");
        result.append(words[words.length - 1] + " ");
        result.append(words[0] + " ");
        for(int i = 1; i < words.length -1; i++){
            result.append(words[i] + " ");
        }
        return result.toString().trim();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(convertName(scanner.nextLine()));
    }
}
