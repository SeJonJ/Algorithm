package programmers;

import java.util.Arrays;

public class LV2_15 {
    public static void main(String[] args) {
        sol(2000);
    }

    static int sol(int n){
        int answer = 0;
        int[] arr = new int[n+2];

        arr[0] = 0;
        arr[1] = 1;


        for(int i=2; i<=arr.length-1; i++){
            arr[i] = (arr[i - 2] + arr[i - 1])%1234567;
        }

        answer = arr[arr.length - 1];

        return answer;
    }
}
