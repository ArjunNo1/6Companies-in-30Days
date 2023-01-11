package Algos;

public class Sieve {
    public static int prime(int n) {
        boolean primes[] = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == false) {
                count += 1;
                for(int j=2;i*j<n;j++){
                    primes[i*j]=true;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println(prime(n));
    }
}
