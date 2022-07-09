package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/2839
public class Quiz_2839_풀이필요 {
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dfs(num, 0);
        System.out.println("result : " + result);
    }

    static void dfs(int num, int cnt){
        System.out.println("num : " + num);
        if(num == 0){
            System.out.println("여기");

            result = Math.min(cnt, result);
            return;
        }else {
            if(num >5){
                dfs(num%3, cnt+(num/3));
            }
        }

    }

}
