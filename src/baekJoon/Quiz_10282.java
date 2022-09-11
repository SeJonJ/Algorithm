package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/10282
// 이 문제의 핵심 포인트는 감염까지 걸리는 최소 시간을 계산하는 것!!
// 백준 네트워크 문제와 비슷하지만 DFS 나 BFS 로 풀면 시간초과가 나거나 메모리 초과가 발생한다.
// 이에 다익스트라 알고리즘으로 문제를 풀어야했다.
// 최소 시간이라는 말은 딱히 없지만...최소 시간이 걸리도록 계산해야함으로 다익스트라 알고리즘을 사용한다.
// 그나마 주의할 점은 a 가 b 를 의존한다는 점과 전체 입력 받을 때 살짝 복잡하다는 정도?
public class Quiz_10282 {
    // list 에는 컴퓨터와 해당 컴퓨터의 감염까지 걸리는 시간을 저장하는 Edge 객체를 저장
    static ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();

    // pq 는 오름차순으로 빠져나오게
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>(new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.cost - o2.cost;
        }
    });

    // 각 vex - 컴퓨터 - 까지의 시간을 계산하기 위한 배열
    static int[] dis;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 T 만큼 반복
        for (int i = 0; i < T; i++) {
            // 한번 다익스트라가 끝나면
            makeGraph();

            // 감염된 컴퓨터와 총 시간을 구한다.
            int com = 0;
            int max = 0;

            // 이때 dis 에서 MAX_Value 가 아닌 경우에 대해서만 계산
            for (int j : dis) {
                if (j != Integer.MAX_VALUE) {
                    com++;
                    max = Math.max(max, j);
                }
            }
            sb.append(com + " " + max + "\n");
        }
        System.out.print(sb.toString());
    }


    static void makeGraph() throws IOException {
        // 테스트 케이스마다 queue 와 list 초기화
        q.clear();
        list.clear();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 컴퓨터 갯수
        int d = Integer.parseInt(st.nextToken()); // 의존성 갯수
        int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

        // 시간 배열
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);


        /*
        * 첫번째 줄 입력
        * list 는 n 만큼 반복
        * */
        for (int i = 0; i <= n; i++) {

            list.add(new ArrayList<Edge>());
        }

        /* 그래프 정보 입력 */
        for (int i = 1; i <= d; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // b 가 a 를 의존하는 것이 아닌
            // a 가 b 를 의존하는 형태임으로 b 를 기준으로 그래프를 만든다.
            list.get(b).add(new Edge(a, s));
        }

        // 시작은 처음 감염된 컴퓨터 c
        dijkstra(c);
    }

    static void dijkstra(int start) {

        q.offer(new Edge(start, 0));
        // 방문한 start 는 감염시간 0 초
        dis[start] = 0;

        while (!q.isEmpty()) {
            Edge e = q.poll();

            // 각각 현재 컴퓨터와 감염시간 cost
            int nowVex = e.vex;
            int nowCost = e.cost;

            // queue 에서 나온 cost 가 dis 의 해당 노드에서의 값보다 크다면
            // 굳이 더 큰 값으로 계산할필요가 없음으로 continue;
            if (nowCost > dis[nowVex]) {
                continue;
            }

            // list - 그래프 - 에서 방문 가능한 Edge 객체를 꺼내온다.
            for (Edge next : list.get(nowVex)) {

                // 만약 next.vex 보다 nowCost + next.cost 가 작다면
                // 아래 계산
                if (dis[next.vex] > nowCost + next.cost) {
                    dis[next.vex] = nowCost + next.cost;

                    // 또한 다음 node - next.vex - 의 cost 를 위에서 계산된 dis[next.vex] 로 변경한다.
                    q.offer(new Edge(next.vex, dis[next.vex]));
                }
            }
        }
    }
}

class Edge {
    int vex;
    int cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
}