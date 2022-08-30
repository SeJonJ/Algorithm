package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/2839
public class Quiz_2839 {
    static int n;

    // n 에 도달하지 못하는 경우 -1 임으로 기본값 -1로 초기화
    static int min = -1;

    // PriorityQueue 를 사용해서 가장 작은 값이 먼저 나오도록 -> 오름차순으로 나오도록
    static Queue<Sugar> q = new PriorityQueue<>((o1, o2)->{
        return o1.sum - o2.sum;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // BFS 시작
        useBFS();

        System.out.println(min);
    }

    // 0 -> n 까지가는 방식이 아니라 n -> 0 까지 가는 방식으로 구현하였다.
    // n 에서 -5 나 -3 했을 때 0에 도달한다면 3과 5로 조합 가능함으로 cnt 를 return 하고,
    // n 에 도달할 수 없다면 -> 0 보다 작은 숫자가 나온다면 continue 해서 queue 가 계속 돌게 만들었다.

    // 문제는 맞았는데...아무래도 그리디 문제인지라 BFS 로 풀면 효율이 별로 좋지 못하다는 문제가 있다.
    // 만약 규칙을 찾아서 풀었다면 그게 훨씬 더 좋은 방법이다
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