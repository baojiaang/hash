package graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    public DepthFirstSearch(Graph G, int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }
    private void dfs(Graph G,int v){
        marked[v]=true;
        count++;
        for(int w:G.adj(v))  //访问 v的邻接顶点
            if(!marked[w])   //判断是否标记过
                dfs(G,w);    //进行递归调用
    }
    public boolean marked(int w)
    {
        return marked[w];
    }
    public int count(){
        return count;
    }
}
