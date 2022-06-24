package baekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz_2606_XXXX {

    static int vex, edge;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    static int count = 0;
    static boolean[] ch;

    public static void dfs(int n) {
        //System.out.println(n + " : " + vex);

        for (Integer g : graph.get(n)) {
            if (!ch[g]) {
                ch[g] = true;
                count++;
                dfs(g);
            }
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        vex = scanner.nextInt();
        edge = scanner.nextInt();

        ch = new boolean[vex + 1];

        for (int i = 0; i < vex; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edge; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            graph.get(num1).add(num2);
        }

        //ch[1] = true;
        dfs(1);
        System.out.println("count : "+count);
        System.out.println(Arrays.toString(graph.toArray()));
    }
}
