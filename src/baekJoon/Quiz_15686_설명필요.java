package baekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Quiz_15686_설명필요 {
    static int n;
    static int m;

    static ArrayList<CityPoint> house = new ArrayList<CityPoint>();
    static ArrayList<CityPoint> chicken = new ArrayList<CityPoint>();

    static int result = Integer.MAX_VALUE;

    static void deliver(boolean[] check, int[] combi, int cnt, int idx) {
        if ( cnt == m) {
            int sum = 0;

            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();

            for (CityPoint hou : house) {
                int dis = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (check[j]) {
                        CityPoint sh = chicken.get(j);

                        dis = Math.min(dis, Math.abs(hou.x - sh.x) + Math.abs(hou.y - sh.y));
                    }

                }
                sum += dis;

            }
            result = Math.min(sum, result);
            return;

        }

        for (int i = idx; i < check.length; i++) {
            if (!check[i]) {
                check[i] = true;
                combi[cnt] = i;
                deliver(check, combi, cnt + 1, i + 1);
                check[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    house.add(new CityPoint(i, j));
                } else if (num == 2) {
                    chicken.add(new CityPoint(i, j));
                }
            }
        }

        boolean[] check = new boolean[chicken.size()]; // 방문 배열
        int[] combi = new int[m]; // 조합 배열


        deliver(check, combi, 0, 0);
        bw.write(result + "\n");
        //System.out.println(result);
        bw.flush();
        bw.close();
        br.close();
    }
}

class CityPoint {
    int x, y;

    CityPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


