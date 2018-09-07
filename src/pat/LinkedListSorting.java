package pat;


import java.util.*;

public class LinkedListSorting {
    public static class ListNode implements  Comparable<ListNode>{
        String address;
        Integer value;
        String next;

        ListNode(String address,int value,String next){
            this.address=address;
            this.value=value;
            this.next=next;
        }
        public int compareTo(ListNode l){
            return value.compareTo(l.value);
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       String start=sc.next();
        HashMap<String,ListNode> map=new HashMap<>();
        ArrayList<ListNode> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            String address=sc.next();
            int value=sc.nextInt();
           String next=sc.next();
           map.put(address,new ListNode(address,value,next));
        }
       String now=start;

        while(!now.equals("-1")){
            ListNode l=map.get(now);

            a.add(l);
           now=l.next;
        }
       Collections.sort(a);
        if(start.equals("-1")){
            System.out.println(0+" "+-1);
        }else {
            for (int i = 0; i < a.size(); i++) {
                if (i + 1 >= a.size()) {
                    a.get(i).next = "-1";
                    break;
                }
                a.get(i).next = a.get(i + 1).address;
            }

            System.out.println(a.size() + " " + a.get(0).address);
            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i).address + " " + a.get(i).value + " " + a.get(i).next);
            }
        }

    }
}
