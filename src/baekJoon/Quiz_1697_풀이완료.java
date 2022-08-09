package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Quiz_1697_풀이완료 {

    static int n, k;

    static int minTime = Integer.MAX_VALUE;
    static int cnt = 0;
    static int[] ch = new int[100001];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(ch, 0);

        // 입력받은 n 이 k 보다 크거나 같다면, n-k !!
        // n 이 k 보다 클때 n 이 k 에 도달하기 위해 할 수 있는 연산은 -1 하나뿐이다.
        // 따라서 결국 n 에서 k 까지 -1 을 몇번이나 하는가? 가 답이된다.
        if (n >= k) {
            System.out.println(n - k);
        }else{
            // 아니라면
            // ch 배열에 n 번째 인덱스에 1을 넣고
            // queue 에 n 을 넣고 findBrother 실행!
            ch[n] = 1;
            q.offer(n);

            findBrother();
        }



    }

    static void findBrother() {

        while (!q.isEmpty()) {

            int sum = q.poll(); // q에서 하나의 값 빼내기

            // sum+1, sum-1, sum*2 중 하나의 연산이라도 k 에 도달하면 종료
            if (sum + 1 == k || sum - 1 == k || sum * 2 == k) {
                System.out.println(ch[sum]); // ch[sum] 을 출력 ==> ch[sum] 안에는 시간값이 들어가 있음
                return;
            }


            // 아래의 연산은 모두 동일한 내용
            // +1, -1, *2 했을때 각각 0보다 크거나 같고, 100000보다 작거나 같아야함
            // 동시에 ch[sum+1, sum-1, sum*2] 의 값이 0 이여야함
            // 이는 배열의 초기값이 0 임으로 0 이 아닌 다른 숫자가 들어온 경우 해당 배열을 이미 방문했기 때문에
            // 재방문하여 queue 에 넣을 필요가 없기 때문.

            // 또한 ch 배열에 들어가는 값은 현재 ch[sum] 값의 +1
            // 이는 ch[sum] 의 값이 현재까지 몇번 움직였는지 알 수 있는 값이기 때문
            if (sum +1 <= 100000 && ch[sum + 1] == 0) {
                ch[sum + 1] = ch[sum] + 1;
                q.offer(sum + 1);
            }
            if (sum - 1 >= 0 && ch[sum - 1] == 0) {
                ch[sum - 1] = ch[sum] + 1;
                q.offer(sum - 1);
            }
            if (sum * 2 <= 100000 && ch[sum * 2] == 0) {
                ch[sum * 2] = ch[sum] + 1;
                q.offer(sum * 2);
            }


        }

    }
}
