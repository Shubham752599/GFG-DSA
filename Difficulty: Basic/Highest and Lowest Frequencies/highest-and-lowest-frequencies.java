class Solution {
    public int findDiff(int[] arr) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int min = arr.length;

        for (int i : freq.keySet()) {
            int count = freq.get(i);

            max = Math.max(max, count);
            min = Math.min(min, count);
        }

        return max - min;
    }
}