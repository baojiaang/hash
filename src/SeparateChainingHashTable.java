import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<AnyType> {//泛型类

    public void print(){ //print the list
        for (int i=0;i<theLists.length;i++){
            System.out.println(theLists[i]);
        }
    }
    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    public SeparateChainingHashTable(int size)
    {
        theLists=new LinkedList[nextPrime(size)]; // new the List
        for (int i=0;i<theLists.length;i++)
        {
            theLists[i]=new LinkedList<AnyType>(); //实例化
        }
    }
    public void insert(AnyType x){
        List<AnyType> whichLists=theLists[myhash(x)]; //插入到哪个List中
        if(!whichLists.contains(x))  //如果该List中没有 这个value
        {
            whichLists.add(x); //  insert
          if(++currentSize>theLists.length)  //if size bigger than theList's length
              rehash(); //rehash it
        }
    }
    public void remove(AnyType x){
        List<AnyType> whichList=theLists[myhash(x)];
        if(whichList.contains(x))
        {
            whichList.remove(x);
            currentSize--;
        }
    }
    public boolean contains(AnyType x){
        List<AnyType> whichList=theLists[myhash(x)]; //找到哪个List
        return whichList.contains(x);
    }
    public void makeEmpty(){
        for(int i=0;i<theLists.length;i++)
            theLists[i].clear();
        currentSize=0;
    }
    private static final int DEFAULT_TABLE_SIZE=101;
    private List<AnyType> [] theLists;  //List arrary , keep the value
    private int currentSize;
    private  void rehash(){
        List<AnyType> [] oldList=theLists;
        //创造一个两倍长度  空的表
        theLists=new List[nextPrime(2*theLists.length)];
        for (int j=0;j<theLists.length;j++){
            theLists[j]=new LinkedList<AnyType>();
            //将表的数据复制
            for (int i=0;i<oldList.length;i++){
                for (AnyType item:oldList[i]
                     ) {
                    insert(item);
                }
            }
        }
    }
    private int myhash(AnyType x){
        int hashVal = x.hashCode( );

        hashVal %= theLists.length;
        if( hashVal < 0 )
            hashVal += theLists.length;

        return hashVal;
    }
    private static int nextPrime(int n){
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }
    private  static boolean isPrime(int n){
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        SeparateChainingHashTable<Integer> s=new SeparateChainingHashTable<Integer>(11);
        int a[]={4371, 1223, 6173, 4199, 4344, 9679, 1989}; //test
        for (int i = 0; i <a.length ; i++) {
            s.insert(a[i]);
        }
        s.print();
        System.out.println(s.theLists.length);
        long endTime=System.currentTimeMillis();
        System.out.println("time="+(endTime-startTime));
        //System.out.println(s.currentSize);
    }
}

