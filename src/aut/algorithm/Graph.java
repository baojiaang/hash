package aut.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    private final int V; // number of the vertex
    private int E;
    private LinkedList<Vertx> vertxes;
    private int nowTime;

    public Graph(int V) {
        this.V = V;
        this.E=0;
        vertxes=new LinkedList<>();
    }
    public void addEdge(String v,String w){
        Vertx vv=null;
        Vertx ww=null;
       for(int i=0;i<vertxes.size();i++){
           Vertx now=vertxes.get(i);
           if(v==now.name){
                vv=now;
           }
           if(w==now.name){
               ww=now;
           }
       }
       vv.adj.add(ww);
    }
    public void  addVertx(String name){
        Vertx v=new Vertx(name);
        vertxes.add(v);
    }
    public void dfs(Graph g){ //recursive
        nowTime=0;
        for(int i=0;i<vertxes.size();i++){
            Vertx v=vertxes.get(i);
            v.finishTime=0;v.disCoverTime=0;
            v.visted=false;
        }
        for(int i=0;i<vertxes.size();i++){
            Vertx v=vertxes.get(i);
            if(v.visted==false){
                explore(g,v);
            }
        }
    }


    public void explore(Graph g,Vertx v){
        v.visted=true;
        v.disCoverTime=nowTime;
        nowTime++;
        for(int i=0;i<v.adj.size();i++){
            Vertx u=v.adj.get(i);
            if(u.visted==false)
                explore(g,u);
        }
        v.finishTime=nowTime;
        nowTime++;
    }
    public void DFSwithStack(Graph g,Vertx v){
        nowTime=0;
        Stack<Vertx> s=new Stack<>();
        s.push(v);
        v.visted=true;
        v.disCoverTime=nowTime;
        nowTime++;
        while (s.size()!=0){
            Vertx u=s.peek();
            boolean flag=false;
            for(int i=0;i<u.adj.size();i++){
                Vertx w=u.adj.get(i);
                if(w.visted==false)
                {
                    w.visted=true;
                    w.disCoverTime=nowTime;
                    nowTime++;
                    s.push(w);
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                u.finishTime=nowTime;
                nowTime++;
                s.pop();
            }

        }
    }
    public Vertx getVertx(String v){
        Vertx vv=null;
        for(int i=0;i<vertxes.size();i++){
            Vertx now =vertxes.get(i);
            if(v==now.name)
            {  vv=now;
                break;
            }
        }
        return vv;
    }
    private static class Vertx{
        boolean visted;
        String name;
        public int dist;
        public ArrayList<Vertx> adj;
        int disCoverTime;
        int finishTime;
        private Vertx(String name){
            this.name=name;
            adj=new ArrayList<>();
            disCoverTime=0;
            finishTime=0;
            visted=false;
        }
    }

    public static void main(String[] args) {

        Graph g=new Graph(10);


        String names[]={"0","1","2","3","4","5","6","7","8","9"}; //nodes
        for(int i=0;i<names.length;i++){
            String name=names[i];
            g.addVertx(name);
        }
        g.addEdge("0","5");
        g.addEdge("5","2");
        g.addEdge("2","3");
        g.addEdge("3","7");
        g.addEdge("7","8");
        g.addEdge("2","6");
        g.addEdge("6","4");
        g.addEdge("0","6");
        g.addEdge("4","9");
        g.addEdge("1","3");
        g.addEdge("1","4");
        g.addEdge("3","8");
        g.addEdge("4","3");
        //g.dfs(g);
        Vertx start=g.getVertx("0");
        g.DFSwithStack(g,start);
        for(int i=0;i<g.vertxes.size();i++){
            Vertx v=g.vertxes.get(i);
            System.out.print(" vertex "+v.name+" discovertime is"+v.disCoverTime+"  finishtime is"+v.finishTime);
            System.out.println();
        }





    }
}
