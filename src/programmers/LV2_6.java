package programmers;

public class LV2_6 {
    public static void main(String[] args) {
        sol(15);
    }

    static int sol(int n){
        int answer = 0;

        for(int i=1; i<=n; i++){
            int sum = 0;
            sum+=i;
            if (sum == n) {
                answer++;
                break;
            }
            for(int j=i+1; j<=n; j++){
                sum += j;

                if(sum == n){
                    answer++;
                    break;
                }else if(sum>n){
                    break;
                }
            }
        }
        return answer;
    }
}
