class Solution {
public:
    long long mergeCount(vector<long long> &pre, int left, int right, int l, int r) {
        if (right - left <= 1)
            return 0;
        int mid = (left + right) / 2;
        long long cnt = mergeCount(pre, left, mid, l, r) +
                        mergeCount(pre, mid, right, l, r);
        int low = mid, high = mid;
        for (int i = left; i < mid; i++) {
            while (low < right && pre[low] - pre[i] < l)
                low++;
            while (high < right && pre[high] - pre[i] <= r)
                high++;
            cnt += (high - low);
        }
        inplace_merge(pre.begin() + left,
                      pre.begin() + mid,
                      pre.begin() + right);
        return cnt;
    }
    int countSubarray(vector<int>& arr, int l, int r) {
        int n = arr.size();
        vector<long long> prefix(n + 1, 0);
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + arr[i];
        return (int)mergeCount(prefix, 0, n + 1, l, r);
    }
};