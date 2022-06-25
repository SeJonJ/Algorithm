package baekJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz_2750 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] list = new int[n];

        for(int i=0; i<n; i++){
            int num = scan.nextInt();
            list[i] = num;
        }
        Arrays.sort(list);
        for(int i : list){
            System.out.println(i);
        }

    }
}
