package baekJoon;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2606
public class Quiz_2606_Virus {

    static int vex, edge; // vex 는 컴퓨터 edge 는 컴퓨터와 연결된 네트워크의 수

    static int count = 0; // 최종 감염된 컴퓨터의 갯수
    static boolean[] ch; // 방문한 컴퓨터 배열
    static int[][] graph; // 컴퓨터간 연결된 네트워크 구조

    public static void dfs(int n) {

//            System.out.println(n);
        ch[n] = true; // n 번째 컴퓨터에 방문함


        for (int i = 1; i <= vex; i++) { // 1번째 컴퓨터부터 전체 컴퓨터에 대해서 탐색 시작
//            System.out.println(i + " : " + n);

            if (graph[n][i] == 1 && !ch[i]) { // 해당 컴퓨터에는 방문하지 않아야 하며, 컴퓨터끼리 연결되어있어야함
                // 즉 ch 배열에서 해당 컴퓨터는 false 이여야하고, graph 에서는 값이 있어야함
//                System.out.println(i + " : " + n);

                count++; // 방문가능 -> 감염된 경우 count+1
                dfs(i); // 현재 방문한 n 번째 컴퓨터 말고 n 번째와 연결된 i 번째 컴퓨터에 방문함
            }
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        vex = scanner.nextInt();
        edge = scanner.nextInt();

        ch = new boolean[vex + 1]; // 1번째 컴퓨터부터 계산해야함으로 입력받은 컴퓨터의 수 +1 배열
        graph = new int[vex + 1][vex + 1];
//        Arrays.fill(ch, false);


        for (int i = 0; i < edge; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            // 컴퓨터의 1과 4가 연결된 것이나 4와 1이 연결된 것이나 같은 의미 임으로
            // 1 번 컴퓨터와 4번 컴퓨터가 들어오면 1,4 도 1로 두고, 4,1 도 1로 둠
            // 즉 1,4 와 4,1 이 연결된 것을 확인가능
            graph[num1][num2] = graph[num2][num1] = 1;

        }

        //ch[1] = true;
        dfs(1);
        System.out.println(count);

    }
}
