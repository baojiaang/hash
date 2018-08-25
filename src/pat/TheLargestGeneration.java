package pat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TheLargestGeneration {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int all[][]=new int[n+1][n+1];
        int maxlevel=1;
        int maxGeneration=1;
        int level=1;
        int generation=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            int id=sc.nextInt();
            int number=sc.nextInt();
            for(int j=0;j<number;j++){
                all[id][j]=sc.nextInt();
            }
        }
        q.offer(1);
        while(q.size()!=0){
            int length=q.size();
            generation=0;
            level++;
            for(int i=0;i<length;i++){
                int id=q.poll();
                int array[]=all[id];
                for(int j=0;i<array.length;j++){
                    if(array[j]==0)
                    {
                        break;
                    }
                    generation++;
                    q.offer(array[j]);
                }
            }
            if(generation>maxGeneration){
                maxGeneration=generation;
                maxlevel=level;
            }
        }
        System.out.println(maxGeneration+" "+maxlevel);
    }
}
