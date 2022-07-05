package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 구간합 구하기
// https://www.acmicpc.net/problem/11659
public class Quiz_11659_study {

    static int n, m; // 수의 갯수 n 합을 구해야하는 횟수 m
    static ArrayList<Integer> list = new ArrayList<Integer>(); // 입력받는 숫자 배열
    static int[] sum; // 각 자리의 합계 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sum = new int[n+1]; // 합계는 1번째부터 임으로 입력받는 숫자 +1
        sum[0] = 0; // 0번째 값은 없음으로 0 으로 초기화

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+num; // i 번째까지의 합은 i-1 번째 인덱스 값 + 현재 숫자
            list.add(num); // list에 추가
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // f번째부터 b번째 까지의 합은
            // sum[b] - sum[f-1]
            int result = sum[b] - sum[f - 1];
            System.out.println(result);
        }
    }
}
