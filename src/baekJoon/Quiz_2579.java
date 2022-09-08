package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2579
// 이 문제의 포인트는 문제를 쪼개서 쉽게 생각하는 것!!
// 정확히는 문제중에서 조건을 쪼개고 연결시켜서 다 쉽게 생각하는것이 중요하다.
// 조건 1. 현재 계단 i+1 이거나 i+2 가 가능하다.
// 조건 2. 단 계단을 i+1, i+2, i+3 순서대로 오를 수 없다. 최대 i+1, i+2 만 가능하다 => 즉 +1 은 최대 2번만 가능하다
// 조건 1과 2를 연계해서 생각해보면 결국 i 라는 계단에 도달하는 방법은 2가지 밖에 없다.
// ===> 방법 1 : (i-3) -> (i+1) -> i 순서 => 여기는 한칸 전 계단에서 i 계단으로 올라가는 경우
// ===> 방법 2 : (i-2) -> i 순서  => 여기는 2칸 전 계단에서 i 계단으로 올라가는 경우
public class Quiz_2579 {
    // sumArr 은 i 번째 계단까지 올라갔을 때 최대 합계
    // stairArr 은 i 번째 계단의 점수
    static int[] stairArr, sumArr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        stairArr = new int[n+1];
        sumArr = new int[n+1];

        for(int i=1; i<=n; i++){
            stairArr[i] = Integer.parseInt(br.readLine());

        }

        stair(n);
    }

    static void stair(int n){

        sumArr[1] = stairArr[1];

        // n 이 1 인 경우는 그냥 바로 입력된 값을 출력
        if (n == 1) {
            System.out.println(stairArr[1]);

        }else{ // 1이 아닌 경우에만 2번째 계단값을 도출 후 계산
            sumArr[2] = sumArr[1]+stairArr[2];

            for(int i=3; i<=n; i++){
                // 현재 i 번째 계단까지의 최대 합계는 => i 번째 계단을 오를 수 있는 경우의 수는
                // i-2 번째 계단에서 i번째 계단으로 올라가는 경우 => sumArr[i-2]
                // i-3 번째 계단에서 i-1 번째 계단으로가서 다시 i 번째 계단으로 가는 경우 => sumArr[i-3]+stairArr[i-1]
                // 두 가지 경우에서 더 큰 값을 확인 한 후 여기서 i 번째 계단의 점수를 더한다 => 마지막조건, i번째 계단은 반드시! 밟아야한다.
                sumArr[i] = Math.max(sumArr[i-2], sumArr[i-3]+stairArr[i-1]) + stairArr[i];
            }

            System.out.println(sumArr[n]);
        }
    }
}


