package DFS;

import java.util.Scanner;

// 관련 문제 https://www.acmicpc.net/problem/4963

// 섬나라 아일랜드
// n x n 정사각형의 지도가 있다. 
// 해당 정사각형에 0과 1로 이루어진 지도가 주어지는데 1은 섬 0 은 바다이다.
// 섬은 가로 세로 대각선으로 연결될 수 있으며, 연결된 섬은 1개로 취급한다.
// 0 인 바다 갈 수 없다.
// 지도가 주어진다고 할 때 섬의 총 갯수는 몇개인가?
// 백준 문제와 살짝 다름 -> 좀 더 쉬운편
public class Island_dfs {
    static int n;
    static int[][] island;
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1}; // 대각선 8방향
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int answer = 0;

    static void findIsland(int x, int y) {
//        System.out.println(x + " : " + y);
        for (int k = 0; k < 8; k++) { // 대각선 포함 8방향으로 움직임
            int nx = x + dx[k]; // 각 좌표 + 8방향 값
            int ny = y + dy[k];

            // nx 와 ny 는 0보다 크거나 같아야하고, island[nx][ny] 의 값이 섬 == 1 이여야만 갈 수 있음
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && island[nx][ny] == 1) {
                // 방문한 좌표를 0 으로 변경
                island[nx][ny] = 0;
                
                // 다시 함수 시작
                findIsland(nx, ny);
            }
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
                // island[i][j] 가 1 을 만났을 때 == 섬일때 함수 시작
                if(island[i][j] == 1){
                    // 섬 == 1 을 만나면 일단 answer++
                    answer++;
                    island[i][j] = 0; // 가장 먼저 방문한 섬의 값을 0으로 변경 추후 방문 할 수 없도록
                    // 함수 시작
                    findIsland(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
