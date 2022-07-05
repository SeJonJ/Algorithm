package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1743
// 음식물 피하기
public class Quiz_1743 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] load;
    static boolean[][] check;
    static int n, m, k;
    static Queue<TrashPoint> q = new LinkedList<>();

    static int result = Integer.MIN_VALUE;

    static int findCnt(int x, int y) {
        check[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            TrashPoint now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];

                if (nx > 0 && ny > 0 && nx <= n && ny <= m && !check[nx][ny] && load[nx][ny]==1) {
                    check[nx][ny] = true;
                    cnt++;
                    q.offer(new TrashPoint(nx, ny));
                }
            }
        }
        return cnt;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        load = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            load[num1][num2] = 1;
        }

        for (int i = 0; i < load.length; i++) {
            for (int j = 0; j < load[i].length; j++) {
//                System.out.print(load[i][j] + " ");
                if (load[i][j] == 1) {
                    q.offer(new TrashPoint(i, j));
                    result = Math.max(result, findCnt(i, j));
                }
            }
//            System.out.println();
        }

        System.out.println(result);
    }
}

class TrashPoint {
    int x, y;

    TrashPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}