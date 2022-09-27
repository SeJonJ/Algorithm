package programmers;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/12953
// n개의 최소공배수
public class LV2_13 {
    public static void main(String[] args) {
        int[] num = {2,6,8,14};
        sol(num);
    }

    static int sol(int[] num){
        int answer = 0;

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=1; i< num.length; i++){
            q.offer(num[i]);
        }

        int start = num[0];
        int multi = 0;
        int lcm = 0;


        while(!q.isEmpty()){
            int n = q.poll();

            multi = start*n;

            int max = Math.max(start, n);
            int min = Math.min(start, n);
            int an = max%min;

            while (an > 0) {
                max = Math.max(an, min);
                min = Math.min(an, min);
                an = max%min;
            }


            lcm = multi/min;
            start = lcm;

        }

        answer = lcm;

        return answer;
    }
}
