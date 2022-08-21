package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_2798 {
    static int n, m;
    static int result = Integer.MIN_VALUE;
    static int[] arr;
    static boolean[] chk;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        chk = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findNum(arr, 0, 0));


    }

    static int findNum ( int[] arr, int sum, int cnt){

        if (sum > m || cnt > 3) {
            return 0;

        } else if (sum == m && cnt==3) {
            result = sum;
            return result;

        } else if (sum < m && cnt == 3) {

            result = Math.max(sum, result);
            return result;

        } else {
            for (int i = 0; i < n; i++) {
                if (!chk[i]) {
                    chk[i] = true;
                    findNum(arr, sum + arr[i], cnt+1);
                    chk[i] = false;

                }
            }
        }

        return result;
    }
}
