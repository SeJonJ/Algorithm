package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수학 문제들은 정상적으로 계산할 생각 말자
// 정공법 풀이보다는 어떻게든 쉬운 방법 -> 꼼수를 찾자
public class Quiz_1712 {

    // 21억이하의 자연수 임으로 int 대신 long 으로 받음
    static long a,b,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        long result = breakEventPoint();
        System.out.println(result);
    }

    // A = 1000, B = 70, C = 170 인 경우
    // 1일차 : 1000+70*1 , 170*1 을 비교
    // 2일차 : 1000+70*2 , 170*2 을 비교
    // n일차 : 1000+70*n , 170*n 을 비교
    // 이렇게 되는데 쉽게 생각하자면 고정비용인 A 를 빼놓고
    // 가변비용인 70 과 판매액인 170 을 비교해서 생각하자하면 하루 순수익은 100 이 된다.
    // 따라서 순수익이 고정금액을 넘을 수 있는 최소 일수를 계산해주면된다.
    // 즉 170 - 70 을 한 뒤, 고정비용을 순수익으로 나눈 값 +1 하면 손익분기점을 넘는 최소 일수가 계산된다.
    static long breakEventPoint(){
        long n = c - b;
        long m = 0;

        if (n <= 0) {
            return -1;
        }

        m = a/n;

        return m+1;
    }
}
