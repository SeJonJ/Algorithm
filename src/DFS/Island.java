package DFS;

import java.util.Scanner;

// https://www.acmicpc.net/problem/4963
public class Island {
    static int n;
    static int[][] island;
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1}; // 대각선 8방향
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int answer = 0;

    static void findIsland(int x, int y) {
//        if(x>=0 && y>=0 && x<=n && y<=n) return;

        if (x>=0 && y>=0 && x<n && y<n && island[x][y] == 1) {
            island[x][y] = 0;

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                findIsland(nx, ny);
            }
        } else if (x>=0 && y>=0 && x<n && y<n && island[x][y] == 0){
//            System.out.println(island[x][y]);
            answer++;
            return;

        }

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        island = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = scan.nextInt();

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                findIsland(i, j);
            }
        }

        System.out.println("answer : " + answer);
    }
}
