package graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int V; //  顶点数目
    private int E;   //边的数目
    private Bag<Integer>[] adj;  // adjacent 邻接表
    public Graph(int V){
        this. V=V;
        this.E=0;
        adj=(Bag<Integer>[]) new Bag[V];// 创建邻接表
        for(int v=0;v<V;v++){
            adj[v]=new Bag<Integer>(); //将所有链表初始化为空
        }

    }
    public Graph(In in){
        this(in.readInt());  //读取并初始化
        int E=in.readInt();    //读取边 E
        for(int i=0;i<E;i++){
            int v=in.readInt(); //读取一个顶点
            int w=in.readInt();  //读取另一个
            addEdge(v,w);
        }
    }
    public void addEdge(int v,int w){
        adj[v].add(w);  //v添加到w中
        adj[w].add(v);  //w添加到v中
        E++;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public Iterable<Integer> adj(int v){
        return  adj[v];
    }
}
