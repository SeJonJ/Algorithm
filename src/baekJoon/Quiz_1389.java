package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1389
// 플로이드 와샬 알고리즘 풀이 문제
// 3중 for 문 사용, 갈 수 없는 곳은 INF 로 초기화, 자기자신은 0으로 초기화 하는 것을 잊지말자!
public class Quiz_1389 {
    static final int INF = 987654321;
    static int[][] friend;
    static ArrayList<Member> member = new ArrayList<>();


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        friend = new int[n+1][n+1];


        makeGraph(n, m);
        floydWarshall(n);
    }

    // 입력받은 정보로 그래프 생성
    static void makeGraph(int n, int m) throws IOException {
        StringTokenizer st;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if (i == j) {
                    friend[i][j] = 0;
                }else{
                    friend[i][j] = INF;
                }
            }
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a][b] = 1;
            friend[b][a] = 1;
        }

    }

    // 플로이드 와샬 알고리즘 수행
    static void floydWarshall(int n){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    friend[i][j] = Math.min(friend[i][j], friend[i][k] + friend[k][j]);
                }
            }
        }

        // sum 은 friend 의 합계
        // 즉 i 번째 사람의 케빈 베이컨 수의 합계
        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=1; j<=n; j++){
                 sum += friend[i][j];
            }
            member.add(new Member(i, sum));
        }

        // sum 이 다른 경우 오름차순 정렬
        // sum 이 같은 겨우 index 오름차순 정렬
        member.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.sum != o2.sum) {
                    return o1.sum - o2.sum;
                } else {
                    return o1.index - o2.index;
                }
            }
        });

        // 전체가 오름차순으로 정렬되어있음으로
        // 배열에서 0번째 값을 꺼내서 index 를 출력
        System.out.println(member.get(0).index);

    }
}

class Member{
    int sum;
    int index;

    Member(int index, int sum) {
        this.sum = sum;
        this.index = index;
    }
}