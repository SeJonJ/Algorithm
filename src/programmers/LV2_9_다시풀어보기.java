package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class LV2_9_다시풀어보기 {
    public static void main(String[] args) {
        sol(18,6);
    }

    // 노란색 칸의 크기(갯수) 는 (전체 가로-2)*(전체세로-2)
    static int[] sol(int brown, int yellow){
        int[] answer = new int[2];
        int sum = brown+yellow;


        for(int col=3; col<sum; col++){
            int row = sum/col;

            if ((col - 2) * (row - 2) == yellow && row >= 3) {
                answer[0] = Math.max(col, row);
                answer[1] = Math.min(col, row);
            }
        }

        return answer;
    }
}
