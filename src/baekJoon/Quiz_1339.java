package baekJoon;

import java.util.*;

import java.io.*;

public class Quiz_1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 알파벳 단어 갯수 받기

        Integer[] alpha = new Integer[26]; // 알파벳 26개만크 배열 선언
        Arrays.fill(alpha, 0);

        for(int i=0; i<n; i++){
            char ch[] = br.readLine().toCharArray();

            for(int j=0; j<ch.length; j++){
                // ch[j] 로 단어중 하나의 알파벳만을 받아옴.
                // 그후 해당 알파벳의 자리에 해당 알파벳에 맞는 10의 배수를 넣어줌
                // ACD 인 경우 각 A = 100, C = 10, D = 1 이 들어감
                // 또한 자리로는 A 는 0번째, C 는 3번째, D 는 4번째 자리에 들어감
                // 이를 종합하면 아래와 같은 코드로 변환됨
                // 이때 += 인 이유는 단어가 여러개일때는 해당 알파벳이 10의 자리와 100의 자리 모두 올 수 있음으로
                // 이것을 계산해주기 위함
                alpha[ch[j] - 'A'] += (int)(Math.pow(10, ch.length - j - 1));
            }
        }

        // 정렬을 하는 이유는 시작하는 숫자가 9 부터 시작임으로
        // 결국 A 부터 alpha 의 값 중 가장 큰 숫자부터 넣어야 하기 때문
        Arrays.sort(alpha, Collections.reverseOrder());
        //System.out.println(Arrays.toString(alpha));

        int start = 9;
        int result = 0;

        for(int i=0; i<alpha.length; i++){
            // 알파벳 배열안에 값이 없으면 중단 => 필요하지 않은 단어임으로
            if(alpha[i] == 0){
                break;
            }
            result += alpha[i] * start;
            start--;
        }
        System.out.println(result);
    }
}