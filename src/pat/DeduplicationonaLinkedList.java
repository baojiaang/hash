package pat;

import java.util.HashSet;
import java.util.Scanner;

public class DeduplicationonaLinkedList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int start=sc.nextInt();
        int n=sc.nextInt();
        int address[]=new int[100000];
        int next[]=new int[100000];
        int removenext[]=new int[100000];
        int removestart=-1;
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        int size=1;
        int last=-1;
        for(int i=0;i<n;i++){
            int thisaddress=sc.nextInt();
            int value=sc.nextInt();
            int thisnext=sc.nextInt();
//            LinkedNode node=new LinkedNode(address,value,next);
            address[thisaddress]=value;
            next[thisaddress]=thisnext;
            set2.add(Math.abs(value));
        }
        int x=start;
        while(x!=-1){
            size++;
            if(size==set2.size()){
                next[x]=-1;
            }
            int value=address[x];
            if(!set.contains(Math.abs(value))) {
                set.add(Math.abs(value));
            }
            else {
                if(set2.size()-size==set2.size()-set.size()){
                    removenext[x]=-1;
                }
                if(removestart==-1)
                {
                    removestart=x;
                    removenext[removestart]=-1;
                }else {
                    removenext[last]=x;
                }

                next[x]=next[next[x]];
                last=x;
            }
            x=next[x];
        }
        int i=start;
        int j=removestart;
        while(i!=-1){
            System.out.println(i+" "+address[i]+" "+next[i]);
            i=next[i];
        }
        while(j!=-1){
            System.out.println(j+" "+address[j]+" "+removenext[j]);
            j=removenext[j];
        }

    }


//    private static class LinkedNode{
//        private int value;
//        private int address;
//        private int next;
//        LinkedNode(int address,int value,int next){
//            this.address=address;
//            this.value=value;
//            this.next=next;
//        }
//    }
}
