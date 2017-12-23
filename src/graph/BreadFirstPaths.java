package graph;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadFirstPaths {
    private boolean[] marked;  //到达该顶点的最短路径已知吗
    private int[] edgeTo;  //到达该顶点的已知路径上的最后一个顶点
    private  final int s; //  start  起始点
    public BreadFirstPaths(Graph G,int s){
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        bfs(G,s);
    }
    private void bfs(Graph G,int s){
        Queue<Integer> queue=new Queue<Integer>();
        marked[s]=true;  //标记起点
        queue.enqueue(s);  //将它加入队列
        while(!queue.isEmpty()){
            int v=queue.dequeue();  //从队列中删去下一个顶点
            for(int w:G.adj(v))
                if(!marked[w])    //对于每个未被标记的相邻顶点
            {
                edgeTo[w]=v;  //保存最短路径的最后一条边
                marked[w]=true;//标记它， because the shortest path is alreadly know
                queue.enqueue(w);//add it to the queue
            }
        }

    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path=new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return  path;


    }

}
