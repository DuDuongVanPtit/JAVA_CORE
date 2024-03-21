package Day4;

import java.util.Scanner;

public class Bai2 {
    public static String convert(String s){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                if(i % 2 == 0){
                    result.append(Character.toUpperCase(c));
                }
                else result.append((Character.toLowerCase(c)));
            }
            else result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(convert(s));
    }
}
