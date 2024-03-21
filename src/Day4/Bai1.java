package Day4;

import java.util.Map;

public class Bai1 {
    public static boolean check(String s){
        StringBuilder reversed = new StringBuilder(s);
        if(s.equals(reversed.reverse().toString())) return true;
        return false;
    }

    public static void main(String[] args) {
        for(int i = 100000; i < 1000000; i++){
            if(check(i + "")){
                System.out.print(i + " ");
            }
        }
    }
}
