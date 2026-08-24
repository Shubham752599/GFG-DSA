class Solution {
     static final long MOD = 1000000007L;

     public int prefixStrings(int n) {
         int size = 2 * n;

         long[] fact = new long[size + 1];
         fact[0] = 1;

         for (int i = 1; i <= size; i++) {
             fact[i] = (fact[i - 1] * i) % MOD;
         }
         long numerator = fact[2 * n];
         long denominator = (fact[n] * fact[n]) % MOD;

         long inverseDenominator = power(denominator, MOD - 2);

         long combination = (numerator * inverseDenominator) % MOD;

         long answer = (combination * power(n + 1, MOD - 2)) % MOD;

         return (int) answer;
     }

     private long power(long a, long b) {
         long result = 1;

         while (b > 0) {
             if ((b & 1) == 1) {
                 result = (result * a) % MOD;
             }

             a = (a * a) % MOD;
             b >>= 1;
         }

         return result;
     }
 }