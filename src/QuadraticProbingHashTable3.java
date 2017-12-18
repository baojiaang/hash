public class QuadraticProbingHashTable3<AnyType> {
    public void  print(){
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
         //   if(array[i].element!=null)
             //   System.out.println(array[i].element);
         //   else
             //   System.out.println("null");
        }
    }
    public QuadraticProbingHashTable3(){
        this(DEFAULT_TABLE_SIZE);
    }
    public QuadraticProbingHashTable3(int size){
        allocateArray(size); //实例化数组
        makeEmpty();
    }
    public void makeEmpty(){
        currentSize=0;
        for (int i = 0; i <array.length ; i++) {
            array[i]=null;
        }
    }
    public boolean contains(AnyType x){
        int currentPos=findPos(x);
        return isActive(currentPos);
    }
    public void insert(AnyType x){
        int currentPos=findPos(x);
        if(isActive(currentPos))
            return;
        array[currentPos]=new HashEntry<AnyType>(x,true);
        if(++currentPos>array.length/2)  //如果现在的位置大于数组长度的一半
            rehash(); //再散列
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
        public String   toString() {  //重写tostring  方便打印
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
    }//实例化数组
    private boolean isActive(int currentPos){//是否 活跃  参数：当前输入的位置
        return array[currentPos]!=null&&array[currentPos].isActive;
    }//判断是否被删除
    private int findPos(AnyType x){
        int offSet=0; //探测的值
        int i=1;
        int currentPos=myhash(x); //hash value
        int value=Integer.parseInt(x.toString());
        while(array[currentPos]!=null &&!array[currentPos].element.equals(x) )
        {
            offSet=i*(7-value%7); //h2(x) = 7 – ( X % 7 ), f(i)=i*h2(x),
            currentPos+=offSet;
            i++;
            if(currentPos>=array.length)
                currentPos-=array.length;
        }
            return currentPos;
    }

    private void rehash(){
        HashEntry<AnyType> [] oldArray=array;
        allocateArray(nextPrime(2* oldArray.length));//建立一个两倍大小空的hashtable
        currentSize=0;
        for(int i=0;i<oldArray.length;i++){
            if(oldArray[i]!=null&&oldArray[i].isActive)
                insert(oldArray[i].element);
        }


    }
    private int myhash(AnyType x){
       /* int hashval=Integer.parseInt(x.toString());//稍微修改了下书里的myhash 方法 将object 转为int
        hashval%=11;
        if(hashval<0){
            hashval+=11;
        }

        return hashval;*/
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
        QuadraticProbingHashTable3 q=new QuadraticProbingHashTable3();
        int a[]={4371, 1223, 6173, 4199, 4344, 9679, 1989};
        for (int i = 0; i <a.length ; i++) {
            q.insert(a[i]);
        }
        q.print();
        System.out.println(q.array.length);
        long endTime=System.currentTimeMillis();
        System.out.println("time="+(endTime-startTime));
       // System.out.println(q);
    }


}