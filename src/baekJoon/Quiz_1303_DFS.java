package baekJoon;

import java.io.*;
import java.util.*;

public class Quiz_1303_DFS {
    static int[] dx = {0, 0, -1, 1}; // x 좌표로 움직이기 배열
    static int[] dy = {-1, 1, 0, 0}; // y 좌표로 움직이기 배열

    static int[][] battle; // 싸움영역 배열

    static int n, m; // 각각 가로, 세로 ==> y, x
    static int b, w; // b 는 적군, w 는 아군의 총 전투력
    static int cnt; // 최대로 연결된 병사들의 수를 확인하기 위한 cnt

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 열 = col = 가로의 크기 = x
        m = Integer.parseInt(st.nextToken()); // 행 = row = 세로의 크기 = y


        battle = new int[m][n]; // 이중 for문은 [row][col] => y,x

        // 이중 for 문 시작
        // 입력받은 글자가 W 라면 1, B 라면 2로 배열에 저장
        for(int i=0; i<m; i++){ // 바깥 for 문은 세로의 크기 = row = y
            char[] arr = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(arr));
            for (int j = 0; j < n; j++) { // 안쪽 for문은 가로의 크기 = col = x
                if (Objects.equals(arr[j], 'W')) { // 만약 입력받은 글자가 W 라면 1
                    battle[i][j] = 1;
                }else if(Objects.equals(arr[j], 'B')){ // 만약 입력받은 글자가 B 라면 2
                    battle[i][j] = 2;
                }
//                System.out.print(battle[i][j]+" ");
            }
//            System.out.println();
        }

        // 역시 이중 for 문 시작
        // 만약 battle[i][j] 의 값이 1이나 2라면 해당 좌표를 방문한다.
        // 이때 현재 어떤 값을 기준으로 방문했는지 확인하기 위해서 findPower 에 1이나 2를 들고 방문하게 된다.
        // 방문 후에는 해당 좌표를 0 으로 변경해준다.
        // 이후 메서드가 종료되면 cnt 값을 제곱후 w 나 b 에 더한다.
        for(int i=0; i<m; i++){
            int result = 0; // 결과 변수 안쪽 for 문이 한번 끝날때마다 초기화
            for(int j=0; j<n; j++){
                cnt = 1;

                if (battle[i][j] == 1) { // 1을 확인후
                    battle[i][j] = 0;  // 방문하고 0 으로 변경
                    findPower(i, j, 1); // 현재 i, j 값을 갖고 방문
                    result = (int) Math.pow(cnt, 2);
                    w+=result;
                } else if(battle[i][j] == 2){
//                    System.out.println(i + " " + j);
                    battle[i][j] = 0;
                    findPower(i, j, 2);
                    result = (int)Math.pow(cnt, 2);
                    b+=result;
                }
            }
        }
        bw.append(w+" "+b);
        bw.flush();
        bw.close();


    }

    // DFS 시작
    // DFS 에서 중요한 것은 받아오는 i, j 가 단순히 x, y 순서가 아닌 y, x 순서라는 점에 주의한다.
    // 때문에 battle[ny][nx] 를 기준으로 비교를 해야한다.
    // nx, ny 는 0 보다 커야하며 각각 nx 는 n 보다 작아야하고, ny 는 m 보다 작아야한다.
    // 또한 내가 다음 방문하는 곳인 battle[ny][nx] 는 num 이여야한다.
    // 왜냐하면 앞서서 num 인 곳은 기준으로 방문했기 때문에 같은 색 - 같은 num - 인 경우에만 방문 할 수 있다
    static void findPower(int y, int x, int num){

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && battle[ny][nx] == num) {
                battle[ny][nx] = 0;
                cnt++;
                findPower(ny, nx, num);


            }
        }
    }
}