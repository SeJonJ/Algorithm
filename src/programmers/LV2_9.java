package programmers;

import java.util.Arrays;

public class LV2_9 {
    public static void main(String[] args) {
        sol(8,1);
    }

    static int[] sol(int brown, int yellow){
        int[] answer = {987654321, -987654321};
        int sum = brown+yellow;

        for(int i=1; i<=brown; i++){

            for(int j=3; j<=brown; j++){
                if(i>=j && i*j==sum){
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.max(answer[1], j);

                } else if (i * j > sum) {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
