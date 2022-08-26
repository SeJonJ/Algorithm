package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2292
public class Quiz_2292 {

    // 시작 지점은 1 , 이웃하는 방의 범위와 이에 따른 벌집의 갯수는 아래와 같다.
    // 벌집이 6개씩 증가한다.
    // 2 ~ 7 => 2번 벌집 6개 -> 범위 최소값 2
    // 8 ~ 19 => 3번 벌집 12개 -> 범위 최소값 8
    // 20 ~ 37 => 4번 벌집 18개 -> 범위 최소값 20
    // 38 ~ 61 => 5번 벌집 24개 -> 범위 최소값 38
    // 범위 => cnt번 벌집 (cnt-1)*6 개 -> 범위 최소값 range

    // 위의 계산식을 생각해보면 n 번방까지 움직이는 거리는 n 번 방이 있는 최소 범위를 찾아서 계산하면 된다.
    // 즉 범위 최소값인 range 를 기준으로
    // range > n 이면 현재 cnt 를 return 하고
    // range <= n 이면 range > n 가 될 때까지 계산한 후 계산된 cnt 를 return 한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(findCnt(n, 2, 1));

    }

   // range : 범위 최소값 => 2부터 시작하는 이유는 1번 방을 떠나서 처음 도달할 수 있는 방 범위의 최소값이 2 임으로
    static int findCnt(int n, int range, int cnt){

        // n == 1 이면 현재 시작한 방만 포함해서 cnt 값을 바로 return 한다.
        if (n == 1) {
            return cnt;

        }else{ // 만약 다른 n!=1 이라면
            // range > n 가 될때까지 range 와 cnt 계산

            // 2 + 6*1 <= 13 이 true 임으로 while 가 다시 돌고
            // cnt++ 되서 cnt = 2 가 된다.

            // 2+6*2 <= 13 는 false 임으로 while 문이 돌지 않고 cnt = 2 가 return 된다.
            while (range <= n) {
                // 범위는 2 + 6*cnt
                // EX) n == 13 이라면


                range = range + (6 * cnt);
                cnt++;
            }
        }

        return cnt;
    }
}
