package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberCheck {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray(); // 읽어온 STring 을 ch 배열로 나누기
        int num = 0; // 합계 계산
        int cnt = 1; // 곱하기 위한 숫자
        int lastNum = (int) ch[ch.length - 1] - 48; // 마지막 번호 계산

        for (int i = 0; i < ch.length - 1; i++) {
            if (cnt >= 9) { // cnt 가 9 가 오면 아웃! 왜냐하면 9는 아래에서 한번 계산되었기 때문

                cnt = 2; // 다시 2로 초기화
            } else {
                cnt++; // 나머지는 +1
            }

            if (ch[i] == '-') {
                cnt--; // - 가 들어오면 cnt 는 -1 하고 다시 for 문 시작
                continue;
            }

            int check = (int) ch[i] - 48; // ch 배열의 하나를 가져오기
//            System.out.println(check+ " * "+cnt);
            num += check * cnt; // 곱하기!

        }
//        System.out.println("num : " + num);

        int result = 11-(num%11)%10;
        if(result == lastNum){
            System.out.println("검증완료 올바른 주민번호");
        }else{
            System.out.println("검증 완료 올바르지 못한 주민번호");
        }


    }
}
