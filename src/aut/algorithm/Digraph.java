package aut.algorithm;

import java.util.*;

public class Digraph {
    private HashMap<Integer,ArrayList<Integer>> data;
    private HashMap<Integer,Boolean> visited;
    private HashMap<String,ArrayList<Integer>> nodelist;
    private Stack<Integer> s;
    public Digraph(){
        data=new HashMap<>();
        visited=new HashMap<>();
        nodelist=new HashMap<>();
    }
    public Digraph(Digraph g){
        data=g.data;
        visited=g.visited;
        nodelist=g.nodelist;
        s=g.s;
    }
    public void explore(Integer i){
        visited.put(i,true);
        ArrayList<Integer> neighbours=data.get(i);
        for(int j=0;j<neighbours.size();j++){
            int node=neighbours.get(j);
            boolean now=visited.get(node);
            if(now==false)
                explore(node);
            else
                return;
        }
    }
    public void dfs(){
        Iterator<Map.Entry<Integer,ArrayList<Integer>>> it=data.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,ArrayList<Integer>> entry=it.next();
            Integer node=entry.getKey();
            boolean isvisit=visited.get(node);
            if(isvisit==false)
                explore(node);
        }
    }
    public void transpose(Digraph g){
        int n=data.size();
        Digraph u=new Digraph(g);
        clear(g);
        Iterator<Map.Entry<Integer,ArrayList<Integer>>> it=u.data.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,ArrayList<Integer>> entry=it.next();
            Integer node=entry.getKey();
            ArrayList<Integer> adjlist=entry.getValue();
            for(int i=0;i<adjlist.size();i++){
                Integer v=adjlist.get(i);
                g.addEdge(v,n);
            }
        }
    }
    public void dfs2(){
        Iterator<Map.Entry<Integer,Boolean>> it=visited.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Boolean> entry=it.next();
            if(entry.getValue()==false) {
                explore2(entry.getKey());
                System.out.print(entry.getKey());
            }
            System.out.println();
        }
    }
    public void explore2(Integer i){
        visited.put(i,true);
        ArrayList<Integer> neighbours=data.get(i);
        for(int j=0;j<neighbours.size();j++){
            int node=neighbours.get(j);
            boolean now=visited.get(node);
            if(now==false)
                explore(node);

        }
        s.push(i);

    }
    public void clear(Digraph g){
        g.data=new HashMap<>();
    }
    public void addEdge(Integer v,Integer w){
        ArrayList<Integer> adjlist=data.get(v);
        adjlist.add(w);
        data.put(v,adjlist);
    }
    public void printSCC(Digraph g){
        s=new Stack<>();
        dfs2();
        transpose(g);
        for(int i=0;i<g.s.size();i++){
            Integer node=s.pop();
            dfs();
        }
    }
}
