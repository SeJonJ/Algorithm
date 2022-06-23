package DFS;

import java.util.Scanner;

public class Memoization {
    // 조합수 메모이제이션 => 2차원 배열로 문제를 접근하자, nCm 은 n행 m 열
    // 조합수란 고딩때 공부했던 5C2 이런식으로 5개중 2개를 뽑는 경우의 수는?
    // nCm 같은 문제들을 의미한다.
    // 이때 5C3 는 5를 포함해서 4개중 2개를 뽑는 경우 4C2 와 5를 빼고 4개중 3개를 봅는 경우 4C3 으로 나눌 수 있다
    // 여기서 다시 4C2 는 4를 포함해서 3개 중 1개를 뽑는 3C1 과 4를 빼고 3개중 2개를 뽑는 경우 3C2 로 나눌 수 있다
    // 즉 nCm = n-1Cm-1 + n-1Cm 이 된다.
    // 중요한 것은 nCm 이라고 할 때 m == 0 이거나 n == m 이 동일 할 때 경우의 수가 종료된다 => 재귀가 종료
    
    // 근데 이런 재귀를 계산 할 때마다 다시 재귀를 반복하면서 하면...정말 끝도없이 반복될 수 밖에 없다.
    // 따라서 한번 경우의 수가 계산될 때 마다 메모리에 저장 - 메모이제이션 - 을 동일한 경우는 다시 계산하지 말고
    // 메모리의 낭비도 줄이고, 시간도 줄 일 수 있다

    static int[][] memo = new int[35][35];
    static int dfs(int n, int m){
        if(memo[n][m] > 0) return memo[n][m];

        if(m == n || m == 0) {
            return 1;
        } else{
                memo[n][m] = dfs(n-1,m-1)+dfs(n-1,m);
                return memo[n][m];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //System.out.println(memo.length);
        //System.out.println(memo[n].length);

        System.out.println(dfs(n,m));
    }
}
