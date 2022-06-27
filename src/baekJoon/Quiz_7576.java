package baekJoon;

import java.io.IOException;
import java.util.*;

// https://www.acmicpc.net/problem/7576
public class Quiz_7576 {
    static int[] dx = {1, -1, 0, 0}; // 좌 우
    static int[] dy = {0, 0, 1, -1}; // 상하
    static int[][] tomato; // 토마토 배열
    static int n, m; // 토마토 열, 행
    static Queue<PointTomato> q = new LinkedList<PointTomato>();
    static int result = Integer.MIN_VALUE;

    static void findDay() {
        while(!q.isEmpty()){ // queue 에 내용이 없을때까지 반복
            PointTomato now = q.poll(); // queue 의 가장 앞에 것을 꺼내서 저장
            int day = now.day; // 현재 날짜
            int nowX = now.x; // x 좌표
            int nowY = now.y; // y 좌표

            for(int i=0; i<4; i++){
                int nx = nowX + dx[i]; // 현재 좌표에서 dx 만큼 움직인 x
                int ny = nowY + dy[i]; // 현재 좌표에서 dy 만큼 움직인 y

//                System.out.println("nx : "+nx);
//                System.out.println("n : "+n );

                // nx ny 는 각각 0보다 크거나 같고, n 과 m 보다 작아야함
                // 또한 값이 0인 토마토만 익을 수 있음 => 방문 가능
                if(nx >=0 && ny >= 0 && nx < n && ny<m && tomato[nx][ny] == 0 ){
                    tomato[nx][ny] = 1; // 토마토가 익음 => 방문
                    q.offer(new PointTomato(nx, ny, day+1)); // queue 에 nx, ny, 현재 날짜 +1
                    result = Math.max(result, day+1); // 결과 값에 result 와 현재 날짜 +1 중 큰 값을 비교

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();

        tomato = new int[n][m]; // 토마토 배열
        boolean flag = false; // 익어야하는 토마토가 있는지 확인하기 위한 flag

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int toma = scan.nextInt();
                tomato[i][j] = toma; // 배열에서 하나를 꺼내서 저장

                if(toma == 1){
                    // 하나를 꺼냈을 때 1이면 queue 에 넣기 => 왜냐하면 배열의 위치가 어디던 상관없이
                    // 익은 토마토 인 1부터 시작해서 다른 토마토가 익어야 함으로
                    q.add(new PointTomato(i, j, 0));
                }else if(toma==0){
                    // 만약 0이 하나라도 tomato 배열에 들어왔다면 익을 수 있는 토마토가 있는 것임으로
                    // flag 를 true 로
                    flag = true;
                }
            }
        }
        findDay();

        if(flag){ // flag 가 true 인 경우 익을 수 있는 토마토가 하나라도 있는 것임으로 최대 일 수 꼐산
            result = Math.max(result, new PointTomato().day);
        }else{
            // flag 가 false 인 경우 1 과 -1 만 들어가 있는 상태, 따라서 모든 토마토가 익은 토마토!!
            // 따라서 결과값은 0
            result = 0;
        }

        // 만약 메서드 실행후에도 tomato 배열안에 0이 하나라도 있는 경우 => 익을 수 있는 토마토가 남아있는 경우
        // 토마토가 모두 익지 못하는 상황임으로 결과값은 -1
       for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (tomato[i][j] == 0) {
                    result = -1;
                    break;
                }
            }
        }


        System.out.println(result);
    }
}

class PointTomato {
    int x, y;
    int day = 1;
    PointTomato(){};
    PointTomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
