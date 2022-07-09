package greedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Wedding {

    static int min = Integer.MIN_VALUE;
    static int result = 0;
    static ArrayList<Friend> list = new ArrayList<Friend>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Friend(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for(Friend f : list){
            System.out.println(f.time + " " + f.status);

        }
    }







}

class Friend implements Comparable<Friend>{
    int time;
    int status;

    Friend(int time, int status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Friend o) {
        if(this.time == o.time){
            return this.status - o.status;
        }else{
            return this.time - o.time;
        }

    }
}