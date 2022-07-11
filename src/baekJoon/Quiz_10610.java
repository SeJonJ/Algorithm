package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz_10610 {
    static int[] list = {300, 60, 10};
    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 10 != 0) {
            System.out.println(-1);
        } else {

            for (int i = 0; i < 3; i++) {
                if (list[i] <= n) {
                    arr[i] = n / list[i];
                    n = n % list[i];
//                System.out.println("n : " + n);

                }
                System.out.print(arr[i] + " ");
            }
        }
    }
}
