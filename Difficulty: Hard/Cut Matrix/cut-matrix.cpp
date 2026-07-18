#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9+7;

class Solution {
public:
    int findWays(vector<vector<int>>& matrix, int k) {
        int n = matrix.size(), m = matrix[0].size();
        vector<vector<long long>> pre(n+1, vector<long long>(m+1,0));
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                pre[i+1][j+1]=pre[i][j+1]+pre[i+1][j]-pre[i][j]+matrix[i][j];

        auto sumRegion=[&](int r1,int c1,int r2,int c2)->long long{
            return pre[r2][c2]-pre[r1][c2]-pre[r2][c1]+pre[r1][c1];
        };

        vector<vector<long long>> dpPrev(n+1, vector<long long>(m+1,0));
        for(int top=0;top<n;top++)
            for(int left=0;left<m;left++)
                dpPrev[top][left] = (sumRegion(top,left,n,m) > 0) ? 1 : 0;

        if(k==1) return (int)dpPrev[0][0];

        vector<vector<long long>> dpCur(n+1, vector<long long>(m+1,0));

        for(int kk=2; kk<=k; kk++){
            // For fixed left, as top decreases, horizontal-cut sum over r needs
            // suffix sums of dpPrev[r][left] for r where region(top,left,r,m) has a 1.
            // Precompute, for each left, suffix sum array of dpPrev[r][left] over r.
            vector<vector<long long>> suffH(n+2, vector<long long>(m,0));
            for(int left=0; left<m; left++){
                for(int r=n; r>=1; r--){
                    suffH[r][left] = (suffH[r+1][left] + dpPrev[r][left]) % MOD;
                }
            }
            vector<vector<long long>> suffV(n, vector<long long>(m+2,0));
            for(int top=0; top<n; top++){
                for(int c=m; c>=1; c--){
                    suffV[top][c] = (suffV[top][c+1] + dpPrev[top][c]) % MOD;
                }
            }

            for(int top=n-1; top>=0; top--){
                for(int left=m-1; left>=0; left--){
                    long long res=0;

                    // find smallest r > top such that sumRegion(top,left,r,m) > 0
                    // binary search since sumRegion is monotonic non-decreasing in r
                    int lo=top+1, hi=n, rStart=n;
                    while(lo<=hi-1 || lo<hi){
                        if(lo>=n) break;
                        int mid=(lo+hi)/2;
                        if(mid>=n) { hi=mid; break; }
                        if(sumRegion(top,left,mid,m) > 0){ rStart=mid; hi=mid; }
                        else lo=mid+1;
                        if(lo>=hi) break;
                    }
                    // simpler correct binary search:
                    {
                        int l=top+1, r=n, ans=n;
                        while(l<=r-1){
                            int mid=l+(r-l)/2;
                            if(sumRegion(top,left,mid,m)>0){ ans=mid; r=mid; }
                            else l=mid+1;
                        }
                        rStart=ans;
                    }
                    if(rStart<n) res += suffH[rStart][left];

                    {
                        int l=left+1, r=m, ans=m;
                        while(l<=r-1){
                            int mid=l+(r-l)/2;
                            if(sumRegion(top,left,n,mid)>0){ ans=mid; r=mid; }
                            else l=mid+1;
                        }
                        if(ans<m) res += suffV[top][ans];
                    }

                    dpCur[top][left] = res % MOD;
                }
            }
            swap(dpPrev, dpCur);
        }

        return (int)dpPrev[0][0];
    }
};