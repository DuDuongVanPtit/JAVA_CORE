package day1BasicAssignment;

public class Bai8 {
    public static boolean tn(int n){
        StringBuilder sb = new StringBuilder(n + "");
        String s = n + "";
        if(s.equals(sb.reverse().toString())) return true;
        return false;
    }
    public static int sum(int n){
        int s = 0;
        while(n != 0){
            s += n % 10;
            n /= 10;
        }
        return s;
    }
    public static void main(String[] args) {
        // ý a
        for(int i = (int)Math.pow(10, 5) + 1; i <= (int)Math.pow(10, 6); i+= 2){
            if(tn(i)) System.out.print(i + " ");
        }
        System.out.println();
        //ý b
        for(int i = (int)Math.pow(10, 5) + 1; i <= (int)Math.pow(10, 6); i+= 2){
            if(tn(i) && sum(i) % 10 == 0) System.out.print(i + " ");
        }
    }
}
