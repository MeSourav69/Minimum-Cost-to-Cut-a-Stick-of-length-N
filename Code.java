//you Minimum Cost to Cut a Stick of length N
import java.util.*;

class Code {
    public int minCutCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) arr[i + 1] = cuts[i];
        Arrays.sort(arr);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len < m + 2; len++) {
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                int cost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    cost = Math.min(cost, arr[j] - arr[i] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = cost == Integer.MAX_VALUE ? 0 : cost;
            }
        }

        return dp[0][m + 1];
    }
                      }
