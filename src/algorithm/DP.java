package algorithm;

// Dynamic Programming - 동적 프로그래밍
// 동적 프로그래밍은 복잡하거나 계산할것이 많은 문제를 보다 작은 단위로 쪼갠 후
// 작은 단위에 대한 답을 기억해두면서 전체 문제를 풀어가는 방법!!

// 문제
// 첫째줄에 계단의 갯수인 자연수가 주어진다. 이때 마지막 계단까지 올라가는 방법의 수를 출력하라
// 이때 계단은 한번에 한 계단 또는 두 계딴씩 오를 수 있다
// 이 문제를 DP 를 활용해서 풀어보면 각 계단을 오르는 방법의 수는 다음과 같다.
 /*
 * 1번 계단 - 1
 * 2번 계단 - 2
 * 3번 계단 - 3(1+2)
 * 4번 계단 - 5(2+3)
 * ----- 피보나치 수열과 같다 ------->
 * i 번째 계단 - i-2 번째 계단까지의 방법 수 + i-1번째 계단까지의 방법의 수
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP {
    static int[] dy;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dy = new int[n+1];

        System.out.println(sol());
    }

    static int sol(){
        dy[1] = 1;
        dy[2] = 2;

        for(int i=3; i<=n; i++){
            dy[i] = dy[i-2]+dy[i-1];
        }

        return dy[n];
    }
}
