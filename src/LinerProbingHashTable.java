public class LinerProbingHashTable<AnyType> {
    public void  print(){
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]); //print the table
          // if(array[i]!=null)
             //  System.out.println(array[i].element);
          //  else
                //System.out.println("null");
        }
    }
    public LinerProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    public LinerProbingHashTable(int size){
        allocateArray(size); //new the array
        makeEmpty();//make it empty
    }
    public void makeEmpty(){
        currentSize=0;
        for (int i = 0; i <array.length ; i++) {
            array[i]=null; //make arrary nnull
        }
    }
    public boolean contains(AnyType x){
        int currentPos=findPos(x);
        return isActive(currentPos);
    }
    public void insert(AnyType x){
        int currentPos=findPos(x); //find the position
        if(isActive(currentPos)) //if the current position is acitive
            return; //do nothing
        array[currentPos]=new HashEntry<AnyType>(x,true); //insert the value
        if(++currentPos>array.length/2)
            rehash();
    }
    public void remove(AnyType x){
        int currentPos=findPos(x);
        if(isActive(currentPos))
            array[currentPos].isActive=false;
    }
    private static class HashEntry<AnyType>{
        public  AnyType element; //存放的数据
        public  boolean isActive;   //如果为 false 则表明该数据被删除
        public HashEntry(AnyType e){
            this(e,true);
        }
        public HashEntry(AnyType e,boolean i){
            element=e; isActive=i;
        }

        public AnyType getElement() {
            return element;
        }

        @Override
        public String   toString() {
            return "HashEntry{" +
                    "element=" + element +
                    ", isActive=" + isActive +
                    '}';
        }
    }
    private static final int DEFAULT_TABLE_SIZE=11;
    private HashEntry<AnyType> [] array;  //将数据 用数组来保存
    private int currentSize;
    private void allocateArray(int arraySize){//分配数组
        array=new HashEntry[arraySize];
    }
    private boolean isActive(int currentPos){//是否 活跃  参数：当前输入的位置
        return array[currentPos]!=null&&array[currentPos].isActive;
    }
    private int findPos(AnyType x){
        int offSet=1;//线性探测的值 从1开始
        int currentPos=myhash(x);
        while(array[currentPos]!=null &&!array[currentPos].element.equals(x) )
        {
            currentPos+=offSet;
            offSet++; //f(i)=i
            if(currentPos>=array.length)  //if currentposition bigger than array's length
                currentPos-=array.length; //currposition minus the array's length
        }
            return currentPos;
    }

    private void rehash(){
        HashEntry<AnyType> [] oldArray=array;
        allocateArray(nextPrime(2* oldArray.length));//建立一个两倍大小空的hashtable
        currentSize=0;
        for(int i=0;i<oldArray.length;i++){
            if(oldArray[i]!=null&&oldArray[i].isActive) //covert the value to the new hashtable
                insert(oldArray[i].element);
        }


    }
    private int myhash( AnyType x )
    {
        int hashVal = x.hashCode( );

        hashVal %= array.length;
        if( hashVal < 0 )
            hashVal += array.length;

        return hashVal;
    }
    private static int nextPrime(int n){
        if( n % 2 == 0 )
        n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }
    private static boolean isPrime(int n){
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
        LinerProbingHashTable q=new LinerProbingHashTable();
        int a[]={4371,1223,6173,4199,4344,9679,1989};
        for (int i = 0; i <a.length ; i++) {
            q.insert(a[i]);
        }
        q.print();
        long endTime=System.currentTimeMillis();
        System.out.println("time="+(endTime-startTime));
        System.out.println(q.array.length);
       // System.out.println(q);
    }


}