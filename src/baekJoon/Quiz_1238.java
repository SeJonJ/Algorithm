package baekJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1238
// 총 2번의 다익스트라 알고리즘을 이용해서 풀이한다.

// 이때 첫번째는 x 에서 각 마을로 가는 최단 경로를 구하고,
// 두번째는 간선을 뒤집어서 각 마을에서 x 로 가는 최단 거리를 구한다.

// 결국 x 를 시작으로 하는 다익스트라 알고리즘 2번 돌리면
// x 에서 각 마을로 가는 최단 경로와 각 마을에서 x 로 가는 최단 경로가 각각
// goX 배열과 bakHome 에 저장된다.

// 이때 비용의 최대값을 구하는 것임으로 goX 배열과 bakHome 의 합을 구햇을 때 최대값을 확인하면 된다.
public class Quiz_1238 {
    static PriorityQueue<Party> q = new PriorityQueue<>((o1, o2) -> {
        return o1.cost - o2.cost;
    });

    // 각 마을 -> X 마을까지의 그래프
    static ArrayList<ArrayList<Party>> tree = new ArrayList<>();

    // X 마을 -> 각 마을까지의 그래프
    static ArrayList<ArrayList<Party>> treeReverse = new ArrayList<>();

    // X 로 가는 거리 배열 -> goX
    // X 에서 각 마을로 돌아오는 거리 배열 -> bakHome
    static int[] goX, bakHome;
    static int n, m, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<Party>());
            treeReverse.add(new ArrayList<Party>());
        }

        goX = new int[n + 1];
        bakHome = new int[n + 1];

        Arrays.fill(goX, Integer.MAX_VALUE);
        Arrays.fill(bakHome, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // tree 는 입력받은 그대로
            tree.get(from).add(new Party(to, cost));

            // treeReverse 는 입력받은 것을 반대로 -> 1 2 4 라면 2 1 4 로
            treeReverse.get(to).add(new Party(from, cost));

        }

        // 1. X 마을에서 각 마을까지 최단 거리 계산 후 bakHome 에 저장 => 파티 돌아오는 길
        findTime(tree, bakHome, x);

        // 2. 각 마을에서 X 마을까지의 최단 거리 계산 후 goX 에 저장 => 파티 가는 길
        findTime(treeReverse, goX, x);


        System.out.println(findMax());
    }


    static void findTime(ArrayList<ArrayList<Party>> tree, int[] dis, int start ) {
        // 이미 방문한 곳을 체크하는 배열
        boolean[] visited = new boolean[n+1];

        // 시작지점은 언제나 X
        q.offer(new Party(start, 0));

        // 시작 지점이 되는 X 마을까지의 거리는 당연 0
        dis[start] = 0;

        // 여기서부터는 기본적인 다익스트라 알고리즘과 동일
        while (!q.isEmpty()) {
            Party p = q.poll();

            int nowTo = p.to;
            int nowCost = p.cost;

            if(visited[nowTo]) continue;

            visited[nowTo] = true;

            for (Party next : tree.get(nowTo)) {
                // 다음 방문할 마을인 nextTo 까지의 비용 값보다
                // 현재 마을까지의 비용+다음 마을까지의 비용이 더 작다면
                // dis[next.To] 를 변경
                if (dis[next.to] > nowCost + next.cost) {
                    dis[next.to] = nowCost + next.cost;

                    q.offer(new Party(next.to, nowCost + next.cost));

                }
            }
        }
    }

    // for 문을 사용해서 goX[i] + bakHome[i] 했을 때 최대값을 찾는 메서드
    static int findMax(){
        int result = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            result = Math.max(result, goX[i] + bakHome[i]);
        }

        return result;
    }

}

class Party {
    int to;
    int cost;

    Party(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

}