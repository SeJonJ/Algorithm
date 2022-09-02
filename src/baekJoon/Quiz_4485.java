package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/4485
public class Quiz_4485 {

    static int[][] maze;
    static int[][] dijkstra;

    // 2차원 배열에서 움직이기 위한 배열 dx, dy
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static Queue<Rupee> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 몇번째 problem 인지 알기 위해서 cnt 변수 선언
        int cnt = 1;
        // n == 0 일때까지 받아야 하기 때문에 while 문 시작
        while (true) {

            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            // maze 는 입력받는 2차원 배열
            // dijkstra 는 다이스트라 알고리즘을 위한 배열 => 각 노드 방문시 최종 cost 를 저장하기 위한 배열
            maze = new int[n][n];
            dijkstra = new int[n][n];

            // 큐는 PriorityQueue 로 만들고, cost 를 기준으로 오름차순으로 튀어나오도록 설정
            q = new PriorityQueue<>((o1, o2) -> {
                return o1.cost - o2.cost;
            });

            // maze 를 입력받고, dijkstra 에는 최대값을 저장한다.
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j=0; j<n; j++){
                    maze[i][j] = Integer.parseInt(st.nextToken());
                    dijkstra[i][j] = Integer.MAX_VALUE;
                }
            }

            // queue 에 시작점을 넣고 시작!!
            q.offer(new Rupee(0, 0, maze[0][0]));
            System.out.println(findLose(cnt));
            cnt++;
        }

    }

    static String findLose(int cnt){
        while (!q.isEmpty()) {
            Rupee r = q.poll();
            int x = r.x;
            int y = r.y;
            int cost = r.cost;

            // 2차원 배열로 입력받고, 움직이는만큼 결국 풀이의 기본을 DFS, BFS 문제들처럼 생각한다.
            // 즉 노드끼리 연결되서 갈 수 있는 곳은 결국 BFS 나 DFS 문제에서 움직이는 것처럼
            // dx, dy 를 이용한다.
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                // nx, ny 의 범위 지정
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                // ncost 는 위치의 cost 와 앞으로 움직일 지점의 cost
                int ncost = cost+maze[nx][ny];

                // 현재 위치의 cost 가 dijkstra[x][y] 의 값보다 크다면 continue;
                // 왜냐하면 이미 더 크기 때문에 이 이상 계산할 필요X
                if (cost > dijkstra[x][y]) {
                    continue;
                }

                // 만약 n-1, n-1 좌표에 도착한다면 끝!
                if (nx == n - 1 && ny == n-1) {
                    return "Problem "+cnt+": "+ncost;
                }else if(dijkstra[nx][ny] > ncost){
                    // 만약 dijkstra[nx][ny] 의 cost 값보다 ncost 값이 작다면
                    // dijkstra 좌표의 값을 변경 후 queue 에 넣기
                    dijkstra[nx][ny] = ncost;
                    q.offer(new Rupee(nx, ny, ncost));
                }
            }

        }

        return null;
    }
}

class Rupee{
    int x;
    int y;
    int cost;

    Rupee(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}