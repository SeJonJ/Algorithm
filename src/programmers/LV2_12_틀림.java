package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885
// 그리디 - 구명보트
public class LV2_12_틀림 {
    public static void main(String[] args) {
        int[] people = {10,20,30,40,50,60,70,80,90,100};


        sol(people, 100);

    }


    static int sol(int[] people, int limit) {
        int answer = 0;
        int index = 0;
        boolean cnt = true;

        Arrays.sort(people);

        for(int i=people.length-1; i>=index; i--) {
            int min = people[index];
            int max = people[i];

            if (min + max <= limit) {
                answer++;
                index++;
            }else{
                answer++;
            }

        }

        System.out.println("answer : " + answer);

        return answer;
    }


}
