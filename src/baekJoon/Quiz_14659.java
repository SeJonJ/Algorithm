package baekJoon;

import java.util.Scanner;

public class Quiz_14659 {
    static int[] arr;
    static int n;
    static int count = Integer.MIN_VALUE;

    // 재귀 함수 풀이
    static void peak(int num, int k, int kill) {

        // k 가 배열의 크기인 n 보다 크면 k 를 num+1 로 고정
        if(k>n) peak(num, num+1, 0);
        if(k == n){ // k 가 n 과 동일해지면 count 계산
            count = Math.max(count, kill);
        }else{
            if (arr[num] > arr[k]) {
                // 현재 arr[num] 의 값이 비교 대상 arr[k]보다 크다면
                // kill+1 한 후 비교대상 index 를 +1 하고 재귀 시작
                // 즉 arr[num] > arr[k] 인 경우 한조가 한명을 처치한 것

                //System.out.println(arr[num] + " : " + arr[k]);
                peak(num, k+1, kill+1);

            }else{
                // 만약 arr[num] 의 값이 arr[k] 보다 작다면
                // 더이상 처치할 수 없음으로 해당 arr[num] 값으로 재귀를 중지하고
                // 대신 num+1 해서 다시 재귀를 시작함
                // 이때 비교 대상이 되는 arr[k] 는 num+1이 num+1 의 다음 값인 num+2 가 됨
                // 동시에 kill 값은 초기화
                //System.out.println(arr[num] + " : " + arr[k]);
                count = Math.max(count, kill);
                peak(num+1, num+2, 0);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt(); // 산봉우리 수

        arr = new int[n]; // 산봉우리 배열

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        // 재귀 시작은 0번째 봉우리부터이고
        // 비교대상은 1번째 봉우리
        // 즉 arr[0] 과 arr[1] 부터 비교
        peak(0, 1, 0);
        System.out.println(count);


    }
}
