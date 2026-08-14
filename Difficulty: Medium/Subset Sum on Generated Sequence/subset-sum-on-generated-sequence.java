import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) {
            return true;
        }
        ArrayList<Long> nums = new ArrayList<>();

        long sum = s;
        if (s <= x) {
            nums.add((long) s);
        }
        for (int val : arr) {

            long next = sum + val;

            if (next > x) {
                break;
            }
            nums.add(next);
            sum += next;
        }
        int n = nums.size();
        int mid = n / 2;
        ArrayList<Long> left = new ArrayList<>();
        ArrayList<Long> right = new ArrayList<>();
        generate(nums, 0, mid, 0, left);
        generate(nums, mid, n, 0, right);
        HashSet<Long> set = new HashSet<>(left);
        for (long r : right) {
            long need = (long) x - r;

            if (set.contains(need)) {
                return true;
            }
        }

        return false;
    }

    private void generate(
        ArrayList<Long> nums,
        int start,
        int end,
        long sum,
        ArrayList<Long> result
    ) {

        if (start == end) {
            result.add(sum);
            return;
        }
        generate(nums, start + 1, end, sum, result);

        generate(
            nums,
            start + 1,
            end,
            sum + nums.get(start),
            result
        );
    }
}