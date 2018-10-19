package assignment1;



/*
    BaoJiaang 18031228
    fastMultiply(int a[][],int b[][]) is for the Strassen's algorithm
    normalMultiply(int a[][],int b[][]) is for the normal matrix algorithm
 */
public class MatrixMultiplication {
    public int[][] normalMultiply(int a[][],int b[][]){
        int result[][]=new int[a.length][a.length];
        for(int i=0;i<a.length;i++){// all rows
            for(int j=0;j<a.length;j++){ //row
                for(int k=0;k<a.length;k++){ //for an entry
                    result[i][j]=result[i][j]+a[i][k]*b[k][j];
                }
            }
        }
        return result;
    }


    /*
    multiply two matrix

     */
    public int[][] Multiply2by2(int a[][],int b[][]){
        int result[][]=new int[a.length][a.length];
        int a1=a[0][0];
        int a2=a[0][1];
        int a3=a[1][0];
        int a4=a[1][1];
        int b1=b[0][0];
        int b2=b[0][1];
        int b3=b[1][0];
        int b4=b[1][1];
        int p1=a1*(b2-b4);
        int p2=(a1+a2)*b4;
        int p3=(a3+a4)*b1;
        int p4=a4*(b3-b1);
        int p5=(a1+a4)*(b1+b4);
        int p6=(a2-a4)*(b3+b4);
        int p7=(a1-a3)*(b1+b2);
        result[0][0]=p5+p4-p2+p6;
        result[0][1]=p1+p2;
        result[1][0]=p3+p4;
        result[1][1]=p5+p1-p3-p7;

        return result;
    }


    /*
    divide the big matrix into four small matrixs
     */
    public void divide(int pre[][],int a1[][],int a2[][],int a3[][],int a4[][]){
        int n= a1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a1[i][j]=pre[i][j];
                a2[i][j]=pre[i][j+n];
                a3[i][j]=pre[i+n][j];
                a4[i][j]=pre[i+n][j+n];
            }
        }
    }
    public int[][] merge(int a1[][],int a2[][],int a3[][],int a4[][]){
        int n= a1.length;
        int result[][]=new int[2*n][2*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j]=a1[i][j];
                result[i][j+n]=a2[i][j];
                result[i+n][j]=a3[i][j];
                result[i+n][j+n]=a4[i][j];
            }
        }
        return result;
    }
    public int[][] plus(int a[][],int b[][]){// plus two matrix
        int result[][]=new int[a.length][a.length];
        int n=a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j]=a[i][j]+b[i][j];
            }
        }
        return result;
    }
    public int[][] minus(int a[][],int b[][]){ // minus two matrix
        int n=a.length;
        int result[][]=new int[a.length][a.length];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j]=a[i][j]-b[i][j];
            }
        }
        return result;
    }
    public int [][] fastMultiply(int a[][],int b[][]){ //the method for Strassen's algorithm
        int n=a.length;
        int k=n;
        int length=a.length/2;
        int a1[][]=new int[length][length];
        int a2[][]=new int[length][length];
        int a3[][]=new int[length][length];
        int a4[][]=new int[length][length];
        int b1[][]=new int[length][length];
        int b2[][]=new int[length][length];
        int b3[][]=new int[length][length];
        int b4[][]=new int[length][length];
        int c1[][]=new int[length][length];
        int c2[][]=new int[length][length];
        int c3[][]=new int[length][length];
        int c4[][]=new int[length][length];
        int c[][]=new int[a.length][a.length];
        int [][] p1,p2,p3,p4,p5,p6,p7;
        if(k==1){
            c[0][0]=a[0][0]*b[0][0];
            return c;
        }
        if(k==2){
            c=Multiply2by2(a,b);
            return c;
        }
        else{
            k=n/2;
            divide(a,a1,a2,a3,a4);
            divide(b,b1,b2,b3,b4);
            divide(c,c1,c2,c3,c4);
            p1=fastMultiply(minus(b2,b4),a1); //P1 = A1(B2 - B4)
            p2=fastMultiply(plus(a1,a2),b4);  //P2 = (A1 + A2)B4
            p3=fastMultiply(plus(a3,a4),b1); //P3 = (A3 + A4)B1
            p4=fastMultiply(a4,minus(b3,b1)); //P4 = A4(B3 - B1)
            p5=fastMultiply(plus(a1,a4),plus(b1,b4)); // P5 = (A1 + A4)(B1 + B4)
            p6=fastMultiply(minus(a2,a4),plus(b3,b4)); //P6 = (A2 - A4)(B3 + B4)
            p7=fastMultiply(minus(a1,a3),plus(b1,b2)); //P7 = (A1 - A3)(B1 + B2)
            c1=plus(minus(plus(p5,p4),p2),p6); //P5 + P4 - P2 + P6
            c2=plus(p1,p2); //P1 + P2
            c3=plus(p3,p4); //P3 + P4
            c4=minus(minus(plus(p5,p1),p3),p7); // P5 + P1 - P3 - P7
            c=merge(c1,c2,c3,c4);
            return c;

        }

    }

    public static void main(String[] args) {
        MatrixMultiplication m=new MatrixMultiplication();
//        int a[][]={{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
//        int b[][]={{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
        int n=512;
        long x[]=new long[11];
        long y[]=new long[11];
        for(int i=1,index=1;i<=n;i=i*2,index++){// 1 2 4 8 16 ..... 512
            x[index]=i;
            int a[][]=new int[i][i];
            int b[][]=new int[i][i];
            for(int j=0;j<i;j++){
                for(int k=0;k<i;k++){
                    a[j][k]=1;
                    b[j][k]=1;
                }
            }
            long start=System.currentTimeMillis();
            int c[][]=m.normalMultiply(a,b);
            long end=System.currentTimeMillis();
            long time=end-start;
            System.out.println(time);
            y[index]=time;
        }
        GraphingData g=new GraphingData("",x,y);



        // this is for test the result
      //int  c[][]=m.fastMultiply(a,b);
//        for(int i=0;i<c.length;i++){
//            for(int j=0;j<c.length;j++){
//                System.out.print(c[i][j]);
//            }
//            System.out.println();
//        }
    }



}
