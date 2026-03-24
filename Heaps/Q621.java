
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q621 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] parts = str.split(" ");
        char[] tasks = new char[parts.length];
        for(int i = 0 ; i < tasks.length ; i++){
            tasks[i] = parts[i].charAt(0);
        }
        int n = sc.nextInt();
        System.out.println(leastInterval(tasks, n));
        // System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    // optimal 
    // tc : n + 26 log 26 + 26 log 26 = n
    // sc : 26 + 26 = 1
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26] ;
        for(char ch : tasks){
            map[ch-'A']++;
        }

        PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
        for(int freq : map){
            if(freq > 0){
                Q.add(freq);
            }
        }

        int time = 0;

        while(!Q.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < n+1 ; i++){

                if(!Q.isEmpty()){
                    int freq = Q.poll();
                    freq--;
                    temp.add(freq);
                }
            }

            for(int freq : temp){
                if(freq > 0){
                    Q.add(freq);
                }
            }

            if(Q.isEmpty()){
                time += temp.size();
            }else{
                time += n+1 ;
            }
        }

        return time ;
    }
}