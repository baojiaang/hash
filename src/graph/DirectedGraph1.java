package graph;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class DirectedGraph1 {
    private  int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private LinkedList<Vertex> vertexs; //store the vertex
    private  static class Vertex{
        private String label; // name of vertex
        private List<Vertex> adj;//adjcacent list
        private int indegree=0;        // indegree[v] = indegree of vertex v
       int topNum=0;
        public Vertex(String label){
            this.label=label;
            adj=new LinkedList<Vertex>();

        }
    }

    public DirectedGraph1(){
        this.V =0;
        this.E = 0;
        vertexs=new LinkedList<Vertex>();

    }
    public void createNode(Vertex v){
        vertexs.add(v);
    } //创造顶点，将顶点添加到list中

    public void addEdge(Vertex v,Vertex w){  //add edge
        v.adj.add(w);
        w.indegree++;
        E++;

    }
    public void topologic(){
        Queue<Vertex> q=new LinkedList<Vertex>();
        int counter=0;
        for(Vertex v:vertexs){ // 遍历整个list
            if(v.indegree==0){ //if vertex 的 indegree等于0
                q.offer(v);
            }
        }
        while(!q.isEmpty()){
            Vertex v=q.poll();
            v.topNum++;
            System.out.println(v.label);
            for(Vertex w:v.adj){
                if(--w.indegree==0){
                    q.offer(w);
                }
            }
        }
        if(counter!=V){ // if counter unequals to vertes numbers
            System.out.println("find cycle");
        }
    }

    public static void main(String[] args) {
        DirectedGraph1 d=new DirectedGraph1();
        Vertex A=new Vertex("A");//建立顶点

        Vertex B=new Vertex("B");
        Vertex C=new Vertex("C");
        Vertex D=new Vertex("D");
        Vertex E=new Vertex("E");
        Vertex F=new Vertex("F");
        d.createNode(A);//将顶点放入list中
        d.createNode(B);
        d.createNode(C);
        d.createNode(D);
        d.createNode(E);
        d.createNode(F);



        d.addEdge(A,D);
        d.addEdge(A,C);
        d.addEdge(C,B);
        d.addEdge(C,F);
        d.addEdge(F,E);
        d.addEdge(F,D);
        d.addEdge(B,E);
        d.addEdge(E,D);
        long startTime=System.currentTimeMillis();
        d.topologic();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);



    }

}
