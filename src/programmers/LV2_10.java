package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LV2_10 {
    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        sol(3, words);
    }

    static int[] sol(int n, String[] words){
        int[] answer = {0,0};

        ArrayList<String> list = new ArrayList<>();
        int num = 2;
        int cnt = 2;

        char lastCh = words[0].charAt(words[0].length() - 1);
        list.add(words[0]);

        for(int i=1; i<words.length; i++, num++, cnt++){

            if(num > n){
                num = 1;
            }

            if (lastCh != words[i].charAt(0)) {
                answer[0] = num;
                answer[1] = cnt%n==0?cnt/n:cnt/n+1;
                break;
            } else if (list.contains(words[i])) {
                answer[0] = num;
                answer[1] = cnt%n==0?cnt/n:cnt/n+1;
                break;
            }

            list.add(words[i]);
            lastCh = words[i].charAt(words[i].length() - 1);


        }

        return answer;
    }
}
