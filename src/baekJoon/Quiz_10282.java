package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_10282 {
    static ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
    static PriorityQueue<Edge> q = new PriorityQueue<Edge>(new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.cost - o2.cost;
        }
    });

    static int[] dis;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            makeGraph();

            int com = 0;
            int max = 0;
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


        /*첫번째 줄 입력 */
        for (int i = 0; i <= n; i++) {

            list.add(new ArrayList<Edge>());
        }

        /* 그래프 정보 입력 */
        for (int i = 1; i <= d; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list.get(b).add(new Edge(a, s));
        }

        dijkstra(c);
    }

    static void dijkstra(int start) {
        q.offer(new Edge(start, 0));
        dis[start] = 0;

        while (!q.isEmpty()) {
            Edge e = q.poll();
            int nowVex = e.vex;
            int nowCost = e.cost;

            if (nowCost > dis[nowVex]) {
                continue;
            }

            for (Edge next : list.get(nowVex)) {

                if (dis[next.vex] > nowCost + next.cost) {
                    dis[next.vex] = nowCost + next.cost;
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