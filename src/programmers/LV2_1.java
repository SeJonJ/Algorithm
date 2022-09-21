package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class LV2_1 {


    public static void main(String[] args) {
        String str = "1 2 3 4";
        System.out.println(findStr(str));
    }

    static String findStr(String str){
        String answer = "";

        String[] strArr = str.split(" ");
        int max = -987654321;
        int min = 987654321;

        for(int i=0; i<strArr.length; i++){
            max = Math.max(max, Integer.parseInt(strArr[i]));
            min = Math.min(min, Integer.parseInt(strArr[i]));
        }
        answer = max+" "+min;
        return answer;
    }
}
