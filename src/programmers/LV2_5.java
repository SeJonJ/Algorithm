package programmers;


import java.util.Arrays;

public class LV2_5 {
    public static void main(String[] args) {
        System.out.println(sol("(()("));
    }

    static boolean sol(String s){
        boolean answer = true;


        int cnt = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                cnt++;
            }else if(s.charAt(i)==')'){
                cnt--;
            }

            // 맨 처음 문자가 ) 인 경우를 계산산
           if(cnt <0){
                break;
            }
        }

        answer = cnt==0;


        return answer;
    }
}
