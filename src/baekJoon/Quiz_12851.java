package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 참고
// https://velog.io/@undefcat/%EB%B0%B1%EC%A4%80-12851-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88-2

public class Quiz_12851 {
    static int n, k;
    static int[] arr = new int[100001];
    static Queue<Integer> q = new LinkedList<Integer>();
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;


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

            if (min < arr[dis]) {
                continue;
            }
            int[] move = {dis+1, dis-1, dis*2};

            for(int i=0; i<3; i++){
                int next = move[i];


                if (next < 0 || next > 100000) {
                    continue;
                }

                if (next == k) {
                    min = arr[dis];
                    cnt++;
                }

                // next 는 현재 위치 dis 에서 +1, -1, *2 연산한 값
                // 이 값이 0 이거나 ==> 한번도 해당 위치로 방문하지 않았거나
                // 0 이 아니고, 해당 위치에 방문했을 때의 시간이 현재 dis 위치의 시간 +1 인 경우
                // 즉 해당 위치에 이미 방문을 한 상태이며, next 에 도착했을 때 시간이 현재 dis에 도달한 시간 +1 인 경우
                // - arr[next] = arr[dis]+1 - queue 에 next 값을 넣고 arr 배열에 next 의 시간을 arr[dis]+1 로 둔다

                // 예를 들어 n = 1, k = 4 가 입력되었다고 생각해보자
                // 이때 1 -> 4 로 가는 최소 횟수는 총 2가지 이다.
                // 1->2(1+1) -> 3 -> 4
                // 1->2(1*2) -> 3 -> 4
                // 여기서 1*2 = 2 와 1+1 = 2 일 때 모두 현재 위치 1에서 단 한 번의 연산으로 2 라는 좌표에 도착할 수 있다
                // 이때 1 -> 2 로 이동하는 경우 1+1 을 먼저해서 next = 2, arr[next] = arr[dis] +1 임으로 arr[next] = 2 가 된다
                // 여기서 다시 한번 1->2 로 이동하는 1*2 를 생각해야한다. 1*2 도 1+1 과 마찬가지로 1번의 연산으로 2에 도착할 수 있다
                // 이때는 arr[next] 가 0 이 아닌 상황 - arr[next] = 2 - 일 때
                // arr[next] 의 값이 현재 위치인 1(dis) 의 값 +1 과 일치하는지, 즉 똑같이 next 라는 위치에 도달할때
                // arr[next] 에 있는 시간이 현재 위치에서의 시간+1 - arr[dis] +1 - 인지 확인해야한다.
                if (arr[next] == 0 || arr[next] == arr[dis] + 1) {
                    q.offer(next);
                    arr[next] = arr[dis] + 1;
                }
            }




        }
    }
}
