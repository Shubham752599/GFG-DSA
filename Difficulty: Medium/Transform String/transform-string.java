class Solution {
      int transform(String s1, String s2) {
          if (s1.length() != s2.length()) {
              return -1;
          }
          int[] freq = new int[256];
          for (int i = 0; i < s1.length(); i++) {
              freq[s1.charAt(i)]++;
              freq[s2.charAt(i)]--;
          }

          for (int x : freq) {
              if (x != 0) {
                  return -1;
              }
          }
          int i = s1.length() - 1;
          int j = s2.length() - 1;
          while (i >= 0 && j >= 0) {
              if (s1.charAt(i) == s2.charAt(j)) {
                  j--;
              }
              i--;
          }
          return j + 1;
      }
  }