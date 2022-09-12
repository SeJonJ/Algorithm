package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11404
// 플로이드 와샬 알고리즘 풀이 문제
// 플로이드 와샬 알고리즘의 포인트는 3중 반복문을 사용한다는 점!!
// 때문에 시간 복잡도가 O(n^3) 이기 때문에 그래프가 커질수록 계산이 오래걸린다
public class Quiz_11404 {
    // 생각없이 MAX_VAL 로 했더니 오버플로 발생ㅠ
    static final int INF = 987654321;
    static int[][] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];


        makeGraph(n, m);
        floydWarshall(n);

    }

    static void makeGraph(int n, int m) throws IOException {
        StringTokenizer st;

        // 거리 계산을 위한 arr 배열을 가장 큰 값으로 초기화 한다.
        // 이는 결국 각 노드에 도착하는 최소 비용 을 찾기 위함이기 때문에
        // 처음에는 가장 큰 값으로 초기화 후 최소값을 비교해서 찾기 위해서 이다.
        for (int i = 1; i<= n; i++) {
            for (int j = 1; j<=n; j++) {
                arr[i][j] = INF;

                if(i == j){
                    arr[i][j] = 0;
                }
            }
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 출발 도시와 도착 도시가 같지만 다른 입력값이 들어올 수 있다
            // 즉 1 4 1 과 1 4 2 가 동시에 입력값이 될 수 있다.
            // 이때 우리는 1 4 1 을 선택해야 한다.
            arr[a][b] = Math.min(arr[a][b], c);
        }

    }

    static void floydWarshall(int n){
        StringBuilder sb = new StringBuilder();

        // 플로이드 와샬 알고리즘 시작
        for (int k = 1; k<=n; k++){ // 중간에 경유하는 노드에 대해서 계산하기 위한 for 문
            for (int i = 1; i<=n; i++){ // 출발지 for 문
                for(int j = 1; j<=n; j++){ // 도착지 for 문
                    // 최단경로 초기화
                    // 출발지 i 에서 도착지 j 로 직행하는 cost 보다
                    // 경유지 k 를 거치는 경우가 더 작다면 해당 값을 arr 배열에 갱신
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        // 출력
        for (int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                // 갈 수 없는 곳은 0 으로 초기화
                if(arr[i][j] == INF){
                    arr[i][j] = 0;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
