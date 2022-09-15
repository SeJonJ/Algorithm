package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/11403
// 플로이드 와샬
public class Quiz_11403 {
    static int[][] graph;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        makeGraph(n);
        floydWarshall(n);
    }

    static void makeGraph(int n) throws IOException {
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;

            }
        }
    }

    // 문제에서 이야기하는 i 에서 j 로 가는 간선이 존재할때 i 번째 줄의 j 번째 숫자를 1로 하라는 말의 의미는
    // 결국 i 에서 시작해서 j 로 갈 때 중간 지점인 k 를 거쳐서 가는 경우가 있는 경우에만 graph 를 체크해주면 된다.
    // i 에서 j 로 바로가는 경우인 graph[i][j] 는 이미 1로 초기화 되어있기 때문에 생각하지 않아도 된다.
    static void floydWarshall(int n){
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : graph) {
            Arrays.stream(arr).forEach(value -> {
                sb.append(value + " ");
            });
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}