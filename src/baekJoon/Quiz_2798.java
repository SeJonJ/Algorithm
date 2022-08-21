package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz_2798 {
    static int n, m;
    static int result = Integer.MIN_VALUE;

    // 입력받은 카드 배열
    static int[] arr;
    // 합계를 위해 방문한 카드를 체크하기 위한 배열
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

    // 이 문제에서 중요한 것은 카드를 꼭 3개를 뽑아야하고
    // 3개의 카드의 합이 m 보다 작을때, 클때, 같을 때를 나눠서 계산해야한다는 점이다.
    static int findNum ( int[] arr, int sum, int cnt){

        // sum 값이나 cnt 값이 각각 m 보다 크거나, 3 보다 크다면(3보다 큰 경우는 4개 이상의 카드의 합을 계산하는 경우임으로)
        if (sum > m || cnt > 3) {
            // 0 을 return
            return 0;

            // 만약 sum 이 m 과 동일하고, 동시에 cnt == 3 과 동일하다면
            // 즉 sum 으로 블랙잭이 나오고, 카드를 3개를 뽑은 경우라면
            // result 에 sum 을 담아서 return
        } else if (sum == m && cnt==3) {
            result = sum;
            return result;

            // 만약 sum 이 m 보다 작은데 카드는 3개를 봅은 경우라면
            // sum 과 result 를 비교해서 result 담아서 return
        } else if (sum < m && cnt == 3) {

            result = Math.max(sum, result);
            return result;

        } else {
            // cnt 가 3 이 안된 경우라면 for 문 진행
            for (int i = 0; i < n; i++) {
                // chk[i] 가 false 경우만 해당 카드의 숫자를 뽑는다
                if (!chk[i]) {
                    // chk[i] 번째 즉, arr[i] 번째 카드에 방문하면 방문했다고 표시하고,
                    chk[i] = true;
                    // sum 에는 현재 카드를 더하고, cnt 는 +1 한다.
                    findNum(arr, sum + arr[i], cnt+1);
                    // DFS 에서 빠져나왔다면 chk[i] 카드, arr[i] 카드를 false 로 바꾼다.
                    // 이는 추후 동일한 카드에 다시 방문할 수 있도록 하기 위함이다.
                    // 예를들어 뽑은 카드가 5,6,7 이라면 이 카드가 계속 true 인 상태가 아니라 false 여야만
                    // 추후 6,7,8 로 다시 합계를 계산할 수 있기 때문!!
                    chk[i] = false;

                }
            }
        }

        return result;
    }
}
