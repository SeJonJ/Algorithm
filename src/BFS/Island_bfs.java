package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island_bfs {
    static int n;
    static int[][] island;
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1}; // 대각선 8방향
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int answer = 0;
    static Queue<PointIsland> q = new LinkedList<PointIsland>();
    static int[][] point;

    public static void findIsland(){
        while(!q.isEmpty()){
            PointIsland now = q.poll();
            for(int i=0; i<8; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && island[nx][ny] == 1 ) {
                    island[nx][ny] = 0;
                    q.add(new PointIsland(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        island = new int[n][n];
        point = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // island[i][j] 가 1 을 만났을 때 == 섬일때 함수 시작
                if(island[i][j] == 1){
                    // 섬 == 1 을 만나면 일단 answer++
                    answer++;
                    island[i][j] = 0; // 가장 먼저 방문한 섬의 값을 0으로 변경 추후 방문 할 수 없도록
                    q.add(new PointIsland(i, j));
                    findIsland();
                }
            }
        }
        System.out.println(answer);
    }
}

class PointIsland{
    int x;
    int y;
    PointIsland(int x, int y){
        this.x = x;
        this.y = y;
    }
}
