package Day4;

import java.util.Arrays;
import java.util.Scanner;

public class Bai6 {
    public static String[] separationString(String s){
        return s.split("\\s+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ans = separationString(scanner.nextLine());
        Arrays.sort(ans);
        for(String x : ans){
            System.out.println(x);
        }
    }
}
