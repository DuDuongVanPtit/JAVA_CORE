package day1BasicAssignment;

public class Bai9 {
    public static boolean tn(long n){
        StringBuilder sb = new StringBuilder(n + "");
        String s = n + "";
        while (n != 0){
            long x = n % 10;
            if(x != 0 && x != 6 && x != 8){
                return false;
            }
            n /= 10;
        }
        if(s.equals(sb.reverse().toString())) return true;
        return false;
    }
    public static long sum(long n){
        long s = 0;
        while(n != 0){
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public static void main(String[] args) {
        for(long i = (int)Math.pow(10, 6) + 1; i <= (long)Math.pow(10, 8); i++){
            if(tn(i) && sum(i) % 10 == 0) System.out.print(i + " ");
        }
    }
}
