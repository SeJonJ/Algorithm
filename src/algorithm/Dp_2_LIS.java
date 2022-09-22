package algorithm;

// 최대부분증가수열
/*
 i 번째 숫자를 마지막항으로 하는 최대 증가 수열
 주어지는 배열에서 i 번째 항(index) 를 기준으로 만들 수 있는 최대의 증가 수열
 { 5 3 7 8 6 2 9 4 } 라는 배열이 있을 때
 arr[3] = 8 을 기준으로 올 수 있는 최대의 증가수열의 갯수를 구한다
 {3,7,8}
 {7,8}
 {5,7,8}
 {5,3,7,8} 의 경우에는 5->3 으로 증가하는 것이 아닌 감소하기 때문에 허용X

 풀이 요점 : 0 ~ i-1 까지 검사하면서 각 항마다 최대 증가 수열의 최대값을 찾고, 거기에 +1 한다
* */

public class Dp_2_LIS {
    // 각 인덱스(항) 의 최대부분증가 수열 저장
    static int[] dy;
    public static void main(String[] args){
        int[] arr = {5, 3, 7, 8, 6, 2, 9, 4};
        System.out.println(sol(arr));
    }

    static int sol(int[] arr){
        int answer = 0;

        dy = new int[arr.length];
        // 0번째 인덱스의 최대 부분증가수열은 당연히 1
        dy[0] = 1;

        for(int i=1; i<arr.length; i++){
            int max = 0;

            // i보다 작은 index 를 기준으로 가장 큰 최대 부분 증가 수열의 값을 찾는다
            for(int j=i-1; j>=0; j--){
                // 증가 수열이기 때문에 arr[j] 는 arr[i] 보다 작아야한다
                if(arr[j]<arr[i] && dy[j]>max){
                    // dy[j] 중에 max 보다 큰 수가 있다면
                    // 0 ~ j(i-1) 중에서 가장큰 부분증가수열이 됨
                    max = dy[j];
                }

                // i 번째 항의 최대 부분 수열의 값은 max+1
                dy[i] = max+1;
            }

            // 각 항의 최대 부분증가수열의 값이 들어있는 dy 중에서
            // 가장 큰 값을 찾으면 그게 바로 정답!!
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }
}
