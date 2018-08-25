package pat;

import java.util.Hashtable;

public class Hashing {
    public static void main(String[] args) {

    }


    public static int prime(int end){
        if(end ==1)
            return 1;
        if(end ==2)
            return 2;
        int prime=0;
        for(int i=3; ;i++){
            boolean flag=false;
            if(prime>=end)
                break;
            for(int j=2;j<i;j++){
                if(i%j==0) {
                    flag=true;
                    break;
                }
            }
            if(flag==false)
                prime=i;
        }
            return prime;
    }
//    public static void hash(){
//        Hashtable
//    }
}
