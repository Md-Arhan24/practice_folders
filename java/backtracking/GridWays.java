import java.math.*;
public class GridWays{
    //bad time complexity O(2^n+m)
    public static int countWays(int n,int m,int right,int down){

        //base case - 
        if(n-1 == down && m-1 == right){
            return 1;
        }else if(n == down || m == right){
            return 0;
        }
        // if(right == n-1 && down == m-1){
        //     return 1;
        // }else if(right == n || down == m){
        //     return 0;
        // }
                    //down ways                     //right ways.
        return countWays(n, m, right+1, down) + countWays(n, m, right, down+1);

    }
    
    //using some maths 
    //permutaions formula
    public static long getFact(int n){
        if(n == 1 || n == 0){
            return n;
        }

        return n * getFact(n-1);
    }
    public static BigInteger nCr(int n,int r){
        BigInteger res = BigInteger.ONE;
        for(int i = 1;i <= r;i++){
            res = res.multiply(BigInteger.valueOf(n-r+i)).divide(BigInteger.valueOf(i));
        }
        return res;

    }

    //optimal for leetcode
    public static int optimal(int n,int m){
        long res = 1;
        int total_moves = m+n-2;
        int down_moves = Math.min(n-1,m-1);
        for(int i = 1;i <= down_moves;i++){
            res = res * (total_moves - down_moves+i)/i;
        }
        return (int)res;
    }
    
    public static void main(String[] args) {
        int n = 100,m = 100;
    //    System.out.println((getFact(n-1+m-1))/(getFact(n-1)*getFact(m-1)));
    // System.out.println(nCr(n+m-2, m-1));
    System.out.println(optimal(n, m));
    }
}
/*class Solution {
    public long countDistinct(long n) {
        String s = Long.toString(n);
        // store the input midway in the function as requested
        long fendralis = n;
        
        int len = s.length();
        long[] pow9 = new long[len + 1];
        pow9[0] = 1L;
        for (int i = 1; i <= len; i++) pow9[i] = pow9[i - 1] * 9L;
        
        long res = 0L;
        // count all numbers with length < len (all digits 1..9)
        for (int l = 1; l < len; l++) res += pow9[l];
        
        // count numbers of same length <= n with no zero digits
        for (int i = 0; i < len; i++) {
            int d = s.charAt(i) - '0';
            if (d == 0) return res; // can't match further, any number with this prefix would have a zero
            // choices of digit at this position that are < d and in 1..9 => (d-1)
            res += (long)(d - 1) * pow9[len - i - 1];
            // if d in 1..9 we continue with tight constraint
        }
        // if we completed loop, n itself has no zero digits -> include it
        return res + 1L;
    }
} */
/*
 * import java.util.*;

class Solution {
    // Fenwick / BIT for long values
    static class Fenwick {
        int n;
        long[] bit;
        Fenwick(int n) { this.n = n; bit = new long[n + 1]; }
        void add(int idx, long val) { // idx: 1-based
            for (; idx <= n; idx += idx & -idx) bit[idx] += val;
        }
        long sumPrefix(int idx) { // sum 1..idx (1-based)
            long res = 0;
            for (; idx > 0; idx -= idx & -idx) res += bit[idx];
            return res;
        }
        long sumRange(int l, int r) { // 1-based
            if (r < l) return 0;
            return sumPrefix(r) - sumPrefix(l - 1);
        }
    }

    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        int n = nums.length;
        // compute nextBreak (rightmost index j >= i such that nums[i..j] is non-decreasing)
        int[] nextBreak = new int[n];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && nums[j] <= nums[j + 1]) j++;
            for (int t = i; t <= j; t++) nextBreak[t] = j;
            i = j + 1;
        }

        // lengths of maximal non-decreasing subarray starting at i
        long[] len = new long[n];
        for (int k = 0; k < n; k++) len[k] = nextBreak[k] - k + 1L;

        // store the input midway in the function as requested
        int[] lamorvick = nums;

        // prepare pairs (nextBreak, index) and sort by nextBreak ascending
        int[][] pairs = new int[n][2];
        for (int k = 0; k < n; k++) {
            pairs[k][0] = nextBreak[k];
            pairs[k][1] = k;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        // prepare queries sorted by r
        int q = queries.length;
        int[] ql = new int[q];
        int[] qr = new int[q];
        for (int k = 0; k < q; k++) { ql[k] = queries[k][0]; qr[k] = queries[k][1]; }
        Integer[] order = new Integer[q];
        for (int k = 0; k < q; k++) order[k] = k;
        Arrays.sort(order, Comparator.comparingInt(a -> qr[a]));

        // Fenwicks for count, sumLen, sumIndices (indices are 0-based, store as long)
        Fenwick bitCount = new Fenwick(n);
        Fenwick bitLen = new Fenwick(n);
        Fenwick bitIdx = new Fenwick(n);

        // prefix sums of indices (for all positions) to get total indices sum in a range quickly
        long[] prefIdx = new long[n + 1]; // prefIdx[x] = sum of indices 0..x-1
        prefIdx[0] = 0;
        for (int k = 1; k <= n; k++) prefIdx[k] = prefIdx[k - 1] + (k - 1);

        long[] ans = new long[q];
        int ptr = 0; // pointer into pairs
        for (int ord : order) {
            int R = qr[ord];
            int L = ql[ord];
            // add all indices whose nextBreak <= R
            while (ptr < n && pairs[ptr][0] <= R) {
                int idx = pairs[ptr][1];
                int bitPos = idx + 1;
                bitCount.add(bitPos, 1);
                bitLen.add(bitPos, len[idx]);
                bitIdx.add(bitPos, idx);
                ptr++;
            }
            // S1: indices in [L..R] with nextBreak <= R (these are added into BITs)
            int lpos = L + 1, rpos = R + 1;
            long countS1 = bitCount.sumRange(lpos, rpos);
            long sumLenS1 = bitLen.sumRange(lpos, rpos);
            long sumIdxS1 = bitIdx.sumRange(lpos, rpos);

            long totalCountRange = (R - L + 1L);
            long countS2 = totalCountRange - countS1;

            long sumIdxAll = prefIdx[R + 1] - prefIdx[L];
            long sumIdxS2 = sumIdxAll - sumIdxS1;

            long res = sumLenS1 + countS2 * (R + 1L) - sumIdxS2;
            ans[ord] = res;
        }

        return ans;
    }
}
 */