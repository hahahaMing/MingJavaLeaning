package com.leetcode.q0054;

public class Solution {
    public String convertToBase7(int num) {
        if(num==0) return new String("0");
        StringBuffer s = new StringBuffer();
        if(num<0){
            s.append('-');
            num = -num;
        }
        while(num!=0){
            s.append(num%7);
            num/=7;
        }
        s.reverse();
        return s.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(100));
    }
}
