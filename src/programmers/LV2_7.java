package programmers;

public class LV2_7 {
    public static void main(String[] args) {
        sol(100);
    }

    static int sol(int n){
        int answer = 0;
        float[] f = new float[n + 1];
        f[0] = 0;
        f[1] = 1;

        for(int i=2; i<=n; i++){
            f[i] = (f[i - 1] + f[i - 2])%1234567;
        }
        answer = (int)f[n]%1234567;


        return answer;
    }
}
