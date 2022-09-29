package programmers;

import java.util.Arrays;

public class LV2_16_틀림 {

    public static void main(String[] args) {
        int answer = 0;

        sol(5000);
    }

    static void sol(int n) {
        int[] dis = new int[n + 1];
        int cnt = 0;

        Arrays.fill(dis, 987654321);


        dis[0] = 0;
        dis[1] = 1;
//        dis[2] = 1;
//        dis[3] = 2;
//        dis[4] = 1;
//        dis[5] = 2;
//        dis[6] = 2;

        while (n != 0) {
            if (n % 2 == 0) {
                n = n/2;
            }else{
                n = n-1;
                cnt++;
            }
        }


        System.out.println(cnt);

    }
}
