package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TwoPointer {
    /*
    2 pointer 알고리즘은  슬라이딩 윈도우(Sliding Window)라고도 불린다
    A 배열과 B 배열에 각각의 포인터를 두고 2개의 포인터로 계산하는 알고리즘?

    문제
    두 배열 합치기 : 오름차순으로 정렬이 된 두 배열이 주어질 때 두 배열을 오름차순으로 합쳐 출력하라

    풀이방법
    두 배열을 비교 후 합치기 위한 answer 배열을 만들어 두 배열을 비교한 값을 answer 배열에 담는다.
    이때 각 배열에 비교 대상 값(포인터)를 두고 각 배열의 포인터를 더 작은 값이 answer 배열에 들어간다


    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        sol(n, m, a, b).forEach(i ->{
            System.out.print(i + " ");
        });


    }

    static ArrayList<Integer> sol(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0; // a 배열의 포인터
        int p2 = 0; // b 배열의 포인터

        while(p1<n && p2 <m){
            if(a[p1]<b[p2]){
                answer.add(a[p1++]);
            }else{
                answer.add(b[p2++]);
            }
        }

        while (p1 < n) {
            answer.add(a[p1++]);
        }
        while (p2 < m) {
            answer.add(b[p2++]);
        }

        return answer;
    }
}
