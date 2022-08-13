package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Quiz_13549 {
    static int n, k;
    static int[] arr = new int[100001]; // 방문 시간 저장 배열
    static int result = Integer.MAX_VALUE; // 최솟값 체크 변수
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 배열 전체를 -1 로 초기화
        // -1 로 초기화하는 이유는 n*2 했을 때 이전 문제와는 다르게 가중치가 +1 이 아닌 0 이기 때문
        // 따라서 0 초가 존재하기 때문에 이를 계산하기 위해서 -1로 초기화
        Arrays.fill(arr, -1);

        if (n >= k) {
            System.out.println(n - k);
        }else{
            q.offer(n);
            arr[n] = 0;
            System.out.println(findBrother3());
        }
    }

    static int findBrother3(){
        while (!q.isEmpty()) {
            int num = q.poll();

            // 만약 현재 q에서 빼왔던 arr[num] 의 값이 현재 result 보다 크다면 더 이상 계산할 필요도 없이
            // continue;
            if (result < arr[num]) {
                continue;
            }

            // move 배열은 이동값과 이동 시간(초)를 설정한 2차원 배열
            // num-1, num+1 은 1초, num*2 는 0 초가 걸린다
            int[][] move = {
                    {num-1, 1},
                    {num+1, 1},
                    {num*2, 0}
            };

            // move 배열에서 값을 얻어오기 위한 for문 실행
            for(int i=0; i<3; i++){
                int next = move[i][0]; // 이러면 next 값은 num+1, num-1, num*2 중 하나가 된다

                if (next == k) { // next 값이 k 와 일치하면
//                    return arr[num]+move[i][1];
                    // 이전에 방문했었던 arr[num] 에 num+1, num-1, num*2 에 맞는 가중치를 더한다.
                    // 즉 num+1, num-1 은 arr[num]+1 이 될 것이고, num*2 의 경우에는 arr[num]+0 이 될 것이다.
                    // 이후 result 와 최솟값을 비교해서 저장
                    result = Math.min(result, arr[num]+move[i][1]);

                    // next 값이 k 와 일치하지 않고, next >= 0, next <= 100000 이 만족하는 상황이라면
                    // 총 2가지 경우에 대해서 생각한다.
                    // 첫째로 arr[next] 에 방문하지 않은 경우 => arr[next] = -1 인 경우에는 방문후 queue 에 next 를 넣고, arr[next] 의 방문시간을 표시한다
                    // 다음으로 arr[next] 에 이미 방문한 경우 => arr[next] != -1 인 경우에는
                    // arr[next] 가 arr[num]+move[i][1] 보다 큰 수 인지 여부를 확인하고,
                    // 만약 arr[next] 보다 arr[num]+move[i][1] 이 작은 경우 해당 next 좌표에 재방문 후 arr[next] 값을 수정한다.

                    // 이는 4->9 가 주어졌을 때 9 이전 좌표인 8 이라는 좌표에 도착하기 위한 경우를 생각하면 된다.
                    // 4->3->6->7->8 : 총 3초 =
                    // 4->5->6->7->8 : 총 4초
                    // 4->8 : 총 0초
                    // 결국 arr[8] 의 최솟값은 0 이 되고, 8->9 까지는 1 초 임으로
                    // 답은 1초가 된다.
                }else if (next >= 0 && next <= 100000 && (arr[next] == -1 || arr[next] > arr[num]+move[i][1]) )  {
                    q.offer(next);
                    arr[next] = arr[num] + move[i][1];
                }

            }
        }

        return result;
    }
}
