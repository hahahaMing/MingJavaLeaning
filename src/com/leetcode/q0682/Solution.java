package com.leetcode.q0682;

class Solution {
    public int calPoints(String[] ops) {
        int last1 = 0,last2 = 0,sum = 0;
        for(String s:ops){
            switch(s){
                case "+":
                    sum+=last1+last2;
                    last2 = last1;
                    last1+=last2;
                    break;
                case "D":
                    sum+=last1*2;
                    last2 = last1;
                    last1*=2;
                    break;
                case "C":
                    sum-=last1;
                    last2 = last1;
                    last1 = 0;
                    break;
                default:
                    sum += Integer.parseInt(s);
                    last2 = last1;
                    last1 = Integer.parseInt(s);
            }
        }
        return sum;
    }


}


class MainClass{
    public static void main(String[] args) {
        String[] opt = new String[]{"5","2","C","D","+"};
        System.out.println(new Solution().calPoints(opt));

    }


}