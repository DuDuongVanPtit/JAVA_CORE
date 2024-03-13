package day1BasicAssignment;

public class Bai10 {
    static boolean[] isPrime = new boolean[10000001];
    public static void sieve() {
        for(int i = 0; i <= 10000000;++i) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= 10000000; ++i) {
            if(isPrime[i]) {
                for(int j = i * i; j <= 10000000; j += i)
                    isPrime[j] = false;
            }
        }
    }
    public static boolean check(int n){
        int s = 0;
        int dao = 0;
        while(n != 0){
            if(!isPrime[n % 10]) return false;
            dao = dao * 10 + n % 10;
            n /= 10;
        }
        if(!isPrime[dao]) return false;
        return true;
    }
    public static void main(String[] args) {
        sieve();
        for(int i = (int)Math.pow(10, 6); i < (int)Math.pow(10, 7); i++){
            if(isPrime[i] && check(i)) System.out.print(i + " ");
        }
    }
}
