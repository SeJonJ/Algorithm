package baekJoon;

import java.util.Scanner;

public class Quiz_14659 {
    static int[] arr;
    static int n;
    static int count = Integer.MIN_VALUE;
    static boolean[] ch;

    static void peak(int num, int k, int sum) {

        if(k>n) peak(num, num+1, 0);
        if(k == n){
            count = Math.max(count, sum);
        }else{
            if (arr[num] > arr[k]) {
                //System.out.println(arr[num] + " : " + arr[k]);
                peak(num, k+1, sum+1);
            }else{
                //System.out.println(arr[num] + " : " + arr[k]);
                count = Math.max(count, sum);
                peak(num+1, num+2, 0);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        arr = new int[n];
        ch = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        peak(0, 1, 0);
        System.out.println(count);


    }
}
