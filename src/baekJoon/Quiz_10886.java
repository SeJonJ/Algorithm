package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz_10886 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int cnt_non = 0;

        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());

            if (m == 1) {
                cnt++;
            }else{
                cnt_non++;
            }
        }

        if (cnt > cnt_non) {
            System.out.println("Junhee is cute!");
        }else{
            System.out.println("Junhee is not cute!");
        }
    }
}
