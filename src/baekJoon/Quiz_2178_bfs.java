package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2178
public class Quiz_2178_bfs {
    static int[][] maze; // 미로
    static int[][] dis; // 시작점부터 도착점까지의 거리
    static int[] dx = {-1, 0, 1, 0}; // 좌 우
    static int[] dy = {0, 1, 0, -1}; // 상 하

    static int n, m;

    public static void findExit(int x, int y){
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x, y)); // x, y 좌표를 갖는 point 를 queue 에 넣는다

        while (!q.isEmpty()) {
            Point now = q.poll(); // queue 의 가장 앞에 것을 빼서 now 변수에 저장

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // nx ny 는 모두 0 모다 크고, 각각 n 과 m 보다 작아야한다
                // 동시에 maze[nx][ny] 가 1 이여야만 갈 수 있다
                if(nx >0 && ny >0 && nx <= n && ny <= m && maze[nx][ny] == 1){
                    maze[nx][ny] = 0; // 방문했음을 확인하기 위해 0 으로 변경
                    q.offer(new Point(nx, ny)); // 방문한 좌표를 queue 에 저장
                    dis[nx][ny] = dis[now.x][now.y] +1; // 방문한 곳까지의 거리는 현재 좌표까지의 거리+1
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input); // String 을 나누기 위한 StringTokenizer
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //System.out.println(n + " : " + m);

        maze = new int[n+1][m+1]; // 미로는 1,1 부터 시작임으로 n+1, m+1 만큼의 크기로 선언
        dis = new int[n+1][m+1]; // 거리는 미로와 동일한 크기로 선언

        for(int i=1; i<=n; i++){

            char[] ch = br.readLine().toCharArray(); // 입력받은 미로의 값들을 char 배열로 저장
            //System.out.println(Arrays.toString(ch));
            //System.out.println(maze.length);
            //System.out.println(maze[i].length);

            for(int j=0; j<ch.length; j++){
                maze[i][j+1] = (int)ch[j] - 48; // char 배열에서 하나씩 꺼내서 int 로 변환하여 int 형 maze 배열에 저장
                //maze[i][j] = 1;
            }
//            System.out.println("");
//            System.out.println(Arrays.toString(maze[i]));
        }

        // 미로에서 시작점은 1,1 => 따라서 1,1 은 항상!! 방문한 상태임
        // 따라서 dis[1][1] 에서의 시작 거리(값)는 1
        maze[1][1] = 0;
        dis[1][1] = 1;
        findExit(1, 1);

        System.out.println(dis[n][m]);
    }
}

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}