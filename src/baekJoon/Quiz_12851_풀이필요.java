package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 참고
// https://velog.io/@undefcat/%EB%B0%B1%EC%A4%80-12851-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88-2

public class Quiz_12851_풀이필요 {
    static int n, k;
    static int[] arr = new int[100001];
    static Queue<Integer> q = new LinkedList<Integer>();
    static int min = Integer.MAX_VALUE;
    static int cnt = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, 0);

        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
        } else {
            q.add(n);
            arr[n] = 1;
            findBrother2();
            System.out.println(min);
            System.out.println(cnt);
        }
    }

    // +1 과 *2 는 서로 다르다!
    static void findBrother2() {
        while (!q.isEmpty()) {
            int dis = q.poll();

            if (arr[dis] > min) {
                continue;
            }

            if (dis + 1 == k || dis - 1 == k || dis * 2 == k) {
                min = Math.min(arr[dis], min);
            }

            if (dis - 1 >= 0) {
                arr[dis - 1] = arr[dis] + 1;
                q.add(dis - 1);
            }
            if (dis + 1 <= 100000 && arr[dis + 1] == 0) {
                arr[dis + 1] = arr[dis] + 1;
                q.offer(dis + 1);
            }
            if (dis * 2 <= 100000 && arr[dis * 2] == 0) {
                arr[dis * 2] = arr[dis] + 1;
                q.add(dis * 2);
            }

            if (q.contains(dis - 1) && arr[dis] == arr[dis - 1] || q.contains(dis + 1) && arr[dis] == arr[dis + 1] || q.contains(arr[dis * 2]) && arr[dis] == arr[dis * 2]) {

            }
        }
    }
}
