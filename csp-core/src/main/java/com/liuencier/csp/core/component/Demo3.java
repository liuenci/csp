package com.liuencier.csp.core.component;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-09-01 19:24
 **/
public class Demo3 {
    public static void main(String[] args) {
        // nums = [2, 1, -2, 3], target = 5
        int[] nums = {2, 1, -2, 3};
        int target = 5;
        Demo3 demo3 = new Demo3();
        int i = demo3.closestNumber(nums, target);
        System.out.println(i);

        // W = 3, R = {{0,1,600},{1,2,500},{0,2,1300}}, A = 0, B = 2
        // W = 3, R = {{0,1,600},{1,2,800},{0,2,1300}}, A = 0, B = 2
        int w = 3;
        int[][] r = {{0,1,600},{1,2,800},{0,2,1300}};
        int a = 0;
        int b = 2;
        int minAirTicketPrice = demo3.findMinAirTicketPrice(w, r, a, b);
        System.out.println(minAirTicketPrice);
    }


    public int closestNumber(int[] nums , int target){
        int closest=nums[0]+nums[1]+nums[2];
        int diff=Math.abs(closest-target);
        Arrays.sort(nums);
        int length=nums.length;
        for(int i=0;i<length-2;i++){
            int left=i+1;
            int right=length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                int diff2=Math.abs(sum-target);
                if(diff>diff2){
                    diff=diff2;
                    closest=sum;
                }
                if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return closest;
    }

    public static int min=0;
    public static int findMinAirTicketPrice(int W,int[][] R,int A,int B){
        int K = W;
        int[][] dp = new int[W][K+2];
        for(int i = 0;i < W; ++i){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int k = 0; k <= K+1; ++k){
            dp[A][k] = 0;
        }
        for(int k = 1;k <= K+1;++k){
            for(int[] fl : R){
                if(dp[fl[0]][k-1] != Integer.MAX_VALUE){
                    dp[fl[1]][k] = Math.min(dp[fl[1]][k],dp[fl[0]][k-1]+fl[2]);
                }
            }
        }
        return dp[B][K+1] == Integer.MAX_VALUE?-1:dp[B][K+1];
    }
    public static void trackback(int w,int[][] R,int a,int target,int money){
        if(a==target){
            min=Math.min(min,money);
        }else{
            for(int i=0;i<w;i++){
                if(R[i][0]!=a){
                    continue;
                }
                money=money+R[i][2];
                trackback(w,R,R[i][1],target,money);
                money=money-R[i][2];
            }
        }
    }


    public static int ticktetPrice(int price, int[][] R, int A, int B){
        for(int i = 0 ;i < R.length ;i++){
            if(R[i][0] == A){
                price += R[i][2];
                if(R[i][1] != B){
                    findMinAirTicketPrice(price,R,R[i][1],B);
                }else{
                    return price;
                }
            }
        }
        return 0;
    }
}
