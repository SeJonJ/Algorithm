package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Quiz_2468 {
    /*
    입력
    첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다.
    N은 2 이상 100 이하의 정수이다. 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다.
    각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다.
    높이는 1이상 100 이하의 정수이다.

    출력
    첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.

    풀이 방법 : 아래 사항들이 특히 중요하다
    1. 입력받는 방법은 이전의 섬의 갯수 구하기 문제와 동일!! => 전체 배열 1개와 방문하기 위한 ch 배열 하나 생성
    2. 탐색 방법도 마찬가지로 ch 배열 - 아래에서는 arr 배열 - 이 1 인 경우 방문 후 0 으로 변경 후 nx , ny 지점으로 이동
        이것을 dx , dy 배열만큼 반복
    3. 여기서 부터 매우 중요!!!
        섬 탐색 문제와는 다르게 탐색하기 위한 arr 배열이 계속 변한다.
        왜냐하면 문제에서 내리는 비의 양을 지정해주지 않았기 때문에 내릴 수 잇는 비의 양은
        최소 높이보다 크고, 최대 높이 만큼 내릴 수 있다는 가정하에 문제에서 제시한 내리는 비의 양보다 큰 높이의 경우 1로 두고, 낮은 경우 0 으로 둔다
    4. 무엇보다 비가 내리지 않는 경우!! 를 생각해야 한다. 즉 내리는 비가 0 인 경우 모든 지점이 물에 잠기지 않게 되고,
        물에 잠기지 않는 최대 크기는 1 이 된다 => 이 부분을 해결하기 위해 코드에서는 flag 를 만들어 한 영역이라도 물에 잠기는 경우
        즉 arr 배열이 0 이 되는 경우 flag 를 true 로 바꾸고 계속 1만 들어오는 경우 -> 모든 지점이 물에 잠기지 않기 때문에
        그냥 1을 return 하도록 하였다.

    * */

    static int n;
    static int[][] area; // 안전영역 배열
    static int[][] arr; // 안전확인(방문가능) 배열
    static int result = Integer.MIN_VALUE; // 안전 영역 최대값 계산하기 위한 변수

    static Queue<Safe> q = new LinkedList<>(); // bfs 를 위한 q
    static int[] dx = {-1, 1, 0, 0}; // 이동좌표
    static int[] dy = {0, 0, 1, -1}; // 이동좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE; // 최대값
        int min = Integer.MAX_VALUE; // 최솟값

        area = new int[n][n];
        arr = new int[n][n];

        for (int i = 0; i < area.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < area[i].length; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num); // 최대로 내릴 수 있는 비의 양 구하기
                min = Math.min(min, num); // 최소로 내릴 수 있는 비의 양 구하기

                area[i][j] = num; // area 에 들어오는 값 담기
//                System.out.println(area[i][j]);
            }
//            System.out.println();
        }
        // 여기서 i 는 최소로 내릴 수 있는 비의 양과 최대로 내릴 수 있는 비의 양만큼을 의미
        // 여기서 정말 중요한게 모든 영역이 잠기지 않는 경우 == 비가 내리지 않는 경우도 있을 수 있음
        // 따라서 비의 양 최소값 = 0 이 됨
        for (int i = 0; i <= max; i++) {
//            System.out.println(findSafe(i));
            // 기존 result 값과 findSafe에서 return 된 값을 비교해서
            // 최대값 담기
            result = Math.max(result, findSafe(i));
        }
        System.out.println(result);
    }

    static int findSafe(int n) {

        int cnt = 0; // 현재 안전 영역의 수
        boolean flag = false; // 물에 잠기는 영역이 있는지 여부를 확인하기 위한 변수

        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
//                System.out.print(arr[i][j]+" ");
                // area[i][j] 의 값이 현재 비의 양 n 보다 크다면
                // arr[i][j] 안전확인 배열에 1을 넣어줌

                // 이때 area[i][j] 에 단 한 번이라도 0 이 오는 경우는 물에 잠기는 영역이 생기게 되는 것이고
                // 이에 따라서 flag 를 true 로 변경
                // 만약 area[i][j] 가 모두 1 이 오는 경우 == 모든 영역의 높이가 현재 비가오는 양보다 높은 경우
                // flag 는 그대로 false 가 오게 되고 이에 따라서 return 값은 1로 고정한다
                if (area[i][j] > n) {
//                    System.out.println(flag);
                    arr[i][j] = 1;

                } else {
                    flag = true;
                    arr[i][j] = 0;
                }
            }
        }

        // 만약 flag 가 false 면 그냥 1 return
        if(!flag){
            return 1;
        }

        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {

                // area[i][j] 이 n 보다 크고, arr[i][j] 가 1인 경우 방문
                if (area[i][j] > n && arr[i][j] !=0) {
                    q.add(new Safe(i, j)); // 해당 i, j 를 Safe 클래스를 통해서 Queue에 저장
                    cnt++; // 현재 area[i][j] 가 1이면 비가 내리는 양보다 높음으로 cnt 증가
                    arr[i][j] = 0; // arr 배열의 0으로 변경
                    bfs(arr);
//                    System.out.println("cnt : " + cnt);
                }
            }
        }

        return cnt; // 현재 cnt return

    }

    static void bfs(int[][] arr) {
        while (!q.isEmpty()) { // queue 가 비어있는 동안 while 문 실행
            Safe s = q.poll(); // q 에서 하나 빼오기

            for (int i = 0; i < 4; i++) { // 움직이기 위한 for 문
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                // nx, ny 가 0 이상이고, n보다 작으며, arr[nx][ny] 가 0 이 아닌 경우만 반복
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] != 0) {
                    arr[nx][ny] = 0;
                    q.offer(new Safe(nx, ny));
                }
            }
        }
    }
}

class Safe {
    int x, y;

    Safe(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
