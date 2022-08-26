package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Quiz_25372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            arr.add(br.readLine());
        }

        for (String pwd : arr) {
            if (pwd.length() >= 6 && pwd.length() <= 9) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
