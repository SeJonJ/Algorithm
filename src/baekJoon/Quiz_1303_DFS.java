package baekJoon;

import java.io.*;
import java.util.*;

public class Quiz_1303_DFS {
    static int[] dx = {0, 0, -1, 1}; // x 좌표로 움직이기 배열
    static int[] dy = {-1, 1, 0, 0}; // y 좌표로 움직이기 배열

    static int[][] battle; // 싸움영역 배열

    static int n, m; // 각각 가로, 세로 ==> y, x
    static int b, w; // b 는 적군, w 는 아군의 총 전투력
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로

        battle = new int[n][m]; // (y,x)

        for(int i=0; i<n; i++){ //
            char[] arr = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(arr));
            for (int j = 0; j < m; j++) { //
                if (Objects.equals(arr[j], 'W')) { // 만약 입력받은 글자가 W 라면 1
                    battle[i][j] = 1;
                }else if(Objects.equals(arr[j], 'B')){ // 만약 입력받은 글자가 B 라면 2
                    battle[i][j] = 2;
                }
//                System.out.print(battle[i][j]+" ");
            }
//            System.out.println();
        }

        //
        //
        for(int i=0; i<n; i++){
            int result = 0; // 결과 변수
            for(int j=0; j<m; j++){
                cnt = 1;

                if (battle[i][j] == 1) {

                    battle[i][j] = 0;
                    findPower(i, j, 1);
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

    // BFS 배열
    static void findPower(int y, int x, int num){

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && battle[ny][nx] == num) {
                battle[ny][nx] = 0;
                cnt++;
                findPower(ny, nx, num);


            }
        }
    }
}