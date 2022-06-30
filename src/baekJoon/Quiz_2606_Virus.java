package baekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz_2606_Virus {

    static int vex, edge;

    static int count = 0;
    static boolean[] ch;
    static int[][] graph;

    public static void dfs(int n) {

//            System.out.println(n);
        ch[n] = true;


        for (int i = 1; i <= vex; i++) {
//            System.out.println(i + " : " + n);

            if (graph[n][i] == 1 && !ch[i]) {
                System.out.println(i + " : " + n);

                count++;
                dfs(i);
            }
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        vex = scanner.nextInt();
        edge = scanner.nextInt();

        ch = new boolean[vex + 1];
        graph = new int[vex + 1][vex + 1];
//        Arrays.fill(ch, false);


        for (int i = 0; i < edge; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();


            graph[num1][num2] = graph[num2][num1] = 1;

        }

        //ch[1] = true;
        dfs(1);
        System.out.println(count);

    }
}
