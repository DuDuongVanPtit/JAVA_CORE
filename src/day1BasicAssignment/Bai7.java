package day1BasicAssignment;

public class Bai7 {
    static boolean[] isPrime = new boolean[10000000];
    public static void sieve(int N) {
        for(int i = 0; i <= N;++i) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= N; ++i) {
            if(isPrime[i]) {
                for(int j = i * i; j <= N; j += i)
                    isPrime[j] = false;
            }
        }
    }
    public static void main(String[] args) {
        sieve(1000000);
        for(int i = (int)Math.pow(10, 5) + 1; i <= (int)Math.pow(10, 6); i+= 2){
            if(isPrime[i]) System.out.print(i + " ");
        }
    }
}
