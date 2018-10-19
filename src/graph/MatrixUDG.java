package graph;

public class MatrixUDG {
    private int mEdgNum;  // 边的数量
    private char[] mVexs;  //顶点集合
    private int[][] mMatrix; //邻接矩阵
    private static final int INF=Integer.MAX_VALUE;// 最大值

    public void dijkstra(int start,int[] prev,int dist[]){
        boolean visited[]=new boolean[mVexs.length];
        for(int i=0;i<mVexs.length;i++){
            visited[i]=false;
            prev[i]=0;
            dist[i]=mMatrix[start][i];
        }

        visited[start]=true;
        dist[start]=0;
        int k=0;
        for(int i=1;i<mVexs.length;i++){
            int min=INF;
            for(int j=0;j<mVexs.length;j++){
                if(visited[j]==false&&dist[j]<min){
                    min=dist[j];
                    k=j;
                }
            }

            visited[k]=true;



            for(int j=0;j<mVexs.length;j++){
                int temp=(mMatrix[k][j]==INF?INF:min+mMatrix[k][j]);
                if(visited[j]==false&&(temp<dist[j])){
                    dist[j]=temp;
                    prev[j]=k;
                }


            }
        }
    }
}
