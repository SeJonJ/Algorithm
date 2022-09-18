package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_1516_풀이중 {
    static int n;
    static ArrayList<ArrayList<Integer>> building;
    static int[] time;
    static int[] result;
    static Queue<Integer> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {


        n = Integer.parseInt(br.readLine());
        building = new ArrayList<>();
        time = new int[n+1];
        result = new int[n + 1];
        Arrays.fill(result, 0);


        makeGraph();
        for(int i=2; i<=n; i++){
            if(result[i] !=0) continue;

            findTime(i);
        }

        Arrays.stream(result).forEach(i -> {
            if (i != 0) {
                System.out.println(i);
            }
        });

    }

    static void makeGraph() throws IOException {
        for(int i=1; i<=n; i++){
            building.add(new ArrayList<>());
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            // 시간 저장
            time[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if (n != -1) {

                    // 간선 저장
                    building.get(n).add(i);
                }
            }


        }

//        System.out.println(Arrays.toString(time));
//
//        System.out.println(Arrays.toString(building));
    }


    static void findTime(int n) {


    }

}
