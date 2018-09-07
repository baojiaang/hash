package pat;

import java.util.*;

public class PathofEqualWeight {
    public static Node[] nodeList;
    public static int[] path;
    public static int needweight;
    public static class Node implements  Comparable<Node>{
        int id;
        Integer weight;
      ArrayList<Integer> childrens;

        @Override
        public int compareTo(Node o) {
            return o.weight.compareTo(weight);
        }
        public Node(){
            childrens=new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nonleaf=sc.nextInt();
        int target=sc.nextInt();
        nodeList=new Node[n];
        path=new int[n];
        for(int i=0;i<n;i++){
            nodeList[i]=new Node();
            nodeList[i].weight=sc.nextInt();

        }
        for(int i=0;i<nonleaf;i++){
            int index=sc.nextInt();
            int number=sc.nextInt();
            for(int j=0;j<number;j++){
                nodeList[index].childrens.add(sc.nextInt());
            }
            Collections.sort(nodeList[index].childrens, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return nodeList[o1].weight.compareTo(nodeList[o2].weight);
                }
            });
        }

        dfs(0,1,nodeList[0].weight,target);

    }


    public static void dfs(int index,int nodeNum,int sum,int target){
        if(sum>target) return;
        if(sum==target){
            if(nodeList[index].childrens.size()!=0) return;
            for(int i=0;i<nodeNum;i++){
                System.out.printf("%d%c",nodeList[path[i]].weight,i!=nodeNum-1?' ':'\n');
            }
            return;
        }
        for(int i=0;i<nodeList[index].childrens.size();i++){
            int node=nodeList[index].childrens.get(i);
            path[nodeNum]=node;
            dfs(node,nodeNum+1,sum+nodeList[node].weight,target);
        }


    }


}
