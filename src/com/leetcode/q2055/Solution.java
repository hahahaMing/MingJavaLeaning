package com.leetcode.q2055;
import java.util.*;

public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='|'){
                list.add(i);
            }
            i++;
        }
        int[] rst = new int[queries.length];
        for(i=0;i<queries.length;++i) {
            int l = queries[i][0], r = queries[i][1];
            int il = Collections.binarySearch(list, l);
            int ir = Collections.binarySearch(list, r);
            rst[i] = r - l + 1;
            if (il < 0) {
                il = -il - 1;//子数组最左边棍在list的索引
            }
            if (ir < 0) {
                ir = -ir - 2;//子数组最右边棍在list的索引
            }
            if(ir-il<1){
                rst[i] = 0;
            }else{
                rst[i] -= (list.get(il) - l);
                rst[i] -= (r - list.get(ir));
                rst[i] -= ir - il +1;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
//        String s = "**|**|***|***";
//        int[][] queries = {{2,5},{5,9},{0,1},{1,1},{3,4},{10,11}};

        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};

        Solution solution = new Solution();
        int[] rst = solution.platesBetweenCandles(s,queries);
        for(int x:rst){
            System.out.println(x);
        }
    }
}
