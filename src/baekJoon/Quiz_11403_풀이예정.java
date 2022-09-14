package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11403
// 플로이드 와샬
public class Quiz_11403_풀이예정 {
    static int[][] graph;
    static int[][] map;
    static int[] dis;
    static int INF = 987654321;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        map = new int[n][n];
        dis = new int[n];

        Arrays.fill(dis, INF);

        makeGraph(n);
        floydWarshall(n);
    }

    static void makeGraph(int n) throws IOException {
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void floydWarshall(int n){
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dis[i] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        System.out.println(Arrays.toString(dis));
    }
}
