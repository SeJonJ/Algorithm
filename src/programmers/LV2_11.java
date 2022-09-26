package programmers;


import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973
// 짝지어 제거하기
public class LV2_11 {
    public static void main(String[] args) {
        sol("baabaa");
    }

    static int sol(String s) {
        int answer = -1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        answer = stack.size()==0 ? 1 : 0;
        System.out.println("answer : " + answer);

        return answer;
    }
}
