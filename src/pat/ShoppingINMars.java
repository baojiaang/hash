package pat;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingINMars {
   static int des[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int need=sc.nextInt();
        int money[]=new int[n+1];
        des=new int[n+1];
        money[0]=0;
        for(int i=1;i<=n;i++){
            money[i]=sc.nextInt();
            money[i]=money[i]+money[i-1];

        }

        ArrayList<Integer> arrayList=new ArrayList<>();
        int res;
        int mm=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            res=findBestSum(i,n,need,money);
            if(res>=need){
                if(res==need) {
                    arrayList.add(i);
                }
                else if(res<mm){
                    mm=res;
                    arrayList.clear();
                    arrayList.add(i);
                }
            }
            else{
                break;
            }
        }
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i)+1+"-"+des[arrayList.get(i)]);
        }

    }
    public static int findBestSum(int i,int n,int need,int money[]){
        int left=i+1;
        int right=n;
        int mid;
        while (left<right){
            mid=(left+right)/2;
            if(money[mid]-money[i]>=need){
                right=mid;
            }else{
                left=mid+1;
            }

        }
        des[i]=right;
        return money[right]-money[i];

    }

}
