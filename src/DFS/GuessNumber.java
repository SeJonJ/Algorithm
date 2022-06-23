package DFS;

import java.util.Scanner;

public class GuessNumber {
    static int n, f;
    static boolean[] check;
    static int[] arr, number, result;
    static int[][] tmp = new int[12][12];
    static boolean flag;

    static int getNumber(int n, int m){
        if(tmp[n][m] > 0){
            return tmp[n][m];
        }
        if(n==m || m==0){
            return 1;
        }else{
            tmp[n][m] = getNumber(n-1,m-1)+getNumber(n-1,m);
            return tmp[n][m];
        }
    }

    static void guess(int num, int sum){
        //System.out.println("결과 : "+Arrays.toString(result));
        if(sum>f) return;
        if(flag) return;
        if(num == n && sum == f){
            //System.out.println("결과 : "+Arrays.toString(result));
            for(int i : result){
                System.out.print(i+" ");
            }
            flag = true;
        }else{
            for(int i=1; i<=n; i++){
                //System.out.println("결과 : "+Arrays.toString(result));
                if(!check[i]){
                    check[i] = true;
                    result[num] = i;
                    guess(num+1, sum+(number[num]*i));
                    check[i] = false;
                }

            }
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        f = scanner.nextInt();

        arr = new int[n];
        result = new int[n];
        check = new boolean[n+1]; // 배열에 담긴 값이 아니라 index 번호를 기준으로 check 해야하기 때문?
        number = new int[n];

        //
        for(int i = 0; i < n; i++){
            number[i] = getNumber(n-1, i);
        }
        //System.out.println(Arrays.toString(number));
        guess(0, 0);
    }
}
