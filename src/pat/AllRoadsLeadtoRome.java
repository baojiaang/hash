package pat;

import java.util.HashMap;
import java.util.Scanner;

public class AllRoadsLeadtoRome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//  number of city
        int k=sc.nextInt(); // number of routes
        String start =sc.next();
        int costs[]=new int[n];  //每一个点到顶点的cost
        int hpns[]=new int[n];   //每一个点到顶点的happiness
        int steps[]=new int[n];  //每一条路径的节点数
        int routes[]=new int[n];// 到达每个点的路径数量
        int parents[]=new int[n];  //每一个节点的父节点
        int [][] M=new int[n][n];  //邻接矩阵
        HashMap<String,Integer> index=new HashMap<>();  //  名字 和 index号对应
        boolean visited[]=new boolean[n];
        int h[]=new int[n]; //每个城市的幸福值
        String[] names=new String[n];


        routes[0]=1;
        parents[0]=-1;
        index.put(start,0);
        names[0]=start;


        //initilize

        for(int i=1;i<n;i++){
            costs[i]=Integer.MAX_VALUE;
            hpns[i]=Integer.MIN_VALUE;
            names[i]=sc.next();
            index.put(names[i],i);
            h[i]=sc.nextInt();
        }

        int end=index.get("ROM");

        for(int i=0;i<k;i++){
            int s=index.get(sc.next());
            int e=index.get(sc.next());
            int cost=sc.nextInt();
            M[s][e]=cost;
            M[e][s]=cost;
        }

        for(int t=0;t<n;t++){
            int v=-1;
            for(int i=0;i<n;i++){
                if(!visited[i]&&((v<0)||costs[i]<costs[v]))
                    v=i;
            }
            visited[v]=true;  //标记为已经访问
            for(int i=0;i<n;i++){
                if(!visited[i]&&M[v][i]!=0){
                    int cost=costs[v]+M[v][i];
                    int happy=hpns[v]+h[i];
                    int step=steps[v]+1;
                    boolean flag=false;
                    if(cost<costs[i]){
                        costs[i]=cost;
                        routes[i]=routes[v];
                        flag=true;
                    }
                    else if(cost==costs[i]){
                        routes[i]+=routes[v];
                        if(happy>hpns[i]){
                            flag=true;
                        }
                        else if(happy==hpns[i]&&step<steps[i]){
                            flag=true;
                        }
                    }
                    if(flag){
                        costs[i]=cost;
                        hpns[i]=happy;
                        steps[i]=step;
                        parents[i]=v;
                    }
                }
            }
        }

        int totol=steps[end];
        int happiness=hpns[end];
        int avg=happiness/totol;
        totol++;
        System.out.println(routes[end]+" "+costs[end]+" "+happiness+" "+avg);
        String results[]=new String[totol];
        int j=totol-1;
        while(end!=-1){
            results[j--]=names[end];
            end=parents[end];
        }
        for(int i=0;i<results.length-1;i++){
            System.out.print(results[i]+"->");
        }
        System.out.println(results[totol-1]);




    }
}
