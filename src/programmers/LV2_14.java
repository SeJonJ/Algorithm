package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class LV2_14 {
    public static void main(String[] args) {

        sol(8,3,4);
    }

    // 이 문제의 포인트는 a 와 b 가 한 라운드에 있는 경우를 찾는 것이다.
    // 여기서 한 라운드란 a+1/2 했을 때와 b+1/2 했을 때 같은 값이 나오는 때를 의미한다.
    // 이는 1, 2 가 있을 때 1+1/2 == 1 , 2+1/2 == 1 햇을 때 값이 같고,
    // 3+1/2 ==2 , 4+1/2 == 2 -----> 로 같기 때문이다.
    static int sol(int n, int a, int b){
        int answer = 0;


        while (a!=b) {
            answer++;

            a+=1;
            a = a/2;

            b+=1;
            b = b/2;
        }

        System.out.println(answer);
        return answer;
    }
}
