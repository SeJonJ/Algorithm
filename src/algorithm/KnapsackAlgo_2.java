package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최대 점수 찾기 - 냅색알고리즘
/*
    냅색 알고리즘은 크게 2가지로 구분 가능하다
    첫 번째는 이전의 동전 문제와 같이 내가 사용할 수 잇는 자원이 무한정인 경우와 => 거스름돈을 줄때 사용가능한 동전의 갯수 제한 없음
    두 번째는 이 문제와 같이 사용할 수 있는 자원이 제한적인 경우 => 문제를 1번만 풀 수 있음

    첫번째 문제 방식의 풀이는 증가 for 문을 사용하면 되지만
    두번째 문제 방식의 for 문은 감소 for 문을 사용해야한다

    이는 자원에 제한이 있기 때문에 중복을 없애기 위해서 이다.
* */
public class KnapsackAlgo_2 {
    static int n, m;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dy = new int[m + 1];

//        Arrays.fill(dy, -987654321);
//        dy[0] = 0;

        // i 는 그대로 0 -> n 까지 증가
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            // 점수와 시간 입력 받음
            int ps = Integer.parseInt(st.nextToken());
            int pt = Integer.parseInt(st.nextToken());

            // 자원(문제)를 한번만 풀 수 있기 때문에 문제의 중복을 방지 - 2번 이상 풀이 - 하기 위해
            // 감소 for 문을 사용

            // j 분동안 얻을 수 잇는 문제의 최대값은 j분에서 입력받은 현재 문제의 시간을 뺀 후
            // 현재 문제의 점수 ps 를 더하면 됨

            /*
                이 문제는 j 에서 현재 문제의 시간 - pt - 를 뺀 후 dy[j-pt] 햇을 때 나오는 값에서
                현재 문제의 점수를 더한 후 기존의 dy[j] 값과 비교한다.

                예를 들어 j=20, dy[j]=15, dy[8] = 5 이고 pt = 12, ps = 15 일 때
                j 분에서 현재 문제의 시간을 뺀 후 - 20-12 - 해당 시간의 dy 값을 조회한다.
                이때 dy[8] = 5 이기 때문에 8 분안에 얻을 수 잇는 최대 점수는 5가 되고,
                여기서 현재의 문제 점수 15를 더하면 총 20 이 된다.

                이때 dy[j] = 15 보다 dy[j-pt]+ps = 20 으로 더 크기 때문에
                dy[j] = 20 으로 바뀌게 된다.
            */
            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j - pt] + ps);

            }
        }

        System.out.println(dy[m]);

    }


}