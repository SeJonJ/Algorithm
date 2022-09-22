package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    여러 단위의 동전이 주어져 있을 때 거스름돈을 가장 적은 수의 동전으로 교환하는 방법
* */
public class KnapsackAlgo {
    // dy 배열을 선언 -> dy 배열은 i 금액을 만드는데 드는 최소 동전의 개수
    static int[] dy;

    // coin 배열
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        coin = new int[n];


        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            coin[cnt] = Integer.parseInt(st.nextToken());
            cnt++;
        }

        int m = Integer.parseInt(br.readLine());
        dy = new int[m+1];
        Arrays.fill(dy, 987654321);

        System.out.println(sol(m));
    }

    /*
     coin = {1,2,5}
     이때 dy[j-coin[i]]+1 의 의미를 잘 기억해야 한다.
     예를 들어 j = 5 이고 i , coin[i] 가 2인 경우 j = 3 이 된다.
     이때 +1 을 하는 이유는 i 번째 코인 = 2 을 사용했음으로 +1 하는 것이다. => 1개 사용

     다시 j=3 이고 coin[i] = 2 인 경우 j-coin[i] => 3-2 를 한다.
     그리고 다시 coin[i] 를 사욯했음으로 +1 => 2개 사용
     j=1 임으로 만약 coin 중 1원 짜리가 있기때문에 1원짜리를 사용해서 거스름돈을 맞추게 된다.
     따라서 5원을 거스르기위한 최소 갯수는 2,2,1 총 3개가 사용된다 => dy[5] = 3이 저장된다.

     다시 coin[i] 가 5인 경우 아래와 같이 계산된다.
     j-coin[i] => 5 - 5 = 0 이 됨으로 5원짜리 1개 동전만으로 거슬러 줄 수 있다.
     따라서 5원을 거슬러주기 위한 최소 갯수는 5 총 1개가 사용된다

     거슬러주기 위한 최소의 동전갯수를 구하는 것이기 때문에 이전 dy[5]= 3 과 현재 dy[5] = 1 을 비교후
     dy[j]에 더 작은 최소값을 넣어준다.
    */

    static int sol(int m){
        // 0 원의 값은 0으로 고정
        dy[0] = 0;

        // 코인의 종류만큼 for문 돌기
        for(int i=0; i<coin.length; i++){

            // j 는 coin[i] 값을 시작점으로 시작
            // coin[i] = 1 이면 j 는 1부터 시작
            for(int j=coin[i]; j<=m; j++){
                // j 원을 거슬러 주려고할 때 가장 적은 수의 동전으로 교환하는 방법은
                // dy[j] 번째 값과 dy[j-coin[i]]+1 한 값중 최소값을 찾는다
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }

        }

        return dy[m];
    }
}
