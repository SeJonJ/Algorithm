package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

// https://www.acmicpc.net/problem/2981
// (정수론+) 유클리드 호제법 + 나머지 정리

// 임의의 정수 K 와 L 이 있을 때 다음과 같이 표현 가능하다
/*
*  K = M*k + r1
*  L = M*l + r2
*
*  이때 위 수식에서 r 은 모두 동일하기 때문에 => 나머지가 모두 같게 되는 M
*   r1-r2 = 0 임으로
*   K-L = M(k-l) 이 성립한다. 이때 M은 K 와 L 의 공약수가 된다... 라고하는데 개어렵다
*
*   예제를 기준으로 다시 생각해보면
*   6 = M*k + r
*   34 = M*l + r
*   38 = M*p + r
*   =>
*   (6-34) = M*(l-k);
*   (34-38) = M*(p-l);
*   이 성립한다는 말이다.
*   여기서 M 은 (6-34) 와 (34-38) 모두에서 동일해야한다.
*   왜냐하면 위의 식 모두 M 으로 나눴을 때 나누어떨어지는 수가 되기 때문이다.
*
*   따라서 M 을 구하기 위해서는 6-34, 34-38 의 공약수를 구하면 되는 것이다.
*   여기서 공약수를 찾는 방법은 6-34 와 34-38 의 최대 공약수를 찾아서
*   그 최대 공약수의 약수를 찾는 방법으로 간다.
* */
public class Quiz_2981 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        // 뺏셈을 위해 오름차순으로 정렬
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // gcd 를 입력받은 두번째수 - 입력받은수 첫번째수로 초기화한다.
        int gcd = list.get(1) - list.get(0);

        for(int i=2; i<n; i++){
            // 최대공약수(gcd) 를 계속해서 계산한다.
            // 이는 앞서 이야기한 6-34 의 최대공약수를 먼저 구하고,
            // 다시 6-34의 최대공약수에 해당하는 수와 34-38 에 해당하는 수의 최대공약수를
            // 구하기 위함이다.
            // 최종적으로 gcd 는 list 에 담긴 모든 수들에 대한 최대공약수가 구해진다.
            gcd = gcd(gcd, list.get(i)-list.get(i-1));
        }
//        System.out.println("gcd : " + gcd);
        findM(gcd);

    }

    static int gcd(int a, int b){

        // 나머지가 0 일 때 그 몫이 되는 a 를 출력
        while (b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    // 공약수들의 약수를 찾는다.
    // 여기서 gcd/2 를 한 이유는 최대 공약수의 약수들 중에는 자기 자신을 제외한 수 중 최대값이 최대공약수/2 의 값을
    // 넘을 수 없기 때문이다.
    // 다만 이때는 마지막에 sb 에 자기자신 - 최대공약수 - 를 넣어주어야 한다.
    static void findM(int gcd){
        StringBuffer sb = new StringBuffer();

        for(int i=2; i<=gcd/2; i++){
            if (gcd % i == 0) {
                sb.append(i+" ");
            }
        }
        sb.append(gcd);

        System.out.println(sb.toString());
    }
}
