package programmers;

public class LV1_1 {
    public static void main(String[] args) {
        System.out.println(findNum(626331));
    }

    static int findNum(int n){
        int answer = 0;
        int cnt = 0;

        while(true){

            if(cnt<500){
                if(n==1){
                    answer = cnt;
                    break;
                }else if(n%2==0){
                    n = n/2;
                }else if(n%2==1){
                    n = n*3+1;
                }
            }else{
                answer = -1;
                break;
            }

            cnt++;
        }

        return answer;
    }
}
