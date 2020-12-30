package com.liuencier.csp.core.component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @program: csp
 * @description:
 * @author: liuenci
 * @create: 2020-12-30 09:27
 **/
public class Demo4 {
    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        int[] scores = {1, 0, 3};
        int[] scores1 = {1,2,2};
        System.out.println(demo4.floers(scores));
        System.out.println(demo4.floers(scores1));

        int[] a = {3, 2, 1, 0, 5, 1};
        int[] b = {3, 2, 5, 1, 1};
        System.out.println(demo4.cloudLadderGame(a));
        System.out.println(demo4.cloudLadderGame(b));
    }

    public int floers(int[] scores) {
        int ans=0;//至少需要的小红花总数
        int len=scores.length;//数组长度
        ans=len;//每人至少一朵红花
        for(int i=0;i<len;i++){
            if(i==0){//第一个孩子
                if(scores[i]>scores[i+1]){
                    ans++;
                }
            }else if(i==len-1){//最后一个孩子
                if(scores[i]>scores[i-1]){
                    ans++;
                }
            }else{
                //其余孩子
                if(scores[i]>scores[i-1]||scores[i]>scores[i+1]){
                    ans++;
                }
            }
        }
        return ans;
    }


    public boolean cloudLadderGame(int[] buff) {
        int cur=0;//当前的层数
        int n=buff.length;//数组长度
        while(cur<n){
            int b=buff[cur];//buff加成
            if(b==0&&cur<n){
                return false;
            }
            cur=cur+b;
        }
        return true;
    }
}