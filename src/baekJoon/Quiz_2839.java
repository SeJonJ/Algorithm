package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/2839
public class Quiz_2839 {
    static int n;
    static int min = -1;
    static Queue<Sugar> q = new PriorityQueue<>((o1, o2)->{
        return o1.sum - o2.sum;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        useBFS();

        System.out.println(min);
    }

    static void useBFS(){
        q.offer(new Sugar(n, 0));

        while (!q.isEmpty()) {
            Sugar su = q.poll();
            int sum = su.sum;
            int cnt = su.cnt;


            if(sum < 0){
                continue;
            } else if (sum == 0) {
                min = cnt;
                return;
            }else{
                q.offer(new Sugar(sum-3, cnt+1));
                q.offer(new Sugar(sum-5, cnt+1));
            }
        }
    }
}

class Sugar{
    int sum;
    int cnt;

    Sugar(int sum, int cnt) {
        this.sum = sum;
        this.cnt = cnt;
    }
}