package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Quiz_2178_bfs {
    static int[][] maze;
    static int[][] dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m;

    public static void findExit(int x, int y){
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >0 && ny >0 && nx <= n && ny <= m && maze[nx][ny] == 1){
                    maze[nx][ny] = 0;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[now.x][now.y] +1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //System.out.println(n + " : " + m);

        maze = new int[n+1][m+1];
        dis = new int[n+1][m+1];

        for(int i=1; i<=n; i++){

            char[] ch = br.readLine().toCharArray();
            //System.out.println(Arrays.toString(ch));
            //System.out.println(maze.length);
            //System.out.println(maze[i].length);

            for(int j=0; j<ch.length; j++){
                maze[i][j+1] = (int)ch[j] - 48;
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