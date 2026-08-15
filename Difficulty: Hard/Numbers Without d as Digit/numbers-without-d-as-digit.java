class Solution {
     public int countWithout(int n, int d) {
         if (n == 0) return 0;

         String s = String.valueOf(n);
         int len = s.length();

         long ans = 0;
         for (int l = 1; l < len; l++) {
             if (d == 0) {
                 ans += 9L * pow(9, l - 1);
             } else {
                 ans += 8L * pow(9, l - 1);
             }
         }
         for (int i = 0; i < len; i++) {
             int cur = s.charAt(i) - '0';
             int remaining = len - i - 1;

             if (d == 0) {
                 if (i == 0) {
                     int smaller = cur - 1;
                     ans += (long) smaller * pow(9, remaining);
                 } else {
                     int smaller = cur;
                     ans += (long) smaller * pow(9, remaining);
                 }
             } else {
                 int smaller = cur;
                 if (d < cur) {
                     smaller--;
                 }

                 if (i == 0) {
                     smaller--;
                 }

                 if (smaller > 0) {
                     ans += (long) smaller * pow(9, remaining);
                 }
             }
             if (cur == d) {
                 return (int) ans;
             }
         }
         ans++;

         return (int) ans;
     }

     private long pow(long base, int exp) {
         long result = 1;

         while (exp-- > 0) {
             result *= base;
         }

         return result;
     }
 }