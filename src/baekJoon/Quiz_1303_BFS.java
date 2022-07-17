package baekJoon;

import java.io.*;
import java.util.*;

public class Quiz_1303_BFS {
    static int[] dx = {-1, 1, 0, 0}; // 움직임 배열 x
    static int[] dy = {0, 0, -1, 1}; // 움직이기 배열 y

    static int[][] battle; // 전투 배열

    static int n, m; // 가로, 세로
    static int b, w; // 각각 적군, 아군

    static Queue<FindFriend> q = new LinkedList<FindFriend>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 가로 = col = x
        m = Integer.parseInt(st.nextToken()); // 세로 = row = y

        battle = new int[m][n]; // new int[row][col]

        for(int i=0; i<m; i++){ // 바깥쪽 for 문은 row = 세로의 크기
            char[] arr = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(arr));
            for (int j = 0; j < arr.length; j++) { // 안쪽 for 문은 col = 가로의 크기
                if (Objects.equals(arr[j], 'W')) {
                    battle[i][j] = 1;
                }else if(Objects.equals(arr[j], 'B')){
                    battle[i][j] = 2;
                }
//                System.out.print(battle[i][j]+" ");
            }
//            System.out.println();
        }


        for(int i=0; i<m; i++){ // 바깥 for 문은 row = y = 세로의 크기
            int result = 0; //
            for(int j=0; j<n; j++){ // 안쪽 for 문은 col = x = 가로의 크기
                if (battle[i][j] == 1) {
                    q.add(new FindFriend(i,j));
                    battle[i][j] = 0;
                    result = (int)Math.pow(findPower(1, 1), 2);
                    w+=result;
                }else if(battle[i][j] == 2){
//                    System.out.println(i + " " + j);
                    q.add(new FindFriend(i,j));
                    battle[i][j] = 0;
                    result = (int)Math.pow(findPower(1, 2), 2);
                    b+=result;
                }
            }
        }
        bw.append(w+" "+b);
        bw.flush();
        bw.close();


    }

    // q가 비어있지 않은 동안 계속 반복됨
    // 움직임 배열 dx, dy 를 이용해 nx, ny 생성
    // nx, ny 는 0보다 크며, 각각 n, m 보다 작아야한다.
    // 또한 battle[ny][nx] 로 받아야한다는 것에 유의한다.
    static int findPower(int cnt, int num){
        while (!q.isEmpty()) {
            FindFriend now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && battle[ny][nx] == num) {
                    battle[ny][nx] = 0;
                    cnt++;
                    q.add(new FindFriend(ny, nx));

                }
            }
        }

        return cnt;
    }
}

class FindFriend{
    int x, y;

    FindFriend(int y, int x){
        this.x = x;
        this.y = y;
    }
}