package sort;

public class ShellSort {
    public void shell(Integer a[]){
        for(int gap=a.length/2;gap>0;gap/=2){
            for(int i=gap;i<a.length;i++)
                for(int j=i;j>=gap&&a[j].compareTo(a[j-gap])<0;j-=gap)
                    swapReference(a,j,j-gap);
        }
    }
    public void swapReference(Integer a[],int i,int j){
        Integer temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }

    public static void main(String[] args) {
        ShellSort s=new ShellSort();
        Integer a[]={1,95,5,9,7};
        s.shell(a);
        for (int b:a
             ) {
            System.out.println(b);
            
        }
    }
}
