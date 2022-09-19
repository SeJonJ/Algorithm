package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_1516_풀이중 {
    static int n;
    static ArrayList<ArrayList<Integer>> building;
    static int[] time;
    static int[] indegree;
    static int[] result;
    static Queue<Integer> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // https://www.acmicpc.net/problem/1516
    // 위상정렬 알고리즘을 사용한 문제! 이 부분은 추후 정리예정

    // 이 문제의 포인트는 주어지는 건물을 테크트리처럼 생각하는 것
    // 즉 4 3 2 -1 이 주어진다면
    // 1번 건물을 짓기 위해서는 4초가 걸리고, 3번 2번 건물이 필요하다라는 것을 기억하자

    // 또한 건물을 짓는다 => queue 에 건물 번호를 넣는다
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        building = new ArrayList<>();

        makeGraph();

        findTime();

    }

    static void makeGraph() throws IOException {
        for(int i=0; i<=n; i++){
            building.add(new ArrayList<>());
        }

        // 특정 건물을 짓기 전에 먼저 지어야할 건물의 갯수
        indegree = new int[n + 1];

        // 특정 건물을 짓기 전 걸리는 시간
        time = new int[n+1];

        // 건물을 짓는데 걸리는 시간 최종
        result = new int[n + 1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            // 시간 저장
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                // i 번째 건물을 짓는데 필요한 건물 번호 : n
                int n = Integer.parseInt(st.nextToken());

                if (n == -1) break;

                // 간선 저장
                building.get(n).add(i);

                indegree[i]++;
            }
        }
    }


    static void findTime() {
        StringBuilder sb = new StringBuilder();

        // 먼저 한번에 지어지는 건물을 찾아서 그 건물을 먼저 짓는다
        // 건물 번호를 queue 에 넣는다
        for(int i=1; i<=n; i++){
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 특정 건물을 건설하는데 걸리는 시간 계산하기
        while (!q.isEmpty()) {

            // 현재 지어진 건물번호
            int now = q.poll();

            // 해당 건물로 지을 수 있는 다음 건물을 탐색
            // building 에서 현재 지어진 건물 now 를 기준으로 탐색
            for (int next : building.get(now)) {
                // 탐색 할때마다 indegree 에서 -1 한다.
                // 이는 건물 탐색 -> 건물 짓는다 -> 건물 짓는 시간 계산 완료 이기 때문
                indegree[next]--;

                // next 건물을 짓기 전까지 걸리는 시간 계산 => 즉 자기 자신 건물을 짓는데 걸리는 시간을 포함X
                // next 건물을 짓는데 필요한 A 건물의 시간이 10초, B 건물의 시간이 20초 라고 한다면
                // 결과적으로 next 건물을 짓기전까지 필요한 시간을 20초이다 =>
                // 동시에! 건물 건설이 가능하기 때문에 n개 이상의 건물이 필요한 경우 가장 큰 건물의 시간을 따라가게된다

                // 따라서 가장 큰 값을 선택!
                result[next] = Math.max(result[next], result[now] + time[now]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for(int i=1; i<=n; i++){
            // 최종적으로는 i건물을 짓기 전까지 시간+i건물 자기 자신의 시간
            sb.append((result[i]+time[i])+"\n");
        }

        System.out.println(sb.toString());
    }
}
