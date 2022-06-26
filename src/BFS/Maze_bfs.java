package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze_bfs {
    // 최소 일수, 최단 거리, 최소 시간 ---- 등등등 최소 가 들어간 것들은 대부분 BFS 임을 기억할 것
    // DFS 로 비슷한 문제를 풀었떠니 시간초과 나온다ㅠㅠㅠ
    // 문제는 DFS 의 미로찾기 문제와 동일
    // 단 도착 지점까지 최소 횟수를 구하는 것이 문제 내용

    static int[] dx = {0, 1, 0, -1}; // 좌 우
    static int[] dy = {1, 0, -1, 0}; // 상 하
    static int[][] maze; // 미로 배열
    static int[][] dis; // 출발점 1,1 에서 해당 좌표까지의 거리


    static void mazeBFS(int x, int y){
        // Point 클래스는 x, y 좌표를 저장하고, 이를 Queue 에 넣어주기 위한 좌표 클래스
        Queue<Point> q = new LinkedList<Point>();
        // queue 에 x, y 좌표가 저장된 Point 클래스를 넣는다
        // => queue 에 넣어졋으면 방문했음을 의미
        q.offer(new Point(x, y));

        // 현재 방문한 x, y 좌표를 방문했다는 것을 표시하기 위해서 1 로 변경
        maze[x][y] = 1;
        while (!q.isEmpty()) {
            // Queue 에서 가장 첫번째 Point 객체를 내와서 temp 로 저장
            Point tmp = q.poll();

            for(int i=0; i<4; i++){ // 현재 위치 x,y 에서 이동할 수 잇는 방향은 상하좌우 총 4가지
                // 아래의 tmp.x 와 tmp.y 는 현재 x, y 좌표를 의미함
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                // 여기는 이전 문제와 동일
                if (nx > 0 && ny > 0 && nx <= 7 && ny <= 7 && maze[nx][ny] == 0) {
                    // nx, ny 에 방문했으니 1 로 변경
                    maze[nx][ny] = 1;
                    // 다음 그리고 방문해야할 좌표를 queue 에 넣기
                    q.offer(new Point(nx, ny));
                    // 방문해야할 좌표까지의 거리는 현재 좌표까지의 거리 +1
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        maze = new int[8][8];
        dis = new int[8][8];

        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                maze[i][j] = scan.nextInt();
            }
        }
        mazeBFS(1,1);
        if (dis[7][7] == 0) { // 만약 7,7 이 0 이면 갈 수 없음을 의미 따라서 -1
            System.out.println(-1);
        }else{ // dis[7][7] 이 0 이 아닌 다른 값이 있으면 해당 값이 곧 1,1 에서 부터의 거리를 의미함
            System.out.println(dis[7][7]);
        }
    }
}

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
