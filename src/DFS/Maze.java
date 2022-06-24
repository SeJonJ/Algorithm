package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Maze {
    // n x n 짜리 미로가 있다. 이때 1은 벽이고, 0 은 통로다.
    // 미로에서는 상하좌우로만 움직인다. 출발지점은 1,1 이고 도작점은 7,7 이다.
    // 이때 격자판이 주어질때 도착점까지 가는 경우의 수는?

    // 여기서 중요한 것은 1은 갈수 없는 곳, 0은 갈 수 있는 곳이라는 점
    // 상하좌우로 움직이는 것에 대한 코드를 짜야한다는 점
    // 갈때는 1, 뒤로 돌아올때는 0으로 체크해야한다는 점
    // 을 기억하자

    // 상하좌우로 이동하기 위해 사용하는 배열 dx, dy
    // dx 는 x 좌표를 기준으로 왼쪽(-1), 그대로, 오른쪽(+1), 그대로 를 의미하고
    // dy 는 y 좌표를 기준으로 그래도, 위쪽(+1), 그대로, 왼쪽(-1) 을 의미한다.
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    static int[][] maze = new int[8][8];
    static int answer = 0;

    static void exitMaze(int x, int y) {
        if(x == 7 && y == 7 ){ // 탈출구는 7,7 임으로 여기에 도착하면 answer++ 한 후 종료
            answer++;
        }else{
            for(int i=0; i<4; i++){
                // 좌우, 상하 로 이동을 위한 변수
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 전체 7x7 의 maze 임으로 이동 변수 nx, ny 가 각각 1,1 이하나 7,7 이상이 되면 안된다.
                if(nx >=1 && ny>=1 && nx <=7 && ny<=7){
                    // 동시에 maze 에서 이동할 수 있는 곳은 값이 0 인 곳이다.
                    if(maze[nx][ny] == 0){
                        // 0 인 곳으로 이동한 후에는 해당 좌표의 값을 1로 바꾼 후
                        maze[nx][ny] = 1;
                        // exitMaze 에 내가 움직인 좌표를 넣어준다
                        exitMaze(nx, ny);
                        // 한번 거리 계산이 끝난 후에는 좌표의 값을 0으로 변경한다
                        maze[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = scan.nextInt();
            }
        }

        // 시작지점인 1,1 은 항상 1
        maze[1][1] = 1;
        exitMaze(1, 1);
        System.out.println(answer);
    }
}
